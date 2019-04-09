package kt

import java.lang.Integer.max

//Longest Increasing Subsequence
fun LISBottomUp(array: IntArray): Int {
    val subSequencesLens = IntArray(array.size)
    for (i in 0 until array.size) {
        subSequencesLens[i] = 1
        for (j in 0 until i) {
            if (array[j] < array[i] && subSequencesLens[j] + 1 > subSequencesLens[i]) {
                subSequencesLens[i] = subSequencesLens[j] + 1
            }
        }
    }
    var ans = 0
    for (el in subSequencesLens) {
        ans = max(ans, el)
    }
    val recoveredIndexes = recoverAnswerWithoutPrev(array, subSequencesLens, ans)

    print("Recovered Indexes: ")
    recoveredIndexes.map { print("$it ") }
    println()
    print("Recovered Subsequence: ")
    for (el in recoveredIndexes) {
        print("${array[el]} ")
    }
    println()
    return ans
}

// with prev array
fun LISBottomUp2(array: IntArray): Int {
    val subSequencesLens = IntArray(array.size)
    val prev = IntArray(array.size)
    for (i in 0 until array.size) {
        subSequencesLens[i] = 1
        prev[i] = -1
        for (j in 0 until i) {
            if (array[j] < array[i] && subSequencesLens[j] + 1 > subSequencesLens[i]) {
                subSequencesLens[i] = subSequencesLens[j] + 1
                prev[i] = j
            }
        }
    }
    var ans = 0
    for (el in subSequencesLens) {
        ans = max(ans, el)
    }
    val recoveredIndexes = recoverAnswer(subSequencesLens, prev, ans)

    print("Recovered Indexes: ")
    recoveredIndexes.map { print("$it ") }
    println()
    print("Recovered Subsequence: ")
    for (el in recoveredIndexes) {
        print("${array[el]} ")
    }
    println()
    return ans
}

fun recoverAnswer(subSequencesLens: IntArray, prev: IntArray, ans: Int): IntArray {
    val indexes = IntArray(ans)
    var k = 0
    for (i in 1 until subSequencesLens.size) {
        if (subSequencesLens[i] > subSequencesLens[k]) {
            k = i
        }
    }
    var j = ans - 1
    while (k > 0) {
        indexes[j] = k
        j--
        k = prev[k]
    }
    return indexes
}

fun recoverAnswerWithoutPrev(array: IntArray, subSequencesLens: IntArray, ans: Int): IntArray {
    val indexes = IntArray(ans)
    var m = ans // max current subsec.len
    val k = subSequencesLens.indexOf(m) // index of max current element
    indexes[m - 1] = k

    for (i in k - 1 downTo 0) {
        if (array[i] < array[k] && subSequencesLens[i] == m - 1) {
            m--
            indexes[m - 1] = i
        }
    }
    return indexes
}

fun longestDivisibleSubsequence(array: IntArray): Int {
    val subSequencesLens = IntArray(array.size)

    for (i in 0 until array.size) {
        subSequencesLens[i] = 1
        for (j in 0 until i) {
            if (array[i] % array[j] == 0 && subSequencesLens[j] + 1 > subSequencesLens[i]) {
                subSequencesLens[i] = subSequencesLens[j] + 1
            }
        }
    }

    var ans = 0
    for (el in subSequencesLens) {
        ans = max(ans, el)
    }
    return ans
}

fun longestNonIncreasingSubsequence(array: IntArray): Int {
    val subSequencesLens = IntArray(array.size)

    for (i in 0 until array.size) {
        subSequencesLens[i] = 1
        for (j in 0 until i) {
            if (array[j] >= array[i] && subSequencesLens[j] + 1 > subSequencesLens[i]) {
                subSequencesLens[i] = subSequencesLens[j] + 1
            }
        }
    }

    var ans = 0
    for (el in subSequencesLens) {
        ans = max(ans, el)
    }
    val recoveredIndexes = recoverNonIncreasingAnswer(array, subSequencesLens, ans)
    recoveredIndexes.map { print("$it ") }
    println()
    return ans
}

fun recoverNonIncreasingAnswer(array: IntArray, subSequencesLens: IntArray, ans: Int): IntArray {
    val indexes = IntArray(ans)
    var m = ans // max current subsec.len
    var k = subSequencesLens.indexOf(m) // index of max current element
    indexes[m - 1] = k + 1

    for (i in k - 1 downTo 0) {
        if (array[i] >= array[k] && subSequencesLens[i] == m - 1) {
            m--
            indexes[m - 1] = i + 1
        }
    }

    return indexes
}

fun LISimproved(array: IntArray): Int {
    val subSequencesLens = IntArray(array.size + 1)
    subSequencesLens[0] = Int.MIN_VALUE
    for (i in 1 until subSequencesLens.size) {
        subSequencesLens[i] = Int.MAX_VALUE
    }

    for (i in 0 until array.size) {
        val j = upperBound(subSequencesLens, subSequencesLens.size, array[i])
        if (subSequencesLens[j - 1] < array[i] && array[i] < subSequencesLens[j]) {
            subSequencesLens[j] = array[i]
        }
    }
    subSequencesLens.map { print("$it ") }
    println()
    return subSequencesLens.max()!!
}

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    println(longestNonIncreasingSubsequence(arr))
}