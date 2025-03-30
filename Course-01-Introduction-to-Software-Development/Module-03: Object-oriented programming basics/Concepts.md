
Coursera

Search in course
Search in course

Introduction to Software Development
Module 3
Writing method signatures
Writing method signatures
Introduction
You have likely had to sign documents on many occasions, such as admission forms, forms for opening a bank account, checks for utility bills, appointment letters, resignation letters, and so on. But why is your signature on a document so important? It’s a form of identification, an authentication of who you are. Recall an instance when you ordered something from Amazon, and the delivery person required you to sign before receiving it. This was a verification, a confirmation that the right person had received the package. So, apart from your face and name, you are recognized by your signatures too!

Likewise, methods in Java also have signatures that recognize them. How else would you know which method to call? In this reading, you will explore method signatures and two types of methods, returning and non-returning, and how to write them.

The main() method
When you purchase any electronic device, it usually comes with an instruction booklet, which has different sections to elaborate on the distinct features of the device. However, the booklet's first page tells you how to get started. Similarly, the main() method in Java is the starting point for a computer program. Here is the signature of the main method:

123
public static void main(String[] args) {
// instructions to be performed
}
Let’s examine how the signature of the main method acts like the instructions from the booklet from the previous example:

public - is like stating that “anyone can follow these steps.”

Hello, I am accessible to anyone!

Even your friend can read me.

static - is like saying, “These steps are always the same for this device.”

You can operate many similar devices using these exact instructions.

The basic instruction set is shared among all the devices.

void - means this section does not give you anything back directly, unlike the > (greater than) operator that always returns a result in either true or false.

Reading the booklet is an action, but it does not prepare your device for use. There are more steps to follow.

main - tells you what it does: Just like the booklet's first page might say “Getting Started,” the word main says, “This is the most important section for getting the program running.”

(String[] args) - is similar to saying, “This section might take some optional instructions or inputs later on, but they’re not needed to get started yet.”

Since it is an array, it can be empty!

Set of curly braces {} - contains all the instructions to be performed when the program starts.

Important
In simpler words, the signature of the main method tells you:

What it does: Start the program (similar to “Getting Started”).

How to use it: Just call “main” without any extra information.

What to expect: It might not give the result directly, but it sets the program in motion.

This is what the signature of every method tells you!

Understand the technical jargon.
At this stage, you must familiarize yourself with technical terminology relating to method signatures.

The keyword public is called an access modifier because it makes the method available to anyone who wants to use it.

The keyword static is like a sharing mechanism because it creates a single version of a method that all parts of the program can access. If you don’t want to share your method, you can skip it.

The keyword void is a return type because it indicates that the method does not give something in return for being called.

The keyword main is the method name. That is how Java recognizes the starting point of a program. For the methods you create, it can be a verb signifying the purpose of the method.

The (String[] args), such as the parentheses (empty or not empty), is called the parameter list because this is where you provide some input or information to the method. You can also offer multiple inputs, which is why it is called a list. Every time you use a print statement, you are providing parameters to a method, System.out.println(parameters);.

Anatomy of a method signature
Based on the above information, it’s easy to identify the various parts of a method signature as follows:

Parts of message as access modifier, sharing mechanism, return type, method name, argument list, and method body.
Now, examine the method used in the chicken and cheese sandwich example. It looked like this:

123456789
public static void gatherIngredients() {
// place the ingredients in the array
    ingredients = new String[4];
    ingredients[0] = "bread";
    ingredients[1] = "chicken slices";
    ingredients[2] = "cheese slices";
    ingredients[3] = "lettuce";
    System.out.println("All ingredients arranged.");
}
Can you identify the method signature in the code block above? if your answer matches the following, you’re correct!

123
public static void gatherIngredients() {
// instructions
}
Can you identify the various parts of this method signature?

Method name

Parameter list (empty or not)

Return type

Access modifier

Shareable or not: (if yes, how did you recognize that?)

How about asking for a method to ‘return’ something
Let’s explore how methods return something in more detail. Remember, void indicates that the method does not give something in return for being called. It’s like giving your friend a map to the coolest treasure in the world, only to find out they came back empty-handed (except for maybe sunburn!). 

When you are on a treasure hunt, you want the map to lead you to the actual treasure; that is the result. Similarly, while programming, you might want a few of your methods to give you a result. Therefore, in Java, methods are of two types:

1.     Following the map (non-returning methods): These non-returning methods are similar to the basic steps on your treasure map. Imagine a method called digHere that tells you to dig at a specific spot. However, it doesn’t unearth any treasure (no return value). You finish digging but do not find anything valuable. 

In the programming world, such methods might rearrange things internally, like gathering ingredients for a recipe. However, they do not provide a specific answer or a piece of data, like the final delicious meal.

2.    Treasure trove methods (returning a value): These methods are like finding hidden clues on our treasure hunt. Imagine a method called findNextClue, that tells you to search the current location and “returns” the next hidden clue it finds.

In programming, some methods perform tasks like looking up information and then return that specific data. For example, searching for a product on Amazon would “return” a list of matching products.

Both non-returning and returning methods are important while programming:

The non-returning methods help you to progress through the treasure hunt. Just like following instructions leads us to different locations, these methods can move a program through different steps, even if they don’t directly provide the result.

The returning methods can return different types of treasures, depending on the kind of clue they unearth. They might return a simple arrow pointing to the following location, a short riddle to solve, or even a more complex drawing like the detailed map of the next area. The critical point is that they bring back something valuable that helps you to progress further in your treasure hunt. 

These methods can provide you with information to help you make insightful decisions, such as whether to buy a specific product. Let’s put things into code with a practical example. 

Recall a time when you struggled to calculate the area of various shapes in your maths class. Now that you’re studying programming, how about coding an area calculator yourself? Just pick a simple shape, like a square, to start with.

Note: You will not use a parameter list in your methods. You will explore that later.

Begin by writing the Main class and declaring the necessary variable as follows:

4321
class Main {
// Area of a square = side * side
    static double sideOfSquare;
}
Create a method and set the values for this variable (recall the method signature):

 Access modifier: public

Is a sharing mechanism required? Yes, so this is static.

Return type required? No. This method will not provide you with any results (Non-returning method).

Method name: setSquareSide (indicates the purpose of the method).

1234
// method to set the side of the square
public static void setSquareSide() {
    sideOfSquare = 5.2;
}
You’re already familiar with non-returning methods. So, quickly move on to the next method, which calculates the area of a square. Sift through the following example:

12345
// method to calculate the area of the square
public static double calculateAreaOfSquare() {
    double areaOfSquare = sideOfSquare * sideOfSquare;
    return areaOfSquare;
}
The method's return type is double, because you want it to calculate the area of the square. Using the value of a double type of variable sideOfSquare, the result will eventually be double, right?

Within the method, the result is stored inside another variable called areaOfSquare. To return this result, you simply use the return statement with the variable's name containing the result.

If you closely observe, you’re indirectly returning the result of sideOfSquare * sideOfSquare. You could easily eliminate the variable areaOfSquare from the picture and directly return the multiplication result. Here is the modified code:

1234
// method to calculate the area of the square
public static double calculateAreaOfSquare() {
    return sideOfSquare * sideOfSquare;
}
Looks clean, right? Let’s complete the program by writing the main method:

123456789101112
// the main method
public static void main(String[] args) {
// set the side of square
    setSquareSide();

// call the method to calculate the area of the square
// And store the result given back by the method in a variable
    double areaOfSquare = calculateAreaOfSquare();

// print the result, using the values from the variables

Here is the complete program for your reference. To view the output, click Run. Try adding more methods with return types and run the program each time you change to observe the output. 

123456789101112131415161718192021222324252627
public class Main {
// Area of a square = side * side
    static double sideOfSquare;

// method to set the side of the square
    public static void setSquareSide() {
        sideOfSquare = 5.2;
    }

// method to calculate the area of the square

Reset
The significance of method signature when calling a method
Examine the way you called setSquareSide, or calculateAreaOfSquare in your program inside the main method.

You only used the method name along with parentheses. Why is this? Whenever you call a method:

 You don’t need to specify the access modifier, the sharing mechanism, or the return type of the method

The access modifier helped you call the method where you wanted to call it.

The sharing mechanism helped you use the method without any special preparation.

The method either gives you a result or not, depending on the return type.

 You only need to write the method name and the parameter list (if required). In your case, the method doesn’t have a parameter list, so you write an empty parenthesis with the method name.

Here are a few technical things to remember
The return statement must be the last statement inside a method. 

A method is called from somewhere in the program, meaning the program's control is handed over to it. 

As soon as a return statement is encountered, the method hands the control back to the place from where it was called. Therefore, anything written after the return statement will not be executed (also, your integrated development environment (IDE) will generate an error if you try to do so).

When a method is being called, the parameter list is called the argument list.

Conclusion
In this reading, you learned that method signatures identify methods just like our signatures identify us. You also examined how these signatures are written in a peculiar way indicated by a specific syntax. Each part of this syntax has its role to play when a method is defined and called. Additionally, you gained insight into the two types of methods: returning and non-returning. If a method is of the returning type, you mention the type of the expected result as the method's return type (double in the example provided in this reading); otherwise, you write void.

Completed

