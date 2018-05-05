import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.regex.PatternSyntaxException

internal class RegExSearch(private val searchTerm: String) : Search() {
    override fun execute() {
        var pattern: Pattern? = null
        try {
            pattern = Pattern.compile(searchTerm)
        } catch (e: PatternSyntaxException) {
            println("Unknown or invalid regex pattern, exiting")
            return
        }

        for (i in 0 until files.size) {
            val contentFromFile : String = stringFromFile(i)
            val matcher : Matcher = pattern.matcher(contentFromFile)
            var numberOfMatches = 0
            while (matcher.find()) {
                numberOfMatches++
            }
            results.add(SearchResult(files[i].name, numberOfMatches))
        }
    }
}