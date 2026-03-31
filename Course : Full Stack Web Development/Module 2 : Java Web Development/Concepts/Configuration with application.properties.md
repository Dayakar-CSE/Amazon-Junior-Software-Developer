
Amazon
Configuration with application.properties
Introduction
Configuration is at the heart of building adaptable and scalable applications. With the right customized settings, you can control how an application behaves in different settings, making it easier to manage and deploy.

In this reading, you’ll learn how to configure Spring Boot applications with application.properties. You'll adjust settings like server port and application name, and see how profiles enable smooth transitions between environments like development and production.

Ready to make your apps fit for purpose? 

Configuring the server port and application name
You can think of configuring applications like managing a smart home system, where you can adjust the temperature, lighting, or door locks from a central app, without any rewiring. In Java, Spring Boot applications offer similar flexibility, and configuration is typically managed through two common files found in src/main/resources:

application.properties: A simple key-value format for configuration.

application.yml: An alternative format that organizes settings in a hierarchical structure.

The configuration set up in the application.properties or applications.yml file is invaluable when adapting your application across environments, such as development, testing, or production. 

In a real-world scenario, you might adjust the server port to avoid conflicts in development or set a unique application name to streamline tracking in logs. Let’s start by configuring these two common properties: the server port and application name.

In the Spring Boot project previously created in this lesson, open the application.properties file (or create it if it doesn’t exist) and add the following configurations:

server.port: Sets the port number for your Spring Boot application. By default, Spring Boot runs on port 8080, but here we’re changing it to 8081. Type in server.port=8081.

spring.application.name: Sets the name of your application, which is useful for logging or tracking the application within a larger system. Type in spring.application.name=MyExampleApp.

And you’re off! With these simple configurations, you’ve already customized core settings in your Spring Boot application, making it more flexible and suited to different environments.

Using profiles to manage environments
Spring Boot allows you to define configurations for different environments using profiles, making it easy to switch settings without altering your core application. Think of profiles as "modes" for your app – like switching your phone between silent and normal mode. 

Each profile can have its own configuration, enabling you to tailor the application for specific environments. For example, imagine you’re working with the following two profiles:

Development profile: You might use an embedded database for quick testing and set the application to run on localhost.

Production profile: You could connect to a production-grade database and configure the application to run on a designated server port to ensure stability and security.

Setting up profiles
To set up a profile, create a profile-specific configuration file by naming it “application-{profile}.properties”. And to create the first of our two profiles, the development profile, name the file application-dev.properties:

The open file application-dev.properties.
For a production profile, add another file named application-prod.properties:

The open  file named application-prod.properties.
These profile-specific files let you define settings unique to each environment, such as database connections, server ports, and logging configurations. When you activate a profile, Spring Boot automatically applies the settings from the corresponding profile file, making environment-specific configuration easy to manage.

Activating a profile
Once created, profiles need to be activated for their unique configurations to take effect. To do this, specify the profile in the default application.properties file with the following line, which sets the active profile to "dev":

The default application.properties file highlights the following line: spring.application.name=MyExampleApp
To start the Spring Boot application and view the active profile, use the Maven spring-boot:run command. The active profile name will appear in the output log, confirming that the correct profile settings have been applied:

The active profile name is dis in the output log.
Nice! With profiles activated, your application is now configured to adapt to different environments seamlessly.

Challenge: Switching profiles from the command line
Now that you understand how profiles work in Spring Boot, it’s time to challenge yourself by switching profiles directly from the command line. The challenge is to configure your Maven pom.xml file to allow for profile switching (e.g. between development and production) and then running your Spring Boot application with different profiles. In the process, you will learn how your application behaves differently based on the active profile.

RequirementsComplete these steps to switch profiles:
Open your pom.xml file. 

Make changes in the Maven plugin section to enable profile activation via command line. This configuration tells Maven to look for the spring-boot.run.profiles property when running the application and use it to activate the corresponding profile.

1234567891011
<plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
            <profiles>
                <profile></profile>
            </profiles>
        </configuration>
   </plugin>

Open a terminal and navigate to your project directory.

Run the required Maven command to start the application and also add argument activate the dev or prod profile. Type in:  mvn spring-boot:run “argument to activate profile within double quotes” .

Note

In the Spring Boot starting terminal, you will be able to see the active profile name. This is how you retrieve a specific resource from a REST API using its identifier.

Reflection point 
The following reflects the desired output for the challenge:

Several lines of output are displayed.
What areas did I struggle with and why?

How did I troubleshoot any errors (if any)?

What lessons will I take forward?

Download the document to review the solution after you have attempted the challenge.

Tips

In general, keep in mind these tips to manage profiles effectively and ensure your application behaves as expected in different environments:

Keep profile-specific configurations organized: Use application-{profile}.properties or application-{profile}.yml files for each environment (e.g. dev, prod, test) to maintain a clear and organized structure.

Easily activate profiles: You can set the active profile in application.properties using spring.profiles.active=dev, or override it directly from the command line for flexibility.

Use environment variables: Spring Boot can read environment variables, which is useful for managing sensitive or environment-specific settings outside of code.

Combine profiles: You can activate multiple profiles at once, such as spring.profiles.active=dev,prod, allowing you to combine configurations as needed.

Check active profile: Use @Value in your code to log the currently active profile, which can be helpful for troubleshooting.

Conclusion
Just as you adjust settings in a smart home system to meet specific needs, Spring Boot’s application.properties and application.yml files give you the flexibility to configure your application to suit different environments. 

By using externalized configuration and profiles, you can seamlessly adapt your application for any setting – whether it’s running locally during development or serving thousands of users in production. This approach keeps your code clean, configurations organized, and your application versatile and ready for real-world demands.


  

Completed


STEP 1: Open your pom.xml file and add the following Maven plugin section to enable profile activation via command line:

<plugins>
   <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <configuration>
         <profiles>
            <profile>${spring-boot.run.profiles}</profile>
         </profiles>
      </configuration>
   </plugin>

STEP 2: Switch to the production profile by running the following:

mvn spring-boot:run “-Dspring-boot.run.profiles=prod”
