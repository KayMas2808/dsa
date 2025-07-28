# Data Structures and Algorithms

## Two Pointers
* **Same Direction**
* **Opposite Directions**

## Sliding Window
* **Start and End Pointer**

> Substring, max substring problems often leverage Two Pointers or Sliding Window techniques.

## Binary Search
* Time Complexity: $O(\log n)$
* Applicable only to sorted lists.

## Trees and Graphs

* **Breadth-First Search (BFS)**
    * Uses a queue.
    * Ideal for finding shortest paths.
* **Depth-First Search (DFS)**
    * Uses a stack.
    * Suitable for exploring all paths.
    * **Backtracking:** An extension of DFS.

* **Priority Queue (Heaps)**
    * Insertion Time Complexity: $O(\log n)$
    * Access Time Complexity: $O(1)$
    * **Min-Heap:** Parent node value is less than or equal to its children's values (useful for finding *k* largest values).
    * **Max-Heap:** Parent node value is greater than or equal to its children's values (useful for finding *k* smallest values).

## Dynamic Programming (DP)
* **Bottom-Up**
* **Top-Down:** Backtracking with memoization.

---

> ![alt text](image.png)
> ![alt text](image-1.png)

### Problem Solving Approach:
1.  Read the question twice.
2.  Formulate a rough, brute-force idea.
3.  Hand draw/write out the solution.

---

# Sortings

1.  **Selection Sort:** Find the minimum element and swap it with the element at the current position.
2.  **Bubble Sort:** Repeatedly swap adjacent elements to push the maximum element to the end.
3.  **Insertion Sort:** Take an element and insert it into its correct position within the sorted portion of the array.
4.  **Merge Sort:**
    * **Divide:** Split the array into two halves (left and right) using a midpoint.
    * **Sort:** Recursively sort the left and right halves.
    * **Merge:** Combine the sorted left and right halves.
5.  **Quick Sort:**
    * Pick a pivot element. All elements to the left of the pivot should be smaller, and all to the right should be larger.
    * Often, the first element is chosen as the pivot.
    * **Partitioning Process:**
        * While (left pointer < right pointer):
            * Find the first element on the left that is greater than the pivot.
            * Find the first element on the right that is less than the pivot.
            * Swap these two elements.
    * Recursively apply to sub-arrays.

---

# Heap

* Helpful in finding elements that satisfy a specific condition (e.g., finding a largest number).
* Stored as an array but conceptually represented as a tree.
* Must be a complete binary tree.
* Every node's value is greater than or equal to all its children (for a max-heap; reverse for min-heap).

### Array Representation Formulas:
1.  Parent of index $i = \lfloor i/2 \rfloor$
2.  Left child of index $i = 2i$
3.  Right child of index $i = 2i + 1$
> No pointers are required for heap implementation using an array.

---

# Operating System

## What is the main purpose of an operating system? Discuss different types?

An operating system (OS) is system software that manages computer hardware, software resources, and provides common services for computer programs. It manages the computer's memory, processes, devices, files, and security aspects of the system. It also allows users to communicate with the computer without knowing its low-level language. Without an operating system, a computer is not useful.

### Types of Operating Systems:
* Batch OS
* Distributed OS
* Multitasking OS
* Network OS
* Real-Time OS
* Mobile OS

**Reference:** [https://www.geeksforgeeks.org/types-of-operating-systems/](https://www.geeksforgeeks.org/types-of-operating-systems/)

## What is a socket, kernel, and monolithic kernel?

### Socket:
A socket is defined as an endpoint for communication. A pair of processes communicating over a network employ a pair of sockets, one for each process. A socket is identified by an IP address concatenated with a port number. The server waits for incoming client requests by listening to a specified port. Once a request is received, the server accepts a connection from the client socket to complete the connection.

### Kernel:
The kernel is the central core component of an operating system that manages operations of the computer and hardware. It establishes communication between user-level applications and hardware, manages memory and CPU time, decides the state of incoming processes, and controls disk, memory, and task management.

### Monolithic Kernel:
It is a type of kernel where all operating system services operate in kernel space. It has dependencies between system components and a large codebase, which makes it complex. It generally provides good performance.
**Examples:** Unix, Linux, Open VMS, XTS-400, etc.

## Difference between process, program, and thread? Different types of processes.

### Process:
A process is an instance of an executing program. For example, when a computer program (a text file with instructions) is executed, it becomes a process that performs all the tasks mentioned in the program.

### Program:
A program is a set of instructions to perform a certain task.
**Examples:** `chrome.exe`, `notepad.exe`

### Thread:
A thread is a path of execution within a process, also known as a lightweight process. The idea is to achieve parallelism by dividing a process into multiple threads. For example, a word processor uses multiple threads: one thread to format the text, another thread to process inputs.

## Define virtual memory, thrashing, threads.

### Virtual Memory:
Virtual memory allows a computer to address more memory than the amount physically installed on the system. This extra memory is a section of a hard disk set up to emulate the computer's RAM.
The main visible advantage is that programs can be larger than physical memory. Virtual memory serves two purposes:
1.  It extends the use of physical memory by using a disk.
2.  It provides memory protection because each virtual address is translated to a physical address.

### Thrashing:
Thrashing is a condition where the system spends a major portion of its time servicing page faults, with very negligible actual processing done. High degree of multiprogramming (if the number of processes keeps increasing in memory) and lack of frames (if a process is allocated too few frames, leading to frequent page faults) can cause thrashing.

### Threads:
A thread is a single sequential flow of execution of tasks within a process; it is also known as a thread of execution or thread of control.

## What is RAID? Different types.

RAID, or "Redundant Array of Independent Disks," is a technique that uses a combination of multiple disks instead of a single disk for increased performance, data redundancy, or both. Data redundancy, although taking up extra space, adds to disk reliability. This means, in case of disk failure, if the same data is also backed up onto another disk, the data can be retrieved, and operations can continue.
RAID 0, RAID 1, RAID 5, etc.

## What is a deadlock? Different conditions to achieve a deadlock.

A Deadlock is a situation where each of the computer processes waits for a resource that is being assigned to some other process. In this situation, none of the processes gets executed since the resource it needs is held by some other process which is also waiting for some other resource to be released.

### Necessary Conditions for Deadlock (all must occur simultaneously):
1.  **Mutual Exclusion:** At least one resource must be held in a non-sharable mode; only one process at a time can use the resource.
2.  **Hold and Wait:** A process holding at least one resource is waiting to acquire additional resources held by other processes.
3.  **No Preemption:** Resources cannot be forcibly removed from a process holding them; they must be released voluntarily by the process after it has completed its task.
4.  **Circular Wait:** A set of processes $P_0, P_1, \ldots, P_n$ must exist such that $P_0$ is waiting for a resource held by $P_1$, $P_1$ is waiting for a resource held by $P_2$, ..., $P_{n-1}$ is waiting for a resource held by $P_n$, and $P_n$ is waiting for a resource held by $P_0$.

## What is fragmentation? Types of fragmentation.

### Fragmentation:
Fragmentation is an unwanted problem in an operating system where, as processes are loaded and unloaded from memory, free memory space becomes fragmented. Processes cannot be assigned to memory blocks due to their small size, leading to unused memory blocks. As programs are loaded and deleted from memory, they generate free space or "holes" in the memory. These small blocks cannot be allotted to new arriving processes, resulting in inefficient memory use. The conditions of fragmentation depend on the memory allocation system.

### Types of Fragmentation:
1.  **Internal Fragmentation**
2.  **External Fragmentation**

## What is spooling?

SPOOL is an acronym for **S**imultaneous **P**eripheral **O**perations **O**n **L**ine. Spooling is a process in which data is temporarily held to be used and executed by a device, program, or system. In spooling, there is no direct interaction between the I/O devices and the CPU. This means the CPU does not need to wait for time-consuming I/O operations to finish.

The most common example of spooling is printing. Documents to be printed are stored in the SPOOL and then added to a queue for printing. During this time, other processes can perform their operations and use the CPU without waiting, while the printer executes the printing process on the documents one by one.

## What is semaphore and mutex (Differences might be asked)? Define Binary semaphore.

*(Self-correction: The provided text only defines Belady's Anomaly, Starving, and Aging, not semaphore and mutex directly, except for mentioning semaphores as a solution to the Producer-Consumer problem. I will add a general definition based on common OS knowledge to complete this section based on the heading.)*

### Semaphore:
A semaphore is a signaling mechanism used in operating systems to control access to common resources in a concurrent system like a multi-programming environment. It is a variable or abstract data type used for controlling access, by multiple processes, to a common resource in a parallel programming or multi-user environment.

### Mutex (Mutual Exclusion Object):
A mutex is a program object that prevents multiple program processes from simultaneously executing a specific piece of code, preventing race conditions. It ensures that only one thread can access a shared resource at a time.

### Difference between Semaphore and Mutex:
* **Purpose:** Semaphores are for signaling between processes/threads (resource counting), while mutexes are for controlling access to a single shared resource (mutual exclusion).
* **Ownership:** A mutex has ownership; only the thread that locked the mutex can unlock it. A semaphore does not have ownership; any thread can increment or decrement it.
* **Value:** A mutex can be in one of two states (locked/unlocked). A semaphore can have any non-negative integer value.

### Binary Semaphore:
A binary semaphore is a type of semaphore that can take on only two values, typically 0 or 1. It is often used to implement mutual exclusion, similar to a mutex. When its value is 1, a resource is available; when 0, the resource is in use.

## Belady’s Anomaly

Bélády’s anomaly is the phenomenon where increasing the number of page frames results in an increase in the number of page faults for a given memory access pattern.

### Solution to Fix Belady’s Anomaly:
Implementing alternative page replacement algorithms helps eliminate Bélády’s Anomaly. The use of stack-based algorithms, such as the Optimal Page Replacement Algorithm and the Least Recently Used (LRU) algorithm, can eliminate the issue of increased page faults as these algorithms assign priority to pages.

## Starving and Aging in OS

### Starving/Starvation (also called Livelock):
Starvation is the problem that occurs when low-priority processes get indefinitely delayed as high-priority processes keep executing. So, starvation happens if a method is indefinitely delayed.

### Solution to Starvation:
**Aging** is a technique of gradually increasing the priority of processes that wait in the system for a long time.

## Why does thrashing occur?

Thrashing occurs due to a high degree of multiprogramming (if the number of processes keeps increasing in the memory) and a lack of frames (if a process is allocated too few frames, leading to too many and too frequent page faults).

## What is paging and why do we need it?

### Paging:
Paging is a memory management scheme that eliminates the need for contiguous allocation of physical memory. This scheme permits the physical address space of a process to be non-contiguous.

### Why do we need Paging?
Paging is used for faster access to data. When a program needs a page, it is available in the main memory (RAM) as the OS copies a certain number of pages from your storage device to main memory. Paging allows the physical address space of a process to be noncontiguous, making more efficient use of available memory.

## Demand Paging, Segmentation

### Demand Paging:
Demand paging is a method of virtual memory management based on the principle that pages should only be brought into memory if the executing process demands them. This is often referred to as lazy evaluation, as only those pages demanded by the process are swapped from secondary storage to main memory. So, demand paging works opposite to the principle of loading all pages immediately.

### Segmentation:
Segmentation is a memory management technique in which memory is divided into variable-sized parts. Each part is known as a segment, which can be allocated to a process. The details about each segment are stored in a table called a segment table. The segment table is stored in one (or many) of the segments.

### Segment table contains mainly two information about a segment:
* **Base:** It is the base address of the segment.
* **Limit:** It is the length of the segment.

## Real-Time Operating System (RTOS), types of RTOS.

A real-time operating system (RTOS) is a special-purpose operating system used in computers that has strict time constraints for any job to be performed and is intended to serve real-time applications that process data as it comes in, typically without buffer delays.

### Types of RTOS:
* Hard RTOS
* Firm RTOS
* Soft RTOS

## Difference between main memory and secondary memory.

*(Self-correction: The provided text only lists the heading, not the content. I will add a general definition based on common OS knowledge.)*

### Main Memory (RAM):
* **Volatility:** Volatile (data is lost when power is off).
* **Speed:** Faster access speed.
* **Capacity:** Smaller capacity.
* **Purpose:** Used for active data and programs currently being executed by the CPU.
* **Cost:** More expensive per unit of storage.

### Secondary Memory (Hard Drive, SSD):
* **Volatility:** Non-volatile (data persists even when power is off).
* **Speed:** Slower access speed.
* **Capacity:** Larger capacity.
* **Purpose:** Used for long-term storage of data and programs.
* **Cost:** Less expensive per unit of storage.

## Dynamic Binding

### Static Binding:
When a compiler knows all the information required to call a function or all the values of the variables during compile time, it is called "static binding" (also known as early binding). As all the required information is known before runtime, it increases program efficiency and enhances the speed of execution. Static binding makes a program very efficient, but it declines program flexibility, as 'values of variable' and 'function calling' are predefined in the program. Static binding is implemented in a program at the time of coding. Overloading a function or an operator is an example of compile-time polymorphism, i.e., static binding.

### Dynamic Binding:
Calling a function or assigning a value to a variable at run-time is called "dynamic binding" (also known as late binding). Dynamic binding can be associated with run-time 'polymorphism' and 'inheritance' in OOP. Dynamic binding makes the execution of a program flexible as it can decide what value should be assigned to the variable and which function should be called at the time of program execution. However, as this information is provided at run time, it makes the execution slower compared to static binding.

## FCFS Scheduling

### First-Come, First-Served (FCFS) Scheduling:
FCFS is the simplest CPU scheduling algorithm. In this scheme, the process that requests the CPU first is allocated the CPU first. It is a non-preemptive scheduling algorithm, meaning once a process starts executing, it continues until it completes its CPU burst or terminates.

## SJF Scheduling

### Shortest Job First (SJF) Scheduling:
SJF scheduling algorithm associates with each process the length of its next CPU burst. When the CPU is available, it is assigned to the process that has the smallest next CPU burst. If two processes have the same length next CPU burst, FCFS scheduling is used. SJF is an optimal algorithm, providing the minimum average waiting time for a given set of processes. It can be either preemptive or non-preemptive.

## SRTF Scheduling

### Shortest Remaining Time First (SRTF) Scheduling:
SRTF Scheduling is a preemptive version of SJF scheduling. In SRTF, the execution of the process can be stopped after a certain amount of time. At the arrival of every process, the short-term scheduler schedules the process with the least remaining burst time among the list of available processes and the running process.

## LRTF Scheduling

### Longest Remaining Time First (LRTF) Scheduling:
This is a preemptive version of the Longest Job First (LJF) scheduling algorithm. In this scheduling algorithm, we find the process with the maximum remaining time and then process it. We check for the maximum remaining time after some interval of time (say 1 unit each) to check if another process having more Burst Time arrived up to that time.

## Priority Scheduling

### Priority Scheduling:
Priority Scheduling is a method of scheduling processes that is based on priority. In this algorithm, the scheduler selects the tasks to work as per their priority. Processes with higher priority should be carried out first, whereas jobs with equal priorities are carried out on a round-robin or FCFS basis. Priority depends upon factors such as memory requirements, time requirements, etc.

## Round Robin Scheduling

### Round Robin (RR) Scheduling:
In Round-robin scheduling, each ready task runs turn by turn only in a cyclic queue for a limited time slice (quantum). This algorithm also offers starvation-free execution of processes. It is a widely used preemptive scheduling method in traditional OS. All the jobs get a fair allocation of the CPU. Cons include: Finding a correct time quantum is a quite difficult task in this system, and Round-robin scheduling doesn’t give special priority to more important tasks.

## Producer Consumer Problem

### About Producer-Consumer problem:
The Producer-Consumer problem is a classic problem used for multi-process synchronization, i.e., synchronization between more than one processes. The job of the Producer is to generate data, put it into the buffer, and then start generating data again. The job of the Consumer is to consume data from the buffer.

### What's the problem here?
The following are the problems that might occur in the Producer-Consumer:
* The producer should produce data only when the buffer is not full. If the buffer is full, then the producer shouldn't be allowed to put any data into the buffer.
* The consumer should consume data only when the buffer is not empty. If the buffer is empty, then the consumer shouldn't be allowed to take any data from the buffer.
* The producer and consumer should not access the buffer at the same time.

This problem can be solved by using semaphores.

## Banker’s Algorithm

### Banker’s Algorithm:
It is an algorithm used to avoid deadlock and safely allocate resources to each process in a computer system. The 'S-State' examines all possible tests or activities before deciding whether the allocation should be allowed to each process. It also helps the operating system to successfully share the resources between all the processes. The banker's algorithm is named because it checks whether a person should be sanctioned a loan amount or not to help the bank system safely simulate allocation resources.

## Explain Cache

### Cache Memory:
Cache memory is an extremely fast memory type that acts as a buffer between RAM and the CPU. It holds frequently requested data and instructions so that they are immediately available to the CPU when needed, thereby speeding up data access.

## Diff between direct mapping and associative mapping

### Direct Mapping:
* Each block from main memory has only one possible location in the cache.
* Simple to implement and fast.
* Suffers from conflict misses if frequently used blocks map to the same cache line.

### Associative Mapping:
* A block from main memory can be placed in any cache line.
* More flexible, reduces conflict misses.
* Requires complex hardware for searching all cache lines in parallel, making it slower and more expensive.

## Diff between multitasking and multiprocessing

### Multitasking:
* **Concept:** Allows a single CPU to appear to execute multiple tasks/processes concurrently by rapidly switching between them (time-sharing).
* **Hardware:** Typically involves a single processor core.
* **Concurrency:** Achieves concurrency by rapidly switching between tasks, giving the illusion of parallelism.
* **Examples:** Running a web browser, word processor, and music player on a single-core CPU.

### Multiprocessing:
* **Concept:** Involves the use of multiple CPUs or CPU cores within a single computer system to execute multiple tasks/processes truly simultaneously.
* **Hardware:** Requires multiple processor cores or physical CPUs.
* **Parallelism:** Achieves true parallelism by executing different tasks on different cores at the same time.
* **Examples:** Running computationally intensive simulations on a multi-core processor.

---

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

---

# Computer Networks

## Define network

A network is a set of devices that are connected with a physical media link. In a network, two or more nodes are connected by a physical link, or two or more networks are connected by one or more nodes. A network is a collection of devices connected to each other to allow the sharing of data.

## What do you mean by network topology, and explain types of them?

Network topology is the arrangement of nodes and links of a network. Topologies are categorized as either physical network topology or logical network topology. The topology of a network is key to determining its performance.

### Network topology can be categorized into:
* **Bus Topology:** All devices are connected to a single central cable (the "bus"). Data is transmitted in one direction from one end to the other. Simple and cost-effective, but a break in the main cable can bring down the entire network.
* **Ring Topology:** Devices are connected in a circular fashion, forming a ring. Each device is connected to exactly two other devices, forming a single continuous pathway for signals. Data travels in one direction around the ring. Failure of one node or cable can disrupt the entire network.
* **Star Topology:** All devices are connected to a central hub or switch. Each device has a dedicated connection to the central device. If one link fails, only that device is affected, not the entire network. More robust, but relies heavily on the central device.
* **Mesh Topology:** Every device in the network is connected to every other device. This provides high redundancy and fault tolerance, as there are multiple paths for data. However, it is complex and expensive to implement due to the large number of connections.
* **Tree Topology:** A hybrid topology that combines characteristics of bus and star topologies. It consists of multiple star networks connected to a central bus cable. It allows for network expansion and is suitable for large networks.

## Define bandwidth, node, and link?

* **Bandwidth:** Bandwidth is the data transfer capacity of a computer network, typically measured in bits per second (Bps). The term may also be used colloquially to indicate a person's capacity for tasks or deep thoughts at a point in time.
* **Node:** A node in a network refers to any device connected to the network that can send, receive, or forward information. This includes computers, servers, routers, switches, and other endpoints.
* **Link:** A link refers to the physical medium of connection between two or more computers or network devices, such as optical fiber, coaxial cable, or wireless connections.

## Explain TCP model.

The TCP/IP model is a compressed version of the OSI model with only 4 layers. It was developed by the US Department of Defense (DoD) in the 1960s. The name of this model is based on two standard protocols used: TCP (Transmission Control Protocol) and IP (Internet Protocol).

1.  **Network Access/Link Layer:** This layer decides which links, such as serial lines or classic Ethernet, must be used to meet the needs of the connectionless internet layer.
    * **Examples:** SONET, Ethernet
2.  **Internet Layer:** The internet layer is the most important layer which holds the whole architecture together. It delivers the IP packets where they are supposed to be delivered, handling addressing and routing.
    * **Examples:** IP, ICMP.
3.  **Transport Layer:** Its functionality is almost the same as the OSI transport layer. It enables peer entities on the network to carry on a conversation, providing end-to-end communication services.
    * **Examples:** TCP, UDP (User Datagram Protocol)
4.  **Application Layer:** It contains all the higher-level protocols that deal with specific application-level functions.
    * **Examples:** HTTP, SMTP, RTP, DNS

## Layers of OSI model

The OSI (Open Systems Interconnection) model is a conceptual framework that standardizes the functions of a telecommunication or computing system into seven distinct layers.

* **Layer 1: Physical Layer:** Defines the physical characteristics of the network, including cables, connectors, and electrical signals. It handles the raw bit stream transmission.
* **Layer 2: Data Link Layer:** Provides reliable data transfer across a physical link, handling framing, error detection/correction, and flow control.
* **Layer 3: Network Layer:** Responsible for logical addressing (IP addresses) and routing of packets across different networks.
* **Layer 4: Transport Layer:** Provides end-to-end communication services, including segmentation, reassembly, connection management, flow control, and error control. (e.g., TCP, UDP)
* **Layer 5: Session Layer:** Establishes, manages, and terminates communication sessions between applications.
* **Layer 6: Presentation Layer:** Handles data formatting, encryption, decryption, and compression to ensure data is presented in a readable format for the application layer.
* **Layer 7: Application Layer:** Provides network services to end-user applications. It's where user interaction with the network occurs. (e.g., HTTP, FTP, SMTP)

## Significance of Data Link Layer

The Data Link Layer is a crucial layer in the OSI model, responsible for transferring data from one node to another node across a physical link.

### Functions of Data-link layer:
* **Frame synchronization:** The Data Link Layer converts the data into frames, and it ensures that the destination must recognize the starting and ending of each frame.
* **Flow control:** The Data Link Layer controls the data flow within the network to prevent a fast sender from overwhelming a slow receiver.
* **Error control:** It detects and corrects errors that occur during the transmission from source to destination, ensuring reliable data delivery.
* **Addressing:** Data Link Layers attach the physical address (MAC address) with the data frames so that individual machines can be easily identified on the local network segment.
* **Link management:** Data Link Layer manages the initiation, maintenance, and termination of the link between the source and destination for the effective exchange of data.

## Define gateway, difference between gateway and router.

* **Gateway:** A node that is connected to two or more dissimilar networks (networks using different protocols or architectures) is commonly known as a gateway. It functions as a protocol converter, translating data between different network environments. It is used to forward messages from one network to another.
* **Router:** A router is a network device that forwards data packets between computer networks. It directs traffic between two similar networks (networks using the same protocol).

### Differences between gateway and router:
A router sends the data between two similar networks, while a gateway sends the data between two dissimilar networks. Both the gateway and router regulate the traffic in the network.

## What does ping command do?

The "ping" is a utility program that allows you to check the connectivity between network devices. It sends ICMP (Internet Control Message Protocol) echo request packets to a target host and listens for ICMP echo reply packets. You can ping devices using their IP address or name to determine if the host is reachable and to measure the round-trip time for messages sent to the destination computer.

## What is DNS, DNS forwarder, NIC?

* **DNS (Domain Name System):**
    1.  DNS is an acronym that stands for Domain Name System. DNS was introduced by Paul Mockapetris and Jon Postel in 1983.
    2.  It is a naming system for all the resources over the internet, which includes physical nodes and applications. It is used to locate resources easily over a network.
    3.  DNS is an internet service that maps human-readable domain names (like `google.com`) to their associated numerical IP addresses.
    4.  Without DNS, users would have to know the IP address of the web page they wanted to access.

* **DNS Forwarder:** A forwarder is used with a DNS server when it receives DNS queries that cannot be resolved quickly. So, it forwards those requests to external DNS servers for resolution. A DNS server configured as a forwarder will behave differently than a DNS server which is not configured as a forwarder, as it relies on other servers to resolve certain queries.

* **NIC (Network Interface Card):** NIC stands for Network Interface Card. It is a peripheral card attached to a PC to connect to a network. Every NIC has its own MAC address that uniquely identifies the PC on the network. It provides a wired or wireless connection to a local area network. NICs were mainly used in desktop computers but are now integrated into most devices.

## What is MAC address?

A Media Access Control address (MAC address) is a unique identifier assigned to a network interface controller (NIC) for use as a network address in communications within a network segment. It is a hardware address, typically hard-coded into the NIC by the manufacturer, and is used for addressing on the data link layer.

## What is IP address, private IP address, public IP address, APIPA?

* **IP address:** An IP address is a unique numerical label that identifies a device on the internet or a local network. IP stands for "Internet Protocol," which is the set of rules governing the format of data sent via the internet or local network.

* **Private IP Address:** There are specific ranges of IP addresses that have been reserved for private networks. They are not valid for use directly on the internet. If you want to access the internet from devices with these private IPs, you must use a proxy server or NAT (Network Address Translation) server.
    * **Private IP Ranges:**
        * $10.0.0.0$ to $10.255.255.255$
        * $172.16.0.0$ to $172.31.255.255$
        * $192.168.0.0$ to $192.168.255.255$

* **Public IP Address:** A public IP address is a globally unique address assigned by an Internet Service Provider (ISP) that facilitates direct communication on the internet. Devices with public IP addresses are directly accessible from anywhere on the internet.

* **APIPA (Automatic Private IP Addressing):** APIPA stands for Automatic Private IP Addressing. It is a feature or characteristic in operating systems (e.g., Windows) which enables computers to self-configure an IP address and subnet mask automatically when their DHCP (Dynamic Host Configuration Protocol) server isn't reachable. APIPA addresses are in the $169.254.0.0/16$ range.
    * **DHCP (Dynamic Host Configuration Protocol):** A DHCP Server is a network server that automatically provides and assigns IP addresses, default gateways, and other network parameters to client devices. It relies on the standard protocol known as Dynamic Host Configuration Protocol.

## Difference between IPv4 and IPv6

### IPv4:
* **Address Length:** 32-bit address.
* **Address Format:** Dotted decimal notation (e.g., $192.168.1.1$).
* **Number of Addresses:** Approximately 4.3 billion unique addresses.
* **Addressing Method:** Uses ARP (Address Resolution Protocol) for address resolution.
* **Security:** IPsec (IP Security) is optional.
* **Header Size:** Fixed header size of 20 bytes.
* **Configuration:** Manual or DHCP.
* **Checksum:** Includes a header checksum.

### IPv6:
* **Address Length:** 128-bit address.
* **Address Format:** Hexadecimal notation separated by colons (e.g., $2001:0db8:85a3:0000:0000:8a2e:0370:7334$).
* **Number of Addresses:** Vastly larger, approximately $3.4 \times 10^{38}$ unique addresses.
* **Addressing Method:** Uses Neighbor Discovery Protocol (NDP).
* **Security:** IPsec is built-in and mandatory.
* **Header Size:** Fixed header size of 40 bytes.
* **Configuration:** Stateless Address Autoconfiguration (SLAAC) or DHCPv6.
* **Checksum:** No header checksum (relies on transport layer for error checking).

## What is subnet?

A subnet is a network inside a network achieved by the process called subnetting, which helps divide a larger network into smaller, more manageable subnets. It is used for getting higher routing efficiency and enhances the security of the network. It reduces the time to extract the host address from the routing table and helps in efficient management of IP addresses.

## Firewalls

A firewall is a network security system that is used to monitor the incoming and outgoing network traffic and blocks or allows the same based on predefined firewall security policies. It acts as a wall between the internet (public network) and the networking devices (a private network). It is either a hardware device, a software program, or a combination of both. It adds a layer of security to the network by preventing unauthorized access and controlling allowed traffic.

## Different types of delays

The delays, here, means the time for which the processing of a particular packet takes place. We have the following types of delays in computer networks:

* **Transmission Delay:** The time required to push all the bits of a packet onto the transmission link. It depends on the packet size and the link's bandwidth.
* **Propagation Delay:** The time it takes for a bit to travel from the source to the destination across a physical link. It depends on the distance between the two points and the propagation speed of the medium.
* **Queueing Delay:** The time a packet waits in a queue before being processed or transmitted. This delay is variable and depends on the congestion level of the network devices (e.g., router queues).
* **Processing Delay:** The time required by routers to examine the packet's header, determine its destination, and forward it to the appropriate output link.

## 3-way handshaking

Three-Way Handshake or a TCP 3-way handshake is a process used in a TCP/IP network to establish a connection between the client and server. It is a three-step process that requires both the client and server to exchange synchronization (SYN) and acknowledgment (ACK) packets before the real data communication process starts.

### Steps:
1.  **SYN (Synchronize):** The client sends a SYN segment to the server, requesting to establish a connection.
2.  **SYN-ACK (Synchronize-Acknowledge):** The server receives the SYN, acknowledges it with an ACK, and sends its own SYN to the client.
3.  **ACK (Acknowledge):** The client receives the SYN-ACK, acknowledges the server's SYN with an ACK, and the connection is established.

The three-way handshake process is designed in such a way that both ends help you to initiate, negotiate, and separate TCP socket connections at the same time. It allows you to transfer multiple TCP socket connections in both directions at the same time.

## Server-side load balancer

All backend server instances are registered with a central load balancer. A client requests this load balancer, which then routes the request to one of the server instances using various algorithms like round-robin, least connections, etc. AWS ELB (Elastic Load Balancing) is a prime example of server-side load-balancing that registers multiple EC2 instances launched in its auto-scaling group and then routes the client requests to one of the EC2 instances.

### Advantages of server-side load balancing:
* **Simple client configuration:** Clients only need to know the load-balancer address, not the individual server addresses.
* **Clients can be untrusted:** All traffic goes through the load-balancer, where it can be inspected and filtered for security. Clients are not directly aware of the backend servers.
* **Improved scalability and reliability:** Distributes traffic across multiple servers, preventing overload and providing fault tolerance if a server fails.

## RSA Algorithm

RSA algorithm is an asymmetric cryptography algorithm. Asymmetric actually means that it works on two different keys: Public Key and Private Key. As the name describes, the Public Key is given to everyone, and the Private Key is kept private.

### Example of asymmetric cryptography:
A client (for example, a browser) sends its public key to the server and requests some data. The server encrypts the data using the client's public key and sends the encrypted data. The client receives this data and decrypts it using its corresponding private key. Since this is asymmetric, nobody else except the browser can decrypt the data, even if a third party has the public key of the browser, because decryption requires the unique private key. This ensures confidentiality.

## What is HTTP and HTTPS protocol?

* **HTTP (HyperText Transfer Protocol):** HTTP defines the set of rules and standards on how information can be transmitted on the World Wide Web (WWW). It facilitates communication between web browsers and web servers. It is a ‘stateless protocol’, meaning each command is independent with respect to the previous command. HTTP is an application layer protocol built upon TCP. It uses port 80 by default.

* **HTTPS (HyperText Transfer Protocol Secure):** HTTPS is the HyperText Transfer Protocol Secure or Secure HTTP. It is an advanced and a secured version of HTTP. On top of HTTP, the SSL/TLS protocol is used to provide security. It enables secure transactions by encrypting the communication and also helps identify network servers securely. It uses port 443 by default.

## What is SMTP protocol?

SMTP is the Simple Mail Transfer Protocol. SMTP sets the rules for communication between mail servers. This set of rules helps software to transmit emails over the internet. It supports both End-to-End and Store-and-Forward methods for mail delivery. It is in an always-listening mode on port 25.

## TCP and UDP protocol, prepare differences

### TCP (Transmission Control Protocol):
* **Connection-oriented:** Establishes a connection before data transfer begins (3-way handshake).
* **Reliable:** Provides guaranteed delivery of data. Includes error checking, retransmission of lost packets, and acknowledgments.
* **Ordered Delivery:** Ensures that data packets arrive in the correct order.
* **Flow Control:** Manages the data flow to prevent a fast sender from overwhelming a slow receiver.
* **Congestion Control:** Manages network congestion to prevent network collapse.
* **Speed:** Relatively slower due to overhead for reliability and connection management.
* **Usage:** Web Browse (HTTP/HTTPS), email (SMTP, POP3, IMAP), file transfer (FTP).

### UDP (User Datagram Protocol):
* **Connectionless:** Does not establish a connection before sending data.
* **Unreliable:** Does not guarantee delivery, order, or error-free transmission.
* **No Ordered Delivery:** Packets may arrive out of order.
* **No Flow Control:** Does not manage data flow, can lead to receiver overflow.
* **No Congestion Control:** Does not manage network congestion.
* **Speed:** Much faster, simpler, and more efficient due to minimal overhead.
* **Usage:** DNS lookups, video streaming, online gaming, VoIP (Voice over IP).

### Summary of Differences:
TCP is a connection-oriented protocol, whereas UDP is a connectionless protocol. A key difference between TCP and UDP is speed, as TCP is comparatively slower than UDP. Overall, UDP is a much faster, simpler, and efficient protocol; however, retransmission of lost data packets is only possible with TCP. TCP provides extensive error checking mechanisms because it provides flow control and acknowledgment of data. UDP has only a basic error checking mechanism using checksums.

## What happens when you enter “google.com” (very very famous question)

1.  **Browser Cache Check:** The browser first checks its own cache. If the content for `google.com` is fresh and present in the cache (e.g., previously visited page assets), it displays the same.
2.  **DNS Lookup (Browser/OS Cache):** If not found in the browser cache, the browser checks if the IP address of `google.com` is present in its internal DNS cache or the operating system's DNS cache.
3.  **DNS Lookup (Recursive Query):** If the IP is not in cache, the browser requests the OS to perform a DNS lookup. The OS queries a local DNS resolver (often configured by the ISP). If the resolver doesn't have the IP, it performs a recursive query process starting from the root DNS servers, TLD (Top-Level Domain) servers, and finally authoritative DNS servers for `google.com` to get the corresponding IP address. This typically uses UDP for DNS queries.
4.  **TCP Connection Establishment:** Once the browser receives the IP address for `google.com`, it initiates a new TCP connection with the web server at that IP address using the three-way handshake process.
5.  **HTTP Request:** An HTTP (or HTTPS) request (e.g., a GET request for the homepage) is sent to the web server using the established TCP connection.
6.  **HTTP Response:** The web servers running on the Google servers handle the incoming HTTP request, process it, and send an HTTP response back to the browser. This response includes the HTML, CSS, JavaScript, images, and other resources for the webpage.
7.  **TCP Connection Management:** The browser processes the HTTP response sent by the server and may close the TCP connection or keep it open for future requests (persistent connection, common with HTTP/1.1 and HTTP/2).
8.  **Caching Response:** If the response data is cacheable (indicated by HTTP headers), the browser caches the same for future use.
9.  **Rendering:** The browser decodes the response data (HTML, CSS, JS) and renders the content on the screen, displaying the `google.com` homepage.

## Hub vs Switch

### Hub:
* A hub is a networking device that operates on the **Physical Layer** (Layer 1) of the OSI model.
* It is a multi-port repeater; when a signal arrives at one port, the hub transmits (broadcasts) the signal to all other ports (except the one it received from).
* Packet filtering is not available; it does not intelligently direct traffic.
* It creates a single collision domain, leading to network congestion and reduced efficiency.
* It is of two types: Active Hub (amplifies signal) and Passive Hub (does not amplify signal).

### Switch:
* A switch is a network device that operates on the **Data Link Layer** (Layer 2) of the OSI model.
* It is used to enable connection establishment and connection termination on the basis of need, intelligently forwarding frames only to the port where the destination device is connected (after learning MAC addresses).
* Packet filtering is available; it maintains a MAC address table to forward frames efficiently.
* Each port on a switch is its own collision domain, significantly reducing collisions and improving network performance.
* It typically operates in full-duplex transmission mode, allowing simultaneous sending and receiving. It is also called an efficient bridge.

## VPN, advantages and disadvantages of it

### VPN (Virtual Private Network):
A VPN, or the Virtual Private Network, is a private WAN (Wide Area Network) built on the internet. It allows the creation of a secured tunnel (protected network) between different networks using the internet (public network). By using a VPN, a client can connect to an organization’s network remotely as if they were physically on the internal network.

### Advantages of VPN:
1.  VPN is used to securely connect offices in different geographical locations remotely and is cheaper when compared to dedicated WAN connections.
2.  VPN is used for secure transactions and confidential data transfer between multiple offices located in different geographical locations.
3.  VPN keeps an organization’s information secured against any potential threats or intrusions by using tunneling and encryption.
4.  VPN encrypts internet traffic and disguises the user's online identity and location, providing privacy and anonymity.

### Disadvantages of VPN:
1.  **Not designed for continuous use:** Some VPNs may not be optimized for continuous, high-volume data transfer, leading to performance issues.
2.  **Complexity prevents scalability:** Setting up and managing large-scale VPN deployments can be complex, potentially hindering easy scalability.
3.  **Lack of granular security:** VPNs typically secure the entire connection, but may lack fine-grained control over specific application traffic within the tunnel.
4.  **Unpredictable performance:** Performance can vary widely depending on server load, distance to the server, and network congestion.
5.  **Unreliable availability:** VPN server availability can sometimes be an issue, leading to connection drops or inability to connect.

## LAN

A Local Area Network (LAN) is a collection of devices connected together in one physical location, such as a building, office, or home. A LAN can be small or large, ranging from a home network with one user to an enterprise network with thousands of users and devices in an office or school. LANs typically use Ethernet or Wi-Fi technology and provide high-speed connectivity over a limited geographical area.

---
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