import kt.longestDivisibleSubsequence
import kt.longestNonIncreasingSubsequence
import kotlin.test.assertEquals

internal class DynamicalProgTest {

    var array = intArrayOf(1, 2, 3, 4, 5)

    @org.junit.jupiter.api.Test
    fun LISBottomUpTest() {
        assertEquals(5, kt.LISBottomUp(array))

        array = intArrayOf(7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1)
        assertEquals(5, kt.LISBottomUp(array))

        array = intArrayOf(1, 3, 2, 4)
        assertEquals(3, kt.LISBottomUp2(array))
    }

    @org.junit.jupiter.api.Test
    fun LISBottomUp2Test() {
        assertEquals(5, kt.LISBottomUp2(array))

        array = intArrayOf(7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1)
        assertEquals(5, kt.LISBottomUp2(array))
    }

    @org.junit.jupiter.api.Test
    fun longestDivisibleSubsequenceTest() {
        assertEquals(3, longestDivisibleSubsequence(array))
    }

    @org.junit.jupiter.api.Test
    fun longestNonIncreasingSubsequenceTest() {
        assertEquals(4, longestNonIncreasingSubsequence(array))

        array = intArrayOf(9, 8, 9, 3, 2, 1)
        assertEquals(5, longestNonIncreasingSubsequence(array))
    }

    @org.junit.jupiter.api.Test
    fun LISImprovedTest() {
        assertEquals(5, kt.LISimproved(array))

        array = intArrayOf(7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1)
        assertEquals(5, kt.LISimproved(array))
    }
}