package org.aguinore.crackInterview

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class CrackInterviewKotlinTest {
    @Test
    fun numberOfPairsTest() {
        val arr = intArrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)
        val result = 3
        assertEquals(result, CrackInterviewKotlin.numberOfPairs(arr))
    }

    @Test
    fun numberOfPairsTest2() {
        val arr = intArrayOf(1, 2, 1, 2, 1, 3, 2)
        val result = 2
        assertEquals(result, CrackInterviewKotlin.numberOfPairs(arr))
    }
}