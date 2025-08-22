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