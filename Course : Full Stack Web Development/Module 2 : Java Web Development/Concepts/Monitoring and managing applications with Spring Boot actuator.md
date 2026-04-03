
Amazon
Monitoring and managing applications with Spring Boot actuator
Introduction
When managing an application, knowing its health, performance, and potential issues is essential. Think about running a busy e-commerce site: keeping tabs on customer visits, load times, and potential glitches like low stock or checkout delays is critical for smooth operations. Similarly, monitoring an application helps you catch issues early and keep it running optimally.

Spring Boot Actuator makes this monitoring straightforward. With its built-in endpoints, Actuator offers insights into metrics like memory usage, uptime, and database connections, giving you a real-time view of your application’s status. This can be a game-changer for maintaining a reliable and responsive system.

In this reading, you’ll learn how to add Spring Boot Actuator to your project and use its endpoints to monitor health checks, track performance metrics, and troubleshoot potential problems. You must use the existing code in the project, which is part of the 
Activity: Using Spring Data JPA for database operations
.

Step 1: Add Spring Boot Actuator dependency
To start monitoring with Spring Boot Actuator, begin by adding its dependency to your pom.xml file. This will enable the Actuator features in your project.

```bash
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

With the dependency added, Actuator automatically enables its default endpoints, allowing you to monitor your application's health and performance right away.

Step 2: Enable Actuator endpoints in application.properties
All actuator endpoints, except shutdown, are enabled by default. Many endpoints may contain sensitive information, so we may choose to expose them by using the application.properties file. By default, some Actuator endpoints are restricted for security. To make them accessible, update your application.properties file.

In the src/main/resources/application.properties file, add these lines to expose essential Actuator endpoints:

```bash
management.endpoints.web.exposure.include=health,info,metrics,env
```
This will expose critical Actuator endpoints for monitoring:

/actuator/health: provides a health status of your application.

/actuator/info: displays basic application information.

/actuator/metrics: shows application performance metrics.

/actuator/env: displays environment properties.

Step 3: Explore key Actuator endpoints
Now, let's dive into some of the key Actuator endpoints and how they can help monitor your application’s performance and health.

1. Health check endpoint
The health endpoint (http://localhost:8081/actuator/health) provides a quick snapshot of your application's current health. For instance, in an e-commerce app, if the database connection is lost, this endpoint will report the system as DOWN.

Expected output:

```bash
{
        "status": "UP"
}
```

This output is useful for automated health checks and can integrate with monitoring tools like Prometheus or Grafana. With this, you'll be alerted when there’s an issue with your application.

2. Metrics endpoint
The metrics endpoint (http://localhost:8081/actuator/metrics)  provides detailed performance data, such as memory usage and HTTP request timings. For an e-commerce site, this can be especially helpful to monitor how long customers wait during checkout or product viewing.

To check specific metrics, you can query details with:

Example for HTTP requests

URL for metrics:  http://localhost:8081/actuator/metrics/http.server.requests

Expected output:

```bash
{
  "name": "http.server.requests",
  "measurements": [
    {
      "statistic": "count",
      "value": 150
    }
  ],
  "availableTags": [
    {
      "tag": "method",
      "values": ["GET", "POST"]
    }
  ]
}

```

This output shows how many requests have been made and how long they take. Monitoring these metrics helps ensure users experience fast response times.

3. Application info endpoint
The info endpoint (http://localhost:8081/actuator/info) provides general information about your application, such as version number or custom info (e.g., last deployment date).

Expected output:

```bash
"app": {
        "version": "1.0.0",
        "description": "E-commerce application for product management."
        }
        }
```

This is useful for tracking your application version and viewing release notes directly from the API.

4. Environment properties endpoint
The env endpoint (http://localhost:8081/actuator/env) displays environment properties like system properties and configuration settings your application is using. For instance, you can verify which database configuration is active.

Important

To try this on your own, launch your lab and apply these modifications to the project created earlier. Be sure to save your files after making changes.

The lab includes the database required to run the application. Each code block in this reading will guide you step-by-step through the process.

Challenge: Secure the Actuator endpoints
Currently, all your Actuator endpoints are publicly accessible. This can expose sensitive information about your application's health and performance. The challenge here is to restrict access to these endpoints so only authenticated users with the ADMIN role can access them.

Step-by-step instructions
Update your security configuration so that only users with the ADMIN role can access Actuator endpoints, such as /actuator/health and /actuator/metrics.

Test these endpoints using an authenticated ADMIN user to confirm that unauthorized users are blocked.

Ensure that regular API endpoints, like /products, remain accessible to non-admin users while keeping the Actuator endpoints secure.

```bash
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http
.authorizeHttpRequests()
.requestMatchers("/register", "/login").permitAll()// Allow public access to these pages
.requestMatchers("/admin/**").hasRole("ADMIN") // Only ADMIN can access /admin/*
.requestMatchers("/user/**").hasRole("USER") // Only USER can access /user/*
.anyRequest().authenticated()
.and()
// Configure Basic Authentication for the API endpoints (like /products)
.httpBasic()
.and()
// Disable form login for API endpoints to avoid redirection
.csrf().disable()
.formLogin()
.loginPage("/login")
.defaultSuccessUrl("/welcome", true)
.and()
.logout().permitAll();
return http.build();
}

```

Reset
Reflection point 
Download the document to review the solution after you have attempted the challenge.
solution:
```bash
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests()
                .requestMatchers("/register", "/login").permitAll()  // Allow public access to these pages
                .requestMatchers("/admin/**","/actuator/**").hasRole("ADMIN")        // Only ADMIN can access /admin/*
                .requestMatchers("/user/**").hasRole("USER")          // Only USER can access /user/*
                .anyRequest().authenticated()
                .and()
                // Configure Basic Authentication for the API endpoints (like /products)
                .httpBasic()
                .and()
                // Disable form login for API endpoints to avoid redirection
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/welcome", true)
                .and()
                .logout().permitAll();

        return http.build();
    }

```

To test, run:

```bash
mvn spring-boot:run
```
Reset
After the application starts, try logging in with user/user123 and admin/admin123 credentials. Then, attempt to access the Actuator endpoints to verify that only users with the ADMIN role have access.

Tips for implementation
You can modify the SecurityConfig class to secure the /actuator/** endpoints. Use hasRole("ADMIN") to restrict access to only admin users and ensure you test it with different user roles.

Code best practices

If you didn’t get the desired output, take some time to troubleshoot your code. Errors happen to everyone, even to the best software developers. Working through them is part of the job.

If you struggled, consider doing the following:

Limit endpoint exposure: Expose only essential Actuator endpoints.

Secure sensitive endpoints: Limit access to authorized users, like those with the ADMIN role.

Use HTTPS: Always use HTTPS in production to secure Actuator data.

Monitor key metrics: Track important performance metrics and set alerts.

Disable unused endpoints: Reduce the attack surface by disabling any unnecessary endpoints.

Integrate monitoring tools: Tools like Prometheus or Grafana can offer advanced monitoring options.

Regularly review configuration: Audit Actuator and security settings to ensure they remain effective.

Test in multiple environments: Verify endpoint exposure and security across different environments.

Take a moment to reflect on the challenge you’ve completed by asking yourself these questions:

What areas did I struggle with and why?

How did I troubleshoot any errors (if any)?

What lessons will I take forward?

Conclusion
With Spring Boot Actuator, you have access to a toolkit that enables you to track essential metrics, set up health checks, and secure sensitive data—all critical for ensuring a seamless user experience. Actuator empowers you to monitor your application much like a store manager overseeing operations, making sure everything runs smoothly for customers.

By mastering these monitoring techniques, you’re building a foundation for creating reliable and resilient applications. These skills will serve you well as you grow in your career, equipping you to build systems that run smoothly, scale confidently, and meet user expectations.

