package lectures.part1basics

object Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b + "\n"
  }

  print(aFunction("hello", 3))

  def aParameterlessFunction(): Int = {
    42
  }

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction (aString: String, n: Int): String = {
     if (n == 1) aString
     else aString + " " + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("Hello",3))

  def aFunctionWithSideEffects (aString: String): Unit = {

    println(aString)

  }
  aFunctionWithSideEffects("test")

  def aBigFunc (n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n , n-1)
  }

  println(aBigFunc(10))


  /*
  1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  2. Factorial function 1 * 2 * 3 * ... * n
  3. A Fibonnaci function
      f(1) = 1
      f(2) = 2
      f(n) = f(n - 1) + f(n - 2)
  4. Test if a number is prime
   */

  //1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  def kid_greet(name: String,age: Int): String = {
    f"Hi, my name is $name%s and I am $age%d years old"
  }
  println(kid_greet("Adam", 10))

  //2. Factorial function 1 * 2 * 3 * ... * n

  def aFactorialRecursive(n: Int): Int = {
    if (n <= 1) 1
    else n * aFactorialRecursive(n - 1)
  }
  println(aFactorialRecursive(5))


  /*3. A Fibonnaci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n - 1) + f(n - 2)
   */

  def aFibonacci(n: Int): Int = {
    if (n < 3) 1
    else aFibonacci(n - 1) + aFibonacci(n - 2)

  }

  println(aFibonacci(8))

  //4. Test if a number is prime
  def isPrime(n: Int): Boolean = {
    def divRemainder(i: Int): Boolean = {
      if (i <= 1) true
      else n % i != 0 && divRemainder(i-1)
    }
    divRemainder(n-1)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37*17))


}