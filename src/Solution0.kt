fun main() {

    val aa = arrayOf(intArrayOf(1, 3, 1), intArrayOf(3, 5, 0), intArrayOf(5, 4, 0), intArrayOf(2, 5, 0))
    val bb = arrayOf(
        intArrayOf(5, 6, 0),
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 0),
        intArrayOf(7, 6, 0),
        intArrayOf(3, 7, 1),
        intArrayOf(2, 5, 0)
    )
    solution(6, aa)
}

fun solution(n: Int, delivery: Array<IntArray>): String {
    var answer = ""
    var has = IntArray(n, { 0 })
    var nonHas = arrayListOf<IntArray>()

    for (i in delivery) {
        if (i[2] == 1) {
            if (i[0] !in has) has[i[0] - 1] = i[0]
            if (i[1] !in has) has[i[1] - 1] = i[1]
        } else {
            nonHas.add(i)
        }
    }

    for (i in nonHas) {
        if (i[0] in has)
            has[i[1] - 1] = -(i[1] - 1)
        else if (i[1] in has)
            has[i[0] - 1] = -(i[0] - 1)
    }

    for (i in has) {
        answer += if (i == 0) {
            "?"
        } else if (i < 0) {
            "X"
        } else
            "O"
    }

    println(answer)
    return answer
}

