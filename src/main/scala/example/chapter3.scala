package example

object chapter3 {

  implicit class IntHelper(i: Int) {
    def even : Boolean = { i % 2 == 0 }
    def odd : Boolean = { !i.even }
  }

  def randomA(n: Int) : IndexedSeq[Int] = {
    for (i <- 0 to n) yield scala.util.Random.nextInt(n)
  }

  def swapAdj(a : Array[Int]) : Unit = {
    var swap: Int = 0;
    for (i <- 0 until a.length if !i.even) {
      swap = a(i - 1)
      a(i - 1) = a(i)
      a(i) = swap
    }
  }

  def swapAdj2(a : Array[Int]) : IndexedSeq[Int] = {
    for (i <- 0 until a.length) yield {
      if (i.even && i < a.length - 1) a(i + 1)
      else if (i.odd) a(i - 1)
      else a(i)
    }
  }
}
