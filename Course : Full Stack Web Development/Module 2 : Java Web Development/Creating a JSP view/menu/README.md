
Amazon
Creating a JSP view
Introduction
You’ve already set up the coffee shop’s online menu through the ProductController, making it easy for customers to click and view products. But right now, it’s just plain text. In this guide, you'll transform plain text into a visually inviting menu with JSP.

This is where JSP (Java Server Pages) comes in! JSP lets you blend HTML with Java code, creating dynamic content that looks like a real website. With JSP, you can take data from ProductController and display it in a web-friendly format, making your menu visually appealing and easy to navigate.

What is JSP?
JSP is a technology for creating dynamic web pages in Java-based applications. It allows developers to embed Java code directly in HTML so the page can interact with data and update based on user actions or database content.

Key benefits of JSP
Dynamic content: JSP displays data-driven content, like a product list that updates automatically.

Java + HTML: It combines Java logic with HTML, giving you control over what appears on the page.

MVC integration: In the MVC (Model-View-Controller) framework, JSP serves as the View layer, presenting data to users in a clear, organized format.

Set up a JSP view in the Coffee Shop app
Let’s create a basic JSP view to display your coffee shop menu. You’ll use the data from ProductController to populate your view so that customers can access product IDs, names, and prices in a structured, styled way.

Configure the application for JSP
To use JSP, you must first ensure your Spring Boot application is set up to handle JSP files. This can be done in three steps, as follows:

Step 1: Add the necessary dependencies
First, add the following dependencies to your Spring Boot application to enable JSP support.

tomcat-embed-jasper: This dependency supports JSP files in your application. Tomcat is the server that runs your app, and Jasper interprets JSP files. Without it, your app wouldn’t understand JSP code.

Let’s add this dependency to the project:

Open the pom.xml file, which is directly below the project folder in your coffee shop menu project.


Right-click inside the file and select Generate…


Select Dependency.


Search for org.apache.tomcat.embed:tomcat-embed-jasper in the resulting window, then select it from the list of results, and click the Add button.


Note: 
The version 10.1.30 is used in this example. If you encounter any build errors or issues running the application after adding this dependency, you can try updating the version. A more recent, stable version you can use is 10.1.39. Simply change the version number within the <dependency> tag in your pom.xml file.

The dependency will be added under the <dependencies> section of pom.xml.

JSTL: The JavaServer Pages Standard Tag Library (JSTL) provides special tags to make JSP code simpler and more readable, enabling tasks like looping through data or adding conditions. To support JSTL, you require two dependencies:

jakarta.servlet.jsp.jstl-api: This dependency defines JSTL features, listing available tags and their functions. 

jakarta.servlet.jsp.jstl: This dependency implements JSTL, providing the code to run the tags.

These dependencies allow dynamic content, loops, and conditions to work smoothly on your JSP pages.

Let’s add these two to the pom.xml:

Right-click inside pom.xml, select Generate…, then select Dependency.

Search for jakarta.servlet.jsp.jstl, and select the JSTL API dependency to add it.


Next, search for org.glassfish.web and select the appropriate dependency to add it.


Your pom.xml should contain the following under <dependencies> section by now:

1234567891011121314151617181920212223242526272829
<dependencies>
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-test</artifactId>
       <scope>test</scope>

Observe that your pom.xml displays a small icon at the top right of the file.


Hover over the icon, which prompts you to load Maven changes due to updates in the project structure. Click to load these changes to ensure the project functions correctly.


Click on the icon, and Maven will do the rest.

Important

The first two dependencies were added when you created the project with Spring Initializr and selected Spring Web. The next three dependencies support JSP and JSTL. Adding dependencies this way ensures that your project includes the latest versions. Alternatively, you can search for dependencies on 
Maven Central
 and select specific versions. After adding dependencies, remember to click Load Maven Changes to update the project structure.

Why JSTL with JSP?

JSTL is essential even though JSP can build views with HTML, as it adds dynamic features that HTML alone can’t provide. While HTML manages layout and styling, JSTL enables dynamic capabilities like loops (<c:forEach>) and conditions (<c:if>), making it easy to display changing data. It also supports formatting numbers, dates, and text without complex Java code, keeping views simple and user-friendly. In short, JSTL enhances JSP, making it ideal for building dynamic, interactive pages

Step 2: Create the folder structure for your JSP files
Next, place your JSP files in a specific folder structure to ensure they’re accessible to your Spring Boot application. This setup keeps your files organized and secure.

In your project, navigate to the src/main folder.

Right-click on main and create a new directory.


 Name the directory webapp. By convention, this directory name indicates the main entry point for web resources in a Java web application, including HTML, CSS, JavaScript, images, and JSP files.

Inside the webapp, create a new directory named WEB-INF. By convention, this folder name ensures compatibility with Java web servers, which are designed to treat this folder as secure and inaccessible via direct HTTP requests, adhering to established standards. It is commonly used to store server-side resources like JSP and configuration files, keeping them accessible only through the application’s controllers.

Inside WEB-INF, create another directory called jsp. You can change this name according to your preferences; just remember that it must represent the kind of files it stores. For example, it could be named views.

Your JSP files, such as the coffee shop menu view, will be placed in this WEB-INF/jsp folder. Storing files here keeps them hidden from direct URL access, so only your application can use them.

In essence, your folder structure must resemble the following:


Step 3: Configure a view resolver for JSP
The next step is to configure a View Resolver to ensure Spring Boot can locate and render JSP views. This component tells Spring where to find JSP files and which file extension to expect.

To configure a view resolver, use the application.properties file. Locate it in the src/main/resources folder and open it.


Add the following code snippet to the file:  spring.mvc.view.prefix=/WEB-INF/jsp/spring.mvc.view.suffix=.jsp. This configuration directs Spring to look in the WEB-INF/jsp directory for .jsp files when a controller returns a view name.

Create your first JSP view
Now, build your first JSP file to showcase all menu products.

Right-click on the jsp folder and select New. Then select File.


Name the file as menu.jsp. Remember to add the extension .jsp because IntelliJ doesn’t recognize JSP files by default.

Add the following HTML and JSP code to menu.jsp:

123456789101112131415161718192021222324252627282930313233
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>
                Coffee Shop Menu
            </title>
        </head>
    <body>

Observe the following:

<%@ taglib prefix="c" uri="jakarta.tags.core" %> is a directive that enables JSTL tags in JSP, registering the core JSTL library with the prefix c.

<c:forEach> iterates over collections. Here, it loops through each product in products and displays details in table rows.

${product.id}, ${product.name}, ${product.price} accesses data from the Product model passed by the controller, displaying each product's details in the table for easy viewing.

Modify the controller to pass data to the JSP
To display your coffee shop menu in menu.jsp, the controller needs to pass product data to the JSP view. This is where the Model part of MVC comes in.

In Spring MVC, the Model is like a tray the controller uses to carry data to the JSP, allowing it to be displayed dynamically with JSTL tags. 

The Model interface, found in org.springframework.ui, is added as an argument in the controller method, and data is passed with addAttribute("key", value). The "key" is the name used in JSP to access the data.

In ProductController, modify the listProducts() method to pass productsList to menu.jsp:

12345
@RequestMapping("/list") // This maps to the URL http://localhost:8080/products/list
    public String listProducts(Model productListModel) { // Model argument is used to pass data to the view
        productListModel.addAttribute("products", productsList); // Add the productsList to the model
        return "menu";  // This returns the view name, that is, the JSP file name
    }
Note:

model.addAttribute("products", productsList); adds productsList to the model with the name products, making it accessible in menu.jsp as ${products}.

return "menu"; returns "menu", directing the View Resolver to locate menu.jsp in WEB-INF/jsp/.

Important

To avoid errors, don’t forget to import the Model interface from the org.springframework.ui package.

Test your application
Now it’s time to start your Spring Boot application and navigate to 
http://localhost:8080/products/list
. Your menu should be displayed in a simple borderless table.


Troubleshooting
If your output differs, check for these common issues:

JSP File Not Found: Ensure menu.jsp is in WEB-INF/jsp.

View Resolver: Verify application.properties is set up correctly for the view resolver.

JSTL Dependencies: Confirm JSTL dependencies are added in pom.xml, and reload Maven changes.

1234567891011
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>3.0.2</version>
</dependency>
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>3.0.1</version>
</dependency>

JSTL Taglib Directive: Add at the top of menu.jsp: <%@ taglib prefix="c" uri="jakarta.tags.core" %>

URL or Controller Mapping: Ensure http://localhost:8080/products/list is correct, and @RequestMapping("/list") is set in ProductController.

Model Argument: Confirm that Model is a parameter in listProducts, and that you added productsList correctly:

12345
public String listProducts(Model productListModel) {
    productListModel.addAttribute("products", productsList);
    return "menu";
}

Enhance your menu with CSS styling
Finally, with the JSP menu now visible, style it using CSS for a professional look, making it more engaging and easier to navigate. A few styling touches can transform the table into a visually appealing, inviting menu.

Step 1: Create a CSS folder in the static folder
The static folder is specifically designed to serve static resources like CSS, JavaScript, and images directly.

Navigate to src/main/resources, right-click on static and create a new directory named css.

Right-click on the css folder and create a new file named styles.css.

Your project structure should display as follows:


Step 2: Add styling to styles.css
Then, open styles.css and add the following CSS to style your menu:

12345678910111213141516171819202122232425262728293031323334353637383940
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    color: #333;
    text-align: center;
    margin: 0;
    padding: 20px;
}

h1, h2 {

Notice the styling details:

Body: Light background, comfortable font, and centered text create a welcoming feel.

Headers: Color accents highlight headings.

Table: Centered layout with padding and a subtle shadow adds depth.

Row Hover Effect: Color change on hover makes the menu interactive.

Step 3: Link the CSS file in menu.jsp
Now, connect styles.css to menu.jsp so these styles apply to your menu.

Open menu.jsp.

Add the following <link> tag inside the <head> section to link the CSS file: <link rel="stylesheet" href="/css/styles.css">

Why use /css/styles.css?

Files placed in src/main/resources/static are served directly by Spring Boot at the root level, so the path to styles.css will be /css/styles.css.

Rerun your application, open a browser, and navigate to 
http://localhost:8080/products/list
. 

Your menu should display with the new CSS styling, with hover effects and clean formatting.


Troubleshooting
If your output differs at this stage, check for these common issues:

CSS file link: Ensure the <link> tag in menu.jsp is accurate: <link rel="stylesheet" href="/css/styles.css">

File path: Verify styles.css is in src/main/resources/static/css/ and accessible at http://localhost:8080/css/styles.css. If not, recheck your file structure.

Link tag placement: Confirm the <link> tag is correctly placed inside <head> in menu.jsp.

Syntax errors: Review styles.css for typos, missing semicolons, or mismatched brackets.

HTML structure: Ensure that the menu.jsp structure matches the expected tags (<body>, <table>, <tr>, <th>, <td>) for CSS to apply correctly.

Conclusion
In this guide, you transformed a plain text menu into an interactive, visually engaging display using JSP, JSTL, and CSS in a Spring Boot application. You configured dependencies, set up a folder structure, and created a dynamic JSP view that integrates smoothly with your MVC framework. By applying CSS styling, you enhanced the menu’s visual appeal, making it user-friendly and professional. This setup equips you to build more sophisticated, responsive Java-based web applications in the future.

You can also download the complete project for your reference: 


Completed
