package kt/* Example
In:
6
Out:
3
1 2 3
*/
fun main() {
    val n = readLine()!!.toInt()
    val result = ArrayList<Int>()
    var sum = 0

    var i = 0
    while (sum <= n) {
        i++
        sum += i
        result.add(i)
    }

    if (sum > n) {
        result.remove(sum - n)
        sum -= sum - n
    }

    println(result.size)
    result.map { print("$it ") }
}