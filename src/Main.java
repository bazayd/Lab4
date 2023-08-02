import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BSTSearchTree binarySearchTree = new BSTSearchTree();

        binarySearchTree.insert(new Dollar(57.12)); // Root
        binarySearchTree.insert(new Dollar(23.44)); // Left Child
        binarySearchTree.insert(new Dollar(87.43)); // Right Child





        binarySearchTree.InOrderTraversal(binarySearchTree.root);


    }
}