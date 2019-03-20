package kt

import java.lang.StringBuilder
import java.util.*

open class Node(var sum: Int) : Comparable<Node> {
    var code = ""

    open fun buildCode(code: String) {
        this.code = code
    }

    override fun compareTo(other: Node): Int {
        return Integer.compare(sum, other.sum)
    }
}

class InnerNode(val left: Node, val right: Node) : Node(left.sum + right.sum) {
    init {
        super.sum = left.sum + right.sum
    }

    override fun buildCode(code: String) {
        super.buildCode(code)
        left.buildCode(code + "0")
        right.buildCode(code + "1")
    }
}

class Leaf(val symbol: Char, val count: Int) : Node(count) {
    override fun buildCode(code: String) {
        super.buildCode(code)
        println("$symbol: $code")
    }

    init {
        super.sum = count
    }
}

/* Example
Input:
abacabad
Output:
4 14
a: 0
b: 10
c: 110
d: 111
01001100100111
*/
fun main(args: Array<String>) {

    val input = readLine()!!
    val destribution = HashMap<Char, Int>()

    for (c in input) {
        if (c !in destribution) {
            destribution.put(c, 1)
        } else destribution[c] = destribution[c]!! + 1
    }

    val charToCode = HashMap<Char, Node>()
    val priorityQueue = PriorityQueue<Node>()
    for (el in destribution) {
        val leaf = Leaf(el.key, el.value)
        charToCode.put(el.key, leaf)
        priorityQueue.add(leaf)
    }

    var sum = 0
    while (priorityQueue.size > 1) {
        val first = priorityQueue.poll()!!
        val second = priorityQueue.poll()!!
        val node = InnerNode(first, second)
        sum += node.sum
        priorityQueue.add(node)
    }
    if (destribution.size == 1) {
        sum = input.length
    }

    println("${destribution.size} $sum")
    val root = priorityQueue.poll()!!
    if (destribution.size == 1)
        root.buildCode("0")
    else
        root.buildCode("")

    val result = StringBuilder()
    for (char in input) {
        result.append(charToCode[char]!!.code)
    }

    println(result)
}