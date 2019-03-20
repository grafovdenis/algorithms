package kt

import java.lang.Exception
import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    var a: String? = null
    var b = a
    print(b)
}

fun calcChairs(bugs: Int): Int = (bugs * 1.5).toInt()

fun calcBugMoneyValue(dayNumber: Int, bugRank: Int, cashAmount: Int): Int = ((dayNumber * bugRank) + 42) * cashAmount

fun getYearEra(year: Int): String = when (year) {
    in 0..1969 -> "before"
    1970 -> "equals"
    in 1971..1999 -> "after (XX century)"
    in 2000..2099 -> "after (XXI century)"
    else -> "distant future"
}

fun isEven(digit: Int) = digit % 2 == 0 && digit != 0

fun calculateEvenDigits(input: String): Int {
    var result = 0
    for (c in input) {
        val num = c.toInt() - '0'.toInt()
        if (isEven(num))
            result += num
    }
    return result
}

class NibirunianClass {
    var namePlate: String? = null

    fun createNamePlate(name: String) {
        namePlate = "Live long and prosper, $name"
    }
}

class SugarStorage(var volume: Int = 0) {
    fun decreaseSugar(v: Int) {
        if (v > 0) {
            volume -= v
            if (volume < 0) volume = 0
        }
    }

    fun increaseSugar(v: Int) {
        if (v > 0)
            volume += v
    }
}

open class Bug(val rank: Int, val name: String) {
    open fun getSugarLimit(): Int {
        return rank
    }

    fun getId(): String {
        return "${rank}.${name}"
    }
}


class BugCivilian(rank: Int, name: String) : Bug(rank, name) {
    override fun getSugarLimit(): Int {
        return super.getSugarLimit() / 2
    }
}

fun getCubeList(n: Int): List<Int> {
    val result = ArrayList<Int>()
    for (i in 0 until n) {
        result.add(i * i * i)
    }
    return result
}

fun calculateWordStat(input: String): String {
    val words = input.split(' ').groupingBy { it }.eachCount()
    val reversed = words.entries.associateBy({ it.value }) { it.key }
    return reversed[reversed.keys.max()].toString()
}

fun exceptionExample() {
    throw IllegalArgumentException()
}


class DogException() : Exception()
class CatException() : Exception()

fun checkClient(client: String) {
    when (client) {
        "dog" -> throw DogException()
        "cat" -> throw CatException()
    }
}

class SphinxesException : Exception()

//fun engineStatus(engineNumber: Int): String {
//
//    // Call rawEngineStatus(engineNumber)
//    try {
//        return rawEngineStatus(engineNumber)
//    } catch (e: EngineNotFoundException) {
//        return ("engine $engineNumber not found")
//    } catch (e: SensorsMeltException) {
//        return ("engine $engineNumber offline")
//    }
//
//    return "I dont know anything about space engines!"
//
//}

fun getLength(str: String?):Int = str?.length?:0

fun calcNullValues(input: Array<Int?>):Array<Int> {
    var nullCnt = 0
    var sum = 0
    for (el in input) {
        if (el == null)
            nullCnt++
        else sum += el
    }
    return arrayOf(nullCnt, sum)
}