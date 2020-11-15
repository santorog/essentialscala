1/ Type parameters 
```scala
case class Name[A](...){ ... }
trait Name[A]{ ... }
def name[A](...){ ... }
```

2/ With type parameters we can do some Generic Sum Type Patterns
```scala
sealed trait A[T]
final case class B[T]() extends A[T]
final case class C[T]() extends A[T]
```

3/ Unlike a method a function is value

4/ Function literals 
```scala
val sum = (x: Int, y:Int) => x + y
```

5/ Fold pattern 

For an algebraic datatype A, fold converts it to a generic type B. Fold is a structural recursion with:
- one function parameter for each case in A;
- each function takes as parameters the fields for its associated class;
- if A is recursive, any function parameters that refer to a recursive field take a parameter of type B.

The right-hand side of pattern matching cases, or the polymorphic methods as appropriate, consists of calls to the appropriate function


6/ Placeholder syntax 

```scala
(_: Int) * 2  // expands to (a: Int) => a * 2
_ + _         // expands to `(a, b) => a + b`
foo(_)        // expands to `(a) => foo(a)`
foo(_, b)     // expands to `(a) => foo(a, b)`
_(foo)        // expands to `(a) => a(foo)`
// and so on...
````    

7/ Converting methods to functions => simply follow a method with an underscore

8/ Multiple parameters lists

```scala
def example(x: Int)(y: Int) = x + y
// example: (x: Int)(y: Int)Int

example(1)(2)
// res3: Int = 3
```

 It can be a bit easier to read but more importantly, the use of multiple parameter lists to ease type inference. Scala’s type inference algorithm cannot use a type inferred for one parameter for another parameter in the same list. However, Scala can use types inferred for one parameter list in another parameter list.This means fewer type declarations, and a smoother development process.

9/ *Generic Product Type* -> A tuple is the generalisation of a pair to more terms. Scala includes built-in
   generic tuple types with up to 22 elements. 

10/ *Generic Sum Type* -> We introduce a new type that explicitly represents the disjunction. 
```scala
sealed trait Either[A, B]

final case class Left[A, B](value: A) extends Either[A, B]
final case class Right[A, B](value: B) extends Either[A, B]
```

11/ *Generic Optional Values* -> Option

12/ 
```scala 
// Where L is an object containing some A
final class L[A](){

  def map[B](f: A => B) : L[B] = { ... } 

  def flatMap[B](f: A => L[B]) : L[B] = { ... }
}
```

13/ Functors and Monads - simple definition 

A type like F[A] with a map method is a functor. If a functor also has a flatMap method it is called a monad.

14/ *Variance annotations* allow us to control sub-class relationships between types with type parameters.

A type Foo[T] is invariant in terms of T , meaning the types Foo[A] and Foo[B] are unrelated regardless of the
relationship between A and B . This is the default variance of any generic type in Scala.

A type Foo[+T] is covariant in terms of T , meaning Foo[A] is a supertype of Foo[B] if A is a supertype of B.
Most Scala collection classes are covariant in terms of their contents.

A type Foo[-T] is contravariant in terms of T , meaning Foo[A] is a subtype of Foo[B] if A is a supertype of B.
The only example of contravariance that I am aware of is func on arguments.

15/ *Covariant Generic Sum Type Pattern*
```scala
sealed trait A[+T]
final case class B[T](t: T) extends A[T]
case object C extends A[Nothing]
```

16/ *Contravariant Position Pattern*

If A of a covariant type T and a method f of A complains that T is used in
 a contravariant position, introduce a type TT >: T in f .

```scala
case class A[+T]() {
def f[TT >: T](t: TT): A[TT] = ???
}
```