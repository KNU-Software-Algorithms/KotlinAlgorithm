package practice

class Programmers12950 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> =
        arr1.mapIndexed { ArrayIdx, ints ->
            ints.mapIndexed { idx, item -> item + arr2[ArrayIdx][idx] }.toIntArray()
        }.toTypedArray()
}

fun main() {
    val test = Programmers12950().solution(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)), arrayOf(intArrayOf(3, 4), intArrayOf(5, 6)))
}