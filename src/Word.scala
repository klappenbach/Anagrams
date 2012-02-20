/**
 * Represents a word in the dictionary. Words that are anagrams will have the same hashCode.
 * @param word a string representing a word
 */
case class Word(word: String) {
  assert (word != null, "Word must not be null")
  assert(word.size > 0, "Word must not be empty string")

  override val hashCode = word.toLowerCase.sorted.hashCode()
}