package day3

import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Tests {

    @Test
    fun `test extractMulsFromString returns 4 elements`() {
        val input = listOf("""xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))""")
        val result = extractMulsFromString(input)
        assertEquals(4, result.toList().size)
        assertEquals(161, splitAndMultiplyList(result))

    }

    @Test
    fun `test extractMulsFromString returns 2 elements with Dos and Donts`() {
        val input = listOf("""xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))""")
        val dontsInString = extractDosAndDontsMulsFromString(input)
        assertEquals(48, splitAndMultiplyListWithDos(dontsInString))

    }


}
