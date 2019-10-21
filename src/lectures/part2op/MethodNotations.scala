package lectures.part2op

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = {
      movie == favoriteMovie
    }
    def handOutWith (person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def + (person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def + (nickname: String): Person = new Person(s"${this.name} ($nickname)", favoriteMovie, age)

    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie."
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(subject: String): String = s"${this.name} learns $subject"
//    def learnsScala: String = learns("Scala")
    def learnsScala = this learns "Scala"
  }

  val mary = new Person ("Mary", "Inception")
  println(mary.likes("Inception"))

  println(mary likes "Inception") // equivalente
  //infix notation = operator notation (syntactic sugar)


  //"operators" in Scala
  val tom = new Person("Tom", "Fight Club")

  println(mary handOutWith tom)
  println(mary.+(tom))


  println(1 + 2)
  println(1.+(2))


  //all operators are methods.


  //prefix notation
  val x = -1 //unary operators --> equivalent with 1.unary_-
  val y = 1.unary_-
  //unary_ prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)


  //postfix notation
  println(mary.isAlive)
//  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent
  println(tom())



  /*
  1. Overload the + operator
    mary + "the rockstart" => new person "Mary (the rockstar)"

  2. Add an age to the Person class
     Add a unary + operator => new person with the age + 1
     +mary => mary with the age incrementer

  3. Add a "learns" method in the person class => "Mary leands Scala"
     Add a learnsScala method, calls learns method with "Scala".
     Use it in postfix notation.

  4. Overload the apply method
  mary.apply(2) => "Mary watched Inception 2 times"
   */

  //Exercises
  println((mary + "the rockstar").name)
  println((mary + "the rockstar")())
  println(mary.name)

  println((+(+(+mary))).age)

  println(mary learnsScala)

  println(mary(2))

}
