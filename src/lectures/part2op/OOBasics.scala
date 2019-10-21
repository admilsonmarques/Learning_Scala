package lectures.part2op

object OOBasics extends App{

//  val person = new Person("John",26)
//  println(person.age)
//  person.greet("Daniel")
//  person.greet()

  val author = new Writer("Ad", "Ma", 1986)
  val impostor = new Writer("Ad", "Ma", 1986)
  println(author.fullname())

  val novel = new Novel("biografia", 2010, author)
  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(impostor))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

//class parameters are not fields. To transform in fields we need to add Val/var to the parameter
//constructor
class Person(val name: String, val age: Int) {
  //body

  val x = 2

  println(1 + 3)

//method
  def greet(name: String): Unit = println (s"${this.name} says: Hi, $name")


//overloading -> defining methods  with the same name, but different signatures, meaning different parameters or qtt of parameters
  def greet(): Unit = println(s"Hi, I am $name")


  //multiple constructors --> The same as assigning a default value
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

}

/*
Class Novel and a Writer

Writer: First name, surname, year
    - Method fullname

Novel: name, year of release, author
    - authorAge (buyt the year of release)
    - isWrittenBy (author)
    - copy (new year of release) = new instance of Novel

 */


/*
Counter class
  -receives an int value
  -method current count
  -method to increment/decrement => new counter
  -overload inc/dec to receive an amount
 */


//Class Novel and a Writer
class Writer(val fname: String, val lname: String, val byear: Int) {
  //Writer: First name, surname, year
  //    - Method fullname
  def fullname (fname: String = this.fname, lname: String = this.lname): String = s"$fname $lname"
//  def fullname (): Unit = println(s"${this.fname} ${this.lname}")
}
class Novel (val name: String, val yearOfRelease: Int, author: Writer) {
  //Novel: name, year of release, author
  //    - authorAge (buyt the year of release)
  def authorAge(yearOfRelease: Int = this.yearOfRelease, byear: Int = author.byear): Int = {
    if (byear < yearOfRelease) yearOfRelease - byear
    else 0
  }
//  def authorAge = yearOfRelease - author.byear

  //    - isWrittenBy (author)
  def isWrittenBy(author: Writer) = author == this.author
  //    - copy (new year of release) = new instance of Novel
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)

}

//Counter class
class Counter (val count: Int = 0) {
  //  -receives an int value
  //  -method current count
  def inc = {
    println("increasing")
    new Counter(count + 1)
  } // immutability
  def dec = {
    println("decreasing")
    new Counter(count - 1)
  }
  //  -method to increment/decrement => new counter
  //  -overload inc/dec to receive an amount
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
//    new Counter(count + n)
  }
  def dec(n: Int): Counter = {
    if (n<=0) this
    else dec.dec(n-1)
//    new Counter(count - n)
  }

  def print = println(count)

}





