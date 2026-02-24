
Amazon
Introduction to JPA
Introduction
Your new cafe is very popular with a vast menu and hundreds of customers daily. Keeping track of all the orders, updating ingredients, and managing customer preferences manually is a total headache. What if a tool could handle all the ordering, tracking, and inventory updates for you so you could focus on crafting new recipes and making your customers happy?

That’s precisely what Spring Data JPA does for a Spring MVC project. It takes care of all the complex, repetitive data tasks—like saving, updating, and finding information—so you don’t have to write loads of code to make it work. With Spring Data JPA, you get an efficient, automated system for managing data, letting you focus on building great features for your app.

What is JPA?
JPA stands for Java Persistence API. It is an object-relational mapping (ORM) framework that allows you to map Java objects to tables in a relational database.

ORM is a technique that allows programmers to write in a programming language of their choice and hide the code needed to manipulate the data, so they don't need to use SQL anymore. The goal is to help programmers work with databases using object-oriented programming concepts, such as classes, objects, and methods, rather than having to write low-level SQL code.

In Java, you work with objects, which represent real-world entities with properties and behaviors. On the other hand, a database organizes data into rows and columns. So, how do you save the object in a database with rows and columns? This is where the Java Persistence API (JPA) comes in. It provides a mechanism that maps the objects to the relational database model.

JPA provides a way to persist Java objects in a database using a set of annotations that define the mapping between Java classes and database tables. JPA is just a specification, so it doesn't perform any operation alone and requires an implementation to function. So, ORM tools like Hibernate, TopLink, and iBatis implement JPA specifications for data persistence. For example, Hibernate provides tools for mapping Java objects to a database. It operates at a lower level and requires more configuration and code for managing database interactions. Spring Data JPA works at a higher level and can use implementations like Hibernate. 

What is Spring Data JPA? 
Spring Data JPA is part of the larger Spring Framework, specifically designed to simplify the interaction between Java applications and databases using the Java Persistence API (JPA). Imagine your database understanding what you need without having to spell out every detail. That's the magic of Spring Data JPA!

Think of Spring Data JPA as an intelligent assistant for managing your data, one that streamlines how your application connects to the database. With Spring Data JPA, you can handle data operations without writing complex SQL. It allows you to focus on the main logic while it takes care of the heavy lifting – whether you're saving, retrieving, or even searching through records. Built to simplify life for Java developers and make data management an almost effortless experience.

Get ready to see your database come to life with less code and more speed!

What does Spring Data JPA do for you?
By handling common database tasks and minimizing the need for SQL, Spring Data JPA enables developers to focus on application logic rather than repetitive data operations. For example:

Simplifies database access: It helps you save, retrieve, update, and delete data in a relational database without writing much SQL code.

Reduces boilerplate code: With Spring Data JPA, you don’t need to write repetitive code for basic database operations, as it provides a range of tools to do that for you.

Provides easy abstraction: Instead of writing SQL queries, you work with Java objects, making your code more object-oriented and easier to maintain.

Spring Data JPA maps Java classes to database tables and handles data operations through repository interfaces. This approach abstracts away much of the complexity of database interactions, making it easier to manage data within your application:

Entities represent database tables: You define classes, called "entities," representing tables in your database. Each object (or instance) of an entity corresponds to a row in the database table.

Repositories handle data operations: Spring Data JPA provides "repository" interfaces that handle CRUD (create, read, update, delete) operations. You don’t need to implement these interfaces; Spring automatically does it at runtime.

Create and set a Spring Boot Project
In your previous project, CoffeeShopMenu, you noticed that even after adding new items through the form, you cannot reflect or save the changes permanently. The newly added components are lost every time you start the application. So, let’s integrate the database into this application and insert and save our items in the Database table.

Step 1: Adding dependencies
 Follow these instructions:

Open your menu Project and CoffeeShopMenuApplication.

In pom.xml with the generate option, add the following dependencies to restart the server after every modification using Spring Data JPA, MySQL DB, and Devtools.


The Spring Boot Application must be reconfigured in order to download new dependencies..  Begin the reconfiguration by selecting :


Add two packages to your application structure named service and repository. The service package will contain all service classes, and the repository package will contain all the jpa repositories.


Please note the following dependency code block in pom.xml, which is the starter dependency for using Spring Data JPA: 

12345
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

This dependency provides a one-stop shop for all libraries to develop a persistence or repository layer. This starter dependency internally manages all libraries required for JPA, Hibernate, and Database connection with all the versions needed according to their compatibilities.

Step 2: Configure and connect MySQL Database
To connect your application to the MySQL database, you need database properties like JDBC URL, MySQL Database Username, MySQL Database Password, and Hibernate Properties.

You can follow these steps:

Navigate to MySQL WorkBench IDE and create the Database for the application with SQL statements.


In IntelliJ Idea, open the file application.properties and add the required database properties:


Step 3: JPA entity annotations
Follow these instructions:

In the model package, open Product.java. This is a simple Java class. Let’s convert this to a JPA entity by adding the JPA annotations.	


The Entity Annotation

Entities in JPA are nothing but POJOs (Plain Old Java Objects) representing data that can be persisted in the database. An entity represents a table stored in a database, and every instance of an entity represents a row in the table.

Let’s say you have a POJO (Plain Old Java Object) called Product that represents product data, and you want to store it in a database.

12345
public class Product {

//fields, getters, and setters
}

To do this, you must ensure that JPA recognizes the entity by defining it using the @Entity annotation. You must specify this annotation at the class level. Also, ensure that the entity has a no-arg constructor and a primary key.

The entity name defaults to the name of the class. You can change the name with the name element.

123456
@Entity(name="Products")
public class Product {

        // fields, getters, and setters
        }

Defining the primary key

Each JPA entity must have a primary key that uniquely identifies it. 
The 
@Id
 annotation
 defines the primary key. It can be generated by identifying different ways specified by the @GeneratedValue annotation.

With the strategy element, you can choose from four ID generation strategies. The value can be AUTO, TABLE, SEQUENCE, or IDENTITY.

GenerationType.IDENTITY: Relies on the database's auto-increment feature to generate primary key values.

GenerationType.AUTO: The default strategy where the persistence provider(e.g., Hibernate) automatically chooses the generation strategy based on the database.

GenerationType.TABLE: A dedicated database table generates unique primary key values managed by the persistence provider.

GenerationType.SEQUENCE: This method generates primary key values using a database sequence, requiring sequence objects specific to the database.

1234567891011
@Entity
public class P {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

        private String name;

        // getters and setters
}

The Table annotation

In most cases, the table's and entity's names in the database won’t be the same. In these cases, you can specify the table name using the @Table annotation.

1234567
@Entity
@Table(name="Products")
public class Product {

        // fields, getters and setters
        }

If the @Table annotation is not mentioned exclusively, the table's name in the database is, by default, the same as the class name.

The Column annotation

Just like the @Table annotation, you can use the @Column annotation to mention the details of a column in the table. The @Column annotation has many attributes: name, length, nullable, and uniqueness.

12345
@Column(name="PRODUCT_NAME", length=50, nullable=false, unique=false)
private String name;
// other fields, getters and setters
        }

If this annotation is not specified, by default the field names of classes in Java will be the column names in the Database.

Step 3: Repository
In Spring Boot, a repository manages data persistence and retrieval in a database. It provides an abstraction layer over the database and simplifies interaction, allowing programmers to focus on main logic rather than database operations. 

@Repository annotation indicates that the class provides the mechanism for storage, retrieval, search update, and delete operations on objects. Spring Data JPA provides the necessary infrastructure to recognize interfaces extending JpaRepository as repositories and automatically generates instances of these interfaces. Therefore, adding @Repository to these interfaces is optional.

Syntax for creating Repository:

12
public interface JpaRepository<T,ID>
 extends PagingAndSortingRepository<T,ID>, QueryByExampleExecutor<T> 
Where:

T: Domain type that the repository manages (generally the Entity/Model class name).

ID: Type of the id of the entity that the repository manages (generally the wrapper class of your @Id that is created inside the Entity/Model class).

Now that you understand the syntax for creating a Repository and the significance of each element, here is an example of creating a Repository:

1
public interface ProductRepository extends JpaRepository<Product, Long> {}
Follow these instructions to create and use Spring Data JPA Repository:

Create a repository interface and extend the JpaRepository interface.


Extend the ProductRepository interface with the JpaRepository interface, which takes two arguments: JPA Entity and Primary Key. Hence, you can use all the CRUD methods provided by Spring Data JPA for Product Entity.


In the service package, create an interface ProductService and add a simple method.


Create a class, ProductServiceImpl, that implements the ProductService interface and injects ProductRepository using the @Autowired annotation. You must annotate with @Service.

Important 

The @Autowired annotation in Spring automatically injects a required dependency (a class or bean) into another class where it is needed. It saves you from manually creating or passing objects and allows Spring to handle dependency management.

The @Service annotation indicates that the class is a service component in the Spring application.


Create a method handler for the home page with menu.html to display a list of employees.


Create the menu.html page by inserting the tags inside the <body> tags.


The project structure will look similar to this:


Run the SpringBootApplication.Once the application is started, you'll see the server running in IntelliJ.


Navigate to the browser and enter the URL as 
http://localhost:8080
. An empty table with headings should be displayed.


In MySQL Workbench, you will see an empty Table created.


Next, insert a few rows into the table as shown in the image and refresh the browser page. 


 


Create an ADD button and method to add the records to our menu. In the service interface, add another method, addProduct’, with no return type. Implement this method and override the service class ProductServiceImpl.



After the closing </table> tag in menu.html, add a link to navigate to the add-new-product form.


In ProductController, write method Handler to handle this new request.


In the Thymeleaf template, add-new-product.html, and make the required changes to the new item form. Use the thyme leaf tags with proper syntax to avoid errors.


Finally, implement a new method handler for this new request /saveProduct in the ProductController.


 Conclusion
In this reading, you explored using Spring Data JPA to simplify database interactions by reducing boilerplate code and offering convenient repository interfaces. Setting up Spring Data JPA includes configuring the database connection, defining entity classes, and creating repositories for CRUD operations. 

These straightforward steps enable you to efficiently generate and save entities to a MySQL database.

Completed
