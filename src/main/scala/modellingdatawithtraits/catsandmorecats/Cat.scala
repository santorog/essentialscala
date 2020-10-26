package modellingdatawithtraits.catsandmorecats


case class Cat(colour: String, favouriteFood: String) extends Feline {
  val sound = "meow"
}
