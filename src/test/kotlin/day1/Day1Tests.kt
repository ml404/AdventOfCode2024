package day1

import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Tests {

    @Test
    fun `test calculateDistance for example use case`() {
        val list1 = listOf(3, 4, 2, 1, 3, 3)
        val list2 = listOf(4, 3, 5, 3, 9, 3)
        // Sorted list1: [1, 2, 3, 3, 3, 4]
        // Sorted list2: [3, 3, 3, 4, 5, 9]
        // Pairing: (1,3), (2,3), (3,3), (3,4), (3,5), (4,9)
        // Distances: 2, 1, 0, 1, 2, 5
        // Total distance: 2 + 1 + 0 + 1 + 2 + 5 = 11
        val expectedDistance = 11
        assertEquals(expectedDistance, calculateDistance(list1, list2))
    }

    @Test
    fun `test calculateSimilarity for example use case`() {
        val list1 = listOf(3, 4, 2, 1, 3, 3)
        val list2 = listOf(4, 3, 5, 3, 9, 3)
        // Similarity calculation:
        // 3 appears 3 times in list2: 3 * 3 = 9
        // 4 appears 1 time in list2: 4 * 1 = 4
        // 2 does not appear in list2: 2 * 0 = 0
        // 1 does not appear in list2: 1 * 0 = 0
        // 3 appears 3 times in list2: 3 * 3 = 9
        // 3 appears 3 times in list2: 3 * 3 = 9
        // Total similarity: 9 + 4 + 0 + 0 + 9 + 9 = 31
        val expectedSimilarity = 31
        assertEquals(expectedSimilarity, calculateSimilarity(list1, list2))
    }
}
