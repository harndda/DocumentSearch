internal class StringMatchSearch(private val searchTerm: String) : Search() {
    override fun execute() {
        for (i in 0 until files.size) {
            val contentFromFile = stringFromFile(i)
            val modifiedContent = contentFromFile.replace(searchTerm, "")
            val numberOfMatches = (contentFromFile.length - modifiedContent.length) / searchTerm.length
            results.add(SearchResult(files[i].name, numberOfMatches))
        }
        printResult()
    }
}