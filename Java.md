# Java

### Key Features:
1.  **Class-based Object-Oriented Programming (OOP) Language:** Designed with minimal implementation dependencies.
2.  **Write Once, Run Everywhere (WORA):** Achieved through the Java Virtual Machine (JVM), allowing code to run on all platforms.
3.  **Just-In-Time (JIT) Compiler:** Converts `.java` source code to `.class` bytecode (platform-independent), which is then optimized at runtime by the JVM.
4.  **Automatic Garbage Collection:** Manages memory by automatically reclaiming unused objects.
5.  **Multithreading:** Supports concurrent execution of multiple parts of a program.

### Core Components:
* **JDK (Java Development Kit):** Contains tools for creating Java applications, including the compiler.
* **JRE (Java Runtime Environment):** Necessary to run compiled bytecode; includes the JVM.
* **JVM (Java Virtual Machine):** Executes bytecode, ensuring consistent program execution across different environments.
> Java is platform dependant, JVM is independent.
### Why is Java Not a Pure OOP Language?
1.  **Primitive Data Types:** It includes primitive data types (e.g., `int`, `float`) which are not objects.
2.  **Static Keyword:** Allows the use of static members (methods and variables) without creating an object instance.

### Java String Pool (Constant Pool/Intern Pool):
* When a string is created using `String s = "abc";`, Java checks the string pool.
* If the string already exists in the pool, a reference to the existing string object is returned.
* If it does not exist, a new string object is created in the pool, and a reference to it is returned.
* If a string is created using the `new` keyword (e.g., `String s = new String("abc");`), a new object is always created in the heap, outside of the string pool.
* Note: The string pool itself was moved to the heap after Java 7; it was a separate memory area before.

### Java Garbage Collector:
* Reclaims memory occupied by objects no longer referenced by application.
* process handled by JVM in background, no manual memory deallocation needed like C, C++.
* identifies unreachabe objects in heap, reclaims the space.
* Generational GC - divide heap into generations (young,old), based on object age. More frequent collections in young (minor GC), and since old ones have survived so long, fewer GCs needed.
* Types
    * Serial - single thread
    * Parallel - multiple thread for minor GC
    * Concurrent Mark Sweep(CMS) - most GC work while application runs.
    * Garbage First(G1) - divide heap into regions, sweep region with most garbage
### Misc
* Wrapper classes - convert primitives into object. Allows using collections.
    * Autoboxing - primitive -> wrapper
    * Unboxing - wrapper -> primitive
* **this** keyword - reference to current object
* **super** keyword - refer to immediate parent class, if using for parent constructor, super() must be first statement in child constructor.
* Why are strings immutable - string pool, security, thread safety.