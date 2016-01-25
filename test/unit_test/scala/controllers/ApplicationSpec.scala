/* This is an example for unit test wih ScalaTest plus play.
 * Please refer Official Documentation for Syntax and rules.
 *
 * */

import org.scalatestplus.play._

import scala.collection.mutable.Stack

class ApplicationSpec extends PlaySpec {

  "A Stack" must {
    "pop values in last-in-first-out order" in {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      stack.pop() mustBe 2
      stack.pop() mustBe 1
    }
    "throw NoSuchElementException if an empty stack is popped" in {
      val emptyStack = new Stack[Int]
      a [NoSuchElementException] must be thrownBy {
        emptyStack.pop()
      }
    }
  }
}