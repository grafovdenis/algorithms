package kt

import java.lang.StringBuilder


/* Example
In:
3 10
a: 00
b: 1
c: 01
Out:
1011001011
bcbabcb
*/
fun main() {
    val alphabet = HashMap<String, String>()
    val input = readLine()!!.split(" ")
    val alph_size = input[0].toInt()
    val str_size = input[1].toInt()
    val result = StringBuilder()

    for (i in 0 until alph_size) {
        val inp = readLine()!!.split(": ")
        val char = inp[0]
        val code = inp[1]
        alphabet.put(code, char)
    }

    val encoded = readLine()!!
    var tmp = ""
    for (i in 0 until str_size) {
        tmp += encoded[i]
        if (alphabet.containsKey(tmp)) {
            result.append(alphabet.get(tmp))
            tmp = ""
        }
    }

    println(result)
}