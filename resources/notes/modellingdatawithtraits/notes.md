
Modelling data with traits

0/ Traits are a way of abstracting over classes that have similar properties, just like
   classes are a way of abstracting over objects.

1/
- If all the subtypes of a trait are known, seal the trait
- Consider making subtypes *final* if there is no case for extending them, or *sealed* if we want to allow extension within the file.

2/ 
- The compiler will warn us if we miss a case of pattern matching when we declare a class as sealed.
- We can control extension points of sealed traits and thus makes stronger guarantees about the behaviour of subtypes.

3/ Product type programming pattern - “A has a B and C”
 
 ```scala
 case class A(b: B, c: C)
```
or
```scala
trait A {
 def b: B  
 def c: C
} 
```

4/ Sum type programming pattern - “A is a B or C”
 
 ```scala
 sealed trait A
 final case class B() extends A
 final case class C() extends A
```

5/ An algebraic data type is any data that uses the above two patterns. In the
   functional programming literature, data using the “has-a and” pattern is known
   as a product type, and the “is-a or” pattern is a sum type.
   
6/ Missing patterns : "is-a and" and "has-a or"

```scala
trait B
trait C
trait A extends B with C
```


```scala
trait A {
def d: D
}

sealed trait D
final case class B() extends D
final case class C() extends D

// or

sealed trait A
final case class D(b: B) extends A
final case class E(c: C) extends A
```

7/ Structural recursion is the precise opposite of the process of building an algebraic data type. 
If A has a B and C (the product-type pattern), to construct an A, we must have a B and a C . The sum and product type 
patterns tell us how to combine data to make bigger data. Structural recursion says that if we 
have an A as defined before, we must break it into its constituent B and C that we 
then combine in some way to get closer to our desired answer. 
Structural recursion is essentially the process of breaking down data into smaller pieces.
   
8/
We have three ways of implementing structural recursion:
1. polymorphism; (*subtype*)
2. pattern matching in the base trait; and
3. pattern matching in an external object.

9/ The general rule is: if a method only depends on other fields and methods
   in a class it is a good candidate to be implemented inside the class. If the
   method depends on other data consider implementing it using pattern matching outside of the classes
   in question. If we want to have more than one implementation we should use
   pattern matching and implement it outside the classes.
   
10/ Recursive data structures are approached in this section.

11/A tail call can be optimised to not use stack space. Due to limitations in the
   JVM, Scala only optimises tail calls where the caller calls itself. Since tail recursion
   is an important property to maintain, we can use the **@tailrec** annotation to ask the 
   compiler to check that methods we believe are tail recursion really are.
