package stack

fun main() {
    val stack = arrayListOf<Char>()
    var totalCnt = 0

    val inputStr = readLine()!!
    var preTemp = ' '

    for (each in inputStr) {
        if (each == '(')
            stack.add(each)
        else if ((each == ')') && (preTemp == '(')) {
            stack.removeAt(stack.size - 1)
            totalCnt += stack.size
        } else if (each == ')') {
            stack.removeAt(stack.size - 1)
            totalCnt += 1
        }
        preTemp = each
    }
    print(totalCnt)

}
