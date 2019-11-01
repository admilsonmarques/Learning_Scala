package lectures.part2op

object AnonymousClasses extends App{
  abstract class Animal {
    def eat: Unit
  }


  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahaha")
  }
  /*
  equivalent with
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = print("hahahahaha")
    }
    val funnyAnimal : Animal = new AnonymousClasses$$anon$1
   */

println(funnyAnimal.getClass)

  class Person(name:String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can I Help?")
  }
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }
jim.sayHi


/*
  1. Create a generic trait called MyPredicate[-T] with a def test(T) => boolean
  2. Generic trait MyTransformer[-A,B] method transform(A) => B
  3. MyList:
   - map(transformer) => MyList
   - filter(predicate) => MyList
   - flatMap(transformer from A to MyList[B]) => MyList[B}

   class EvenPredicate extends MyPredicate[Int]
   class StringToIntTransformer extends MyTransformer[String,Int]

   [1,2,3].map(n*2) = [2,4,6]
   [1,2,3,4].filter(n%2) = [2,4]
   [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]




 */

}
