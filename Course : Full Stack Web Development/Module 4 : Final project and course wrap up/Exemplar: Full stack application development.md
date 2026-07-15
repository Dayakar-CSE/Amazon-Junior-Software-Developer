
Amazon
Exemplar: Full stack application development
Introduction
Congratulations on completing the course project graded lab: Full Stack Application Development! 

In this reading, you’ll explore some of the key tasks you completed during the project. We’ll review the flows with TODOs you implemented, their objectives, and how they contributed to the program's overall functionality. This reflection will help you not only better understand the project’s requirements but also refine your coding approach moving forward.

Important

A solution to the graded lab is provided in the file: Solution_Course 5 project. 

In this project, you developed a full stack application, allowing you to have a web-based TODO tasks tracking system. For this, you showcased your HTML with Thymeleaf, CSS, JavaScript, and SpringBoot skills to deepen your understanding of full-stack development.

You had nine flows to complete, each designed to build key features of the web-based TODO tasks tracking system. Let’s quickly review each flow and what you needed to  accomplished:

First, with the public access flow you ensured that users have access to the registration page and view styles to increase the app's usability.  

Next, the login flow ensured the login form is in the center of the desktop browser. This helps the form to appear polished and improves visibility. 

For the registration flow, you created a registration process, ensuring users can register with a unique username and password when logging into the T-Rails application. 

In task flow 1, you added a task button as placeholder with padding on the dashboard, guiding users on what to enter and, therefore, improving the user experience. Furthermore, the new information entered by users, will be saved to the database and a new task appears on the dashboard.

For dashboard flow 1, you assigned due dates to tasks for filtering tasks by completion status and priority levels. 

Next, dashboard flow 2 involved the displaying of the server time as MM/dd/yyyy in the desktop view of your browser.  

In task flow 2, you added buttons (e.g., Done, Edit) to reflect the user's latest changes in the database. This allows the app to mark tasks as completed (e.g., yes or no) or revert them to pending. You also added colour for clear distinguish between completed tasks, and a counter to display the number of tasks completed.  

For the password flow, you added a password placeholder and validation check for improved user experience. Furthermore, the password flows compares old passwords, encode new passwords, update and save passwords.

Finally, the logout flow ensures that users can logout by selecting the Logout button.  

Important

Throughout this project, keep the following in mind:

Use a desktop or mobile browser, and don't disable JavaScript in the browser.  

Don't hit the back button in the browser, but use the application's navigation. If you are logged out, go back to 
http://localhost:8080/dashboard
.

The pause and check sections helps you to determine if you are on the correct path.

Pay attention to when you are instructed to log into T-Rails.

Complete the TODO's in sequence.


Flow 1: Public access flow
The objective of Flow 1 was twofold: Permit access to paths so that any user could access the app's essential pages without logging in and improve the user interface. In TODO 1, you configured free access for the static resource folder CSS with its content and the register page. 

TODO 1: Add the static resource /css/** to allow users to log in. The ** refers to all content in the folder.

1
.requestMatchers("/js/**", "/images/**" , "/css/**").permitAll()

To allow the register endpoint to be available to all users, add the endpoint (/register) as follows:

12
.requestMatchers("/","/login","/terms", "/custom-error",
                          "/register").permitAll()
You could have used a single requestMatchers() method. However, it is best practice to keep the static resources and endpoints separate. 


Flow 2: Login flow
The goal of flow 2 was to center the login form on the desktop browser. Therefore, you'll employ CSS. 

TODO 2: Adjust the margin with 25px for top and bottom, and auto for right and left. The syntax should look like:  is 

1
margin: 25px auto 25px auto;
The login form should be in the middle of the desktop browser.


Flow 3: Registration flow
TODO's 3 to 8 included setting up the form to send data to the correct endpoint upon submission and connecting it with a JavaScript file for client-side validation. Another goal was linking input fields to the server-side model, ensuring seamless data integration between the user interface and backend.

For design, the objectives included adding a subtle shadow to the container for a refined look and making the layout responsive so that buttons align vertically on mobile and side-by-side on larger screens. In terms of validation, the aim was to implement error handling in JavaScript, preventing form submission if validation fails and providing users with helpful error messages. Finally, ensuring that usernames are unique was essential by checking if a username already exists during registration.

Let's break it down:

TODO 3: Add the attribute action to /register to inform the form which location the data should be sent to. 

1
<form action="/register" method="post" th:object="${user}" onsubmit="return validateForm()">

TODO 4: Insert script tags (<script> </script>). Inside the tags, add the Thymeleaf attribute th:src to point to the /js/register.js within the curly braces of “@{}”. This connects register.js to register.html, allowing register.html to use the validateForm() method for client-side validation. Without this link, the form submission would cause a JavaScript error because the required method wouldn’t be available.

1
<script th:src="@{/js/register.js}"></script>

TODO 5: In the email input, add th:field="*{email}" as an attribute. This links the input field to the server-side data model, specifically connecting it to the email field in the User class.

1
<input type="email" id="email" placeholder="Enter your email"  th:field="*{email}" />
TODO 6 (a): Put a box shadow around the registration form container. The registration-container class should look like this:

1234567891011121314
.registration-container {
width: 100%;
max-width: 600px;
margin: 25px auto;
padding: 20px;
/* Light background color to match theme */
background-color: #E8F8FD;
border-radius: 10px;
/** TODO 6 (a): apply box shadow of 0px 4px 8px
     and transparency of 0.1

TODO 6 (b): Arrange the buttons to stack vertically in mobile view by using a button-group class and applying @media CSS styling.

123456
.button-group {
flex-direction: column;
}
@media (max-width: 768px) {
        }

TODO 7: Wrap the following lines with a try-catch block to make the code more robust and fault-tolerant. This ensures the errors array is accessible in both the try and catch sections. If an error occurs, the catch block adds an error message to the errors array and returns false to prevent form submission, while the try block allows the form to submit if there are no issues.

12345678910
try {
        const errors = [];
        // Your code that may throw an error
        // No errors, allow form submission
        return true;
        } catch (e) {
        errors.push("Error handling form fields!");
return false;
        }

TODO 8 (a): Add the following line of code to enable JPA to return a boolean value indicating whether a user with the provided username exists. This allows you to use JPA to check if a user with the specified username exists, returning true if found and false if not.

1
boolean existsByUsername(String username);

TODO 8 (b): Uncomment the following lines to check if a username already exists. Previously, these lines were commented out because the existsByUsername method hadn’t been added to the UserRepository class. Now that this method has been created in TODO 8a, it’s ready to use here to prevent duplicate usernames.

1234
if (userRepository.existsByUsername(user.getUsername())) {
        throw new Exception("Username already exists");
}

Flow 4: Task flow 1
From here onwards, you need to be logged in. Use your registered username and password and log into T-Raiils. After login, you'll view your personalized dashboard with the TODO tasks.

In Task flow 1, you used the placeholder attribute in form fields to guide users on the expected input, enhancing their experience by providing clear examples, such as in the “description” field. You also added padding within the form container, which improved readability and aesthetics by giving the content some breathing room. This prevented the text and input fields from looking cramped, making the form more user-friendly.

Finally, Task flow 1 guided you to implement a line of code that stores new task information in the database. This step ensures that each task a user creates is saved for future reference, enabling users to view or edit their tasks later. Without this, tasks wouldn’t be saved, making task creation ineffective.

Let's break it down.

TODO 9: To guide users on what to enter, add a placeholder to the <textarea> tag and specify the number of visible rows to improve usability. The placeholder attribute will display “Enter task description” inside the text area, giving users a hint about the expected input. Additionally, setting the rows attribute to 5 will expand the text area vertically, providing more space for entering descriptions. Here’s how the updated code should look:

1
<textarea id="description" th:field="*{description}" placeholder="Enter task description" rows="5"></textarea>
This configuration enhances the user experience by offering both a hint and adequate space for input.


TODO 10: Add the following line to give the .container class padding, which provides the content with some breathing room and enhances readability and the form’s appearance:

1
padding: 20px;
This will apply a 20px padding to the container, creating a more visually appealing and user-friendly layout.


TODO 11: Add the following line to update the data on the database server:

1
taskService.saveTask(task);
This line calls the saveTask method in the TaskService class, which then uses the TaskRepository to save or update the data by invoking the save method within TaskRepository. This flow ensures that new or updated tasks are stored in the database effectively.


Flow 5: Dashboard flow 1 
TODOs 12 and 13 guided you to use the findByUserAndDueDateAndCompleted method to retrieve tasks due today for the logged-in user, filtered by completion status and priority. In this flow, the service bridges the database and controller, while the model binds today’s tasks to todaysTasks, making it accessible on the client side with Thymeleaf.

Initially, the lines for displaying tasks by priority (HIGH, MEDIUM, LOW) are commented out to prevent errors if todaysTasks is unavailable. Once the model setup is complete, these lines can be uncommented to display tasks by priority for the current date.

Let's break it down.

TODO 12: Add the following line to retrieve data from the database through the repository layer and assign it to the taskListForToday array list, which is then returned to the controller in the provided lines. The controller will later send this data to the client by binding it to a model, a process you'll cover in upcoming steps.

1234
taskListForToday = taskRepository.findByUserAndDueDateAndCompleted(user, currentDate, false);
// return the task list
return taskListForToday;


TODO 13 (a): Add the following line to bind the list of today’s tasks for the logged-in user to the model object with the name todayTasks. This model object is then sent to the client, where the data can be accessed using Thymeleaf.

1
model.addAttribute("todayTasks", todayTasks);

TODO 13 (b), 13 (c), and 13 (d): Uncomment the lines between the markers for each priority level (High, Medium, Low) to enable the display of tasks due today for the logged-in user. For example: 

12345
<!-- 
...
<!-- End Medium Priority -->
-->


Flow 6: Dashboard flow 2
The Dashboard flow 2 allowed you to bind the server's date and time to the attribute serverTime, making it accessible on the client side through Thymeleaf. This enables the client to display the current date and time from the server.

TODO 14: Add the following line to bind the value of the formattedDate variable to the attribute name serverTime. This allows the date and time to be sent to the client side, where it can be accessed through Thymeleaf.

1
model.addAttribute("serverTime",formattedDate);

TODO 15: Update the <span> element to include th:text="${serverTime}" as follows:

1
<span th:text="${serverTime}"></span>
This setup allows you to display the server time on the client side. The th:text="${serverTime}" retrieves the value sent in the model with the attribute name serverTime and displays it within the span.


Flow 7: Task flow 2
TODOs 16 to 20 guided you to ensure that each task’s completion status in the database reflects user updates, allowing tasks to be marked as done or pending. Without this, users couldn’t save changes, leading to confusion.

Using th:text="${task.completed ? 'Yes' : 'No'}" in Thymeleaf displays "Yes" for completed tasks and "No" for pending ones, with color-coding (green for "Yes," red for "No") to help users quickly distinguish task statuses. The repository’s countByCompleted method, accessed through the service layer, provides counts of completed or pending tasks. The controller retrieves these counts by passing true or false to taskService, sending the results to Thymeleaf for display.

Let's break it down.

TODO 16: Add the line task.setCompleted(true); to mark the task object’s completed property as true. When the object is subsequently updated with taskRepository.save(task);, the task in the database with the same ID as the task object will also have its completed field set to true.

123
task.setCompleted(true);
taskRepository.save(task);


TODO 17: Inside the <span> element, add th:text="${task.completed ? 'Yes' : 'No'}" to display "Yes" if the task.completed value is true, and "No" if it’s false. By combining Thymeleaf’s th:text with the ternary operator, you can dynamically show the task’s completion status.

1
<span th:text="${task.completed ? 'Yes' : 'No'}"></span>

TODO 18: Add color: red; inside .task-status.pending to set the color for pending tasks, and add color: green; inside .task-status.completed for completed tasks. This creates a CSS setup with different colors for each status, allowing the view to display tasks in red if pending and green if completed.

123456789
.task-status.pending {
/* "No" for pending tasks */
color: red;
}
.task-status.completed {
/* "Yes" for completed tasks */
color: green;
}

TODO 19: Inside the <span> element, after th:text="${task.completed ? 'Yes' : 'No'}", add th:class="${task.completed ? 'task-status completed' : 'task-status pending'}". This setup applies different classes based on the task’s completion status, using the ternary operator to display "Yes" in green for completed tasks and "No" in red for pending tasks, making the status easy for users to understand at a glance.

12345
<span
        th:text="${task.completed ? 'Yes' : 'No'}"
        th:class="${task.completed ? 'task-status completed' : 'task-status pending'}">
</span>

TODO 20 (a): Add int countByCompleted(boolean completed);. This enables you to count tasks based on their completion status, with true for completed tasks and false for pending ones, using JPA for the query.

1
int countByCompleted(boolean completed);

TODO 20 (b): Replace the line return 0; with return taskRepository.countByCompleted(completedStatus); to leverage the JPA repository method created earlier. This returns the actual count of tasks based on their completion status, instead of a default value of 0.

1
return taskRepository.countByCompleted(completedStatus);

TODO 20 (c): Replace the lines model.addAttribute("completedCount", 0); and model.addAttribute("pendingCount", 0); with model.addAttribute("completedCount", taskService.countByCompleted(true)); and model.addAttribute("pendingCount", taskService.countByCompleted(false));. This uses the countByCompleted method in the TaskService class to retrieve the actual count of tasks by completion status, passing these values to Thymeleaf.

123
model.addAttribute("completedCount", taskService.countByCompleted(true));
model.addAttribute("pendingCount", taskService.countByCompleted(false));


Flow 8: Password change
The Password change (Flow 8) allowed you to improve user experience by adding a placeholder attribute to guide users on what to enter, reducing confusion. Checking the old password enhances security by confirming the user’s identity before a password change, preventing unauthorized updates.

Adding errorItem to errorList ensures error messages display correctly, while setting hasError to true blocks form submission if there are errors. Encoding the password is required for Spring Security, and updating the user object’s password with the save method securely stores the new password in the database.

Let's break it down.

TODO 21: Inside the <input> tag for the password confirmation field, add the placeholder attribute placeholder="Re-enter new password" to make it clear what is required of the user. The updated code should look like this:

1
<input type="password" id="confirmPassword" name="confirmPassword" placeholder="Re-enter new password">

TODO 22 (a): To ensure an error is flagged when the passwords do not match, add && newPassword !== confirmPassword to the end of the if statement condition. This condition checks that both password fields are filled and that their values match, preventing mismatches during confirmation. The updated code should look like this:

1
if (newPassword && confirmPassword && newPassword !== confirmPassword)

TODO 22 (b): Type in errorList.appendChild(errorItem); to append the error text to the errorList. Without this line, the error text will not be added, and it won’t be displayed in the browser.

1
errorList.appendChild(errorItem);

TODO 22 (c): Set the value of the variable hasError to true to indicate that the form has an error. This flag is later used to prevent form submission by returning false in the following code block:

1234567
hasError = true;
        if (hasError) {
        errorMessages.style.display = "block";
        // Stop the form from submitting
        return false;
        }

TODO 23 (a): In the if statement, add an OR condition || !passwordEncoder.matches(currentPassword, user.getPassword()) to handle password verification. Since the password is stored in the database in an encrypted form, we need to use PasswordEncoder to compare the plain text currentPassword with the encrypted value returned by user.getPassword(). The PasswordEncoder class simplifies this by allowing us to use currentPassword as plain text, automatically handling the comparison with the encrypted database value.

12345
if( user == null
        ||
        !passwordEncoder.matches(currentPassword, user.getPassword())
        )

TODO 23 (b): Change the statement String encodedPassword = newPassword; to String encodedPassword = passwordEncoder.encode(newPassword); to ensure the password is stored in encrypted form, as required by Spring Boot Security. The passwordEncoder bean in SecurityConfig.java provides this encryption, as shown below:

12345
@Bean
public BCryptPasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}

If the password isn’t encoded, login attempts will fail because Spring Boot Security encodes the entered password before comparing it with the stored password, which is already encrypted. Encoding the password before storing it in the database ensures a correct match during login.

1
String encodedPassword = passwordEncoder.encode(newPassword);

TODO 23 (c): Update the password to the value of encodedPassword using the user object by adding user.setPassword(encodedPassword);. This ensures that the password is correctly updated to the encrypted value in the database. Without this update, the password would remain unchanged in the database.

1
user.setPassword(encodedPassword);

TODO 23 (d): Update the password in the database using the save method of userService by adding userService.save(user);. This step is essential to save the changes to the password; otherwise, it will remain the same in the database.

1
userService.save(user);

Flow 9: Logout flow
Finally, with Flow 9, you added the logout button, allowing users to securely end their session by sending a POST request to /logout. Without this option, users wouldn’t have a way to log out, which could leave their account accessible on the current device. The button is conveniently positioned at the top of the dashboard for easy access.

TODO 24: In the <a> tag for the logout button, add th:href to point to /logout. While you could use the standard href attribute since this points to a static location, th:href is preferred if there is server-side processing and data binding. The updated code should look like this:

1
<a th:href="@{/logout}">Logout</a>
Summary
Congratulations on completing the Full Stack Application Development project! You built a web-based TODO tracking system, using HTML with Thymeleaf, CSS, JavaScript, and Spring Boot, showcasing full-stack skills.

Flows 1-3 set up user access, login, and registration, improving usability and security. Flows 4-6 enabled adding tasks, displaying them with priority filters, and showing the server's date and time on the client side. Flow 7 added task completion tracking with color coding and counters. In Flow 8, you enhanced password security with validation and encoding, and Flow 9 implemented a logout button for secure session management.

This project gave you experience in creating secure, responsive, and user-friendly applications. Great work!

