
Amazon
Handling HTTP methods
Introduction
Think about building a social media platform where users create profiles, follow friends, and share posts. Managing these interactions requires clear, consistent methods for handling user data through an API. Each action—viewing a profile, updating a bio, adding a post, or even deleting an account—demands the right HTTP method to ensure secure, predictable data exchanges.

When a user checks a friend’s profile, a GET request retrieves the data. If they want to update their bio, a PUT request makes changes. Adding a new post? That’s where POST comes in. And if they decide to delete their account, a DELETE request safely removes it. Mapping each action to a specific HTTP method keeps the API intuitive and reliable, enabling smooth user interactions with the data.

In this reading, you'll explore each of these HTTP methods in action within a UserController example. By the end, you'll understand when and how to apply each method effectively in your own RESTful services.

Handling HTTP methods in RESTful services
In RESTful services, HTTP methods enable a client to interact with resources through four core operations: Create, Read, Update, and Delete, often called CRUD. Each method is designed for a specific purpose, and using them correctly ensures clarity, security, and predictability in data handling.

In a typical Spring Boot application, the service layer manages business logic, while the controller layer is focused solely on handling HTTP requests and responses. Separating these responsibilities keeps the code clean and makes the API easy to work with. To handle HTTP requests, create a UserController class marked with @RestController and @RequestMapping("/users") annotations. The @RestController annotation identifies the class as a REST controller, meaning it will handle HTTP requests and send JSON responses. Meanwhile, @RequestMapping maps HTTP requests to specific handler methods, directing each request to the right part of the code.

In this context, the comment // All methods here are considered REST endpoints highlights that each method within the UserController class is mapped to handle a specific HTTP request (e.g., GET, POST, PUT, DELETE) for the /users resource. These methods serve as endpoints in a RESTful API, acting as the entry points where clients interact with the resource.

```bash
@RestController
@RequestMapping("/users")
public class UserController {
// All methods here are considered REST endpoints
}
```
Overview of HTTP methods
HTTP Method

Action

Description

GET

Retrieve

Fetches data from the server without modifying it

POST

Create

Submits new data to the server

PUT

Update

Updates existing data on the server

DELETE

Remove

Deletes data from the server

GET: Retrieving data
The GET method is used to fetch data from the server. It’s an idempotent operation, so repeated requests will return the same result without altering the server’s state. In RESTful services, GET requests retrieve data without causing any changes.

For example, to get a list of all users, define a method named getAllUsers() in UserController and annotate it with @GetMapping. The @GetMapping annotation maps to a GET request and specifies the URL path for the endpoint.

```bash
// Retrieve a list of all users
@GetMapping("/users")
public ResponseEntity<List<User>> getAllUsers() {
List<User> users = userService.getAllUsers();
return ResponseEntity.ok(users);
}
```
To retrieve a specific user by ID, create a method getUserById(@PathVariable Long id) and use @GetMapping("/users/{id}"). The @PathVariable annotation binds a URI template variable to a method parameter, capturing dynamic values such as the user’s ID.

```bash
// Retrieve a specific user by ID
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
User user = userService.getUserById(id);
return ResponseEntity.ok(user);
}
```

The GET method is ideal for actions like displaying profiles, listing items, or retrieving details by a unique identifier.

POST: Submitting new data
The POST method is used to create a new resource on the server. It’s not idempotent, meaning repeated POST requests could result in multiple instances of a resource. In RESTful APIs, POST is commonly used to send new data from a client to the server for processing and storage.

To create a new user, define a method createUser(@RequestBody User user) and mark it with @PostMapping("/users"). The @PostMapping annotation maps to an HTTP POST request, while @RequestBody captures data sent from the client.

```bash
// Create a new user
@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User user) {
User newUser = userService.createUser(user);
return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
}
```
Use POST for actions that add new data to the server, such as registering users, submitting forms, or creating new posts.

PUT: Updating existing data
The PUT method is used to update an existing resource. It is idempotent, so repeating a PUT request with the same data doesn’t result in additional modifications beyond the initial request. The PUT method generally requires the full, updated resource representation.

To update a user’s information, define a method updateUser(@PathVariable Long id, @RequestBody User user) in UserController and annotate it with @PutMapping("/users/{id}").

```bash
// Update an existing user
@PutMapping("/users/{id}")
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
User updatedUser = userService.updateUser(id, user);
return ResponseEntity.ok(updatedUser);
}
```
Use PUT when updating resources, such as editing profile details or modifying an existing post.

DELETE: Removing data
The DELETE method is used to remove resources from the server. Like GET and PUT, it’s idempotent—once a resource is deleted, repeating the same DELETE request has no additional effect.

To delete a user by ID, define a method deleteUser(@PathVariable Long id) and annotate it with @DeleteMapping("/users/{id}").

```bash
// Delete a user by ID
@DeleteMapping("/users/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
userService.deleteUser(id);
return ResponseEntity.noContent().build();
}
```

Use DELETE for actions that permanently remove resources, such as deleting user accounts or removing items from a shopping cart.

Conclusion
As you’ve seen, HTTP methods bring structure and clarity to RESTful services, with each one—GET, POST, PUT, DELETE—serving a distinct role in the CRUD operations that manage your resources. 

HTTP Method

Action

Example Route

UserController Example

GET

Retrieve

/users or /users/{id}

getAllUsers(), getUserById()

POST

Create

/users

createUser()

PUT

Update

/users/{id}

updateUser()

DELETE

Remove

/users/{id}

deleteUser()

By applying these methods correctly in your UserController, you create a RESTful API that balances accessibility and control. Users can confidently interact with data, knowing that retrieving, creating, updating, or deleting information is handled predictably and securely.

Completed
