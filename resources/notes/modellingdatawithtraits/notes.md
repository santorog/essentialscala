
1/
- If all the subtypes of a trait are known, seal the trait
- Consider making subtypes *final* if there is no case for extending them, or *sealed* if we want to allow extension within the file.

2/ 
- The compiler will warn us if we miss a case of pattern matching when we declare a class as sealed.
- We can control extension points of sealed traits and thus makes stronger guarantees about the behaviour of subtypes.



