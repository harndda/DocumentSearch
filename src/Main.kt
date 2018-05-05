import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    print("Enter the search term: ")
    val searchTerm : String? = readLine()
    println("Enter 1 for StringMatch, 2 for Regular Expressions, 3 for Indexed")
    print("Enter search method: ")
    val searchMethod : String? = readLine()
    println("")
    if (searchMethod != null && searchTerm != null) {
        when (searchMethod) {
            "1" -> {
                val stringMatchSearch = StringMatchSearch(searchTerm)
                println("Elapsed time: ${measureTimeMillis(stringMatchSearch::execute)} ms")
                stringMatchSearch.printResult()
            }
            "2" -> {
                val regExSearch = RegExSearch(searchTerm)
                println("Elapsed time: ${measureTimeMillis(regExSearch::execute)} ms")
                regExSearch.printResult()
            }
            "3" -> {
                val indexedSearch = IndexedSearch(searchTerm)
                println("Elapsed time: ${measureTimeMillis(indexedSearch::execute)} ms")
                indexedSearch.printResult()
            }
            else -> {
                println("Unknown value entered for search method, exiting")
            }
        }
    } else {
        println("Unknown input given, exiting")
    }
}