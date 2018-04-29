import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    print("Enter the search term: ")
    val searchTerm = readLine()
    println("Enter 1 for StringMatch, 2 for Regular Expressions, 3 for Indexed")
    print("Enter search method: ")
    val searchMethod = readLine()
    if (searchMethod != null && searchTerm != null) {
        when (searchMethod) {
            "1" -> {
                println("Elapsed time: ${measureTimeMillis(StringMatchSearch(searchTerm)::execute)} ms")
            }
            "2" -> {
                println("Elapsed time: ${measureTimeMillis(RegExSearch(searchTerm)::execute)} ms")
            }
            "3" -> {
                val indexedSearch = IndexedSearch(searchTerm)
                println("Elapsed time: ${measureTimeMillis(indexedSearch::execute)} ms")
            }
            else -> {
                println("Unknown value entered for search method, exiting")
            }
        }
    } else {
        println("Unknown input given, exiting")
    }
}