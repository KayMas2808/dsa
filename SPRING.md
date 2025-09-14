# Spring, SpringBoot, Spring MVC

## Spring and its Core features
open source framework for building enterprice java applications

### Core features
* Inversion of control
  * used for creating losely coupled architecture - change in one have minimal impact on others.
  * framework controls object creation and dependency management.
* Dependency Injection
  * design pattern  used to implement IoC principle
  * Spring IoC container uses AppConfig to decide which dependency to inject.
  * we make the dependencies as interfaces, then just modify appconfig.java to make different class injected.
  * Steps:
    * Dependency Injection (DI) in Spring involves the following steps, regardless of whether you are using constructor, setter, or field injection: 

    • Define the Dependency: 
	    • Create the interface for the dependency (e.g., MovieFinder). 
	    • Implement the concrete class for the dependency (e.g., ColonDelimitedMovieFinder implementing MovieFinder). 

    • Define the Dependent Class: 
	    • Create the class that requires the dependency (e.g., SimpleMovieLister). 

    • Specify Injection Point and Type: 
      1. Constructor Injection: Create a constructor in the dependent class that takes the dependency interface as an argument. 
      ```java
        public class SimpleMovieLister {
            private final MovieFinder movieFinder;

            public SimpleMovieLister(MovieFinder movieFinder) {
                this.movieFinder = movieFinder;
            }
            // ...
        }
      ```
      2. Setter Injection: Create a setter method in the dependent class that takes the dependency interface as an argument. 
      ```java
        public class SimpleMovieLister {
            private MovieFinder movieFinder;

            public void setMovieFinder(MovieFinder movieFinder) {
                this.movieFinder = movieFinder;
            }
            // ...
        }
      ```

      3. Field Injection: Declare the dependency as a field in the dependent class. 
      ```java
        public class SimpleMovieLister {
            private MovieFinder movieFinder; // No constructor or setter needed for injection
            // ...
        }
      ```

    • Configure Spring for Dependency Injection: 
	    • Annotation-based (Recommended): 
		    • Annotate the dependency implementation class with a stereotype annotation like @Component, @Service, @Repository, or @Controller to make it a Spring bean. 
		  • Annotate the injection point in the dependent class with @Autowired. 
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

      • XML-based: Define the beans and their dependencies in an XML configuration file using &lt;bean&gt; and &lt;property&gt; or &lt;constructor-arg&gt; tags. 

      • Spring Container Manages Objects: 
	      • Spring's IoC container reads the configuration (annotations or XML). 
	      • When an instance of the dependent class is needed, Spring creates it. 
	      • Spring then finds a suitable bean for the dependency and injects it into the dependent class at the specified injection point (constructor, setter, or field).
* Simplified Configuration
* Spring Container
* Spring MVC
* Spring Data Access
* Real-time capabilities

## Important concepts
* Components and @Component: indicate that a class is a spring managed component.
* Bean and @Bean: object that is instantiated, configured and managed by IoC container. building blocks of spring app. @Bean methods return bean objects.
* Every component is a bean but not every bean is a component.
* Life Cycle of a bean:
  1. Spring IoC container (context) started - reads definitions, registers them within context.
  2. Bean instantiated
  3. Dependency Injected
  4. Bean initialized - any custom initialisation steps for setup.
  5. Bean used
  6. Bean destroyed - cleanup
* AppConfig - configuration class that defines beans.
* @Configuration - indicates that the class declares bean methods.
* @ComponentScan - indicate that spring will automatically scan and register beans from package.
* Spring IoC container - it is the context. Its responsible for managing the beans based on AppConfig
* @Autowired - automatically injects dependencies into spring managed beans, eliminating need for manual instantiation.