package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - First I need the factorial of" + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))


  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x:Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper( x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n,1)


  }

//  println(anotherFactorial(50))


  /* Tail Recursion tasks
  1. Concatenate String n times
  2. IsPrime
  3. aFibonacci
   */

  //1. Concatenate String n times
  @tailrec
  def concatString(Str: String, n: Int, accumulator: String): String = {
    if (n<=0) accumulator
    else concatString(Str,n - 1,Str + " " + accumulator)
  }
  println(concatString("teste", 5,""))

  //2. IsPrime

    def isPrime(n: Int): Boolean = {
      def isPrimeTailRec(i: Int, isStillPrime:Boolean): Boolean = {
        if(!isStillPrime) false
        else if (i <= 1) true
        else isPrimeTailRec(i - 1, n % i != 0 && isStillPrime)
      }
        isPrimeTailRec(n/2, true)
    }


  println(isPrime(3))
  println(isPrime(2003))
  println(isPrime(54))

  //3. aFibonacci
  def aFibonacci(n: Int): Int = {
    def funcHelp(i: Int, last: Int, nextlast: Int): Int = {
      if (i >= n) last
      else funcHelp(i +1, last + nextlast, last)
    }
    if (n < 3) 1
    else funcHelp(2,1,1)

  }

  println(aFibonacci(8))


}