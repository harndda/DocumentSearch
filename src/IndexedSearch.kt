import java.io.File

internal class IndexedSearch(private val searchTerm: String) : Search() { // match # does not include substrings, does not support multi-word phrases
    private val fileMap = HashMap<File, Map<String, Int>>() // maps a file to a cache, each cache is a map of word to number of occurrences in that file

    init {
        preprocess()
    }

    override fun execute() {
        for (i in 0 until files.size) {
            val cache : Map<String, Int>? = fileMap[files[i]]
            if (caseSensitiveSearch) {
                val numberOfMatches : Int? = cache?.getOrDefault(searchTerm, 0)
                results.add(SearchResult(files[i].name, numberOfMatches ?: 0))
            } else {
                val numberOfMatchesCaseInsensitive : Int? = cache?.getOrDefault(searchTerm.toLowerCase(), 0)
                results.add(SearchResult(files[i].name, numberOfMatchesCaseInsensitive ?: 0))
            }
        }
    }

    // preprocesses content in the files and puts them into fileMap for quick lookup later
    private fun preprocess() {
        for (i in 0 until files.size) {
            val wordsInFile : List<String> = wordsFromFile(i)
            val cache = HashMap<String, Int>()
            for (word in wordsInFile) {
                var currentMatchCount = if (caseSensitiveSearch) cache[word] else cache[word.toLowerCase()]
                if (currentMatchCount == null) {
                    if (caseSensitiveSearch) cache.put(word, 1) else cache.put(word.toLowerCase(), 1)
                } else {
                    if (caseSensitiveSearch) cache.put(word, ++currentMatchCount) else cache.put(word.toLowerCase(), ++currentMatchCount)
                }
            }
            fileMap[files[i]] = cache
        }
    }
}