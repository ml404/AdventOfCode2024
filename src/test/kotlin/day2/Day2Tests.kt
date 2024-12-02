package day2

import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Tests {

    @Test
    fun `test validateReport for valid use case`() {
        val list1 = listOf(7, 6, 4, 2, 1)
        assertEquals(true, validateReport(list1))
    }

    @Test
    fun `test validateReport for invalid use case`() {
        val list1 = listOf(1, 2, 7, 8, 9)
        assertEquals(false, validateReport(list1))
    }

    @Test
    fun `test validateReport for valid use case with dampener on 2nd elem`() {
        val list1 = listOf(1, 3, 2, 4, 5)
        assertEquals(true, validateReportWithDampener(list1))
    }

    @Test
    fun `test validateReport for valid use case with dampener on third elem`() {
        val list1 = listOf(8, 6, 4, 4, 1)
        assertEquals(true, validateReportWithDampener(list1))
    }

    @Test
    fun `test validateReport for invalid use case with dampener on`() {
        val list1 = listOf(9, 7, 6, 2, 1)
        assertEquals(false, validateReportWithDampener(list1))
    }
}
