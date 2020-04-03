package stack

fun isVPS(size: Int) {
    if (size == 0) {
        println("YES")
        return
    } else
        println("NO")
}

fun main() {
    val cnt = readLine()!!.toInt()

    for (i in 1..cnt) {
        var stack = arrayListOf<Char>()
        val inputStr = readLine()
        var stackSize = stack.size

        inputStr?.let {
            for (each in it) {
                if (each == '(')
                    stack.add(each)
                else if ((each == ')') && (stack.size == 0)) {
                    stackSize = -1
                    break
                }else if (each == ')')
                    stack.removeAt(stack.size-1)

                stackSize = stack.size
            }
            isVPS(stackSize)
        }
    }
}
