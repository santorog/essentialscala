package objectandclasses.counter

class Counter(val start: Int = 0) {

  def inc: Counter = inc()

  def dec: Counter = dec()

  def inc(amount: Int = 1) = new Counter(start + amount)

  def dec(amount: Int = 1) = new Counter(start - amount)

  def adjust(a: Adder) = new Counter(a(start))

  def count = start
}
