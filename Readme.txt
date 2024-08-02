Name: Vanessa Achaibar
Email: vda59962@uga.edu

To run please type the following in the terminal 
chmod +x assignment2.sh
./assignment2.sh   

Pseudo code (steps) for deleteSubsection operation: 
    1. Check if list is empty.
        a. if it is, print "list is empty" and return.
    2. Initialize pointers 'current' and 'prev' to traverse list.
    3. Initialize boolean variable 'deleted' to false.
    4. Interate over list until 'current' reaches node with data greater than or equal to 'lowerBound'
        a. Update 'prev' to 'current'
        b. Move 'current' to next node.
    5. Interate over list until 'current' reaches node with data greater than 'upperBound'.
        a. Get 'nextNode'.
        b. If 'prev' is null 
            a. Update head to 'nextNode'
        c. Otherwise, update 'prev.next' to 'nextNode'.
        d. If 'nextNode' is not null, update 'nextNode.prev' to 'prev'.
        e. Set 'deleted' to true.
        f. Move 'current' to 'nextNode'.
    6. If 'deleted' is true.
        a. Print empty string.
    7. Otherwise, print nothing. 
Complexity (big O) of deleteSubsection operation: O(n)

Pseudo code (steps) for reverseList operation:
    1. Initialize pointer 'current' to head of list.
    2. Initialize temp pointer 'temp' to null.
    3. Interate over list:  
        a. Set 'temp' to previous node 'current'.
        b. Swap 'current.prev' and 'current.next'.
        c. Move 'current' to previous node.
    4. After loop, check if 'temp' is not null.
        a. if it is, update head pointer to point to previous node 'temp'.
Complexity (big O) of reverseList operation: O(n)

Pseudo code (steps) for swapAlt operation:
1. Initialize pointer 'current' to head of tail.
    2. Initialize temp variable 'temp' to hold data during swapping.
    3. While 'current' and 'current.next' are not null:
        a. store data of 'current' in 'temp'.
        b. assign data of 'current.next' to 'current.data'
        c. assign data stored in 'temp' to 'current.next.data'
        d. Move 'current' to next node skipping one node. 
Complexity (big O) of swapAlt operation: O(n) 