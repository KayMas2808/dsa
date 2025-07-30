System Design
![alt text](fileSizes.png)
Scaling:
vertical scaling - up and down
horizontal scaling - out and in
first prefer vertical scaling

CAP Theorem:
states that in a distributed system, you can only guarantee two out of these three properties simultaneously. It’s impossible to achieve all three, and network partition is bound to happen, so need to make tradeoff between CP and AP
Consistency: A, B and C all have the same data. If there is an update in node B, then data replication happens, and B will propagate that update to A and C.
Availability: Let node B experience a hardware failure and go offline. Nodes A and C are still operational. Despite the failure of node B, the system as a whole remains available because nodes A and C can still respond to client requests.
Partition Tolerance: Network partition happens that separates B from A and C. Node B can still function and serve requests, but it can’t communicate with A and C.
for secure apps like banking, chose CP
for social media etc, chose AP

**Types of DB Architecture:**
**Master Slave DB Architecture:**
The node (server) which processes the write request is called the Master Node.

Nodes (servers) that take the read requests are called Slave Nodes.
When you make a Write Request, it is processed and written in the master node, and then it asynchronously (or synchronously depending upon configuration) gets replicated to all the slave nodes.
good for read heavy traffic.

![alt text](master-slave.png)

**Multi Master Setup:**
more than one master
Ex: A very common thing is to put two master nodes, one for North India and another for South India. All the write requests coming from North India are processed by North-India-DB, and all the write requests coming from South India are processed by South-India-DB, and periodically, they sync (or replicate) their data.
but need to write business logic to decide conflict resolution rules.

**Sharding**
Sharding is similar to partitioning, as we saw above, but instead of putting the different tables in the same server, we put it into a different server.
good for write heavy traffic, hard to implement, loss of consistency, hard to do JOINs
avoid cross shard queries

![alt text](sharding.png)

in the above picture we cut the table into 3 parts and put it into 3 different servers. These servers are usually called shards.

Here, we did sharding based on IDs, so this ID column is called a sharding key.

Note: The sharding key should distribute data evenly across shards to avoid overloading a single shard.
Need to decide which shard to go to at application level.
Sharding Strategies:
1. Range based - id=1 to id=10 on shard 1 etc etc
2. Hash based - hash function applied to shard key.
3. Geographic/Entity based - america shard 1 eu shard 2 etc etc.
4. Directory based - a lookup table for which shard contains what range.


**SQL VS NoSQL DBs**
SQL:
 - data stored in form of tables, with predefined schema.
 - follows ACID properties
 - MySQL, Postgres, ORACLE
 - designed to scale vertically
 - sharding avoided
 - use when structured data, ACID needed, complex queries like JOIN, and aggregations needed.
NoSQL:
 - designed to scale horizontally
 - sharding usually done
 - use when data is unstructured, high scalability and availability is more important than ACID
 - 4 types:
   1. document based - docs like JSON, BSON, e.g. MongoDB
   2. key value stores - key value pairs e.g. Redis, AWS DynamoDB
   3. column family stores - store in column rather than rows, e.g. Apache Cassandra
   4. graph - data like graph, useful in social media like mutual followers, e.g. Neo4j 
