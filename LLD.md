# LLD

## Design Principles
### SOLID Principle
1. **Single Responsibility Principle**: each class should have one job/purpose
    * improved extensibility
    * readibility
    * debugging
    * maintainability
    * change in one doesnt affect others
2. **Open Closed Principle**: entities should be open for extension but closed for modification
    * prevents breaking existing code
    * encourages resuable components
3. **Liskov Substitution Principle**: any child class should be usable in place of its parent without unexpected behavior
    * reliability in polymorphism
    * no unexpected behavior
4. **Interface Segregation Principle**: dont force any client to implement any interface not relevant to it, kinda like SRP for interfaces. Avoid fat interfaces, smaller more focused ones better, since classes would only need to implement methods relevant to their functionality.
5. **Dependency Inversion Principle**: depend on interfaces rather than concrete classes.
    * high level modules should'nt depend on low level modules, both should depend on abstractions.
    * abstractions should not depend on details, details should depend on abstractions.
    * E.g.: one logger. needs EmailNotificationService. uses that class in it.
       * now if i want to have SMSNotification instead of email, i gotta change code.
       * instead, make a NotificationService interface, make SMS and Email services implement them, and in the logger class, just have NotificationService object.
       * now calling function can send whatever type of notification it wants.

### DRY Principle
* **Dont Repeat Yourself**: create reuseable components, functions or modules that can be utilised in different parts of the codebase.
* Features:
    * readibility
    * maintainability
    * reusability
    * consistency
    * testability
    * less development time
    * avoid copy paste
* How to?
    * use functions
    * use OOPs principles
    * use constants, configuration files

### KISS
* **Keep It Simple, Stupid**: simplicity in design and implementation.
* thin line between scalable and maintainable and over complicated code.
* How to implement?
  * break down problems
  * avoid over engineering
  * use clear naming conventions
  * use existing design patterns
  * write modular code

### YAGNI
* **You Aren't Gonna Need It**: should only implement features necessary for current requirements.

## Creational Design Patterns
- manage how objects are created, provide smart, controlled way to handle object creation process.
- centralize and streamline creation, make system flexible and easier to maintain.

1. **Singleton Pattern**
   * ensures only one instance of class throughout system.
   * reduce resource wastage, ensure consistent behavior
   * useful for managing shared resources like config manager, logging service, thread pool. here, we need a single point of control.
   * have a private constructor, and a static method to return the instance.
   * ![Singleton pattern](singleton.png)
   * we need to ensure if instance is not created, 2 instances are not made by 2 different threads, so need synchronisation.
   * but if we make whole mehod synchronised, it is expensive, so we check if its null first
   * so we make only the creation part sync.
   * lazy initialization - object only created when needed, since it may be heavy or expensive to create.

2. **Factory Method Pattern**
   * allow different types of object creations 
   * handle object creation in a centralised manner.
   * when you have a class that needs to create objects, but you want its subclasses to be responsible for specifying which objects to create.
   * also implements encapsulation
   * example - bean injection in spring.
   * ![alt text](factory.png)

3. **Abstract Factory Pattern**
   * creat related objects without specifying their concrete classes directly.
   * instead of modifying one method each time new brand added, just separate factories for each new brand.
   * basically if many many different object types, better to use abstract factory. 
   * ![alt text](abstractFactory.png)

4. **Builder Pattern**
   * construct complex objects step by step
   * large objects - object creation has lots of attributes, and not all objects will have all, still need to pass if using constructor.
   * create step by step, only attributes you need to set, add defaults, and easily extend
   * ![alt text](builder.png)
   * Use Cases: complex meals(toppings, drinks), documents, user profile

5. **Prototype Pattern**


## Behavioral Patterns

1. Obeserver Pattern
   * multiple objects need to react when one object changes. can notify each object manually, but bad.
   * ![alt text](observer.png)

2. Strategy Pattern
   * if i want to implement multiple algorithms, for example, sorting by different criteria.
   * each algo has its own class, can be called based on what is needed, add new by just making a new calls.
   * ![alt text](strategy.png)

3. **Iterator**
4. **Command**
    * decouples object that trigeers the action, from the one that performs it.
   * ![alt text](command.png)
5. **Mediator**
6. **State Design**
7. **Template Design**
8. **Chain of Responsibility**
9. **Visitor**
10. **Memento**

## Structural Patterns

1. **Decorator**
   * example scenario - a text editor. at first, just basic, then adding features like spell check, auto save and turn them on if user decides to.
   * cant keep making if else statements and sub classes.
   * ![alt text](decorator.png)

2. **Adapter**
   * acts as a bridge between two incompatible interfaces, allowing them to work together.
   * ![alt text](adapter.png)

3. **Composite**
4. **Facade**
5. **Bridge**
6. **Proxy**
7. **Flyweight**