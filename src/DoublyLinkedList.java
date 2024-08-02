// Purpose: Implement a doubly linked list with the following methods:
public class DoublyLinkedList<T extends Comparable<T>> {
    private NodeType<T> head;

    // Constructor
    public DoublyLinkedList() {
        head = null;
    }

    // Inner class for the node type
    private static class NodeType<T> {
        private T data;
        private NodeType<T> next;
        private NodeType<T> prev;

        // Constructor
        public NodeType(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        // Compare the data in the node with the value to insert
        public boolean compareTo(int valToInsert) {
            return this.data.equals(valToInsert);
        }

        // Compare the data in the node with the value to insert
        public boolean compareTo(T valToInsert) {
            return this.data.equals(valToInsert);
        }
    }

    // Insert an item in the list
    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<>(item);
        
        if (head == null) {
            head = newNode;
            return;
        }
        NodeType<T> current = head;

        while (current.next != null && compare(current.data, item) < 0) {
            current = current.next;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    // Compare two items
    private int compare(T item, T data) {
        return item.compareTo(data);
    }

    // Delete an item from the list
    public void deleteItem(String valToDelete) {
        if (head == null) {
            System.out.println("You cannot delete from an empty list.");
            return;
        }
        if (head.data.equals(valToDelete)) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }
        NodeType<T> current = head;
        while (current != null && !current.data.equals(valToDelete)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("The item is not present in the list");
            return;
        }
        if (current.next != null) current.next.prev = current.prev;
        current.prev.next = current.next;
    }

    // lenght of the list
    public int length() {
        int count = 0;
        NodeType<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Print the list
    public void print() {
        NodeType<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print the list in reverse
    public void printReverse() {
        if (head == null) return;
        NodeType<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }


    // Pseudo code and complexity explanation should be provided in the README file
    // Delete a subsection of the list
    public void deleteSubsection(T lowerBound, T upperBound) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        NodeType<T> current = head;
        NodeType<T> prev = null;
        boolean deleted = false;

        while (current != null && current.data.compareTo(lowerBound) < 0) {
            prev = current;
            current = current.next;
        }
        
        while (current != null && current.data.compareTo(upperBound) <= 0) {
            NodeType<T> nextNode = current.next;
            if (prev == null) {
                head = nextNode;
            } else {
                prev.next = nextNode;
            }
            if (nextNode != null) {
                nextNode.prev = prev;
            }
            deleted = true;
            current = nextNode;
        }

        if (deleted) {
            System.out.print("");
        } else {
        System.out.println(" ");
        }
    }

    // Pseudo code and complexity explanation should be provided in the README file
    // Reverse the list
    public void reverseList() {
        NodeType<T> current = head;
        NodeType<T> temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    // Pseudo code and complexity explanation should be provided in the README file
    // Swap alternate elements
    public void swapAlternate() {
        NodeType<T> current = head;
        T temp = null;

        while (current != null && current.next != null) {
            temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
    }

    // Delete an item from the list
    public void deleteItem(int valToDelete) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data.equals(valToDelete)) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }
        NodeType<T> current = head;
        while (current != null && !current.data.equals(valToDelete)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Item not found in the list.");
            return;
        }
        if (current.next != null) current.next.prev = current.prev;
        current.prev.next = current.next;
    }

    // Search for an item in the list
    public boolean searchItem(int valToInsert) {
        NodeType<T> current = head;
        while (current != null) {
            if (current.compareTo(valToInsert)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Insert an item in the list
    @SuppressWarnings("unchecked")
    public void insertItem(double item) {
        insertItem((T) Double.valueOf(item));
    }
    

    // Delete a subsection of the list
    public void deleteSubsection(int lower, int upper) {
        @SuppressWarnings("unchecked")
        T lowerBound = (T) Integer.valueOf(lower);
        @SuppressWarnings("unchecked")
        T upperBound = (T) Integer.valueOf(upper);
        deleteSubsection(lowerBound, upperBound);
    }

    // Search for an item in the list
    public void insertItem(String value) {
        @SuppressWarnings("unchecked")
        T item = (T) value;
        insertItem(item);
    }

    // Delete an item from the list
    public boolean searchItem(double valToInsertDouble) {
        @SuppressWarnings("unchecked")
        T valToInsert = (T) Double.valueOf(valToInsertDouble);
        return searchItem(valToInsert);
    }

    // Search for an item in the list
    private boolean searchItem(T valToInsert) {
        NodeType<T> current = head;
        while (current != null) {
            if (current.compareTo(valToInsert)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Delete a subsection of the list
	public boolean searchItem(String valToInsertString) {
        @SuppressWarnings("unchecked")
        T valToInsert = (T) valToInsertString;
        return searchItem(valToInsert);
	}

    // Delete an item from the list
    public void deleteItem(double valToDeleteDouble) {
        @SuppressWarnings("unchecked")
        T valToDelete = (T) Double.valueOf(valToDeleteDouble);
        deleteItem(valToDelete);
    }

    // Delete a subsection of the list
    private void deleteItem(T valToDelete) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data.equals(valToDelete)) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }
        NodeType<T> current = head;
        while (current != null && !current.data.equals(valToDelete)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Item not found in the list.");
            return;
        }
        if (current.next != null) current.next.prev = current.prev;
        current.prev.next = current.next;
    }
}