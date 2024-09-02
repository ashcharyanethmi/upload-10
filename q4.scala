
class Account(var balance: Double) {


  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
  }


  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
  }


  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
    }
  }

  override def toString: String = f"Account Balance: $$${balance}%.2f"
}

class Bank(var accounts: List[Account]) {


  def accountsWithNegativeBalances: List[Account] = {
    accounts.filter(_.balance < 0)
  }


  def totalBalance: Double = {
    accounts.map(_.balance).sum
  }


  def applyInterest(): Unit = {
    accounts.foreach { account =>
      if (account.balance > 0) {
        account.balance += account.balance * 0.05
      } else {
        account.balance += account.balance * 0.1
      }
    }
  }
}

// Example usage
object BankTest extends App {
  // Create some accounts
  val account1 = new Account(1500)  // Positive balance
  val account2 = new Account(-200)  // Negative balance
  val account3 = new Account(800)   // Positive balance
  val account4 = new Account(-50)   // Negative balance

  // Create a bank with the list of accounts
  val bank = new Bank(List(account1, account2, account3, account4))

  // 4.1 List accounts with negative balances
  println("Accounts with Negative Balances:")
  bank.accountsWithNegativeBalances.foreach(println)

  // 4.2 Calculate the sum of all account balances
  println(f"\nTotal Balance of All Accounts: $$${bank.totalBalance}%.2f")

  // 4.3 Apply interest and show final balances
  bank.applyInterest()
  println("\nFinal Balances after Applying Interest:")
  bank.accounts.foreach(println)
}
