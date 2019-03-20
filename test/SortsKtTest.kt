import kt.mergeEfficient
import kt.mergeNaive
import kt.quickSort1
import kt.quickSort2
import kt.recursiveMergeSort
import kt.selectionSort
import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

internal class SortsKtTest {

    @org.junit.jupiter.api.Test
    fun bubbleSort() {
        val list = MutableList(10) { Random.nextInt(0, 100) }
        val expectation: MutableList<Int> = list

        expectation.sort()
        kt.bubbleSort(list)
        println("Expectation: $expectation")
        assertEquals(expectation, list)
    }

    @org.junit.jupiter.api.Test
    fun insertionSort() {
        val list = MutableList(10) { Random.nextInt(0, 100) }
        val expectation: MutableList<Int> = list

        expectation.sort()
        kt.insertionSort(list)
        println("Expectation: $expectation")
        assertEquals(expectation, list)
    }

    @org.junit.jupiter.api.Test
    fun merge() {
        val first: MutableList<Int> = arrayListOf(2, 3, 5, 7)
        val second: MutableList<Int> = arrayListOf(1, 6, 7, 13, 24)

        val exception:MutableList<Int> = arrayListOf(1, 2, 3, 5, 6, 7, 7, 13, 24)
        val reality = mergeNaive(first, second)
        assertEquals(exception, reality)
    }

    @org.junit.jupiter.api.Test
    fun rand_merge() {
        val first = MutableList(Random.nextInt(1, 100)) { Random.nextInt(0, 100)}
        val second = MutableList(Random.nextInt(1, 100)) { Random.nextInt(0, 100)}
        first.sort()
        second.sort()

        val expectation = mergeEfficient(first, second)
        val reality = mergeNaive(first, second)
        assertEquals(expectation, reality)
    }

    @org.junit.jupiter.api.Test
    fun mergeSort() {
        val list = MutableList(10) { Random.nextInt(0, 100) }
        val expectation: MutableList<Int> = list

        expectation.sort()
        recursiveMergeSort(list)
        println("Expectation: $expectation")
        assertEquals(expectation, list)
    }

    @org.junit.jupiter.api.Test
    fun quickSort1() {
        val list = MutableList(10) { Random.nextInt(0, 100)}
        val expectation = list

        expectation.sort()
        quickSort1(list, 0, list.size)
        println("Expectation: $expectation")
        assertEquals(expectation, list)
    }

    @org.junit.jupiter.api.Test
    fun quickSort2() {
        val list = MutableList(10) { Random.nextInt(0, 100)}
        val expectation = list

        expectation.sort()
        quickSort2(list, 0, list.size)
        println("Expectation: $expectation")
        assertEquals(expectation, list)
    }

    @org.junit.jupiter.api.Test
    fun selectionSort() {
        val list = MutableList(10) {Random.nextInt(0, 100)}
        val expectation = list

        expectation.sort()
        selectionSort(list)
        println("Expectation: $expectation")
        assertEquals(expectation, list)
    }
}