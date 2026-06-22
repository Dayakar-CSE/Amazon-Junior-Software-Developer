
Amazon
Lab

Activity: S3 File operations using Java
Instructions
As applications scale, managing vast amounts of user data – like images, files, or other media – becomes a core challenge. Storing and retrieving these files securely and efficiently requires robust, scalable cloud storage solutions. AWS S3, a powerful cloud storage service, is designed to handle exactly this, enabling applications to scale effortlessly as data demands grow.

In this lab, you’ll integrate AWS S3 with a Spring Boot application to manage essential file operations for Pixoza, including uploading, downloading, and deleting images. By connecting to an S3 bucket using the AWS Java SDK, you’ll equip the app with dynamic, scalable file management capabilities – an essential skill for building cloud-ready applications.Ready to set up and start performing your first S3 operations? Let’s go!

Goal

Integrate AWS S3 with your Spring Boot application to perform basic file operations (upload, retrieve, and delete) using the AWS Java SDK from your local environment.

🖥️  Note: When you encounter this icon, it’s time to get into your IDE and start coding!

In your lab environment, open IntelliJ by double-clicking on the icon.


Getting started
In this lab, you’ll work with a Spring Boot starter project (using the MVC architecture) that’s pre-configured to integrate with AWS S3. This setup includes the necessary dependencies and configurations to connect to an S3 bucket, enabling file operations like uploading, downloading, and deleting files.

Adding AWS SDK dependencies
To enable S3 interactions in your Spring Boot project, you’ll need the AWS SDK for Java, which equips your application with the tools needed to interact with S3 services. This dependency has already been added to your pom.xml file.

123456
<dependency> 
    <groupId>software.amazon.awssdk</groupId>
    <artifactId>s3</artifactId> 
    <version>2.29.3</version>
</dependency>

Note

The S3 client setup and bucket creation method are already configured for you in the AWSS3Service class. This class uses the credentials provided through environment variables to connect securely to AWS S3. The createBucket() method within the class allows you to programmatically create an S3 bucket with a specified name.

Now that your environment is set up, let’s review the main components of the code provided in this lab. Each part of the codebase has been organized to help you interact with AWS S3 effectively, from handling file data to managing HTTP requests and responses. 

Here’s a breakdown of the structure and functionality of each component:

Model (S3File class): Represents the data related to files being uploaded, downloaded, or deleted, along with the status of each operation.

Service (AWSS3Service class): Contains the business logic for interacting with AWS S3, including uploading, downloading, deleting files, and creating buckets.

Controller (AWSS3Controller class): Manages HTTP requests and responses, delegating tasks to the AWSS3Service and returning the appropriate S3File objects or status messages.

Front-end interface (Resource/static/index.html): A basic front end for your application, with options such as “Create Bucket”, “Upload”, “Download”, and “Delete Uploaded File”. Once the backend implementation is complete, use this page to test and interact with your features directly.



