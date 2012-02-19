
object Main extends App {
  if(args.size < 1) {
    println("Need a path to an dictionary file!")
    System.exit(0)
  }
  val dictionaryWords = new DictionaryReader().readFile( args(0))
  val anagrams = new AnagramFinder().findAnagrams(dictionaryWords)

  println("Found " + anagrams.size + " anagram groups.")
  anagrams.toList.sortBy(_.size).foreach(println(_))
}
