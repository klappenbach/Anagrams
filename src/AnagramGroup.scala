/**
 * A set of Words that are anagrams of each other. A new Word can be added only if it's an anagram to the set in this anagramGroup.
 * @param words
 */
case class AnagramGroup private(private val words: Set[Word]) {
  override val hashCode = words.head.hashCode

  def +(anagramCandidate: Word): AnagramGroup = {
    if (anagramCandidate.hashCode == hashCode) new AnagramGroup(words + anagramCandidate)
    else throw new RuntimeException(anagramCandidate.word + " is not an anagram of " + this)
  }
  def size = words.size
  override def toString = this.getClass.getSimpleName + "(" + words.map(_.word).mkString(" ") + ")"
}

object AnagramGroup {
  def apply(word: Word): AnagramGroup = new AnagramGroup(Set(word))
}