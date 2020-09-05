package string

fun main() {
    var input = readLine()!!
    val alphabets = arrayOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")

    alphabets.forEach { alphabet ->
        if (alphabet in input)
            input = input.replace(alphabet, " ")
    }
    print(input.length)
}