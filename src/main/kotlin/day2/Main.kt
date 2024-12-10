package day2

import helper.getFilePath
import helper.readFilePathToListOfLists
import kotlin.math.abs


fun main() {
    // Load the file from the resources folder
    val filePath = getFilePath("day2.txt")
    val listOfLists = readFilePathToListOfLists(filePath)
    val numberOfValidReports = listOfLists.map { validateReport(it) }.filter { it == true }.size
    val numberOfValidReportsWithDampener = listOfLists.map { validateReportWithDampener(it) }.filter { it == true }.size
    println("Number of valid reports is: $numberOfValidReports, Number of valid reports with dampening: $numberOfValidReportsWithDampener")
}



fun validateReportWithDampener(input: List<Int>): Boolean {
    for ((index, _) in input.withIndex()) {
        val newSeq = input.toMutableList().apply { removeAt(index) }
        if (validateReport(newSeq)) {
            return true
        }
    }
    return false
}

fun validateReport(input: List<Int>): Boolean {
    return checkAllDecreasing(input) || checkAllIncreasing(input)
}


fun checkAllDecreasing(input: List<Int>): Boolean {
    input.forEachIndexed { index, value ->
        if (index == input.size - 1) return true

        val next = input[index + 1]
        val diff = value - next
        val isAcceptableRate = (diff >= 1 && diff <= 3)
        if (value <= next || !isAcceptableRate) {
            return false
        }
    }
    return true
}

fun checkAllIncreasing(input: List<Int>): Boolean {
    input.forEachIndexed { index, value ->
        if (index == input.size - 1) return true

        val next = input[index + 1]
        val diff = abs(value - next)
        val isAcceptableRate = (diff >= 1 && diff <= 3)
        if (value >= next || !isAcceptableRate) {
            return false
        }
    }
    return true
}