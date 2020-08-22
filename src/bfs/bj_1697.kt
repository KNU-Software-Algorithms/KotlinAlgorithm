package bfs.d

import java.util.*

var visit = BooleanArray(200000) { false }
var q = LinkedList<Pair<Int, Int>>()
fun main() {

    val (now, destination) = readLine()!!.split(" ").map { it.toInt() }

    q.add(Pair(now, 0))

    println(dfs(destination))
}

fun dfs(destination: Int): Int {
    var time = 0
    while (q.isNotEmpty()) {
        val (nowLoc, sec) = q.poll()
        time = sec

        if (destination == nowLoc) break

        if (visit[nowLoc]) continue
        visit[nowLoc] = true

        time++

        if (check(nowLoc + 1)) q.add(Pair(nowLoc + 1, time))
        if (check(nowLoc - 1)) q.add(Pair(nowLoc - 1, time))
        if (check(nowLoc * 2)) q.add(Pair(nowLoc * 2, time))

    }
    return time
}

fun check(now: Int): Boolean {
    if (now < 0 || now >= 200000) return false
    if (visit[now]) return false
    return true
}