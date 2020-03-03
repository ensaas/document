# WISE-PaaS IoT Hub  
An IoT Hub is a message broker service that enables message delivery and exchange between an IoT device and a cloud application service. For example, the IoT Hub sends the data collected via an IoT device or sensor to the WISE-PaaS cloud platform, where the data can be visualized, analyzed, or processed for other value-added applications. The WISE-PaaS cloud platform can deliver administrative messages via the IoT Hub to IoT devices in the field.

|                |Kafka                          |RabbitMQ                     |
|----------------|-------------------------------|-----------------------------|
|Architectures|Kafka combines messaging queue and publish subscribe approaches.|RabbitMQ uses a messaging queue.|
|Multiple consumers|Multiple consumers can subscribe to the same topic|Multiple consumers cannot all receive the same message.|
|Replication|Topics are automatically replicated, but the user can manually configure topics to not be replicated.|Messages are not automatically replicated, but the user can manually configure them to be replicated.|
|Protocols|Kafka use a binary protocol over TCP|AMQP(s)(Advanced Messaging Queue Protocol)<br>MQTT(s)<br>MQTT over WebSocket<br>STOMP<br>CoAP|
|Charge model|PAYG(Pay as you go)<br>Monthly charge by partition usage|Monthly charge by plan
|Shared plan limitation|Max 50MB per partition<br>Max 28 days retention|3 Million Messages per month<br>Max 100 concurrent connections<br>Max 100 queues<br>Max 2000 queued messages<br>Max 2M queued bytes<br>Max 1 day message TTL (time-to-live)<br>Max idle queue time 28 days|

## Kafka  
> ### Introduction Of Kafka
>
> #### Kafka has been designed and prominently marketed towards stream processing scenarios. In addition to that, Kafka has recently added Kafka Streams which positions itself as an alternative to streaming platforms such as Spark, Flink, Beam/Google Cloud Data Flow and Spring Cloud Data Flow. Kafka has use cases like Website Activity Tracking, Metrics, Log Aggregation, Stream Processing, Event Sourcing and Commit logs
>
> ### Architecture Of Kafka
>
> #### Kafka combines messaging queue and publish subscribe approaches
>
> ### Handle Multiple Consumers In Kafka
>
> #### Multiple consumers can subscribe to the same topic and get same message
>
> ### Kafka Replication Protocol
>
> #### Kafka Topics are automatically replicated, but the user can manually configure topics to not be replicated
>
> ### Kafka Protocols
>
> #### Kafka uses a binary protocol over TCP
>
> ### Pro Of Using Kafka
>
> * Stream processing, not just queuing
> * High throughput
> * Reprocessing of events
>
> ### Con Of Using Kafka
>
> * No IoT-specific features like last will and testament
> * Requires stable network and good infrastructure
>
> ### Some Scenarios Best For Kafka
>
> * Stream from A to B without complex routing, with maximal throughput (100k/sec+), delivered in partitioned order at least once.
> * When your application needs access to stream history. Kafka is a durable message store and clients can get a “replay” of the event stream on demand, as opposed to more traditional message brokers where once a message has been delivered, it is removed from the queue.
> * Stream Processing
> * Event Sourcing
>
> ### WISE-PaaS IoT Hub Kafka has the following features
>
> 1. 

## RabbitMQ  
> ### Introduction Of RabbitMQ
>
> #### RabbitMQ is a general purpose messaging solution, often used to allow web servers to respond to requests quickly instead of being forced to perform resource-heavy procedures while the user waits for the result. It’s also good for distributing a message to multiple recipients for consumption. When your requirements extend beyond throughput, RabbitMQ has a lot to offer: features for reliable delivery, routing, federation, HA, security, management tools and other features
>
> #### It provides client libraries for major programming languages
>
> * Python
> * Java
> * Ruby
> * PHP
> * C#
> * JavaScript
> * Go
>
> ### Architecture Of RabbitMQ
>
> #### RabbitMQ uses a messaging queue
>
> ### Handle Multiple consumers In RabbitMQ
>
> #### Multiple consumers cannot all receive the same message in defult setting
>
> ### RabbitMQ Replication Protocol
>
> #### Messages are not automatically replicated, but the user can manually configure them to be replicated
>
> ### RabbitMQ Protocols
>
> #### Advanced messaging queue protocol (AMQP) with support via plugins: MQTT, STOMP
>
> ### Pro Of Using RabbitMQ
>
> * Lightweight
> * Built for poor connectivity scenario
>
> ### Con Of Using RabbitMQ
>
> * Queuing, not stream processing
> * No reprocessing of events
> * No high scalability
>
> ### Some Scenarios Best For RabbitMQ
>
> * Your application needs to work with any combination of existing protocols like AMQP 0-9-1, STOMP, MQTT, AMQP 1.0
> * You need a finer-grained consistency control/guarantees on a per-message basis (dead letter queues, etc.)
> * Your application needs variety in point to point, request / reply, and publish/subscribe messaging
> * Complex routing to consumers, integrate multiple services/apps with non-trivial routing logic
>
> ### WISE-PaaS IoT Hub RabbitMQ has the following features
>
> 1. Supports several protocols, including AMQP, MQTT, MQTT Over WebSocket, and CoAP
> 2. Supports TLS 1.2
> 3. Highly reliable, high-performance cluster architecture
> 4. Offers “shared” and “dedicated” services; the former allows you and other users to share computing resources available in a cluster of IoT Hub servers, whereas the latter provides you with computing resources available in an IoT Hub host or a cluster of IoT Hub hosts
> 5. Supports multi-tenancy management, allowing the administrator to manage connection channels and redeploy resources as appropriate
> 6. Provides a device- or connection-based channel for data isolation, depending on the tenant’s needs


