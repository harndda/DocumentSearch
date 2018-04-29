import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    /* INDEXED */
    // FINAL INDEXED RUNTIME: 39934 ms
    // Fastest because HashMap get and put are usually O(1)
    val indexedTime = measureTimeMillis {
        for (i in 0 until 2000000) {
            val indexedSearch = IndexedSearch(generateRandomString())
            println("Elapsed time: ${measureTimeMillis(indexedSearch::execute)} ms")
        }
    }
    println()
    println("FINAL INDEXED RUNTIME: $indexedTime ms")



    /* REGEX */
    // FINAL REGEX RUNTIME: 341461 ms
    // Second fastest
//    val regExSearch = RegExSearch("drive")
//    val regExTime = measureTimeMillis {
//        for (i in 0 until 2000000) {
//            println("Elapsed time: ${measureTimeMillis(regExSearch::execute)} ms")
//        }
//    }
//    println()
//    println("FINAL REGEX RUNTIME: $regExTime ms")



    /* STRINGMATCH */
    // I don't recommend running this, it will take hours :)
//    val stringMatchSearch = StringMatchSearch("drive")
//    val stringMatchTime = measureTimeMillis {
//        for (i in 0 until 2000000) {
//            println("Elapsed time: ${measureTimeMillis(stringMatchSearch::execute)} ms")
//        }
//    }
//    println()
//    println("FINAL STRINGMATCH RUNTIME: $stringMatchTime ms")
}

fun generateRandomString() : String {
    val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var word = ""
    for (i in 0..3) {
        word += chars[Math.floor(Math.random() * chars.length).toInt()]
    }
    return word
}