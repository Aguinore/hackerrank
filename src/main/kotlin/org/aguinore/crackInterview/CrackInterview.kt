package org.aguinore.crackInterview

class CrackInterviewKotlin {
    companion object {
        fun numberOfPairs(arr: IntArray): Int {
            val stack: MutableSet<Int> = HashSet()
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

        fun minimumDistances(arr: IntArray): Int {
            val positions: MutableMap<Int, Int> = HashMap()
            var minimumDistance = Int.MAX_VALUE
            var currentPosition = 0
            for (i: Int in arr) {
                if (i in positions) {
                    val distance = currentPosition - positions.getOrDefault(i, -1)//never default because i is in positions
                    if (distance < minimumDistance) {
                        minimumDistance = distance
                    }
                }
                positions.put(i, currentPosition)
                currentPosition++
            }
            if (minimumDistance == Int.MAX_VALUE) {
                return -1
            }
            return minimumDistance
        }
    }
}