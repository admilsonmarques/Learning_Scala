package exercises

abstract class MyList[+A] {

  /*
    methods:
     -head = first element of the list
     -tail = remainder of the list
     - isEmpty = is this list empty
     -add(int) => new list with this element added
     - override toString => a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""


  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing,MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}


case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))


  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)


  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

}

  trait MyPredicate[-T] {
    def test(elem: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(elem: A): B
  }

object ListTest extends App {
//  val list = new Cons(1,new Cons(2,new Cons(3, Empty)))
//  println(list.tail.head)
//  println(list.add(4).toString)
//  println(list.isEmpty)
//
//
//  //polymorphic call
//
//  println(list.toString)

  val listofInt: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val ClonelistofInt: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherlistofInt: MyList[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listofStr: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listofInt.toString)
  println(listofStr.toString)

  println(listofInt.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)


  println((listofInt ++ anotherlistofInt).toString)

  println(listofInt.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem +1, Empty))
  }))

  println(listofInt == ClonelistofInt)

}
