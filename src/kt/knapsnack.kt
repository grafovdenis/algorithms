package kt/* Example
In:
3 50
60 20
100 50
120 30
Out:
180.000
*/
fun main() {
    data class Item(val cost: Double, val weight: Double)

    val input = readLine()!!.split(' ').map { it.toDouble() }
    val n = input[0].toInt()
    var W = input[1]
    val items = ArrayList<Item>()
    var result = 0.0

    for (i in 0 until n) {
        val inp = readLine()!!.split(' ').map { it.toDouble() }
        items.add(Item(inp[0], inp[1]))
    }

    items.sortBy { it.cost / it.weight }
    items.reverse()

    for (el in items) {
        if (W > el.weight) {
            result += el.cost
            W -= el.weight
        } else {
            result += W / el.weight * el.cost
            break
        }
    }

    print(result)
}