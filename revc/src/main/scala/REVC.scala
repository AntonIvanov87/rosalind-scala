import InputFromFile.firstLineOf

import scala.annotation.tailrec

object REVC {

  def main(args: Array[String]) {

    val dna = firstLineOf(fileName = args(0))

    val result = complementDNA(dna)

    println(result)
  }

  def complementDNA(dna: String): String = {

    @tailrec
    def complementDNAAcc(dna: String, complementChars: List[Char]): String = {

      if (dna.isEmpty) {
        complementChars.mkString

      } else {
        val headComplement = dna.head match {
          case 'A' => 'T'
          case 'T' => 'A'
          case 'C' => 'G'
          case 'G' => 'C'
        }
        complementDNAAcc(dna.tail, headComplement :: complementChars)
      }
    }

    complementDNAAcc(dna, List())
  }

}
