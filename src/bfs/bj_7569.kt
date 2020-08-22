package bfs.c

import java.util.*

var M = 0
var N = 0
var H = 0

lateinit var array: Array<Array<IntArray>>
lateinit var visit: Array<Array<BooleanArray>>

fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    M = input[0]
    N = input[1]
    H = input[2]

    array = Array(H) {
        Array(N) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    }

    visit = Array(H) {
        Array(N) { BooleanArray(M) { false } }
    }

    val queue = LinkedList<Triple<Int, Int, Int>>()
    val day = LinkedList<Int>()

    var isZero = false
    (0 until H).forEach { z ->
        (0 until N).forEach { y ->
            (0 until M).forEach { x ->
                if (array[z][y][x] == 0) isZero = true
                if (array[z][y][x] == 1) {
                    queue.add(Triple(x + 1, y + 1, z + 1))
                    day.add(0)
                }
            }
        }
    }
    if (!isZero) {
        println(0)
        return
    }

    println("${bfs(queue, day)}")
}

fun bfs(queue: Queue<Triple<Int, Int, Int>>, day: Queue<Int>): Int {
    var currentDay = 0

    val xArray = intArrayOf(1, -1, 0, 0, 0, 0)
    val yArray = intArrayOf(0, 0, 1, -1, 0, 0)
    val zArray = intArrayOf(0, 0, 0, 0, 1, -1)

    var max = 0
    while (queue.isNotEmpty()) {

        val (currentX, currentY, currentZ) = queue.poll()
        currentDay = day.poll()

        if (visit[currentZ - 1][currentY - 1][currentX - 1]) continue
        visit[currentZ - 1][currentY - 1][currentX - 1] = true
        array[currentZ - 1][currentY - 1][currentX - 1] = 1

        if (currentDay> max) max = currentDay

        (0 until 6).forEach {
            val x = currentX + xArray[it]
            val y = currentY + yArray[it]
            val z = currentZ + zArray[it]

            if (check(x, y, z)) {
                queue.add(Triple(x, y, z))
                day.add(currentDay + 1)
            }
        }
    }

    array.forEach {
        it.forEach { line ->
            if (0 in line) return -1
        }
    }

    return max
}

fun check(x: Int, y: Int, z: Int): Boolean {
    if (z < 1 || z > H || y < 1 || y > N || x < 1 || x > M) return false
    if (visit[z - 1][y - 1][x - 1]) return false
    if (array[z - 1][y - 1][x - 1] != 0) return false
    return true
}