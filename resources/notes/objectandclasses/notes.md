1/ Scala classes are all subclasses of java.lang.Object and are, for
the most part, usable from Java as well as Scala

2/ class Name(**val** parameter: type, ...)

3/ Notion of Keyword parameters

4/ 
![Type hierarchy](../../../resources/pictures/type_hierarchy.png)

5/ In Scala, by conven on, an object can be “called” like a func on if it has a method called apply

6/ Companion objects provide a way of implementing static methods. The common use is auxiliary constructors. 
We can also use this(parameters) to override the constructorsIt is important to note 
that the companion object is not an instance of the class — it is a singleton object 
with its own type.
A companion object has the same name as its associated class. This doesn’t cause
a naming conflict because Scala has two namespaces: the namespace of values
and the namespace of types.
