package it.stanislas.scala.progfun2.week01

/**
  * Created by stanislas on 18/01/2017.
  */
trait Tree

case class Inner(leaf: Tree, right: Tree) extends Tree
case class Leaf(x: Int) extends Tree
