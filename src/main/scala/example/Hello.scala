package example

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello world"
}

class HelloAgain {
  def foo(s : String) : Int = {
    val f = 10 max 2
    s.length()
  }
}
