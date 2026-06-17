
Amazon
Introduction to AWS RDS
Introduction 
Remember how you used databases and MySQL in the previous course, connecting to them from Java using Java Database Connectivity (JDBC)? Amazon offers a service called Relational Database Service (RDS) through Amazon Web Services (AWS) that simplifies database management. With Amazon RDS, developers are freed from manual tasks like hardware setup, database backups, and scaling to handle changes in demand. Amazon RDS supports several relational database systems, including MySQL, which we’ll focus on in this reading. You’ll learn how to create a MySQL database on Amazon RDS and integrate it into Java code with minimal effort.

There are two pre-requisites: 

You must have an Amazon AWS account. 

Sign in to your AWS management console.

Amazon RDS overview
Amazon RDS is a cloud-based database service that enables users to easily set up, operate, maintain, and scale relational databases. It supports different database engines like MSQL, PostgreSQL, Oracle, IBM DB2, MariaDB, and  Microsoft SQL Server. As it is a cloud service, the time required to spin up and maintain one RDS is quite low, including the time and effort required to maintain the database availability and backup systems.

Benefits of Amazon RDS
Amazon RDS provides the following benefits over a local instance of MySQL: 

Automatic backups: RDS automatically saves backups of your database. This ensures that your data is safe and can be restored if necessary. 

Easy scaling: RDS provides an increase or decrease of the database storage size quickly and efficiently, reducing downtime.

Load balancing: RDS can distribute the work across multiple servers. This is helpful when a large number of users are demanding data simultaneously. 

No hardware or server setup: AWS manages the hardware and resources, so you do not have to worry about buying hardware, software, or other resources to ensure the high availability of your database.

Secure access: RDS uses strong security features to protect your data, allowing you to control who can access it and who cannot. 

High availability: RDS can duplicate or replicate your database data across different locations worldwide and across different servers, ensuring that if one server at one location fails, another server can take over, ensuring that your data is always available. 

Accessible anywhere: RDS allows you to connect to your database from any location worldwide, ensuring that your data is available 24/7. 

Create and configure the RDS instance
Follow the steps below to set up an Amazon RDS server with MySQL, configured to allow users to connect using their username and password. 

Remember

Using a username and password is the least secure method to connect to an Amazon RDS, but it is the simplest and easiest to understand.

For information about other methods to connect to an RDS database, refer to the AWS Documentation or explore the Security Best Practices for Amazon RDS section in the AWS Management Console.

On your AWS console dashboard:



Search for rds and click Databases.


 

Click Create Database.



In Choose a database creation method, select Standard create. In Engine options, select MySQL.



Scroll down, and select MSQL Community under Edition. For Engine version, select MySQL 8.0.39 or the latest version.



Scroll to the Templates section and select Free tier.



Scroll to the Settings section and provide the following details:

DB instance identifier: Enter rdstest. 

Master username: Enter adminajsd

Master password: Enter ADmin123CDF#CDF?

Remember to confirm the password. In the Credentials management section, select Self managed. You will use these credentials to connect to the MySQL Server on RDS. The instance name of the RDS database is the name of the instance, which uniquely identifies the RDS within your AWS account. You are using the database instance identifier of rdstest. An identifier represents the RDS instance on the AWS cloud, under your AWS account.


Important

The database instance identifier identifies your RDS within your AWS account, but it is not a database but a name representing the RDS system itself. You can create one or more databases on your RDS instance.



In the Compute resource section, select Don’t connect to an EC2 resource. In the Public access section, select Yes.


Remember

If you do not allow Public access, the RDS instance will not be accessible from outside the Amazon cloud directly.



Scroll to the Additional configuration section and enter 3306 in the Database port field.



  In the Database authentication section, select Password authentication.

Remember

Password authentication enables users to connect using a plain username and password.



Accept all other default values and click Create database.



If you get any pop-ups similar to the example above, click Close.



In the Status column of the DB Identifier section, you will notice that the RDS instance is being created. Please wait until the process is complete.



When the process is complete, you will receive a message confirming that the database was created successfully. If the status is Backing-up, please wait. 


When the status updates to Available, you can proceed.



Click on the name of the DB Identifier, which is hyperlinked. 



In the Connectivity & security tab, in the Endpoint & port section, you will find the URL and port for the RDS. 



Click the copy icon to copy the URL to your computer’s clipboard and enable you to paste it elsewhere. You will need to do this in the next section.

Congratulations on getting this far! You have now successfully set up an RDS database that uses MySQL and allows a user to connect to it using the username and password you entered.

Test with MySQL Workbench and create a database
Now that you have set up and configured the RDS, you will complete the following tasks: 

Test that the credentials work.

Create a database named Learners from MySQL Workbench.



Click on the + symbol to add a new MySQL connection.



Return to the RDS console and copy the endpoint as mentioned in Step 16 of the Create and configure the RDS instance section above. You should observe the message: Endpoint copied. If this does not work, select and copy the endpoint. 



Enter a Connection Name. For the Connection Method, select Standard(TCP/IP). For the Hostname, paste the URL you copied in the previous step. For the Username enter the Master username, adminajsd, from Step 6 of the Create and configure the RDS instance section. Click Store in vault.



In the pop-up, enter the Master password, ADmin123CDF#CDF?,  from Step 6 of the Create and configure the RDS instance section. Click OK.



When the pop-up closes, click Test Connection. You should see a pop-up similar to the one in the above example, confirming that the connection was successful. Click OK on this pop-up and then then click OK on the Setup New Connection screen.



You should now see the new connection to your Amazon RDS instance. Open the connection.



In MySQL Workbench, create a new Database or Schema. Right-click in the SCHEMAS section and select Create Schema. 



In the Name field on the Create Schema window, enter Learners and click Apply. 



In the pop-up that appears, click Apply. 

Tip

Instead of Steps 7, 8 and 9, you can also use a create database command on the SQL Editor and execute it. 



In the Navigator section, under Schemas, you will notice the Learners schema. Close the schema to view the SQL Editor tab.



If the SQL editor tab does not appear, click the icon in the toolbar, as shown in the above image.



In the Navigator section, double-click the Learners schema under SCHEMAS, or execute the SQL statement in the SQL Editor as follows: use learners;  

In the Navigator section under Schemas, the Learners name should become bold, which indicates it is in use.

Great work! You set up an RDS instance and created a database from your MySQL Workbench. Let's now move to using this database from a Spring Boot application using Java. You just created a database, but you can execute whatever SQL query you want on the RDS.

Use the RDS database from a Spring Boot application
Suppose you have a Spring Boot Application where you connect to a local MySQL database on your local machine. But what if you now want to connect to a database named Learners on the Amazon RDS, which you just created? Complete the following steps to configure the Spring Boot application to point to the Learners database on your Amazon RDS.

Open up the application.properties file and make the following modifications:

Update the spring.datasource.url property. Return to the RDS console and copy the endpoint as mentioned in Step 16 of the Create and configure the RDS instance section above. You should observe the message: Endpoint copied. If this does not work, select and copy the endpoint.



In the properties file after the equals sign of spring.datasource.url property 

Type jdbc:mysql:// 

Next, paste the URL you copied from the RDS console

Then, type in the database name as follows: /Learners

Replace the name Learners with the actual database name you want to connect to.

Next, add the SSL options and the public key options after the database name as follows: ?useSSL=false&allowPublicKeyRetrieval=true

If you assume that your Amazon RDS URL, running on port 3306, is: myrds.abc123.us-east-1.rds.amazonaws.com:3306

It will look as follows:

1
jdbc:mysql://myrds.abc123.us-east-1.rds.amazonaws.com:3306/Learners?useSSL=false&allowPublicKeyRetrieval=true

Change the spring.datasource.username property to use the username you set for the RDS and the spring.datasource.password property to use the password you set for the RDS. 

You can now use the RDS database system in the same manner you used your local MySQL system.

Conclusion
The only difference between using a local MySQL and an RDS MySQL is not visible for the Java Programmer, except for the initial server setup. However, the advantages derived from using Amazon RDS are great for real-time systems because it simplifies database management by handling system backup, automatic scaling during load, and system security. In addition, since it is cloud-based, it is available and accessible from anywhere in the world. 

Completed
