package bfsdfs

var computerCnt = 0
var answer = 0
lateinit var array: Array<BooleanArray>
lateinit var visit: Array<Boolean>

fun main() {
    computerCnt = readLine()!!.toInt()
    val edgeCnt = readLine()!!.toInt()
    array = Array(computerCnt) { BooleanArray(computerCnt) { false } }
    visit = Array(computerCnt) { false }

    (0 until edgeCnt).forEach { _ ->
        val (node1, node2) = readLine()!!.split(" ").map { it.toInt() }
        array[node1 - 1][node2 - 1] = true
        array[node2 - 1][node1 - 1] = true
    }

    dfs(0)
    print(answer)
}

fun dfs(v: Int) {
    visit[v] = true
    for (i in 0 until computerCnt) {
        if (visit[i] || !array[v][i])
            continue
        dfs(i)
        answer++
    }
}