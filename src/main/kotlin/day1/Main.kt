package day1

import helper.readFilePathToLists
import kotlin.math.abs

fun main() {
    // Load the file from the resources folder
    val filePath = object {}.javaClass.classLoader.getResource("day1.txt")?.path ?: throw IllegalArgumentException("File not found in resources folder")


    // Read the file and process each line
    val (list1, list2) = readFilePathToLists(filePath)

    val distance = calculateDistance(list1, list2)
    val similarity = calculateSimilarity(list1, list2)
    println("Total distance is: '$distance', Similarity is: '$similarity' ")
}



fun calculateDistance(list1: List<Int>, list2: List<Int>): Int {
    return (list1.sorted() zip list2.sorted()).map { abs(it.first - it.second) }.sum()
}

fun calculateSimilarity(list1: List<Int>, list2: List<Int>) : Int{
    return list1.map { left -> left * list2.filter { it == left }.size }.sum()
}