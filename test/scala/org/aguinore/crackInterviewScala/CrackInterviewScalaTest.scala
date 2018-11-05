package org.aguinore.crackInterviewScala

import org.scalatest.FunSuite
import org.scalatest.prop.Checkers

class CrackInterviewScalaTest  extends FunSuite with Checkers {
  test("a number of pairs should return 3") {
    val arr = Array(10, 20, 20, 10, 10, 30, 50, 10, 20)
    assert(CrackInterviewScala.numberOfPairs(arr) === 3)
  }

  test("a number of pairs should return 2") {
    val arr = Array(1, 2, 1, 2, 1, 3, 2)
    assert(CrackInterviewScala.numberOfPairs(arr) === 2)
  }
}