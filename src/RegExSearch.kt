import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.regex.PatternSyntaxException

internal class RegExSearch(private val searchTerm: String) : Search() { // match # includes substrings, supports multi-word phrases
    override fun execute() {
        var pattern: Pattern? = null
        try {
            pattern = if (caseSensitiveSearch) {
                Pattern.compile(searchTerm)
            } else {
                Pattern.compile(searchTerm.toLowerCase())
            }
        } catch (e: PatternSyntaxException) {
            println("Unknown or invalid regex pattern, exiting")
            return
        }

        for (i in 0 until files.size) {
            var contentFromFile : String = stringFromFile(i)
            if (!caseSensitiveSearch) {
                contentFromFile = contentFromFile.toLowerCase()
            }
            val matcher : Matcher = pattern.matcher(contentFromFile)
            var numberOfMatches = 0
            while (matcher.find()) {
                numberOfMatches++
            }
            results.add(SearchResult(files[i].name, numberOfMatches))
        }
    }
}