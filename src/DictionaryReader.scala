/**
 * Reads a dictionary file with a word on each line and returns it as a List of Words.
 */
class DictionaryReader {
  def readFile(path: String = "english.0"): List[Word] = {
    import scala.io.Source
    val iterator = for (line <- Source.fromFile(path).getLines())
                       yield Word(line.trim())
    iterator.toList
  }
}
