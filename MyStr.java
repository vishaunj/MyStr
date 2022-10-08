/* Vishaun Jones
*  03=31=2022
*  Assignment 5: MyStr
*  CGS3416
*  Silei Song*/

import java.util.Scanner;

class node {
    private char data; //variables that stores the nodes data.
    private node link; //variable that points to the next node

    public node(char initialData, node initialLink) { //constructor initializes the data and link variables
        data = initialData;
        link = initialLink;
    }

    public char getData () { //method used to return the data of the current node
        return data;
    }

    public node getLink() { //method used to return the current node
        return link;
    }

    public void setLink (node newLink) { //method used to set the data of the next node.
        link = newLink;
    }
}

class mystring{
    private node head; //variable used to set the first node of the list
    private node tail; //variables used to add more nodes to the list
    private String inputString; //variable that stores the users String input
    private int size = 0; //This variable is used as a counter to count the number of characters in the users string input.

    public mystring(String input) { //Constructor that takes in the user input as a String and stores it in a variable.
        inputString = input;        //It also calls the two methods that add each char from the string to a node.
        addFirst();
        addEnd();
    }

    public void addFirst() { //This method adds the first character from the string to the head of the node by using
        head = new node(inputString.charAt(0),head);  //the charAt method for string to extract the first character
        tail = head;                                  //located at index 0. It then makes tail null.
        size++;
    }

    public void addEnd() {
        for (int i = 1; i < inputString.length(); ++i) { //This loop creates a new node for every character in the user
            tail.setLink(new node(inputString.charAt(i), null)); //string, using the same charAt method to extract
            tail = tail.getLink();                                        //the character.
            size++; //Adds 1 to size after each iteration, which is an indication of a character.
        }
    }

    public int myLength() {
        return size; //Returns the final value of the variable size which was counting the number of characters in the user string.
    }

    public char myCharAt(int a) {
        node current = head; //This variable initially stores the data of the head node.
        for (int i = 0; i < a; ++i) {
            current = current.getLink(); //As the loop iterates until it reaches the user int input, the variable current
        }                                //updates to the next node in the list using the getLink method.
        return current.getData();        //Once the node is determined by the loop, the getData method is used to return
    }                                    //the character at that node.

    public boolean myEquals(mystring a) {
        node current1 = head; //Variable pointing to the first node of the object called
        node current2 = a.head; //Variable pointing to the first node of the parameter
        while(current1 != null) { //Loop exists at end of node
            if(current1.getData() == current2.getData()) { //If the node for the called object is equal to the parameter
                current1 = current1.getLink();             //the loop will continue interating, checking for more
                current2 = current2.getLink();             //similar characters
            } else {
                return false;  //Returns false if all the nodes in the linked list are not the same
            }
        }
        return true; //Returns true if all the nodes in the linked list are the same.
    }
}

public class MyStr {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please input three sentences: ");
        mystring str1 = new mystring(in.nextLine());
        mystring str2 = new mystring(in.nextLine());
        mystring str3 = new mystring(in.nextLine());
        System.out.println("The length for these three sentences are " +
                str1.myLength() + ", " + str2.myLength() + ", " + str3.myLength());
        System.out.println("The second characters of these three sentences are: ");
        System.out.println(str1.myCharAt(1) + ", " + str2.myCharAt(1) + ", " +
                str3.myCharAt(1) + ". ");
        str1.myEquals(str2);
        if(str1.myEquals(str2))
            System.out.println("The first string and the second string are the same.");
        else
            System.out.println("The first string and the second string are different.");
    }
}