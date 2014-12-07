import DNATestUtils.possibleDNAs
import org.scalacheck.Prop.{BooleanOperators, forAll}
import org.scalacheck.Properties

object REVCCheck extends Properties("REVC") {

  property("complementDNA") = forAll(possibleDNAs) {
    dna =>

      val complementDNA = REVC.complementDNA(dna)

      s"complementDNA = $complementDNA" |: (
        ("complement of complement must be equal to initial" |:
          REVC.complementDNA(complementDNA) == dna) &&
        ("num of T in complement must be equal to num of A in initial" |:
          complementDNA.count(_ == 'T') == dna.count(_ == 'A')) &&
        ("num of A in complement must be equal to num of T in initial" |:
          complementDNA.count(_ == 'A') == dna.count(_ == 'T')) &&
        ("num of G in complement must be equal to num of C in initial" |:
          complementDNA.count(_ == 'G') == dna.count(_ == 'C')) &&
        ("num of C in complement must be equal to num of G in initial" |:
          complementDNA.count(_ == 'C') == dna.count(_ == 'G'))
      )
  }

}
