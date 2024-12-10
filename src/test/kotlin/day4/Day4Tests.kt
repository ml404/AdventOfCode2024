package day4

import kotlin.test.Test
import kotlin.test.assertEquals

class Day4Tests {

    @Test
    fun `test calculateCountForInputAndSequence returns 18 matches`() {
        val input = """MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX""".lines()

        val count = calculateCountForInputAndSequence(input, listOf("X", "M", "A", "S"))
        assertEquals(18, count)
    }

}
