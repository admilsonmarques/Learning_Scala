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
}
