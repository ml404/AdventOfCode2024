package helper

import java.io.File
import kotlin.sequences.forEach

fun readFilePathToLists(filePath: String): Pair<MutableList<Int>, MutableList<Int>> = File(filePath).useLines { lines ->
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    lines.forEach { line ->
        val (first, second) = line.split("   ").map { it.toInt() }
        list1.add(first)
        list2.add(second)
    }
    Pair(list1, list2) // Return the two lists as a pair
}

fun readFilePathToListOfLists(filePath: String): List<List<Int>> = File(filePath).useLines { lines ->
    val result = mutableListOf<List<Int>>()

    lines.forEach { line ->
        val output = line.split(" ").map { it.toInt() }
        result.add(output)

    }
    return result.toList()
}

fun readFilePathToString(filePath: String): String = File(filePath).readText()