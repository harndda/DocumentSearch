import java.io.File
import java.io.FileInputStream
import java.util.*

internal abstract class Search {
    protected val files : ArrayList<File> = InputFiles.getFiles()

    // used to store search results
    val results: PriorityQueue<SearchResult> = PriorityQueue(files.size, { a, b -> b.numberOfMatches - a.numberOfMatches })

    internal abstract fun execute()

    internal fun printResult() {
        println("----------RESULTS----------")
        while (results.size > 0) {
            val maxPair : SearchResult = results.remove()
            println(maxPair.fileName + " - " + maxPair.numberOfMatches)
        }
    }

    // used to get string from content inside a file
    protected fun stringFromFile(index: Int) : String {
        val inputStream : FileInputStream = files[index].inputStream()
        return inputStream.bufferedReader().use { it.readText() }
        // String[] words = instring.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+")
        //val modifiedInput = inputString.replace("[,.;:()!\"]".toRegex(), "")
        //val words = modifiedInput.split("\\s+".toRegex())
    }

    // user to get word list from content inside a file
    protected fun wordsFromFile(index: Int) : List<String> {
        val inputStream : FileInputStream = files[index].inputStream()
        val inputString : String = inputStream.bufferedReader().use { it.readText() }
        // String[] words = instring.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+")
        //val modifiedInput = inputString.replace("[,.;:()!\"]".toRegex(), "")
        val words : List<String> = inputString.split("\\s+".toRegex())
        return words
    }
}