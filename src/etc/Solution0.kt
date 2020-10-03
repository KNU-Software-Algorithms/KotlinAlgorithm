package etc

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()

        val sum = brown + yellow

        (3..sum/3).forEach { it ->
            if (sum/it == 0){
                val n = it
                val m = sum/it


            }
        }



        return answer
    }
}

fun main(){
    val test = Solution().solution(3,1)
    println(test.toString())
}