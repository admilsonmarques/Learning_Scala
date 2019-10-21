package lectures.part2op

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = {
      movie == favoriteMovie
    }
    def handOutWith (person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def + (person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie."

  }

  val mary = new Person ("Marry", "Inception")
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

}
