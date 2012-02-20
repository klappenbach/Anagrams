/**
 * A set of Words that are anagrams of each other. A new Word can be added only if it's an anagram to the set in this anagramGroup.
 * @param words
 */
case class AnagramGroup private(private val words: Set[Word]) {

  def +(anagramCandidate: Word): AnagramGroup = {
    assert(anagramCandidate.hashCode == words.head.hashCode, anagramCandidate.word + " is not an anagram of [" + this + "]")
    new AnagramGroup(words + anagramCandidate)
  }

  def groupSize = words.size
  def wordSize = words.head.word.size

  override def toString = words.map(_.word).mkString(" ")
}

object AnagramGroup {
  def apply(word: Word): AnagramGroup = new AnagramGroup(Set(word))
}