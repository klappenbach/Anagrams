import org.scalatest.FunSuite

/**
 * Created by IntelliJ IDEA.
 * User: Gabriel
 * Date: 2012-02-20
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */

class AnagramGroupTest extends FunSuite {
  test("A Word that is not an anagram to AnagramGroup cannot be added to it") {
    intercept[AssertionError]{
      AnagramGroup(Word("abc")) + Word("bbc")
    }
  }
}
