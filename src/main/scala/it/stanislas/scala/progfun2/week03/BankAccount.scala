package it.stanislas.scala.progfun2.week03

/**
  * Created by stanislas on 23/01/2017.
  */
class BankAccount {
  private var balance = 0
  def deposit(amount: Int): Unit = {
    if(amount > 0) balance = balance + amount
  }
  def withdraw(amount: Int): Int = {
    if(0 < amount && amount<= balance){
      balance = balance - amount
      balance
    } else throw new Error("insufficient funds")
  }
}
