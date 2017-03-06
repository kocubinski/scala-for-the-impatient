package example

import scala.collection.mutable.ArrayBuffer

object chapter3 {

  implicit class IntHelper(i: Int) {
    def even: Boolean = { i % 2 == 0 }
    def odd: Boolean = { !i.even }
  }

  def randomA(n: Int): IndexedSeq[Int] = {
    for (i <- 0 to n) yield scala.util.Random.nextInt(n)
  }

  def swapAdj(a: Array[Int]): Unit = {
    var swap: Int = 0;
    for (i <- 0 until a.length if !i.even) {
      swap = a(i - 1)
      a(i - 1) = a(i)
      a(i) = swap
    }
  }

  def swapAdj2(a: Array[Int]): IndexedSeq[Int] = {
    for (i <- 0 until a.length) yield {
      if (i.even && i < a.length - 1) a(i + 1)
      else if (i.odd) a(i - 1)
      else a(i)
    }
  }

  def reorder(a: Array[Int]): Array[Int] = {
    a.filter(_ > 0) ++ a.filter(_ <= 0)
  }

  def avg(a: Array[Int]): Int = {
    a.sum / a.length
  }

  def rSort(a: Array[Int]): Array[Int] = {
    a.sortWith(_ > _)
  }

  def noDupe(a: Array[Int]): Array[Int] = {
    a.distinct
  }

  def butFirstNegative(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val ns = for (i <- 0 until a.length if a(i) < 0) yield i
    for (n <- ns.tail.reverse) a.remove(n)
    a
  }

  def butFirstNegative2(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val ns = for (i <- 0 until a.length if a(i) < 0) yield i
    val ps = for (i <- 0 until a.length if a(i) >= 0) yield i
    println(s"negatives: $ns.tail")
    println(s"positives: $ps")
    a
  }
}
