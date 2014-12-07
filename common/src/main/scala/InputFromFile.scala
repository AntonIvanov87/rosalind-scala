
object InputFromFile {

  def firstLineOf(fileName: String): String = {
    import scala.io.Source
    val source = Source fromFile fileName
    source.getLines().next()
  }

}
