package lectures.part1basics

object DefaultArgs extends App{

  def trFactorial(n: Int, acc: Int = 1): Int =
    if (n<=1) acc
    else trFactorial(n-1,n*acc)

  val fact10 = trFactorial(10)


  def savePict(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  savePict(width = 800)
/*
1. Pass in every leading argument
2. name the arguments
savePict(width = 800)

 */

  savePict(height=600, width = 800, format = "bitmap")


}
