import java.io.File

internal class IndexedSearch(private val searchTerm: String) : Search() {
    private val fileMap = HashMap<File, Map<String, Int>>() // maps a file to a cache, each cache is a map of word to number of occurrences in that file

    init {
        preprocess()
    }

    override fun execute() {
        for (i in 0 until files.size) {
            val cache = fileMap[files[i]]
            val numberOfMatches = cache?.getOrDefault(searchTerm, 0)
            results.add(SearchResult(files[i].name, numberOfMatches ?: 0))
        }
    }

    // preprocesses content in the files and puts them into fileMap for quick lookup later
    private fun preprocess() {
        for (i in 0 until files.size) {
            val wordsInFile = wordsFromFile(i)
            val cache = HashMap<String, Int>()
            for (word in wordsInFile) {
                var currentMatchCount = cache[word]
                if (currentMatchCount == null) {
                    cache[word] = 1 // new word, set occurrences to 1
                } else {
                    cache[word] = ++currentMatchCount // word already exists in map, simply increment occurrences
                }
            }
            fileMap[files[i]] = cache
        }
    }
}