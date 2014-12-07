import org.scalacheck.Gen.{listOf, oneOf}

object DNATestUtils {

  lazy val possibleDNAs = listOf(oneOf('A', 'C', 'G', 'T')).map(_.mkString)

}
