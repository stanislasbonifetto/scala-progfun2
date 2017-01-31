import it.stanislas.scala.progfun2.week02.Pouring

object test {
  val problem = new Pouring(Vector(4, 9, 12))

  problem.moves

  problem.pathSets take 3

  problem solutions 6

}