package kt

import kotlin.random.Random

fun bubbleSort(list: MutableList<Int>) {
    for (pass in 0 until list.size - 1) {
        for (currentPos in 0 until list.size - 1) {
            if (list[currentPos] > list[currentPos + 1]) {
                val tmp = list[currentPos]
                list[currentPos] = list[currentPos + 1]
                list[currentPos + 1] = tmp
            }
        }
    }
}

fun insertionSort(list: MutableList<Int>) {
    for (i in 1 until list.size) {
        var j = i
        while (j > 1 && list[j] < list[j - 1]) {
            val tmp = list[j]
            list[j] = list[j - 1]
            list[j - 1] = tmp
            j--
        }
    }
}

fun mergeNaive(first: MutableList<Int>, second: MutableList<Int>): MutableList<Int> {
    val result: MutableList<Int> = arrayListOf()
    var left = 0
    var right = 0
    while (left <= first.size && right <= second.size) {
        if (left == first.size && right != second.size) {
            result.add(second[right])
            right++
        } else if (right == second.size && left != first.size) {
            result.add(first[left])
            left++
        } else if (left != first.size && right != second.size) {
            if (first[left] < second[right]) {
                result.add(first[left])
                left++
            } else {
                result.add(second[right])
                right++
            }
        } else break
    }
    return result
}

/*https://stackoverflow.com/questions/5958169/how-to-merge-two-sorted-arrays-into-a-sorted-array*/
fun mergeEfficient(first: MutableList<Int>, second: MutableList<Int>): MutableList<Int> {
    val size = first.size + second.size
    var i = first.size - 1
    var j = second.size - 1
    val result = IntArray(size)
    var k = size

    while (k > 0)
        result[--k] = if (j < 0 || i >= 0 && first[i] >= second[j]) first[i--] else second[j--]
    return result.asList().toMutableList()
}

/*
Sorting tree
    7 2 5 3 7 13 1 6
   7 2 5 3    7 13 1 6
  7 2  5 3    7 13  1 6
7  2  5  3    7  13  1  6
  2 7  3 5    7 13  1  6
   2 3 5 7    1 6 7 13
    1 2 3 5 6 7 7 13
*/
fun recursiveMergeSort(list: MutableList<Int>): MutableList<Int> {
    return if (list.size > 1) {
        val m = list.size / 2
        mergeNaive(recursiveMergeSort(list.subList(0, m)), recursiveMergeSort(list.subList(m, list.size - 1)))
    } else
        list
}

fun partition(list: MutableList<Int>, l: Int, r: Int): Int {
    val x = list[l]
    var j = l
    for (i in l + 1 until r) {
        if (list[i] <= x) {
            j++
        }
        // обменяем A[j] и A[i] местами
        val tmp = list[i]
        list[i] = list[j]
        list[j] = tmp
    }
    // обменяем A[l] и A[j] местами
    val tmp = list[l]
    list[l] = list[j]
    list[j] = tmp
    return j
}

fun quickSort1(list: MutableList<Int>, l: Int, r: Int) {
    if (l >= r)
        return
    val m = partition(list, l, r)
    quickSort1(list, l, m - 1)
    quickSort1(list, m + 1, r)
}


// элиминация хвостовой рекурсии
fun quickSort2(list: MutableList<Int>, l: Int, r: Int) {
    var left = l
    while (left < r) {
        val m = partition(list, left, r)
        quickSort2(list, left, m - 1)
        left = m + 1
    }
}

fun selectionSort(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        var k = i
        for (j in i + 1 until list.size) {
            if (list[j] < list[k]) {
                k = j
            }
        }
        //обменять a[i] b a[k]
        val tmp = list[i]
        list[i] = list[k]
        list[k] = tmp
    }
}

fun main() {
    val list = MutableList(10) { Random.nextInt(0, 100) }
    println("Original: $list")

    bubbleSort(list)
    println("Sorted  : $list")
}