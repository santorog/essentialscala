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


/ Placeholder syntax 

```scala
(_: Int) * 2 is expanded by the compiler to (a: Int) => a * 2
_ + _     // expands to `(a, b) => a + b`
foo(_)    // expands to `(a) => foo(a)`
foo(_, b) // expands to `(a) => foo(a, b)`
_(foo)    // expands to `(a) => a(foo)`
// and so on...
````

/ Converting methods to functions => simply follow a method with an underscore

/ Multiple parameters lists

```scala
def example(x: Int)(y: Int) = x + y
// example: (x: Int)(y: Int)Int

example(1)(2)
// res3: Int = 3
```

 It can be a but easier to read but more importantly, the use of multiple parameter lists to ease type inference. Scala’s type inference algorithm cannot use a type inferred for one parameter for another parameter in the same list. However, Scala can use types inferred for one parameter list in another parameter list.This means fewer type declarations and a smoother development process.

/ 

