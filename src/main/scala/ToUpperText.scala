import scala.io.Source

object ToUpperText extends App {
  uppercaseNthWord(filename = args(0), nth = args(1).toInt).mkString(" ").foreach(print)

  def uppercaseNthWord(filename: String, nth: Int): Seq[String] = {
    val words = Source.fromFile(filename).getLines().flatMap(line => line.split("\\W+"))

    words.zipWithIndex.map {
      case (word, i) => if (i % nth == 0)
        word.toUpperCase
      else word
    }.toSeq
  }
}
