# Spring, Spring Boot, Spring MVC

## Spring and its Core Features

Spring is an open-source framework for building enterprise Java applications.

### Core Features

  * **Inversion of Control (IoC):** Used for creating a loosely coupled architecture where a change in one component has a minimal impact on others. The framework controls object creation and dependency management.
  * **Dependency Injection (DI):** A design pattern used to implement the IoC principle. The Spring IoC container uses an `AppConfig` class to decide which dependency to inject. We define dependencies as interfaces, then just modify the `AppConfig.java` to inject different concrete classes.
      * **Steps:** DI in Spring involves the following steps:
        1.  **Define the Dependency:** Create an interface for the dependency (e.g., `MovieFinder`) and then a concrete class that implements it (e.g., `ColonDelimitedMovieFinder`).
        2.  **Define the Dependent Class:** Create the class that requires the dependency (e.g., `SimpleMovieLister`).
        3.  **Specify Injection Point and Type:**
              * **Constructor Injection:**
                ```java
                public class SimpleMovieLister {
                    private final MovieFinder movieFinder;
                    public SimpleMovieLister(MovieFinder movieFinder) {
                        this.movieFinder = movieFinder;
                    }
                    // ...
                }
                ```
              * **Setter Injection:**
                ```java
                public class SimpleMovieLister {
                    private MovieFinder movieFinder;
                    public void setMovieFinder(MovieFinder movieFinder) {
                        this.movieFinder = movieFinder;
                    }
                    // ...
                }
                ```
              * **Field Injection:**
                ```java
                public class SimpleMovieLister {
                    private MovieFinder movieFinder; // No constructor or setter needed for injection
                    // ...
                }
                ```
        4.  **Configure Spring for Dependency Injection:**
              * **Annotation-based (Recommended):** Annotate the dependency implementation class with a stereotype annotation like `@Component`, `@Service`, `@Repository`, or `@Controller`. Then, annotate the injection point in the dependent class with `@Autowired`.
                ```java
                // For Constructor Injection
                @Service
                public class SimpleMovieLister {
                    private final MovieFinder movieFinder;
                    @Autowired
                    public SimpleMovieLister(MovieFinder movieFinder) {
                        this.movieFinder = movieFinder;
                    }
                    // ...
                }
                // For Setter Injection
                @Service
                public class SimpleMovieLister {
                    private MovieFinder movieFinder;
                    @Autowired
                    public void setMovieFinder(MovieFinder movieFinder) {
                        this.movieFinder = movieFinder;
                    }
                    // ...
                }
                // For Field Injection
                @Service
                public class SimpleMovieLister {
                    @Autowired
                    private MovieFinder movieFinder;
                    // ...
                }
                ```
              * **XML-based:** Define the beans and their dependencies in an XML configuration file using `<bean>` and `<property>` or `<constructor-arg>` tags.
        5.  **Spring Container Manages Objects:** The Spring IoC container reads the configuration. When an instance of the dependent class is needed, Spring creates it, finds a suitable bean for the dependency, and injects it into the dependent class at the specified injection point.
  * **Simplified Configuration**
  * **Spring Container:** The core of the framework that manages beans and their lifecycle.
  * **Spring MVC:** A module for building web applications.
  * **Spring Data Access:** A module for simplifying database interactions.
  * **Real-time Capabilities**

-----

## Important Concepts

  * **Components and `@Component`:** A stereotype annotation that indicates a class is a Spring-managed component.
  * **Bean and `@Bean`:** An object that is instantiated, configured, and managed by the IoC container. Beans are the building blocks of a Spring application. The `@Bean` annotation is used on methods that return bean objects.
  * Every component is a bean, but not every bean is a component.
  * **Life Cycle of a Bean:**
    1.  Spring IoC container (context) starts.
    2.  Bean is instantiated.
    3.  Dependencies are injected.
    4.  Bean is initialized (custom initialization steps can be added).
    5.  Bean is used.
    6.  Bean is destroyed (custom cleanup steps can be added).
  * **`AppConfig`:** A configuration class that defines beans.
  * **`@Configuration`:** An annotation that indicates the class declares bean methods.
  * **`@ComponentScan`:** An annotation that indicates Spring will automatically scan a package and its sub-packages for Spring components.
  * **Spring IoC Container:** The context responsible for managing the beans based on the `AppConfig`.
  * **`@Autowired`:** Automatically injects dependencies into Spring-managed beans, eliminating the need for manual instantiation.
  * **Scope of a Bean:** The lifecycle and visibility of beans. It is `singleton` by default. The `@Scope` annotation is used for defining scope.
      * **Types of Scope:**
        1.  `Singleton`: Exactly one instance of the bean exists and is reused every time it is requested.
        2.  `Prototype`: A new instance of the bean is created every time it is requested.
        3.  `Request`: A new instance is created for each HTTP request.
        4.  `Session`: A new instance is created for each HTTP session.
        5.  `Application`: A single instance is created for the entire application lifecycle.
  * **Spring AOP:** Aspect-Oriented Programming. Used to separate cross-cutting concerns (like logging, security) from business logic.
  * **Circular Dependencies:** A situation where two or more services depend on each other.
      * To resolve this, use setter injection and carefully manage the code to prevent errors, or use the `@Lazy` annotation to delay injection.
  * **BeanFactory:** The predecessor to `ApplicationContext`.

### BeanFactory vs ApplicationContext

| Feature | BeanFactory | ApplicationContext |
| :--- | :--- | :--- |
| **Initialization** | Lazy (loads beans only when requested) | Eager (loads all singleton beans at startup) |
| **Features** | Limited support | Full support with message sources, transaction management, etc. |
| **Integration** | Minimal integration | Integrates with AOP |
| **Resource Loading** | Simple resource loading | Supports classpath, file system, URLs |
| **Suitability** | Suitable for small applications | Suitable for enterprise and large applications |

-----

## Spring Boot

  * Spring + Embedded servers + Auto Configuration + Starter templates = Spring Boot.
  * Built on top of Spring.
  * It helps developers quickly make standalone, production-ready applications with minimal setup and configuration.
  * **How does it provide auto-configuration?**
      * It uses dependencies on the classpath.
      * It uses `@EnableAutoConfiguration`.
      * It scans the classpath. For example, if `spring-boot-starter-data-jpa` is on the classpath, it automatically configures the data source bean. It uses conditional annotations like `@ConditionalOnClass`.
      * It scans the `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` file.
  * **`@SpringBootApplication`:** This annotation bootstraps the application and is a combination of three annotations:
    1.  `@Configuration`: Marks the class as a source of bean definitions.
    2.  `@ComponentScan`: Scans the **package** and sub-packages for Spring components.
    3.  `@EnableAutoConfiguration`: Enables auto-configuration of Spring components.

### Project Structure

  * `src/main/java/`: All main Java source code.
      * `|-config/` - Configuration classes (`@Configuration`).
      * `|-controller/` - Controllers to handle HTTP requests (`@RestController` / `@Controller`).
      * `|-model/` - Entity classes representing the data model (`@Entity`).
      * `|-repository/` - Interfaces used to interact with the database (`@Repository`).
      * `|-service/` - Service classes with business logic (`@Service`).
      * `|-Main class` - The entry point of the application (`@SpringBootApplication`).
  * `src/main/resources/`: Non-Java resources.
      * `|-static/` - Static assets like CSS, JS, images, served directly by the web server.
      * `|-templates/` - View templates like FreeMarker, Thymeleaf for server-side rendering of web pages.
      * `|-application.properties` OR `.yml` - Configuration files.

-----

## Spring MVC

  * A module in Spring that simplifies web application development by using the Model-View-Controller pattern.
  * **Model:** Represents the data and business logic.
  * **View:** Represents the UI (User Interface).
  * **Controller:** Handles user input and coordinates the interaction between the Model and View.
  * **Dispatcher Servlet:** The front controller responsible for receiving incoming requests and dispatching them to the appropriate controllers. This would need to be configured in a traditional Spring application, but not in Spring Boot.

### `@Controller` vs `@RestController`

  * **`@Controller`:** A general-purpose annotation for handling web requests. It's used for applications that return views like HTML or JSP pages.
  * **`@RestController`:** A specialized version of `@Controller` that combines `@Controller` and `@ResponseBody`. It's used to create RESTful web services where the response is typically JSON or XML.

### `@RequestParam` vs `@PathVariable`

  * **`@RequestParam`:** Used to extract query parameters, form data, or other parameters from the URL.
      * **Example:** URL $\\rightarrow$ `/greet?name=john`
    <!-- end list -->
    ```java
    @GetMapping("/greet")
    public String greet(@RequestParam("name") String name) {
        // ...
    }
    ```
  * **`@PathVariable`:** Used to extract values from the URI path itself.
      * **Example:** URL $\\rightarrow$ `/order/user/123`
    <!-- end list -->
    ```java
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        // ...
    }
    ```