import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Driver class for DoublyLinkedList
public class DoublyLinkedListDriver {
    public static void main(String[] args) {
        String inputType;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter list type (i - int, d - double, s - string): ");
        inputType = keyboard.next();

        DoublyLinkedList<? extends Comparable<?>> doublyList = null;

        String inputFile;
        switch (inputType) {
            case "i":
                doublyList = new DoublyLinkedList<Integer>();
                inputFile = "int-input.txt";
                break;
            case "d":
                doublyList = new DoublyLinkedList<Double>();
                inputFile = "double-input.txt";
                break;
            case "s":
                doublyList = new DoublyLinkedList<String>();
                inputFile = "string-input.txt";
                break;
            default:
                System.out.println("Invalid input type. Choose i (int), d (double), or s (string).");
                keyboard.close();
                return;
        }

        try (Scanner fileScanner = new Scanner(new File(inputFile))) {
            if (inputType.equals("i")) {
                while (fileScanner.hasNext()) {
                    String value = fileScanner.next();
                    doublyList.insertItem(Integer.parseInt(value));
                }
            } else if (inputType.equals("d")) {
                while (fileScanner.hasNextDouble()) {
                    double value = fileScanner.nextDouble();
                    doublyList.insertItem(value);
                }
            } else if (inputType.equals("s")) {
                while (fileScanner.hasNext()) {
                    String value = fileScanner.next();
                    doublyList.insertItem(value);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
            keyboard.close();
            return;
        }

        System.out.println("Commands:\n" +
                "(i) - Insert value\n" +
                "(d) - Delete value\n" +
                "(p) - Print list\n" +
                "(l) - Length\n" +
                "(t) - Print reverse\n" +
                "(r) - Reverse list\n" +
                "(b) - Delete Subsection\n" +
                "(s) - Swap Alternate\n" +
                "(q) - Quit program");

        char command;
        do {
            System.out.print("Enter a command: ");
            command = keyboard.next().charAt(0);

            switch (command) {
                case 'p':
                    System.out.print("The list is: ");
                    doublyList.print();
                    break;
                case 'l':
                    System.out.println("The length of the list is " + doublyList.length());
                    break;
                    case 'i':
                    System.out.print("The list is: ");
                    doublyList.print();
                    System.out.print("Enter a value to insert: ");
                    if (inputType.equals("i")) {
                        int valToInsertInt = keyboard.nextInt();
                        if (doublyList.searchItem(valToInsertInt)) {
                            System.out.println("Item already exists.");
                        } else {
                            doublyList.insertItem(valToInsertInt);
                        }
                    } else if (inputType.equals("d")) {
                        double valToInsertDouble = keyboard.nextDouble();
                        if (doublyList.searchItem(valToInsertDouble)) {
                            System.out.println("Item already exists.");
                        } else {
                            doublyList.insertItem(valToInsertDouble);
                        }
                    } else if (inputType.equals("s")) {
                        String valToInsertString = keyboard.next();
                        if (doublyList.searchItem(valToInsertString)) {
                            System.out.println("Item already exists.");
                        } else {
                            doublyList.insertItem(valToInsertString);
                        }
                    }
                    System.out.print("The list is: ");
                    doublyList.print();
                    System.out.print("The reverse list is: ");
                    doublyList.printReverse();
                    break;
                case 'd':
                    System.out.print("Enter a value to delete: ");
                    if (inputType.equals("i")) {
                        int valToDeleteInt = keyboard.nextInt();
                        doublyList.deleteItem(valToDeleteInt);
                    } else if (inputType.equals("d")) {
                        double valToDeleteDouble = keyboard.nextDouble();
                        doublyList.deleteItem(valToDeleteDouble);
                    } else if (inputType.equals("s")) {
                        String valToDeleteString = keyboard.next();
                        doublyList.deleteItem(valToDeleteString);
                    }
                    System.out.print("The list is: ");
                    doublyList.print();
                    break;
                
                case 't':
                    //doublyList.reverseList();
                    System.out.print("The reverse list is: ");
                    doublyList.printReverse();
                    break;
                case 'r':
                    System.out.print("The original list: ");
                    doublyList.print();
                    System.out.print("The reversed list: ");
                    doublyList.printReverse();
                    break;
                case 'b':
                    System.out.print("Enter lower bound: ");
                    int lower = keyboard.nextInt();
                    System.out.print("Enter upper bound: ");
                    int upper = keyboard.nextInt();
                    System.out.print("The original list: ");
                    doublyList.print();
                    doublyList.deleteSubsection(lower, upper);
                    System.out.print("The modified list: ");
                    doublyList.print();
                    System.out.print("The reverse list: ");
                    doublyList.printReverse();
                    break;
                case 's':
                    System.out.print("The original list: ");
                    doublyList.print();
                    doublyList.swapAlternate();
                    System.out.print("The modified list: ");
                    doublyList.print();
                    System.out.print("The reverse list: ");
                    doublyList.printReverse();
                    break;
            }
        } while (command != 'q');
        System.out.println("Exiting the program...");

        keyboard.close();
    }
}
