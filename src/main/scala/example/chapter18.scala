package example

object chapter18 {
  class Plant(val name: String) {
    override def toString = getClass.getName + " " + name
  }

  class Tree(name: String) extends Plant(name)
  
  class Oak(name: String) extends Tree(name)
  
  class RedOak(name: String) extends Oak(name)
  
  class WhiteOak(name: String) extends Oak(name)
  
  class Cedar(name: String) extends Tree(name)
  
  class ImmutablePair[T, S](val first: T, val second: S) {
    def swap : ImmutablePair[S, T] = {
      new ImmutablePair(second, first)
    }
  }
  
  def test1_1 : Unit = {
    val red = new RedOak("backyard oak")
    val white = new WhiteOak("frontyard oak")
    val pair = new ImmutablePair[Oak, Oak](red, white)
    val swapped = pair.swap
    println(s"${swapped.first} and ${swapped.second}")
  }
  
  class MutablePair[T](var first : T, var second : T) {
    def swap : Unit  = {
      val temp = first
      first = second
      second = temp
    }
  }
  
  class PairEx3[T, S](val first: T, val second: S)
  
  def swap[T, S](pair: PairEx3[T, S]) : PairEx3[S, T] = {
    new PairEx3(pair.second, pair.first)
  }
  
  
}
