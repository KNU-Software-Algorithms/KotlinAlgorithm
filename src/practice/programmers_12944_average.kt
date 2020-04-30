package practice

class Solution12944 {
    fun solution(arr: IntArray) : Double = (arr.sum().toDouble())/arr.size.toDouble()
    fun solution0(arr: IntArray) : Double = arr.average()

}

fun main() {
    val answer = Solution12944()
    println(answer.solution(intArrayOf(1,2,3,4)))
}