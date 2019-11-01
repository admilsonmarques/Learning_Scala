package lectures.part2op

import javax.naming.spi.DirStateFactory.Result

object Exceptions extends App {

  val x: String = null
  //println(x.length)

  //this ˆ^will crash with NPE (NullPointerException)
  //1. Throwing exceptions
  //  val aWeirdValue: String = throw new NullPointerException


  //2 . how to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    //code that might throw exception
    getInt(true)
  } catch {
    case e: RuntimeException => 43 //println("Caught a Runtime exception")
  } finally {
    //code that will get executed no matter what
    //optional
    //does not influence the return type of this expression
    //use finally only for side effects
    println("finally")
  }
  println(potentialFail)


  // 3 how to define your own exceptions
  //  class MyException extends Exception
  //  val exception = new MyException
  //
  //  throw exception

  //OOM
  //val array = Array.ofDim(Int.MaxValue)

  //Stack Overflow (SO)

  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathcalculationException extends RuntimeException("Division by 0")

  object Pocketcalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathcalculationException

      else x / y
    }
  }


  println(Pocketcalculator.divide(2,1))
}


