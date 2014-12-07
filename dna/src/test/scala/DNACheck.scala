import org.scalacheck.Properties
import DNATestUtils.possibleDNAs
import org.scalacheck.Prop.{BooleanOperators, forAll}

object DNACheck extends Properties("DNA") {

  property("numOfBases") = forAll(possibleDNAs) {
    dna =>
      val numOfBases = DNA.numOfBases(dna)

      ("correct num of A" |: numOfBases.a == dna.count(_ == 'A')) &&
        ("correct num of C" |: numOfBases.c == dna.count(_ == 'C')) &&
        ("correct num of G" |: numOfBases.g == dna.count(_ == 'G')) &&
        ("correct num of T" |: numOfBases.t == dna.count(_ == 'T'))
  }

}
