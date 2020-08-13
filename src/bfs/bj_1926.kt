package bfs.t

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

    var max = 0
    var printingCnt = 0

    (1..N).forEach { y ->
        (1..M).forEach { x ->
            if (check(x, y)) {
                printingCnt++

                val scale = bfs(x,y)
                if(max < scale){
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
        if (visit[currentY - 1][currentX - 1]) continue
        visit[currentY - 1][currentX - 1] = true

        val yArray = intArrayOf(1, -1, 0, 0)
        val xArray = intArrayOf(0, 0, -1, 1)

        //종료조건 & 카운트
        if (currentX == M && currentY == N) {
            cnt = currentCnt
            break
        }

        (0 until 4).forEach {
            if (check(currentX + xArray[it], currentY + yArray[it]))
                queue.add(Triple(currentX + xArray[it], currentY + yArray[it], currentCnt + 1))
        }
    }

    return cnt
}

fun check(x: Int, y: Int): Boolean {
    //경계조건 check
    if (y < 1 || y > N || x < 1 || x > M) return false
    if (bfs.array[y - 1][x - 1] == 0) return false
    //방문조건 check
    if (bfs.visit[y - 1][x - 1]) return false
    return true
}