import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 * Authors: Nicholas Kang, Brandon Arriaga
 * Group 10 JAVA
 *
 * Lab 4
 *
 * Purpose: Creates a currencies array with dollar objects to seed a Binary Search tree along with
 * having user input, for the user to insert, remove, and search for dollar amounts. As well as
 * writing traversals of the tree to a text file and printing out those traversals to see them in action.
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {

    	//scanner and bst
        Scanner scanner = new Scanner(System.in);
        BSTSearchTree binarySearchTree = new BSTSearchTree();


        //currencies array
        Currency[] currencies = {
                new Dollar(57.12),
                new Dollar(23.44),
                new Dollar(87.43),
                new Dollar(68.99),
                new Dollar(111.22),
                new Dollar(44.55),
                new Dollar(77.77),
                new Dollar(18.36),
                new Dollar(543.21),
                new Dollar(20.21),
                new Dollar(345.67),
                new Dollar(36.18),
                new Dollar(48.48),
                new Dollar(101.00),
                new Dollar(11.00),
                new Dollar(21.00),
                new Dollar(51.00),
                new Dollar(1.00),
                new Dollar(251.00),
                new Dollar(151.00)
        };



        // insert currency data into the bst
        for (Currency dollar : currencies) {
            binarySearchTree.insert(dollar);
        }


        boolean quit = false;


        while (!quit) {
            System.out.println("\nChoose your option: ");
            System.out.println("(1) Add Node");
            System.out.println("(2) Delete Node");
            System.out.println("(3) Search for Node");
            System.out.println("(4) Print Traversals to TXT File");
            System.out.println("(5) Print out Traversals");
            System.out.println("(6) Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            //switch statement for the different choices
            switch (choice) {
                case 1:
                    System.out.println("Enter dollar amount for new node: ");
                    double amountInsert = scanner.nextDouble();
                    scanner.nextLine();
                    binarySearchTree.insert(new Dollar(amountInsert));
                    System.out.println("Node $" + amountInsert + " Added to Binary Tree");
                    break;
                case 2:
                    System.out.println("Enter dollar amount to remove: ");
                    double amountRemove = scanner.nextDouble();
                    scanner.nextLine();
                    if (binarySearchTree.search(new Dollar(amountRemove))) {
                        System.out.println("$" + amountRemove + " Removed.");
                        binarySearchTree.delete(new Dollar(amountRemove));
                    }else {
                        System.out.println("Dollar amount not found!");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter dollar amount to search for: ");
                    double amountSearch = scanner.nextDouble();
                    scanner.nextLine();
                    if (binarySearchTree.search(new Dollar(amountSearch))) {
                        System.out.println("$" + amountSearch + " Found!");
                    }else {
                        System.out.println("$" + amountSearch + " Not found.");
                    }
                    break;
                case 4:
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                        System.out.println("Breadth-first traversal being written.. ");
                        writer.write("Breadth First Traversal: ");
                        binarySearchTree.breadthFirstTraversalWriter(writer);
                        System.out.println("\nIn Order Traversal being written... ");
                        writer.write("\nIn Order Traversal: ");
                        binarySearchTree.inOrderTraversalWriter(writer, binarySearchTree.root);
                        System.out.println("\nPre Order Traversal being written.. ");
                        writer.write("\nPre Order Traversal");
                        binarySearchTree.preOrderTraversalWriter(writer, binarySearchTree.root);
                        System.out.println("\nPost Order Traversal being written..4 ");
                        writer.write("\nPost Order Traversal: ");
                        binarySearchTree.postOrderTraversalWriter(writer, binarySearchTree.root);
                        writer.flush();
                        writer.close();
                        System.out.println("All traversals written to txt file.");
                        break;
                    } catch (IOException e) {
                        System.out.println("Error writing to TXT file.");
                        e.printStackTrace();
                    }
                case 5:
                    System.out.println("Which traversal would you like to see: " +
                            "\n(1) Breadth-First Traversal" +
                            "\n(2) In Order Traversal" +
                            "\n(3) Pre Order Traversal" +
                            "\n(4) Post Order Traversal" +
                            "\n(5) Print all Traversals");
                    int traversalChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (traversalChoice) {
                        case 1:
                            System.out.println("BreadthFirst: ");
                            binarySearchTree.BreadthFirstTraversal(binarySearchTree.root);
                            break;
                        case 2:
                            System.out.println("In Order : ");
                            binarySearchTree.InOrderTraversal(binarySearchTree.root);
                            break;
                        case 3:
                            System.out.println("Pre Order: ");
                            binarySearchTree.PreorderTraversal(binarySearchTree.root);
                            break;
                        case 4:
                            System.out.println("Post Order: ");
                            binarySearchTree.PostorderTraversal(binarySearchTree.root);
                            break;
                        case 5:
                            System.out.println("All traversals: ");
                            System.out.println("BreadthFirst Traversals: ");
                            binarySearchTree.BreadthFirstTraversal(binarySearchTree.root);
                            System.out.println("In Order Traversal: ");
                            binarySearchTree.InOrderTraversal(binarySearchTree.root);
                            System.out.println("Pre Order Traversal: ");
                            binarySearchTree.PreorderTraversal(binarySearchTree.root);
                            System.out.println("Post Order Traversal: ");
                            binarySearchTree.PostorderTraversal(binarySearchTree.root);
                            break;
                    }
                    break;
                case 6:
                    quit = true;
            }
        }
        System.out.println("Exiting Program...");
        scanner.close();
    }
    
}