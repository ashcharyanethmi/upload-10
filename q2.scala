

class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")


  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)


  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g


  def neg: Rational = new Rational(-numer, denom)


  def sub(that: Rational): Rational = {
    val newNumer = this.numer * that.denom - that.numer * this.denom
    val newDenom = this.denom * that.denom
    new Rational(newNumer, newDenom)
  }


  override def toString: String = s"$numer/$denom"
}


object RationalTest extends App {
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)
  val x = y.sub(z)

  println(s"y = $y")
  println(s"z = $z")
  println(s"x = y - z = $x")
}
