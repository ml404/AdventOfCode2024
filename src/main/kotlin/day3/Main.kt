package day3

import helper.filePathToList
import helper.getFilePath

val part1Regex = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex(RegexOption.DOT_MATCHES_ALL)
val part2Regex = "(mul\\(\\d{1,3},\\d{1,3}\\))|(do\\(\\))|(don't\\(\\))".toRegex(RegexOption.DOT_MATCHES_ALL)

fun main() {

    val filePath = getFilePath("day3.txt")
    val fileString = filePathToList(filePath)
    val mulsFromString = extractMulsFromString(fileString)
    val part2mulsFromString = extractDosAndDontsMulsFromString(fileString)

    val part1Total = splitAndMultiplyList(mulsFromString)
    val part2Total = splitAndMultiplyListWithDos(part2mulsFromString)

    println("Part 1 Total is: $part1Total")
    println("Part 2 Total is: $part2Total")

}

fun splitAndMultiplyList(result: List<String>): Int {
    val total = result.map {
        val (num1, num2) = it.split(",").map { it.toInt() }
        num1 * num2
    }.sum()
    return total
}

fun splitAndMultiplyListWithDos(result: List<String>): Int {
    var mul = true
    return result.sumOf {
        part2Regex.findAll(it)
            .map {
                when (it.value) {
                    "do()" -> {
                        mul = true
                        0
                    }
                    "don't()" -> {
                        mul = false
                        0
                    }
                    else -> {
                        if (mul) {
                            val (a, b) = it.value.split(",").map { it.replace("mul(", "").replace(")", "").toInt() }
                            a * b
                        } else {
                            0
                        }
                    }
                }
            }.sum()
    }
}

fun extractMulsFromString(input: List<String>): List<String> =
    input.flatMap { part1Regex.findAll(it).map { match -> match.value.replace("mul(", "").replace(")", "") } }


fun extractDosAndDontsMulsFromString(input: List<String>): List<String> {
   return input.flatMap { part2Regex.findAll(it).map { it.value } }
}

