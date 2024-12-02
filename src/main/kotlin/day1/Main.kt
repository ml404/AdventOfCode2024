package day1

import java.io.File
import kotlin.math.abs

fun main() {
    // Load the file from the resources folder
    val filePath = object {}.javaClass.classLoader.getResource("day1.txt")?.path
        ?: throw IllegalArgumentException("File not found in resources folder")


    // Read the file and process each line
    val (list1, list2) = File(filePath).useLines { lines ->
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        lines.forEach { line ->
            val (first, second) = line.split("   ").map { it.toInt() }
            list1.add(first)
            list2.add(second)
        }
        Pair(list1, list2) // Return the two lists as a pair
    }

    val distance = calculateDistance(list1, list2)
    println("Total distance is: '$distance'")
}

fun calculateDistance(list1: List<Int>, list2: List<Int>): Int {
    return (list1.sorted() zip list2.sorted()).map { abs(it.first - it.second) }.sum()
}