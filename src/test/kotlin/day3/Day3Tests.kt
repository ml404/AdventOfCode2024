package day3

import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Tests {

    @Test
    fun `test extractMulsFromString returns 4 elements`() {
        val input = """xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"""
        assertEquals(4, part1Regex.extractMulsFromString(input).toList().size)
    }

    @Test
    fun `test extractMulsFromString returns 2 elements with Dos and Donts`() {
        val input = """xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"""

        val mulsFromString = part1Regex.extractMulsFromString(input)
        val dontsInString = extractMulsToIgnore(input)

        val result = mulsFromString.filterNot { it in dontsInString }
        assertEquals(2, result.size)
        assertEquals(48, splitAndMultiplyList(result))

    }


}
