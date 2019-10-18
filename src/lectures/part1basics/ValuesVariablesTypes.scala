package lectures.part1basics

/**
 *
 */
object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  //Vals are immutable x = 2
  //Compiler can infer types
  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false //true
  val aChar: Char = 'a'//single quote
  val anInt: Int = x
  val aShort: Short = 4613 //only for small integers (2 bytes instead of 4)
  val aLong: Long = 1131231231231231312L // needs to have the capital L in the end to tell it is a Long int (uses 8 bytes instead of 4)
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //variables

  var aVariable: Int = 4

  aVariable = 5 // side effects

  println(aVariable)

}
