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