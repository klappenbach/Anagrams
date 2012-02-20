import collection.mutable

/**
 * Finds all groups of anagrams (AnagramGroups) given a List of Words
 */
class AnagramFinder {
  def findAnagrams(input: List[Word]): Set[AnagramGroup] = {
    val anagrams = mutable.Map[Int, AnagramGroup]()
    input.foreach(word => {
      anagrams.get(word.hashCode) match {
        case Some(group) => anagrams.put(word.hashCode, group + word)
        case None => anagrams.put(word.hashCode, AnagramGroup(word))
      }
    })
    anagrams.values.toSet.filter(_.groupSize > 1)
  }
}
