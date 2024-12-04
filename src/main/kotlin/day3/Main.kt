package day3

import helper.readFilePathToString

val part1Regex = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex()
val part2Regex = "(?<=don't\\(\\)).*?mul\\(\\d{1,3},\\d{1,3}\\)(?=[^m]*do\\(\\)|\$)".toRegex()

fun main() {

    val filePath = object {}.javaClass.classLoader.getResource("day3.txt")?.path
        ?: throw IllegalArgumentException("File not found in resources folder")
    val fileString = readFilePathToString(filePath)
    val mulsFromString = part1Regex.extractMulsFromString(fileString)
    val dontsInString = extractMulsToIgnore(fileString)

    val result = mulsFromString.filterNot { it in dontsInString }
    val part1Total = splitAndMultiplyList(mulsFromString)
    val part2Total = splitAndMultiplyList(result)

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

fun extractMulsToIgnore(fileString: String): List<String> = extractNegativeMulsFromString(fileString).flatMap {
    part1Regex.findAll(it).toList().map { it.value.replace("mul(", "").replace(")", "") }
}

fun Regex.extractMulsFromString(input: String): List<String> =
    this.findAll(input).toList().map { it.value }.map { it.replace("mul(", "").replace(")", "") }

fun extractNegativeMulsFromString(input: String): List<String> {
   return part2Regex.findAll(input).toList().map { it.value }
}

