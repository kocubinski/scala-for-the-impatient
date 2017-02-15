package example

object functions {
  def sum(args: Int*): Int = {
    var result: Int = 0
    for (arg <- args) result += arg
    result
  }

  def signum(n : Int) = {
    if (n >= 0) 1
    else if (n == 0) 0
    else -1
  }

  def assign() = {
    var y = 0
    var x = y = 1
  }

  def loop() = {
    for (i <- 0 to 10; m = 10 - i) {
      println(m)
    }
  }

  def countdown(n : Int) = {
    for (i <- 0 to n) {
      println(n - i)
    }
  }

  def stringProduct(s : String) = {
    var res: Long = 1
    for (c <- s) {
      res *= c
    }
    res
  }

  def stringProductRecur(s : String, p : Long = 1) : Long = {
    if (s.isEmpty()) p
    else stringProductRecur(s.substring(1), p * s(0).toInt)
  }

  def stringFold(s: String) = {
    s.foldLeft(1L)(_ * _.toInt)
  }

  def stringFold2(s: String) = {
    s.foldLeft(1L)((p, c) => p * c.toInt)
  }
}
