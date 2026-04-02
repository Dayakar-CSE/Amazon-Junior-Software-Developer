Your online shop is growing and becoming more popular. You have regular customers who can browse products and place orders, and, because of the growth, you now also have administrators who can manage products, view all orders, and handle user accounts. 

These two distinct types of users will obviously need very different access permissions. You decide to use Role-Based Access Control (RBAC) to assign specific roles to users and then restrict access to certain parts of your application based on those roles.

In this graded lab, you will define roles, configure access control in Spring Security, and use the @PreAuthorize annotation to secure specific endpoints based on user roles.

Goal

To set up Role-Based Access Control (RBAC) in an e-commerce application using Spring Security by defining the USER and ADMIN roles. Configure Spring Security to control access to specific URLs and endpoints based on these roles. In addition, use the @PreAuthorize annotation to secure individual methods, ensuring that only authorized roles can access certain functionalities, like admin dashboards or user profiles.

Tip

If you need to refresh your knowledge of how to implement basic authentication before you move on to applying role-based access control, you can refer to the reading Handling user registration and login.

Requirements
In this lab you will need to: 

Define user roles.

Modify the User class to include a role field.

Define a USER role for customers and an ADMIN role for the administrators.

Store role information in UserService.

In UserService, assign users roles during registration or initialization, for example ADMIN for administrators and USER for regular users.

Ensure that user role information is accessible when authenticating users.

Configure role-based access in SecurityConfig

Update SecurityConfig to restrict access based on roles using the hasRole() method.

Define access control rules for these specific endpoints:

/admin/ endpoints should be accessible only by users with the ADMIN role.

/user/ endpoints should be accessible only by users with the USER role.

Secure other endpoints by requiring authentication for all users.

Implement @PreAuthorize annotation for method-level security:

Create AdminController class in src/main/java/org/amazon/example

Use @PreAuthorize on controller methods to ensure only users with the appropriate roles can execute certain actions.

Examples:

Restrict access to the admin dashboard to users with the ADMIN role.

Restrict access to the user profile to users with the USER role.

These changes will introduce role-based security, allowing different levels of access within the application based on user roles.

🖥️ Note: When you encounter this icon, it’s time to get into your IDE and start coding!

In your lab environment, open IntelliJ double-clicking on the icon. 
