import it.stanislas.scala.progfun2.week01._

object randtest {

  val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  }

  def single[T](x: T) = new Generator[T] {
    override def generate = x
  }

  val booleans = integers.map(_ >= 0)

  def emptyLists = single(Nil)

  def nonEmptyLists = for {
    head <- integers
    tail <- lists
  } yield head :: tail

  def lists: Generator[List[Int]] = for {
    cutoff <- booleans
    list <- if(cutoff) emptyLists else nonEmptyLists
  } yield list

  def pairs[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = for {
    x <- t
    y <- u
  } yield (x, y)

  def test[T](r: Generator[T], noTimes: Int = 100)(test: T => Boolean): Unit = {
    for (_ <- 0 until noTimes) {
      val value = r.generate
      assert(test(value), "Test failed for: "+value)
    }
    println("Test passed "+ noTimes +" times")
  }


  test(pairs(lists, lists)) {
    case (xs, ys) => (xs ++ ys).length > ys.length
  }
}