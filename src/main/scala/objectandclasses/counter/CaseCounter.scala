package objectandclasses.counter

case class CaseCounter(start: Int = 0){

  def inc: CaseCounter = inc()

  def dec: CaseCounter = dec()

  def inc(amount: Int = 1) = copy(start + amount)

  def dec(amount: Int = 1) = copy(start - amount)

  def adjust(a: Adder) = copy(a(start))

  def count = start
}

