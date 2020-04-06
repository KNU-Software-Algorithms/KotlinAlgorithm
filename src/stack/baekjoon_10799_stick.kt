package stack

fun main() {
    val stack = arrayListOf<Char>()
    var totalCnt = 0

    val inputStr = readLine()
    var preTemp = ' '

    inputStr?.let {
        for (each in it) {
            if (each == '(')
                stack.add(each)
            else if ((each == ')') && (stack.size == 0)) {
                stack.removeAt(stack.size - 1)
                totalCnt += stack.size
            } else if (each == ')') {
                stack.removeAt(stack.size - 1)
                totalCnt += 1
            }
            preTemp = each
        }
        println(totalCnt)
    }
}
