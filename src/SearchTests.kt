import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals

internal class SearchTests {

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {
    }

    @Test
    fun testStringMatchSearchExecute() {
        val millis = measureTimeMillis {
            var stringMatchSearch = StringMatchSearch("warp")
            stringMatchSearch.execute()
            stringMatchSearch = StringMatchSearch("drive")
            stringMatchSearch.execute()
            stringMatchSearch = StringMatchSearch("France")
            stringMatchSearch.execute()
        }
        println("Elapsed time: $millis ms")
    }

    @Test
    fun testIndexedSearchExecute() {
        val millis = measureTimeMillis {
            var indexedSearch = IndexedSearch("warp")
            indexedSearch.execute()
            indexedSearch = IndexedSearch("drive")
            indexedSearch.execute()
            indexedSearch = IndexedSearch("France")
            indexedSearch.execute()
        }
        println("Elapsed time: $millis ms")
    }

    @Test
    fun testRegExSearchExecute() {
        val millis = measureTimeMillis {
            var regExSearch = RegExSearch("X|Z")
            regExSearch.execute()
            regExSearch = RegExSearch("[abc]")
            regExSearch.execute()
            regExSearch = RegExSearch("[trs]")
            regExSearch.execute()
        }
        println("Elapsed time: $millis ms")
    }
}