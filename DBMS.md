# Database Management System

## What is DBMS? Mention advantages.

A Database Management System (DBMS) is software for storing and retrieving users' data while considering appropriate security measures. It consists of a group of programs that manipulate the database. The DBMS accepts the request for data from an application and instructs the operating system to provide the specific data. In large systems, a DBMS helps users and other third-party software to store and retrieve data.

### Advantages:
* Improved data sharing
* Improved data security
* Better data integration
* Minimized data inconsistency
* Improved data access
* Improved decision making
* Improved end-user productivity

## What is Database?

A database is an organized collection of structured information, or data, typically stored electronically in a computer system. A database is usually controlled by a database management system (DBMS). Together, the data and the DBMS, along with the applications that are associated with them, are referred to as a database system, often shortened to just a database.

## What is a database system?

A database system refers to the combination of the database itself, the Database Management System (DBMS), and the applications that interact with them. It is a complete environment for managing and using data.

## What is RDBMS? Properties?

A Relational Database Management System (RDBMS) is a database management system that is based on the relational model. It has the following major components: Table, Record/Tuple/Row, Field, and Column/Attribute. Examples of the most popular RDBMS are MySQL, Oracle, IBM DB2, and Microsoft SQL Server database.

### Relational databases have the following properties:
* Values are atomic.
* All of the values in a column have the same data type.
* Each row is unique.
* The sequence of columns is insignificant.
* The sequence of rows is insignificant.
* Each column has a unique name.
* Integrity constraints maintain data consistency across multiple tables.

## Types of database languages

* **Data Definition Language (DDL):** DDL is used to define the database structure or pattern. It deals with the schema and descriptions of how the data resides in the database.
* **Data Manipulation Language (DML):** DML is used for accessing and manipulating data in a database. It handles user requests to insert, retrieve, update, and delete data.
* **Data Control Language (DCL):** DCL is used to control access to data in the database. It deals with permissions, rights, and other controls of the database system.
* **Transaction Control Language (TCL):** TCL is used to manage transactions within the database. It is used to run the changes made by the DML statement. TCL can be grouped into a logical transaction.

## ACID properties (Very Very Very Very Very Important)

To ensure the consistency of the database, certain properties are followed by all the transactions occurring in the system. These properties are called ACID Properties of a transaction.

* **Atomicity:** Ensures that all operations within a transaction are completed successfully; otherwise, the transaction is aborted at the point of failure, and previous operations are rolled back to their former state.
* **Consistency:** Ensures that a transaction brings the database from one valid state to another, maintaining all defined rules, constraints, and relationships.
* **Isolation:** Ensures that concurrent execution of transactions leaves the database in the same state that would have been obtained if the transactions were executed sequentially.
* **Durability:** Guarantees that once a transaction has been committed, it will remain committed even in the case of a system failure (e.g., power outage, crash).

## Difference between vertical and horizontal scaling

Scaling alters the size of a system. In the scaling process, we either compress or expand the system to meet the expected needs. The scaling operation can be achieved by adding resources to meet smaller expectations in the current system, or by adding a new system to the existing one, or both.

### Vertical Scaling (Scaling Up):
Vertical scaling keeps your existing infrastructure but adds computing power. Your existing code does not need to change — you simply need to run the same code on machines with better specs (e.g., more CPU, RAM, or storage for a single server). By scaling up, you increase the capacity of a single machine and increase its throughput. Vertical scaling allows data to live on a single node and spreads the load through CPU and RAM resources for your machines.

### Horizontal Scaling (Scaling Out):
Horizontal scaling simply adds more instances of machines without first implementing improvements to existing specifications. By scaling out, you share the processing power and load balancing across multiple machines (e.g., adding more servers to a distributed system).

## What is sharding?

Sharding is a method of splitting and storing a single logical dataset into multiple databases. By distributing the data among multiple machines, a cluster of database systems can store larger datasets and handle additional requests. Sharding is necessary if a dataset is too large to be stored in a single database. Moreover, many sharding strategies allow additional machines to be added. Sharding allows a database cluster to scale along with its data and traffic growth.

## Keys in DBMS

A key is a set of attributes that can identify each tuple uniquely in the given relation.

### Types of Keys:
* **Super Key:** A superkey is a set of attributes that can identify each tuple uniquely in the given relation. A super key may consist of any number of attributes.
* **Candidate Key:** A set of minimal attribute(s) that can identify each tuple uniquely in the given relation is called a candidate key.
* **Primary Key:** A primary key is a candidate key that the database designer selects while designing the database. Primary Keys are unique and NOT NULL.
* **Alternate Key:** Candidate keys that are left unimplemented or unused after implementing the primary key are called alternate keys.
* **Foreign Key:** An attribute ‘X’ is called a foreign key to some other attribute ‘Y’ when its values are dependent on the values of attribute ‘Y’. The relation in which attribute ‘Y’ is present is called the referenced relation. The relation in which attribute ‘X’ is present is called the referencing relation.
* **Composite Key:** A primary key composed of multiple attributes and not just a single attribute is called a composite key.
* **Unique Key:** It is unique for all the records of the table. Once assigned, its value cannot be changed, i.e., it is non-updatable. It may have a NULL value.

## Types of relationship

A relationship is defined as an association among several entities.

* **Unary Relationship Set:** A unary relationship set is a relationship set where only one entity set participates in a relationship set.
* **Binary Relationship Set:** A binary relationship set is a relationship set where two entity sets participate in a relationship set.
* **Ternary Relationship Set:** A ternary relationship set is a relationship set where three entity sets participate in a relationship set.
* **N-ary Relationship Set:** An N-ary relationship set is a relationship set where ‘n’ entity sets participate in a relationship set.

## Data abstraction in DBMS, three levels of it

Data Abstraction is a process of hiding unwanted or irrelevant details from the end user. It provides a different view and helps in achieving data independence, which is used to enhance the security of data. Database systems include complex data structures. In terms of retrieval of data, to reduce complexity in terms of usability for users and to make the system efficient, developers use levels of abstraction that hide irrelevant details from the users. Levels of abstraction simplify database design.

### Three Levels of Data Abstraction:
1.  **Physical Level:** The lowest level of abstraction. It describes *how* the data is actually stored on storage devices. This level deals with the physical storage details, such as file organization, indexing, and data compression.
2.  **Logical Level (Conceptual Level):** The next higher level of abstraction. It describes *what* data is stored in the database and the relationships among that data. This level describes the entire database in terms of a schema, independent of its physical storage.
3.  **View Level (External Level):** The highest level of abstraction. It describes only part of the entire database. It defines the specific data that a particular user group or application needs and hides the rest of the database from them. Multiple views can exist for the same logical schema.

## Indexing in DBMS

Indexing is a way to optimize the performance of a database by minimizing the number of disk accesses required when a query is processed. It is a data structure technique which is used to quickly locate and access the data in a database.

## What is DDL (Data Definition Language)?

DDL stands for Data Definition Language. It is used to define database structure or pattern. It is used to create schema, tables, indexes, constraints, etc., in the database. Using the DDL statements, you can create the skeleton of the database. Data definition language is used to store the information of metadata like the number of tables and schemas, their names, indexes, columns in each table, constraints, etc.

## What is DML (Data Manipulation Language)?

DML stands for Data Manipulation Language. It is used for accessing and manipulating data in a database. It handles user requests for operations like selecting, inserting, updating, and deleting data.

## What is normalization? Types of normalization.

Normalization is the process of organizing data by disintegrating bigger tables into smaller ones with proper dependencies. Redundant data wastes a lot of disk space and creates maintenance problems (Update, Insert, and Delete Anomaly). Hence, the database tables should be Normalized. The process of Normalization is achieved by following some rules which are defined as Normal Forms.

### Types of Normal Forms:
There are basically 3 types of Normal Form – 1NF, 2NF, 3NF. Strictness increases as we go from 1NF to 3NF. Apart from the above-mentioned Normal Forms, there exists one more Form called Boyce Codd Normal Form (BCNF). This is an advanced version of 3NF and is even stricter than 3NF.

*(Additional detail for Normal Forms, as per "Read normalization in details")*
* **First Normal Form (1NF):** Eliminates repeating groups in tables. Ensures all values in a column are atomic and each column contains a single value.
* **Second Normal Form (2NF):** Satisfies 1NF and all non-key attributes are fully functionally dependent on the primary key. This means no non-key attribute is dependent on only a part of the composite primary key.
* **Third Normal Form (3NF):** Satisfies 2NF and all non-key attributes are not transitively dependent on the primary key. This means no non-key attribute is dependent on another non-key attribute.
* **Boyce-Codd Normal Form (BCNF):** A stricter version of 3NF. A table is in BCNF if for every non-trivial functional dependency X → Y, X is a superkey. It addresses anomalies that 3NF might miss when there are multiple overlapping candidate keys.

## What is denormalization?

Denormalization is a database optimization technique in which we add redundant data to one or more tables. This can help us avoid costly joins in a relational database. Note that denormalization does not mean not doing normalization. It is an optimization technique that is applied after doing normalization.

## What is functional dependency?

A functional dependency is a constraint that specifies the relationship between two sets of attributes where one set can accurately determine the value of other sets. It is denoted as X → Y, where X is a set of attributes that is capable of determining the value of Y. The attribute set on the left side of the arrow, X, is called the Determinant, while on the right side, Y, is called the Dependent.

## E-R Model?

ER model stands for an Entity-Relationship model. It is a high-level data model. This model is used to define the data elements and relationships for a specified system. It develops a conceptual design for the database. It also develops a very simple and easy to design view of data. In ER modeling, the database structure is portrayed as a diagram called an entity-relationship diagram.

## Conflict Serializability in DBMS?

Serializability is a concept that helps us to check which schedules are serializable. A serializable schedule is one that always leaves the database in a consistent state. A schedule is called conflict serializable if, after swapping of non-conflicting operations, it can transform into a serial schedule. The schedule will be conflict serializable if it is conflict equivalent to a serial schedule.

## What is CCP? (Concurrency Control Protocols)

Concurrency Control is the management procedure that is required for controlling concurrent execution of the operations that take place on a database. The concurrency control protocols ensure the atomicity, consistency, isolation, durability, and serializability of the concurrent execution of database transactions.

### Therefore, these protocols are categorized as:
* Lock Based Concurrency Control Protocol
* Timestamp Concurrency Control Protocol
* Validation Based Concurrency Control Protocol

## Entity, Entity Type, Entity Set, Weak Entity Set?

* **Entity:** An entity in DBMS can be a real-world object with an independent existence. For example, in a College database, the entities can be Professor, Students, Courses, etc.
* **Entity Type:** The entity type is a collection of entities having similar attributes.
    * **Strong Entity Type:** Strong entities are those entity types which have a key attribute (primary key). The primary key helps in identifying each entity uniquely. It is represented by a rectangle.
    * **Weak Entity Type:** A weak entity type does not have a key attribute. Weak entity types cannot be identified on their own. They depend upon some other strong entity for their distinct identity.
* **Entity Set:** An entity set is a collection of entities of the same entity type. We can say that entity type is a superset of the entity set as all the entities are included in the entity type.

## What are SQL commands? Types of them?

SQL (Structured Query Language) commands are instructions used to communicate with a database to perform tasks such as creating tables, adding data to tables, modifying data, and retrieving data.

**Reference:** [https://www.javatpoint.com/dbms-sql-command](https://www.javatpoint.com/dbms-sql-command)

### Types of SQL Commands:
* **DDL (Data Definition Language):** `CREATE`, `ALTER`, `DROP`, `TRUNCATE`, `RENAME`
* **DML (Data Manipulation Language):** `SELECT`, `INSERT`, `UPDATE`, `DELETE`
* **DCL (Data Control Language):** `GRANT`, `REVOKE`
* **TCL (Transaction Control Language):** `COMMIT`, `ROLLBACK`, `SAVEPOINT`

## Nested Queries in SQL?

A nested query (or subquery) is a query embedded inside another SQL query. The inner query executes first, and its result is used by the outer query. Nested queries can be used with `SELECT`, `INSERT`, `UPDATE`, and `DELETE` statements.

**Reference:** [https://www.tutorialspoint.com/explain-about-nested-queries-in-dbms](https://www.tutorialspoint.com/explain-about-nested-queries-in-dbms)

## What is JOIN? Explain types of JOINs.

A SQL JOIN clause is used to combine rows from two or more tables, based on a related column between them.

**Reference:** [https://www.javatpoint.com/dbms-sql-joins](https://www.javatpoint.com/dbms-sql-joins)

### Types of JOINs:
* **(INNER) JOIN:** Returns records that have matching values in both tables. Only rows where the join condition is met in both tables are included.
* **LEFT (OUTER) JOIN:** Returns all records from the left table, and the matched records from the right table. If there is no match, NULL is returned for columns from the right table.
* **RIGHT (OUTER) JOIN:** Returns all records from the right table, and the matched records from the left table. If there is no match, NULL is returned for columns from the left table.
* **FULL (OUTER) JOIN:** Returns all records when there is a match in either the left or right table. If no match exists, NULL is returned for columns from the table that doesn't have a match.

## Diff between 2-tier and 3-tier architecture

**Reference:** [https://www.geeksforgeeks.org/difference-between-two-tier-and-three-tier-database-architecture/](https://www.geeksforgeeks.org/difference-between-two-tier-and-three-tier-database-architecture/)

### 2-Tier Architecture:
* **Structure:** Client (User Interface, Application Logic) and Server (Database).
* **Communication:** Direct communication between client and database.
* **Advantages:** Simple to implement, faster for small applications.
* **Disadvantages:** Less scalable, security concerns (business logic on client), less flexible.

### 3-Tier Architecture:
* **Structure:** Client (User Interface), Application Server (Business Logic), and Database Server (Data Storage).
* **Communication:** Client communicates with the application server, which then communicates with the database.
* **Advantages:** Highly scalable, improved security (business logic encapsulated), more flexible, easier to maintain and develop.
* **Disadvantages:** More complex to implement, potentially higher initial development cost.

## Diff between TRUNCATE and DELETE command

### TRUNCATE:
* **Type:** DDL (Data Definition Language) command.
* **Function:** Removes all rows from a table, but the table structure remains.
* **Logging:** Not logged individually, making it very fast, especially for large tables.
* **Rollback:** Cannot be rolled back (implicit commit).
* **Syntax:** `TRUNCATE TABLE table_name;`
* **Reset Identity:** Resets identity (auto-increment) columns.

### DELETE:
* **Type:** DML (Data Manipulation Language) command.
* **Function:** Removes one or more rows from a table based on a specified `WHERE` clause. If no `WHERE` clause, all rows are removed.
* **Logging:** Each deleted row is logged, making it slower for large tables.
* **Rollback:** Can be rolled back (if within a transaction).
* **Syntax:** `DELETE FROM table_name WHERE condition;` or `DELETE FROM table_name;`
* **Reset Identity:** Does not reset identity (auto-increment) columns.

## Difference between Intension and Extension in a Database

### Intension (Schema):
* **Definition:** Refers to the description or definition of the database. It is the structure, or schema, of the database, which remains relatively stable.
* **Components:** Includes the names of tables, columns, data types, constraints, and relationships.
* **Nature:** Static and fixed once defined. It's the "blueprint" of the database.

### Extension (State/Instance):
* **Definition:** Refers to the actual data stored in the database at a particular moment in time. It is the content of the database, which changes frequently.
* **Components:** The actual rows (tuples) stored in the tables.
* **Nature:** Dynamic and changes with every insert, update, or delete operation. It's the "snapshot" of the database.

## Difference between share lock and exclusive lock, definition of lock

### Definition of Lock:
A lock in a database management system is a mechanism used to manage concurrent access to data. It ensures data integrity and consistency when multiple transactions try to access or modify the same data simultaneously. Locks prevent conflicts and allow transactions to operate on data in an isolated manner.

### Share Lock (S-Lock / Read Lock):
* **Purpose:** Allows multiple transactions to read the same data concurrently.
* **Compatibility:** Compatible with other Share Locks. This means if one transaction holds an S-lock on an item, other transactions can also acquire an S-lock on the same item.
* **Conflict:** Conflicts with Exclusive Locks. If an S-lock is held, an E-lock cannot be acquired until the S-lock is released.
* **Operations:** Used for read-only operations.

### Exclusive Lock (X-Lock / Write Lock):
* **Purpose:** Allows only one transaction to access the data for both reading and writing (modification).
* **Compatibility:** Not compatible with any other lock (neither S-lock nor another X-lock) on the same data item.
* **Conflict:** Conflicts with both Share Locks and other Exclusive Locks.
* **Operations:** Used for write (insert, update, delete) operations.