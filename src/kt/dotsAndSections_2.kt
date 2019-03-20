package kt

import java.lang.StringBuilder

data class Section(val begin: Int, val end: Int)

/*
Задача на программирование: точки и отрезки
﻿
В первой строке задано два целых числа 1≤n≤50000 и 1≤m≤50000 — количество отрезков и точек на прямой, соответственно. Следующие n строк содержат по два целых числа ai и bi (ai≤bi) — координаты концов отрезков. Последняя строка содержит m целых чисел — координаты точек. Все координаты не превышают 108 по модулю. Точка считается принадлежащей отрезку, если она находится внутри него или на границе. Для каждой точки в порядке появления во вводе выведите, скольким отрезкам она принадлежит.

Sample Input:
2 3
0 5
7 10
1 6 11
Sample Output:
1 0 0
*/
fun main() {
    val inp = readLine()!!.split(" ")
    val n = inp[0].toInt()
    val result = StringBuilder()

    val sections = ArrayList<Section>()

    fun dotInSections(dot: Int): Int {
        var res = 0
        for (section in sections) {
            if (dot in section.begin..section.end) {
                res++
            }
        }
        return res
    }

    for (i in 0 until n) {
        val tmp = readLine()!!.split(' ').map { it.toInt() }
        sections.add(Section(tmp[0], tmp[1]))
    }

    val dots = readLine()!!.split(' ').map { it.toInt() }

    for (dot in dots) {
        result.append("${dotInSections(dot)} ")
    }

    println(result)
}