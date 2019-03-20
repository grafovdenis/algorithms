package kt

fun binarySearch(list: List<Int>, key: Int): Int {
    var left = 0
    var right = list.size - 1
    while (left <= right) {
        val m = (left + right) / 2
        when {
            list[m] == key -> return m + 1
            list[m] > key -> right = m - 1
            else -> left = m + 1
        }
    }
    return -1
}

/*
Sample Input:
5 1 5 8 12 13
5 8 1 23 1 11
Sample Output:
3 1 -1 1 -1
*/
fun main() {
    val firstLine = readLine()!!.split(' ')
    val n = firstLine[0].toInt()
    val array = firstLine.subList(1, n + 1).map { it.toInt() }

    val secondLine = readLine()!!.split(' ')
    val k = secondLine[0].toInt()
    val keys = secondLine.subList(1, k + 1).map { it.toInt() }

    for (k in keys) {
        print("${binarySearch(array, k)} ")
    }
}