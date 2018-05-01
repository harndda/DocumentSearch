import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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
            assertEquals(stringMatchSearch.resultsCache.remove().numberOfMatches, 5)
            assertEquals(stringMatchSearch.resultsCache.remove().numberOfMatches, 0)
            assertEquals(stringMatchSearch.resultsCache.remove().numberOfMatches, 0)
            stringMatchSearch = StringMatchSearch("drive")
            stringMatchSearch.execute()
            assertEquals(stringMatchSearch.resultsCache.remove().numberOfMatches, 6)
            assertEquals(stringMatchSearch.resultsCache.remove().numberOfMatches, 0)
            assertEquals(stringMatchSearch.resultsCache.remove().numberOfMatches, 0)
            stringMatchSearch = StringMatchSearch("against")
            stringMatchSearch.execute()
            assertEquals(stringMatchSearch.resultsCache.remove().numberOfMatches, 3)
            assertEquals(stringMatchSearch.resultsCache.remove().numberOfMatches, 0)
            assertEquals(stringMatchSearch.resultsCache.remove().numberOfMatches, 0)
        }
        println("Elapsed time: $millis ms")
    }

    @Test
    fun testIndexedSearchExecute() {
        val millis = measureTimeMillis {
            var indexedSearch = IndexedSearch("warp")
            indexedSearch.execute()
            assertEquals(indexedSearch.resultsCache.remove().numberOfMatches, 5)
            assertEquals(indexedSearch.resultsCache.remove().numberOfMatches, 0)
            assertEquals(indexedSearch.resultsCache.remove().numberOfMatches, 0)
            indexedSearch = IndexedSearch("drive")
            indexedSearch.execute()
            assertEquals(indexedSearch.resultsCache.remove().numberOfMatches, 6)
            assertEquals(indexedSearch.resultsCache.remove().numberOfMatches, 0)
            assertEquals(indexedSearch.resultsCache.remove().numberOfMatches, 0)
            indexedSearch = IndexedSearch("against")
            indexedSearch.execute()
            assertEquals(indexedSearch.resultsCache.remove().numberOfMatches, 3)
            assertEquals(indexedSearch.resultsCache.remove().numberOfMatches, 0)
            assertEquals(indexedSearch.resultsCache.remove().numberOfMatches, 0)
        }
        println("Elapsed time: $millis ms")
    }

    @Test
    fun testRegExSearchExecute() {
        val millis = measureTimeMillis {
            var regExSearch = RegExSearch("X|Z")
            regExSearch.execute()
            assertEquals(regExSearch.resultsCache.remove().numberOfMatches, 1)
            assertEquals(regExSearch.resultsCache.remove().numberOfMatches, 0)
            assertEquals(regExSearch.resultsCache.remove().numberOfMatches, 0)
            regExSearch = RegExSearch("[abc]")
            regExSearch.execute()
            assertEquals(regExSearch.resultsCache.remove().numberOfMatches, 428)
            assertEquals(regExSearch.resultsCache.remove().numberOfMatches, 181)
            assertEquals(regExSearch.resultsCache.remove().numberOfMatches, 127)
            regExSearch = RegExSearch("[trs]")
            regExSearch.execute()
            assertEquals(regExSearch.resultsCache.remove().numberOfMatches, 675)
            assertEquals(regExSearch.resultsCache.remove().numberOfMatches, 290)
            assertEquals(regExSearch.resultsCache.remove().numberOfMatches, 191)
        }
        println("Elapsed time: $millis ms")
    }

    @Test
    fun testGetFiles() {
        val files = InputFiles.getFiles()
        assertTrue(files != null)
        assertTrue(files.size != 0)
        assertTrue(files.size == 3)
        assertTrue(files[0].name == "hitchhikers.txt")
        assertTrue(files[1].name == "warp_drive.txt")
        assertTrue(files[2].name == "french_armed_forces.txt")
    }
}