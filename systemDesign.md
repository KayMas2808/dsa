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

MICROSERVICES:
- Monolith: The entire application is built as a single unit in a monolithic architecture
- Microservice: Break down large applications into smaller, manageable, and independently deployable services.
- allow scaling of a single component which might have more traffic than others. E.g. payment service may have less traffic than product view service
- different tech stack possible for different service
- one fails others mostly un-affected
- different services are on different addresses, so hectic, thus INTRODUCING, THE NEW AND IMPROVED, API GATEWAY! Do you  not want your client to make separate endpoint requests to do different things? Do you want to protect certain services from publiclly exposed endpoints? Use our *slaps roof* new and improved API Gateway! It automatically takes the incoming request and maps it to the requires service!
- API Gateway allows rate limiting, caching, auth.

LOAD BALANCER
- 4 different algorithms:
      1. Round robin - ignores server health so poopy
      2. Weighted round robin - servers are assigned weights based on capacity, static weights, not realtime, so poopy
      3. Least Connections - if connection durations different, shiiiiii
      4. Hash Based - takes anyhting, like client IP, user id etc to hash that and find server. ensures one client always to that server. useful for session persistance, but server changes :(

CACHING
- storing frequently accessed data in high speed storage for faster response in future requests.
- Cache Invalidation - remove old cache data and update to new one, can set Time To Live
- improve performance, reduce load, cost efficiency(network and computation), scalability.
- either write to cache when writing to DB, or on read, first try cache, if miss, serch db
- Types:
     1. Client side - stored on user device like browser cache
     2. Server side - stored on server, e.g. in-memory cache like redis, memcached
     3. CDN (content delivery network) - static content like html, css, png etc. delivered.
     4. Application level - embedded in app code.
 - REDIS
     - in memory => RAM
     - not big enough to be permanent store.

BLOB
- jpeg, mp4 etc can be stored in columns in DB.
- so we convert them into binary => Binary Large Object
- can be 1GB or whatever, big.
- thus stored in managed Blob storages like AWS S3, Cloudfare R2
- managed storage mean that scaling security etc is taken care of, you go sleep.

CDNs
- bunch of distributed servers kept in different parts of the world.
- used to deliver static content like images, videos etc.
- users in US request video in india, too long, but once reached, cached in server closest to the user.
- e.g. AWS CloudFront, Cloudfare CDN
- Process:
  - request goes to nearest CDN (called **edge server**), if found, served, else fetched from **origin server**
- Use GeoDNS to route users to nearest CDN server based on location.

MESSAGE BROKER
- Synchronus and Asynchronus Programming
  - client sent request, server processes, immediately sends response -> Synchronous
  - but what if processing gon take 10 min? client wont wait. HTTP Timeout. bad.
  - in such cases, we dont send back result, but a confirmation message, that "im doing wait mate"
  - assign a **worker** to work on the task in the background
  - then when done, notify client via email or smth. this is Asynchronous
  - we dont directly assign the task to the worker. we put it in a *message broker*
- this broker acts like queue. server put task in it, worker pull and do it, then delete it from queue.
- server is producer, worker is consumer.
> use for communication between microservices. either make REST API calls or use Message Brokers.
- message brokers better for non-critical tasks, delay is affordable, or taks takes long computation time.
- Why?
  - reliability - producer down, consumer still working
  - retry option - cant do now? leave it in queue, reattempt later
  - decoupled - do at your own pace.
- 2 Types:
  1. Message Queues: only one type of consumer for one message.
     - this is bad in case where 2 tasks need doing on one message
     - for example - video transcoding service, on itself ok. if we also want it to add caption generator service, then we get another message queue for caption, there is a chance of mismatch in-case one of them fails while working on a task.
     - e.g. AMAZON SQS
  2. Message Stream: more than one type of consumer for each message
     - write to one, read by many.
     - messages are only processed once by any service.
     - consumer services dont delete the messages, do manually or set time to live.
     - e.g. Apache Kafka

Kafka Deep Dive
- very high throughput.
- USE CASE: if something needs very frequent DB write operations for eg every 2 seconds, put them in kafka message stream, and do DB write every 10 minutes.
 - Kafka Internals
   - **Producer**: Publishes messages to Kafka. As for sending email, the producer can send {“email”, “message”} to the Kafka.
   - **Consumer**: Subscribes to Kafka topics and processes the feed of messages.
   - **Broker**: Kafka server that stores and manages the topics.
   - **Topic**: A category/feed name to which records are published.
     - sendEmail can be a topic.
     - writeLocationToDB can be a topic.
   - Let’s take the analogy of a Database:
     - Broker = Database Server
     - Topics = Tables
     - **Partition**: Each topic is divided into partitions for parallelism. Partition is similar to sharding in DB Tables. On what basis do we do partition? For that, we have to decide and code it ourselves.
     - Suppose, for our sendNotification topic, we partition it based on location. North Indian’s data goes to Partition 1, and South Indian’s data goes to Partition 2.
     - **Consumer Groups**: When we make a consumer that subscribes to a topic, we have to assign a group to the consumer.
     - Each consumer within a group does one type of processing from a subset of partitions.
     - Ex: For video processing, as we saw earlier, we can have two consumer groups. One consumer group is for video transcoding, and the other consumer group is for caption generating.

Realtime Pubsub (publish/subscribe)
- in regular msg broker, publisher push -> store in broker until pulled, using API/SDK
- in Pubsub, a soon as publisher pushes msg, its immediately delivered to subscribers. Consumers dont do API call or anything.
- Messages are not stored or retained. receive->push to all subscribed consumers.
- E.g. Redis
- example use
  - messaging app. websocket connections betwen clients and servers.
  - client 1 is on server 1, client 2 is on server 2. how do they send message?
  - client 1 sends to server 1, server 1 to redis pubsub to server 2 to client 2.
  - ![alt text](pubsub.png)