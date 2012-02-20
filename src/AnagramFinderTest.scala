class AnagramFinderTest extends org.scalatest.FunSuite {
  test("simple two word anagram is found") {
    val anagrams: Set[AnagramGroup] = new AnagramFinder().findAnagrams(List(Word("lamp"), Word("palm")))
    assert(anagrams.size == 1 && anagrams.exists(_.groupSize == 2), "didn't find the anagrams: " + anagrams)
  }
  
  test("duplicated word in input is not duplicated in anagrams output"){
    val anagrams: Set[AnagramGroup] = new AnagramFinder().findAnagrams(List(Word("lamp"), Word("palm"), Word("palm")))
    assert(anagrams.size == 1 && anagrams.exists(_.groupSize == 2), "didn't find the anagrams: " + anagrams)
  }

  test("finds two groups with anagrams"){
    val anagrams: Set[AnagramGroup] = new AnagramFinder().findAnagrams(List(Word("lamp"), Word("palm"), Word("lame"), Word("meal")))
    assert(anagrams.size == 2 && anagrams.forall(_.groupSize == 2), "didn't find the anagrams: " + anagrams)
  }

  test("words with no anagrams are excluded from output"){
    val anagrams: Set[AnagramGroup] = new AnagramFinder().findAnagrams(List(Word("lamp"), Word("palm"), Word("lame")))
    assert(anagrams.size == 1 && anagrams.exists(_.groupSize == 2), "didn't find the anagrams: " + anagrams)
  }
}
