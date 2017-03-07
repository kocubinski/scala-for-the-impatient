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
  
  class Animal(val name: String)
  
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
  
  /*
   * Question 4:
   * Since Student is a sub-type of Person the type constraints of the pair are satisfied.
   *  
   * Question 5:
   * I don't know right now.
   */
  
  def middle[T](it: Iterable[T]) : T = {
    val len = it.count(i => true)
    it.drop(len / 2).head
   }

   /*
    * Question 7:
    * seq, parCombiner.
    * Because these are types which these methods produce
    */
   
   class Pair[T](val first: T, val second: T) {
     def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
     
     // this is some real type magic to me coming from C#
     // automagically returns the nearest supertype of newFirst's type and T as R
     // "worst" case is R = Object. this results in returning Pair[Object] if that is their only common ancestor/supertype
     def replaceFirst2[R >: T](newFirst: R) = new Pair[R](newFirst, second)
     
     def replaceFirst3[R](newFirst: R) = new Pair(newFirst, second)
   }

   /*
    * Question 8:
    * The Type constraint in Pair[T] has already been declared. mutating the field with a value whose type is not a subtype of T is not possible.
    * The immutable form works because a new Pair is returned with the new (super)type parameter.
    */
   
   
}
