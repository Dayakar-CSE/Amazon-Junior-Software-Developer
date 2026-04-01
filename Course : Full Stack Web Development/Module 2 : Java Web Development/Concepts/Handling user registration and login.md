
Amazon
Handling user registration and login
Introduction
When people shop online, they need access to their order information and order history. To ensure a successful online business, they should be able to place new orders without difficulty. Crucially, they also need to know that the information they provide is secure.  

This is why an online shop must have a system where customers register to create an account and where they need to be authenticated with a login to view their order history, update their shipping address, or place an order. 

This reading steps through the process of creating a simple registration and login system using Spring Security to handle user credentials securely. Users will be able to register, log in, and have their sessions managed safely, similar to how an e-commerce platform ensures customers can access their accounts and orders.

List of code changes required
Create User.java (Model Class):

Represents the user entity with fields like username, password, and role.

Holds the basic information needed for registration, login, and authorization.

Create UserService.java (Service Class):

Manages user registration by encoding passwords and storing users in memory.

Provides methods to find users by username, ensuring proper authentication during login.

Create RegistrationController.java (Controller Class):

Handles user registration requests.

Displays the registration form and processes new user registrations.

Create LoginController.java (Controller Class):

Handles requests for displaying the login page.

Directs users to the login form where they input their credentials.

Create SecurityConfig.java (Security Configuration Class):

Configures Spring Security to manage authentication and authorization.

Defines security rules (e.g., public access for registration and login, secured access for other pages).

Handles user authentication through form-based login and session management.

Create PasswordConfig.java (Password Encoder Configuration Class):

Provides the PasswordEncoder bean (using BCryptPasswordEncoder) for secure password hashing.

Ensures that passwords are stored securely during registration and validated correctly during login.

A PasswordEncryptor Bean in Spring Boot ensures that user passwords are securely hashed before storage, protecting them from unauthorized access. It centralizes the encryption logic, promoting consistent and safe password handling across the application.

Create register.html (Registration Page):

Displays the registration form for new users to input their username and password.

Submits user details to the backend for processing and registration.

Create login.html (Login Page):

Provides the login form where existing users input their credentials.

Sends login details to Spring Security for authentication.

Create welcome.html (Welcome Page):

Displays a message after a user successfully logs in.

Serves as a simple landing page for authenticated users.

All the java classes will be created in src/main/java/org/amazon/example and HTML files in src/main/resources/templates.

Step 1: Set up Spring Security dependency
Spring Security has already been added to pom.xml. Thymeleaf will be used to create simple registration and login forms. First, add the required dependency.

```bash
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
Step 2: Create a user model
User details will be stored in memory so you have to create a User class which is a model for storing user information. The role attribute will be used for role-based access control. 

This model will hold user information.

```bash
package org.amazon.example;

public class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }
}
```

Step 3: Create a separate configuration for PasswordEncoder
Next, create a new configuration class called PasswordConfig to define the PasswordEncoder bean:
```bash
package org.amazon.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

Step 4: Create a User management service
You must create a class called UserService to store and manage users. Since a database is not being used in this example, the users will be stored in memory using a Map for simplicity. This service will handle both user registration and authentication. The following two items must be handled correctly to ensure that users can log in after registration.

Store the user in a persistent way (even in-memory for now) so that they can be authenticated.

Use proper password encoding to secure the user's credentials and allow them to log in successfully.

```bash
package org.amazon.example;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.put(user.getUsername(), user);  // Store the user in the map
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public Map<String, User> getAllUsers() {
        return users;
    }
}
```

Step 5: User Registration Controller
User registration must be implemented by making REST API calls.  You need a RegistrationController class to handle user registration. The @Autowired annotation in Spring Boot is used for dependency injection, allowing Spring to automatically inject a required bean into a class. In RegistrationController, UserService is autowired, so Spring provides an instance of UserService to handle user registration logic without manual instantiation. The class is created with this code:
```bash
package org.amazon.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.registerUser(user);  // Attempt to register the user using the service
            model.addAttribute("message", "Registration successful! Please login.");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred during registration. Please try again later.");
            return "register";  // Redirects back to registration page with a generic error
        }
    }
}


```
The form created with the above code which is shown in the image below, allows users to enter their credentials to register.

The Register form displaying the Username, Role, and Password fields, as well as a Register button.
Step 7: Create the login form
Spring Security provides built-in support to handle login. A LoginController class must be created to serve the login page:

1234567891011121314
package org.amazon.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {

Next, create the login.html in the templates folder:

12345678910111213141516171819202122
<!-- login.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form th:action="@{/login}" method="post">
    <label for="username">Username:</label>

The simple form created, shown in this image, captures the username and password for login.

The Login page displaying the Username and Password fields, as well as a Login button.
Step 8: Configure Spring Security
Now, let’s configure Spring Security to handle authentication. 

The user /login and user registration (/register) pages are not authenticated, as both should be available for free public access. All other pages must be authenticated. 

Form-based login is enabled and after successfully logging in, users will be redirected to the welcome page.  
UserDetailsService
 bean will be used for retrieving a username, a password, and other attributes for authenticating with a username and password. 

Spring Security provides 
in-memory
, 
JDBC
, and 
caching
 implementations of UserDetailsService.  The @Bean annotation in Spring marks a method as a bean producer, allowing Spring to manage and inject the returned object as a dependency. In SecurityConfig, defining UserDetailsService as a @Bean lets Spring Security use it to load user details for authentication. You have to update the SecurityConfig class:

```bash
package org.amazon.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/register", "/login").permitAll()  // Allow public access to these pages
                .anyRequest().authenticated()                         // Secure all other pages
                .and()
                .formLogin()                                             // Enable form login
                .loginPage("/login")
                .defaultSuccessUrl("/welcome", true)                 // Redirect after successful login
                .and()
                .logout().permitAll();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            org.amazon.example.User user = userService.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            UserBuilder builder = User.withUsername(user.getUsername());
            builder.password(user.getPassword());  // Password is already encoded
            if(user.getRole() != null) {
                builder.roles(user.getRole());
            }
            return builder.build();
        };
    }
}
```

Go to /register and create a user.

After registration, you'll be redirected to the login page.

Log in with your new credentials.

You should be redirected to the secured page (/welcome) after logging in.

Overall flow
Now that the process of creating a simple registration and login system using Spring Security is complete, consider the flow of the user information and the stages it goes through. 

Registration
First, users fill in their credentials on register.html to complete registration which is processed by RegistrationController and stored by UserService.

Login
When they are logging in, users enter their credentials on login.html, and Spring Security, configured in SecurityConfig, authenticates them against the stored data in UserService.

Security
Spring Security ensures only authorized users can access secure pages after login, and passwords are securely stored using PasswordEncoder.

Conclusion
You’ve now created a basic registration and login system using Spring Security, ensuring that user credentials are handled securely through session management. During this process, users were stored in memory for simplicity. In real-world applications, remember to use secure password storage and proper validation practices. This forms the backbone of any secure user management system in modern web applications.

Completed
