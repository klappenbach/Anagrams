
object Main extends App {
  val dictionaryWords = if(args.size == 0) new DictionaryReader().readFile() else new DictionaryReader().readFile( args(0))
  val anagrams = new AnagramFinder().findAnagrams(dictionaryWords).toList

  anagrams.sortBy(_.groupSize).foreach(println)
  printSomeStats()

  def printSomeStats() {
    val anagramCount = anagrams.map(_.groupSize).sum
    println("\n Found a total of " + anagramCount + " anagrams, in " + anagrams.size + " anagram groups, in " + dictionaryWords.size + " dictionary words.")
    println("\n Group with longest anagram:")
    println(" " + anagrams.sortBy(_.wordSize).reverse.head)
  }
}
