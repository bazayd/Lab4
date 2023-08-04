import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BSTSearchTree binarySearchTree = new BSTSearchTree();
        
        Dollar[] dollars = {
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

        for (Dollar dollar: dollars) {
            binarySearchTree.insert(dollar);
        }
        
        System.out.println("BreadthFirst: ");
        binarySearchTree.BreadthFirstTraversal(binarySearchTree.root);
        
        
        boolean quit = false;


        while (!quit) {
            System.out.println("\nChoose your option: ");
            System.out.println("(1) Add Node");
            System.out.println("(2) Delete Node");
            System.out.println("(3) Search for Node");
            System.out.println("(4) Print Traversals to TXT File");
            System.out.println("(5) Quit");

//<<<<<<< HEAD
        
//        System.out.println("In Order : ");
//        binarySearchTree.InOrderTraversal(binarySearchTree.root);
//        System.out.println("Pre Order: ");
//        binarySearchTree.PreorderTraversal(binarySearchTree.root);
//        System.out.println("Post Order: ");
//        binarySearchTree.PostorderTraversal(binarySearchTree.root);
//=======
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    binarySearchTree.delete(new Dollar(amountRemove));
                    System.out.println("Node $" + amountRemove + " Removed from Binary Tree");
                    break;
                case 3:
                    System.out.println("Enter dollar amount to search for: ");
                    double amountSearch = scanner.nextDouble();
                    scanner.nextLine();
                    binarySearchTree.search(new Dollar(amountSearch));
                    break;
                case 4:
                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {
                        System.out.println("Breadth-first traversal: ");
                        bufferedWriter.write("Breadth-first Traversal: ");
                        binarySearchTree.BreadthFirstTraversal(binarySearchTree.root);
                        System.out.println("\nIn Order Traversal: ");
                        bufferedWriter.write("\nIn Order Traversal: ");
                        binarySearchTree.InOrderTraversal(binarySearchTree.root);
                        System.out.println("\nPre Order Traversal: ");
                        bufferedWriter.write("\nPre Order Traversal");
                        binarySearchTree.PreorderTraversal(binarySearchTree.root);
                        System.out.println("\nPost Order Traversal: ");
                        bufferedWriter.write("\nPost Order Traversal: ");
                        binarySearchTree.PostorderTraversal(binarySearchTree.root);
                    } catch (IOException e) {
                        System.out.println("Error writing to TXT file.");
                        e.printStackTrace();
                    }
                case 5:
                    quit = true;
            }
        }

//        System.out.println("In Order : ");
//        binarySearchTree.InOrderTraversal(binarySearchTree.root);
//        System.out.println("Pre Order: ");
//        binarySearchTree.PreorderTraversal(binarySearchTree.root);
//        System.out.println("Post Order: ");
//        binarySearchTree.PostorderTraversal(binarySearchTree.root);

//
    }
}