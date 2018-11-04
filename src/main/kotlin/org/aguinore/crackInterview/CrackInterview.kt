package org.aguinore.crackInterview

class CrackInterviewKotlin {
    companion object {
        fun numberOfPairs(arr: IntArray): Int {
            val stack: MutableSet<Int> = HashSet<Int>()
            var pairs: Int = 0
            for (i : Int in arr) {
                if (i in stack) {
                    stack.remove(i)
                    pairs++
                } else {
                    stack.add(i)
                }
            }
            return pairs;
        }
    }
}