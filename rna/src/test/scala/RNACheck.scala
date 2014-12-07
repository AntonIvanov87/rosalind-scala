import org.scalacheck.Properties
import DNATestUtils.possibleDNAs
import org.scalacheck.Prop.{forAll, BooleanOperators}
import scala.annotation.tailrec

object RNACheck extends Properties("RNA") {

  property("fromDNA") = forAll(possibleDNAs) {
    dna =>
      val rna = RNA.fromDNA(dna)

      "RNA must be build from DNA replacing T with U" |: rnaIsBuildFromDNA(rna, dna)
  }

  @tailrec
  private def rnaIsBuildFromDNA(rna: String, dna: String): Boolean = {

    if (rna.isEmpty && dna.isEmpty)
      true
    else if (rna.head == dna.head || rna.head == 'U' && dna.head == 'T')
      rnaIsBuildFromDNA(rna.tail, dna.tail)
    else
      false
  }

}
