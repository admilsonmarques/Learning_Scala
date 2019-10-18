package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 //Expressions
  println(x)
  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)
  println(1 == x)
  // == Equality
  // != Non equality
  // >
  // >=
  // <
  //<=

  //logical negation of something (!)
  println(!(1 == x))
  // ! negation
  // && logical AND
  // ||logical OR

  var aVariable = 2

  aVariable += 3 // also works with -= /= *=
  println(aVariable)

  //Instructions (DO) vs Expressions (Value)
  //Instructions -> Tell the computer to do (print, show, change a variable, etc)
  //Expressions -> Is something that has a value and/or a type

  //IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 //If Expressions
  println(aConditionedValue)

  //Don't use while for iterating, but here is how to do it
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  //Everything in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === Void (It doesn't return anything meaningful
  println(aWeirdValue)

  //Side effects: println(), whiles, reassigning -> all return Unit

  //Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "goodbye"
  }

  //1. difference between "Hello" and println("Hello")?
  //ans: the first is a string value, the second is an expression with a side effect (instruction)

  //2. What is the value of:
  val someValue = {
    2 < 3
  }
  //ans: Boolean true

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  //ans: 42, because it is the last expression within the code block

}
