/**
 * Represents a word in the dictionary. Words that are anagrams will have the same hashCode.
 * @param word a string representing a word
 */
case class Word(word: String) {
  assert (word != null, "Word must not be null")
  assert(word.size > 0, "Word must not be empty string")

  override val hashCode = word.toLowerCase.map(Word.mapToPrimeNumber).product
}

object Word {
  private val primes = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109)
  private val mapToPrimeNumber: Map[Char, Int] = (('a' to 'z') :+ '\'').zip(primes).toMap
}