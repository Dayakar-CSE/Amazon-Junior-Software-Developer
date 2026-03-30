
Amazon
Web services
Introduction
Imagine you're at a restaurant, ready to order your meal. You don't go into the kitchen to make your food; instead, you talk to the waiter. The waiter takes your request, communicates it to the kitchen, and brings back your food when it's ready. In this scenario, you and the kitchen have a straightforward way to communicate via the waiter, even though you don't know how the chef prepares the meal. All you care about is that your request gets fulfilled.

In the world of software development, Application Programming Interfaces—commonly known as APIs—work much like that waiter. They provide a way for different pieces of software to talk to each other, send requests, and receive responses without needing to know all the details of what's happening behind the scenes.

One of the most widely used methods for designing APIs is called Representational State Transfer, or REST. REST is like a menu that standardizes how software components interact, making it easy for them to communicate. In this reading, you’ll learn about REST and understand what makes it so essential for building modern web applications.

What is REST?
REST is an architectural style used to design web services. An architectural style defines a set of rules that allow systems to interact over the web in a simple and stateless way. RESTful APIs use standard HTTP methods, like GET, POST, PUT, and DELETE, to perform operations on data. The goal of REST is to separate the client (the one making the request) from the server (the one processing the request) so they can evolve independently without breaking the interaction.

Core principles of REST
To understand REST better, let's investigate its core principles:

Statelessness: In a RESTful system, each request from the client to the server must contain all the information needed to understand and process the request. This means the server doesn't keep track of any previous interactions; it treats each request as a new one. Think of it like calling a pizza delivery service. Every time you place an order, you provide your address and details, even if you’ve ordered from them before. They don't remember who you are—they just need the information to deliver your pizza.

Separate Client-Server architecture: The client and server are completely independent of each other. The client is responsible for the user interface and user experience, while the server handles data storage, processing, and logic. This separation makes it easier to modify and update one part of the system without affecting the other.  Imagine a food delivery app. You (the client) interact with the app to place an order, and the restaurant (the server) prepares and delivers the food. The app and the restaurant work together, but they have distinct roles.

Uniform interface: REST APIs have a consistent way of interacting with the server. A standardized approach makes it easy for developers to understand how to work with RESTful APIs, no matter what application they're using. This uniformity is usually achieved using the following  standard HTTP methods:

GET: Retrieve data from the server (like reading a menu).

POST: Send data to the server (like placing an order).

PUT: Update existing data (like changing your order).

DELETE: Remove data from the server (like canceling an order).

Resource-based: In REST, everything is treated as a resource, which is simply an object or piece of data identified by a URL. For example, a user might be a resource, represented by the URL https://api.example.com/users/123. These resources are represented in a format like JSON or XML, making them easy to work with and transfer over the web.

REST APIs have become the standard for building and consuming web services because they are:

Scalable: They handle large amounts of traffic with ease, making them suitable for modern, cloud-based applications.

Simple: The principles of REST are easy to understand and follow, even for beginner developers.

Platform-independent: REST APIs can be used with any programming language or device that supports HTTP, allowing for flexible integration.

Flexible: The client and server are loosely coupled, meaning they can evolve separately. You can update the backend logic without affecting the client-side application.

REST APIs power most of the internet services used today. When you book a ride on a ride-sharing app, stream a video on a platform like Netflix, or even check the weather on your phone, you are likely interacting with RESTful APIs. These APIs allow your device to send a request to the server (e.g., "Show me available rides"), and the server returns a response with the data you need ("Here are the nearest drivers").

Benefits of using REST
The following are the primary benefits of using REST:

Ease of use: RESTful APIs are easy to integrate and work with because they rely on standard HTTP protocols.

Stateless nature: The statelessness of REST ensures that each request is independent, which helps with load distribution and reduces server memory usage.

Caching: Since REST uses standard HTTP, it allows for caching responses, which can significantly improve performance and reduce the load on the server.

Compatibility: REST APIs are compatible with a wide range of technologies and platforms, which makes them versatile and future-proof.

Challenge: Make a REST call and analyze the results of REST responses
To give you some hands-on experience with REST APIs, let's add a challenge that will let you interact with a real RESTful API. You’ll use a free demo API called JSONPlaceholder, which provides a set of simple endpoints for testing and learning purposes. This challenge will help you to understand how to make REST calls and analyze the results of REST responses. 

For this challenge, you will use a free, publicly accessible REST API called JSONPlaceholder. JSONPlaceholder is a great resource for learning about REST APIs as it provides a simple and structured way to make API calls.

Requirements
Complete these steps.

Step 1: Making a GET request

Open your web browser. In the address bar, type the following URL to retrieve all posts and press Enter:

https://[Json Place Holder Website]/posts.

A list of data items is displayed in your browser in JSON format. This data represents a collection of "posts" (similar to blog posts or articles).

Great job! You just made a GET request to the API, retrieving a list of resources without writing any code.

Step 2: Retrieve a specific resource

Modify the URL in the browser to include an ID to fetch a specific post as demonstrated:

https://[Json Place Holder Website]/posts/[ID of any post retrieved in last call].

Only one post is displayed in JSON format, which corresponds to the ID you requested.

Step 3: Challenge yourself with more queries

Use this URL to get a list of comments related to a specific post:

https://[Json Place Holder Website]/posts/[ID of any post retrieved in last call]/comments.

Fetch a list of users from this API:

https://[Json Place Holder Website]/posts/users.

You can open the 
JSONPlaceHolder website
 if you want to do further research. You can explore different endpoints using the JSONPlaceholder Guide and try making different types of requests using only your browser.

Advanced challenge: Understanding HTTP methods in the browser
Since the browser only supports GET requests directly through the address bar, here is an optional advanced challenge you can try without using any specialized tools.

Requirements
Complete these steps in the interactive code block:

Open the developer tools in your browser (usually accessible with F12 or right-click on the output page of REST call > "Inspect" > "Network")

Tip

Your browser's Developer Tools are a great way to understand how data moves when you're making REST calls. These tools help you see how requests are sent from the browser to a server, and how the server sends back responses. You can also see the size of the data being sent and received, what information is included in the request and response, and how long it takes.

One of the key features is the Network tab, where you can view every HTTP request (such as GET, POST, PUT, DELETE) made by the browser. This is useful for debugging and understanding how web pages or apps communicate with servers.

Use the Network tab, as shown in the following images, to investigate the details of your GET request, including the request headers and the server's response. 

This image shows the JSON response:

12345678910111213141516171819202122232425262728293031323334353637383940
[
    {
        "userId": 1,
        "id": 1,
        "title": "are or do repels provide blacked out except option criticizes",
        "body": "because he also accepts/undertakes the consequences of refusal and when/when criticizes the trouble so that the whole\nof our things are but they are the matter will happen to be architected"
    },
    {
        "userId": 1,
        "id": 2,


This image shows a partial view of the developer’s debug pane:



Reflection point 
The following output reflects the desired output for the challenge.  Navigate to these URLs:

https://jsonplaceholder.typicode.com/posts 

https://jsonplaceholder.typicode.com/posts/1 

https://jsonplaceholder.typicode.com/posts/1/comments

https://jsonplaceholder.typicode.com/users

Take a moment to reflect on the challenge you’ve completed by asking yourself these questions:

What areas did I struggle with and why?

How did I troubleshoot any errors (if any)?

What lessons will I take forward?

Download the document to review the solution after you have attempted the challenge.

Conclusion
REST has become the backbone of web communication because of its simplicity, scalability, and flexibility. Just like the waiter in the restaurant, RESTful APIs act as the perfect intermediary, handling the exchange of data between systems. They ensure that clients can get the data they need from servers without worrying about the underlying details.

Adhering to the principles of REST enables developers to build robust, efficient web applications that are easy to maintain and scale. As you continue to learn and work with APIs, you'll find that REST is not just a technology—it's a philosophy that guides how we design and connect web services to create a seamless experience for users around the world.

Completed
