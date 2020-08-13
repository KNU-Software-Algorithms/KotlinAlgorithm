package bfs

import java.util.*

private var N = 0
private var M = 0

lateinit var array: List<List<Int>>
lateinit var visit: Array<BooleanArray>

fun main() {
    val size = readLine()!!.split(" ").map { it.toInt() }
    N = size[0] //y
    M = size[1] //x

    array = Array(N) { IntArray(M) }.map {
        readLine()!!.map { it.toInt() - 48 }
    }

    visit = Array(N) { BooleanArray(M) { false } }

    println(bfs())
}

private fun bfs(): Int {
    var queue = LinkedList<Triple<Int, Int, Int>>()
    queue.add(Triple(1, 1, 1))

    var cnt = 0
    while (queue.isNotEmpty()) {
        val (currentX, currentY, currentCnt) = queue.poll()
        if (visit[currentY - 1][currentX - 1]) continue
        visit[currentY - 1][currentX - 1] = true

        val y = intArrayOf(1, -1, 0, 0)
        val x = intArrayOf(0, 0, -1, 1)

        //종료조건 & 카운트
        if (currentX == M && currentY == N) {
            cnt = currentCnt
            break
        }

        (0 until 4).forEach {
            if (check(currentX + x[it], currentY + y[it]))
                queue.add(Triple(currentX + x[it], currentY + y[it], currentCnt + 1))
        }
    }

    return cnt
}

fun check(x: Int, y: Int): Boolean {
    //경계조건 check
    if (y < 1 || y > N || x < 1 || x > M) return false
    if (array[y - 1][x - 1] == 0) return false
    //방문조건 check
    if (visit[y - 1][x - 1]) return false
    return true
}
