package line

class Solution3 {
    var result = 0
    var plusCnt = 0

    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf(0,0)

        recursive(n, 0)

        answer[0] = plusCnt
        answer[1] = result
        println("정답 $plusCnt $result")


        return answer
    }

    fun recursive(num : Int, cnt : Int) {
        plusCnt = cnt
        var min = 100000000
        val test = num.toString().map { it.toInt() - 48 }

        if (num < 10){
            result = num.toString().toInt()
            return
        }

        var number1 = 0
        var number2 = 0

        for (it in 1 until test.size) {
            if (num.toString()[it] == '0') continue
            number1 = num.toString().subSequence(0, it).toString().toInt()
            number2 = num.toString().subSequence(it, num.toString().length).toString().toInt()

            if (number1 + number2 < min) {
                min = number1 + number2
            }
        }
        plusCnt += 1

        recursive(min, plusCnt)
    }
}

fun main() {
    val test = Solution3().solution(73425)
    val test1 = Solution3().solution(10007)
    val test2 = Solution3().solution(9)

/*    println(test.toString())
    println(test1.toString())
    println(test2.toString())*/
}