fun quicksort(items:List<Int>):List<Int>{
    if (items.count() < 2){
        return items
    }
    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }

    return quicksort(less) + equal + quicksort(greater)
}
fun main() {
    val numbers = listOf<Int>(2, 8, 7, 3, 6, 9, 5, 1, 0)
    val ordered =  quicksort(numbers)
    println(ordered)
}