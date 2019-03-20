package kt

/*
По данным n отрезкам необходимо найти множество точек минимального размера, для которого каждый из отрезков содержит хотя бы одну из точек.

В первой строке дано число 1≤n≤100 отрезков. Каждая из последующих n строк содержит по два числа 0≤l≤r≤109, задающих начало и конец отрезка. Выведите оптимальное число m точек и сами m точек. Если таких множеств точек несколько, выведите любое из них.

Sample Input 1:
3
1 3
2 5
3 6
Sample Output 1:
1
3
Sample Input 2:
4
4 7
1 3
2 5
5 6
Sample Output 2:
2
3 6
*/
fun main() {
    val numOfSections: Int = readLine()!!.toInt()
    val sections = ArrayList<List<Int>>()
    val rights = ArrayList<Int>()
    for (i in 0 until numOfSections) {
        sections.add(readLine()!!.split(" ").map { el -> el.toInt() })
    }
    sections.sortBy { it[1] }

    val connected = ArrayList<Int>()
    for (i in 0 until numOfSections) {
        val right = sections[i][1]
        for (j in 0 until numOfSections) {
            if (j != i && i !in connected) {
                if (right in sections[j][0]..sections[j][1]) {
                    rights.add(right)
                    connected.add(j)
                } else if (!connected.contains(j)) {
                    rights.add(right)
                    connected.add(i)
                }
            }
        }
    }

    if (!connected.contains(numOfSections - 1))
        rights.add(sections[numOfSections - 1][1])
    println("${rights.distinct().size}")
    rights.distinct().map { print("$it ") }
}