internal class StringMatchSearch(private val searchTerm: String) : Search() {
    override fun execute() {
        for (i in 0 until files.size) {
            val contentFromFile : String = stringFromFile(i)
            val modifiedContent : String = contentFromFile.replace(searchTerm, "")
            val numberOfMatches : Int = (contentFromFile.length - modifiedContent.length) / searchTerm.length
            results.add(SearchResult(files[i].name, numberOfMatches))
        }
    }
}