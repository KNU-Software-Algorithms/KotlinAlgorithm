package bfsdfs.e

import java.util.*

var N = 0
var M = 0
var V = 0
lateinit var array: Array<Array<Int>>
lateinit var visit: Array<Boolean>

fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }

    N = input[0]
    M = input[1]
    V = input[2]

    array = Array(N) { Array(N) { 0 } }
    visit = Array(N) { false }

    (0 until M).forEach { _ ->
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        array[x - 1][y - 1] = 1
        array[y - 1][x - 1] = 1
    }

    dfs(V - 1)
    println()
    bfs()
}

fun dfs(v: Int) {
    visit[v] = true
    print("${v+1} ")
    for (i in (0 until N)) {
        if (visit[i] || array[v][i] == 0)
            continue
        dfs(i)
    }
}

fun bfs() {
    visit = Array(N) { false }

    val queue = LinkedList<Int>()
    queue.add(V - 1)
    visit[V - 1] = true

    while (queue.isNotEmpty()) {
        V = queue.poll()
        print("${V + 1} ")

        (0 until N).forEach {
            if (array[V][it] == 1 && !visit[it]) {
                visit[it] = true
                queue.add(it)
            }
        }
    }
}