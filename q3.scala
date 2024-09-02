
class Account(var balance: Double) {


  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $$${amount}. New balance: $$${balance}.")
    } else {
      println("Deposit amount must be positive.")
    }
  }


  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. New balance: $$${balance}.")
    } else {
      println("Insufficient balance or invalid amount.")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $$${amount} to the target account. Your new balance: $$${balance}.")
    } else {
      println("Transfer failed: Insufficient balance or invalid amount.")
    }
  }


  override def toString: String = s"Account Balance: $$${balance}"
}


object AccountTest extends App {
  val account1 = new Account(1000)
  val account2 = new Account(500)

  println(s"Initial State:\nAccount 1: $account1\nAccount 2: $account2\n")

  account1.deposit(200)
  account1.withdraw(100)
  account1.transfer(300, account2)

  println(s"\nFinal State:\nAccount 1: $account1\nAccount 2: $account2")
}
