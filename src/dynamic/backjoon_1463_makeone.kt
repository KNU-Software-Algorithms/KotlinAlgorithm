package dynamic

var cnt = 0

fun main() {
    var value = readLine()!!.toInt()

    if ((((value % 2) != 0) and ((value % 3) != 0))) {
        value -= 1
        cnt++
    }
    print(returnValue(value))
}

fun returnValue(value: Int): Int {
    var result = value

    while (result != 1){
        cnt++

        if (isPowerOf(result - 1) == 1) {
            result -= 1
            cnt++
        }

        if ((result % 3) == 0) {
            result /= 3
        } else if ((result % 2) == 0) {
            result /= 2
        }
    }
    return cnt
}

fun isPowerOf(value: Int): Int {
    return when {
        value == 1 -> 1
        (value % 3) == 0 -> isPowerOf(value/3)
        else -> value
    }
}