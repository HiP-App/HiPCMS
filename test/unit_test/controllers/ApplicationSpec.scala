import org.scalatestplus.play._

import scala.collection.mutable.Stack


/**
 * An example *Test suite* that tests basic stack functionality. We extend
 * PlaySpec which adds many play related features for testing. It is also
 * possible to add more traits to our spec if needed.
 *
 * The syntax for matchers ("mustEqual", "must have") and many examples can
 * be found at [[http://scalatest.org/user_guide/using_matchers]]. Note that
 * PlaySpec only provides "MustMatchers"
 *
 * @see [[org.scalatest.MustMatchers]]
 */

class ApplicationSpec extends PlaySpec {

  /*
   * This *test* is written in the so-called "FlatSpec" style
   * "should" and "in" are keywords inherited by PlaySpec that enable
   * us to write very descriptive test declarations.
   */
  "A Stack" should {
    "pop values in last-in-first-out order" in {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)

      // We can do general assertions to make simple checks
      stack.pop() mustEqual  2
      stack.pop() mustEqual  1
    }

  }

  // After describing the first test with "A stack" should... we can use the key-word it
  // "it" will be replaced with "A stack" on console printout
  it should {
    //A Condition for failing test
    /*"have size 0 if it's empty" in {
      val stack = new Stack[Int]
      stack must have size 0
      stack must be ("empty")
    }*/

    // We can group _very similar_ tests together
    "have size 2 if 2 elements are pushed on an empty stack" in {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)

      stack must have size 2
    }
  }

  it should {
    "throw NoSuchElementException if an empty stack is popped" in {
      val emptyStack = new Stack[String]

      // We can also intercept Exceptions that are expected
      a [NoSuchElementException] should be thrownBy emptyStack.pop()
    }
  }
}