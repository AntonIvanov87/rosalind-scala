import InputFromFile.firstLineOf

object DNA {

  import scala.annotation.tailrec

  def main(args: Array[String]) {

    val dna = firstLineOf(fileName=args(0))

    val result = numOfBases(dna)

    println(s"${result.a} ${result.c} ${result.g} ${result.t}")
  }

  def numOfBases(dna: String): NumOfBases = {

    @tailrec
    def numOfBasesRec(dna: String, numOfBases: NumOfBases): NumOfBases = {
      if (dna.isEmpty) {
        return numOfBases
      }
      numOfBasesRec(dna.tail, numOfBases + dna.head)
    }
    
    numOfBasesRec(dna, NumOfBases(0, 0, 0, 0))
  }

  case class NumOfBases(a: Int, c: Int, g: Int, t: Int) {

    def +(base: Char): NumOfBases = {
      base match {
        case 'A' => NumOfBases(a+1, c, g, t)
        case 'C' => NumOfBases(a, c+1, g, t)
        case 'G' => NumOfBases(a, c, g+1, t)
        case 'T' => NumOfBases(a, c, g, t+1)
      }
    }

  }

}
