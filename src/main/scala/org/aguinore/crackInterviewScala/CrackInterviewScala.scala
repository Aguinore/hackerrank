package org.aguinore.crackInterviewScala

import scala.collection.mutable

class CrackInterviewScala {
}

private object CrackInterviewScala {
  def numberOfPairs(arr: Array[Int]): Int = {
    val stack: mutable.Set[Int] = mutable.HashSet()
    var pairs: Int = 0
    for (i <- arr) {
      if (stack.contains(i)) {
        stack.remove(i)
        pairs = pairs + 1
      } else {
        stack.add(i)
      }
    }
    pairs
  }
}