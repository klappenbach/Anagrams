import org.scalatest.FunSuite
import org.scalatest.matchers.MustMatchers

class WordTest extends FunSuite with MustMatchers{
  test("two anagrams are not equal()") {
    Word("lamp") must not equal Word("palm")
  }
  test("hashcode for two anagrams is the same") {
    (Word("lamp").hashCode) must equal (Word("palm").hashCode)
  }
}
