Coursera
Instructions
Lab instructions
0 of 5 completed


inLabInstructionsPart~u4rXhq2XEe-K6RKAHTgFMw
​

Now that you’ve created a simple REST controller in the Spring Boot application, it’s time to bring it to life by running it and testing how it responds to requests. You'll use IntelliJ IDEA to start the Spring Boot server and then validate our setup using either a web browser or a tool like Postman. This step will help you ensure that your REST controller is working correctly and responding to the welcome message you coded.

Goal

Run your Spring Boot application and validate that the REST controller is correctly set up.

🖥️ Note: When you encounter this icon, it’s time to get into your IDE and start coding!

In your lab environment, you can open IntelliJ IDEA by double-clicking on the icon.

The IntelliJ icon.
Coursera
Instructions
Lab instructions
0 of 5 completed


inLabInstructionsPart~1MiiNa2XEe-8nA7ehSWC6w
​
To begin, you’ll need to start your Spring Boot application. In this task, you’ll locate the main class that serves as the entry point for the application and then initiate the server. Once the application is running, you’ll check the console output to confirm everything is working as expected.

🖥️It’s time to get coding!

TODO 1: Find the ExampleApplication.java file inside the src/main/java/org.amazon.example package. This file contains the main() method, which is the entry point of your Spring Boot application.

TODO 2: Run the application. You can do it in a variety of ways:

Right-click on the ExampleApplication.java file and select Run 'ExampleApplication.main()'.

Click the green arrow next to the main() method. 

Click on the spring-boot:run under spring-boot plugin under the  Plugins section of the example project in the maven preview on the right-hand side of IntelliJ IDEA. 

You can also type the appropriate maven command mvn spring-boot:run into the IntelliJ IDEA terminal.

The following image showcases the output.

Example output.
TODO 3: If everything is set up correctly, the Spring Boot server starts up in the console. Look for the following message:

1
Tomcat started on port(s): 8080 (http)
Your application is now running, and the server is listening for HTTP requests on port 8080, as shown in the following image.

Example output.
Coursera
Instructions
Lab instructions
0 of 5 completed


inLabInstructionsPart~zdGIHa2YEe-8nA7ehSWC6w
​
As an alternate tool for REST testing, you’ll now verify the REST controller using Postman. This tool allows you to simulate different types of HTTP requests, which is helpful for testing your application beyond a web browser. In this task, you’ll create and send a GET request to the welcome endpoint using Postman.

TODO 6: Open the Postman Application on the Desktop (or use the postman web app) and create a new GET request (by clicking on the New Request button) for the welcome endpoint. (It may ask you to create an account or do a social login.) Hit the Postman request  with the correct URL + correct method type.

TODO 7:  Click the Send button. The response with the welcome message in the body is displayed.

Well done! By following these steps, you’ve successfully run your Spring Boot application and tested the REST controller to make sure it responds as expected. This simple activity confirms that your setup and configuration are correct, and you now have a fully functional Spring Boot web service!
