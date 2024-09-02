object LetterCountApp {


  def countLetterOccurrences(words: List[String]): Int = {

    val wordLengths = words.map(word => word.length)


    val totalCount = wordLengths.reduce((a, b) => a + b)

    totalCount
  }


  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val totalLetterCount = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $totalLetterCount")
  }
}
