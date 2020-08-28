package bfsdfs.a

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
        readLine()!!.split(" ").map { it.toInt() }
    }
    visit = Array(N) { BooleanArray(M) { false } }

    var max = 0
    var printingCnt = 0

    (1..N).forEach { y ->
        (1..M).forEach { x ->
            if (check(x, y)) {
                printingCnt++
                val scale = bfs(x, y)
                if (max < scale) {
                    max = scale
                }
            }
        }
    }

    println(printingCnt)
    println(max)
}

private fun bfs(x: Int, y: Int): Int {
    var queue = LinkedList<Triple<Int, Int, Int>>()
    queue.add(Triple(x, y, 1))

    var cnt = 0
    while (queue.isNotEmpty()) {
        val (currentX, currentY, currentCnt) = queue.poll()
        cnt++

        if (visit[currentY - 1][currentX - 1]) continue
        visit[currentY - 1][currentX - 1] = true

        val yArray = intArrayOf(1, -1, 0, 0)
        val xArray = intArrayOf(0, 0, -1, 1)


        (0 until 4).forEach {
            val x = currentX + xArray[it]
            val y = currentY + yArray[it]

            if (check(x, y) && Triple(x, y, currentCnt + 1) !in queue)
                queue.add(Triple(x, y, currentCnt + 1))
        }
    }
    return cnt
}

fun check(x: Int, y: Int): Boolean {
    if (y < 1 || y > N || x < 1 || x > M)
        return false
    if (array[y - 1][x - 1] == 0)
        return false
    if (visit[y - 1][x - 1])
        return false
    return true
}
