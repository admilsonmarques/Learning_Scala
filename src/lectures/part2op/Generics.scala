package lectures.part2op

object Generics extends App{

  class MyList[A] {
    //use the type A inside the class definition

  }


  class MyMap[Key, Value]

  val listofIntegers = new MyList[Int]
  val listofStrings = new MyList[String]


  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfInt = MyList.empty[Int]



  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(New Dog) ??? Is that okay? HARD QUESTION. We return a list of animals.

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // Errors


  // 3. HELL, NO! = CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  //e.g.
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]


  // bounded types
  class Cage[A <: Animal](animal: A) //class cage only accepts subtypes of animal, the other way around >: only accepts supertypes
  val cage = new Cage(new Dog)


  class Car
//  val newCage = new Cage(new Car) //Error


  class MyList1[+A] {
    //use the type A inside the class definition
    def Add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Dog = Animal
     */
  }


  //expand MyList to be generic
}
