import org.scalatest.matchers.MustMatchers

class AnagramFinderTest extends org.scalatest.FunSuite with MustMatchers {
  val one = 1
  val two = 2

  test("finds two groups with anagrams"){
    val anagrams: Set[AnagramGroup] = new AnagramFinder().findAnagrams(List(Word("lamp"), Word("palm"), Word("lame"), Word("meal")))
    anagrams must have size two
    assertAllGroupsHaveSizeTwo(anagrams)
  }

  test("duplicated word in input is not duplicated in anagrams output"){
    val anagrams: Set[AnagramGroup] = new AnagramFinder().findAnagrams(List(Word("lamp"), Word("palm"), Word("palm")))
    anagrams must have size one
    assertAllGroupsHaveSizeTwo(anagrams)
  }

  test("words with no anagrams are excluded from output"){
    val anagrams: Set[AnagramGroup] = new AnagramFinder().findAnagrams(List(Word("lamp"), Word("palm"), Word("lame")))
    anagrams must have size one
    assertAllGroupsHaveSizeTwo(anagrams)
  }

  def assertAllGroupsHaveSizeTwo(anagrams: Set[AnagramGroup]) {
      assert(anagrams.forall(_.groupSize == 2), "didn't find the anagrams: " + anagrams)
    }
}
