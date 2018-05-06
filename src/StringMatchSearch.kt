internal class StringMatchSearch(private val searchTerm: String) : Search() { // match # includes substrings, supports multi-word phrases
    override fun execute() {
        for (i in 0 until files.size) {
            val contentFromFile : String = stringFromFile(i)
            if (caseSensitiveSearch) {
                val modifiedContent : String = contentFromFile.replace(searchTerm, "", false) // don't ignore cases
                val numberOfMatches : Int = (contentFromFile.length - modifiedContent.length) / searchTerm.length
                results.add(SearchResult(files[i].name, numberOfMatches))
            } else {
                val modifiedContentCaseInsensitive : String = contentFromFile.replace(searchTerm, "", true) // ignore cases
                val numberOfMatches : Int = (contentFromFile.length - modifiedContentCaseInsensitive.length) / searchTerm.length
                results.add(SearchResult(files[i].name, numberOfMatches))
            }
        }
    }
}