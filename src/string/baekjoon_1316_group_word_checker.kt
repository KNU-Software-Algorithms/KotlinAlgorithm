package string

fun checker(word: String): Boolean {
    var preWord = ' '
    val wordStack = arrayListOf<Char>()

    word.forEach {
        if ((it in wordStack) && (preWord != it)) return false
        wordStack.add(it)
        preWord = it
    }
    return true
}

fun main() {
    var result = 0

    for (i in 0 until readLine()!!.toInt()) {
        if (checker(readLine()!!.toString())) result++
    }
    println(result)
}