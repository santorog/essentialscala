1/ Type parameters 
```
case class Name[A](...){ ... }
trait Name[A]{ ... }
def name[A](...){ ... }
```

2/ With type parameters we can do some Generic Sum Type Patterns
```
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
• one function parameter for each case in A;
• each function takes as parameters the fields for its associated class;
• if A is recursive, any function parameters that refer to a recursive
field take a parameter of type B.
The right-hand side of pattern matching cases, or the polymorphic methods as appropriate, consists of calls to the appropriate function


/ Placeholder syntax 

```scala
(_: Int) * 2 is expanded by the compiler to (a: Int) => a * 2
````
