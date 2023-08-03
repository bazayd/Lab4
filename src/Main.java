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




        System.out.println("In Order : ");
        binarySearchTree.InOrderTraversal(binarySearchTree.root);
        System.out.println("Pre Order: ");
        binarySearchTree.PreorderTraversal(binarySearchTree.root);
        System.out.println("Post Order: ");
        binarySearchTree.PostorderTraversal(binarySearchTree.root);


    }
}