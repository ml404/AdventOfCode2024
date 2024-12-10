package day4

import helper.filePathToList
import helper.getFilePath

fun main() {

    val filePath = getFilePath("day4.txt")
    val fileStringList = filePathToList(filePath)

    val sequence = listOf("X", "M", "A", "S")

    val count = calculateCountForInputAndSequence(fileStringList, sequence)

    println("$count instances of '${sequence.joinToString("")}' found")
}

fun calculateCountForInputAndSequence(
    fileStringList: List<String>,
    sequence: List<String>
): Int {
    var count = 0
    fileStringList.forEachIndexed { i, row ->
        row.forEachIndexed { j, value ->
            val startCoordinate = Coordinate(i, j, value.toString())
            if (startCoordinate.value == sequence.first()) {
                // Start the search if the first letter matches
                count += countSequenceOccurrences(fileStringList, startCoordinate, sequence)
            }
        }
    }
    return count
}

fun countSequenceOccurrences(
    grid: List<String>,
    start: Coordinate,
    sequence: List<String>
): Int {
    var count = 0
    val directions = Coordinate.directions

    for ((dx, dy) in directions) {
        if (searchSequence(grid, start, sequence, 0, dx, dy)) {
            count++
        }
    }

    return count
}

// Recursive function to search for the sequence in a specific direction
fun searchSequence(
    grid: List<String>,
    current: Coordinate,
    sequence: List<String>,
    index: Int,
    dx: Int,
    dy: Int
): Boolean {
    // Base case: if the entire sequence is found
    if (index == sequence.size) return true

    // Check boundaries and if the current coordinate matches the sequence character
    if (!current.isValid(grid.size, grid[0].length) ||
        current.value != sequence[index]
    ) {
        return false
    }

    // Move to the next coordinate in the given direction
    val nextX = current.x + dx
    val nextY = current.y + dy
    val nextCoordinate = Coordinate(nextX, nextY, current.calculateCoordinateValue(grid, nextX, nextY))

    return searchSequence(grid, nextCoordinate, sequence, index + 1, dx, dy)
}

data class Coordinate(val x: Int, val y: Int, val value: String) {
    companion object {
        // Define all possible directions (8 directions: horizontal, vertical, diagonal, including backwards)
        val directions = listOf(
            Pair(-1, -1), Pair(-1, 0), Pair(-1, 1), // Above row
            Pair(0, -1), Pair(0, 1),                // Same row
            Pair(1, -1), Pair(1, 0), Pair(1, 1)     // Below row
        )
    }

    // Check if this coordinate is valid within bounds
    fun isValid(maxRows: Int, maxCols: Int): Boolean {
        return x in 0 until maxRows && y in 0 until maxCols
    }

    // Calculate value at given coordinate position
    fun calculateCoordinateValue(
        fileString: List<String>,
        newX: Int,
        newY: Int
    ): String = if (newX in 0 until fileString.size && newY in 0 until fileString[newX].length) {
        fileString[newX][newY].toString()
    } else {
        ""
    }
}