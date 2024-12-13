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


    @Test
    fun `test countXmasPatterns returns 1 match`() {
        val input = """MXM
MAM
SMS""".trimMargin().lines()

        val count = countXmasPatterns(input)
        assertEquals(1, count)
    }

    @Test
    fun `test countXmasPatterns returns 9 matches`() {
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

        val count = countXmasPatterns(input)
        assertEquals(9, count)
    }

}
