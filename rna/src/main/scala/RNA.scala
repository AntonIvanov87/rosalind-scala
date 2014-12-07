import InputFromFile.firstLineOf

object RNA {

  def main(args: Array[String]) {

    val dna = firstLineOf(fileName=args(0))

    val rna = fromDNA(dna)

    println(rna)
  }

  def fromDNA(dna: String): String = {
    dna.replace('T', 'U')
  }

}
