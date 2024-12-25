// Time Complexity : O(1) addition (amortized)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Custom LinkedList implementation led to some difficulties initially


// Your code here along with comments explaining your approach
/*
  I created a hashtable which is a array of custom DoublyLinkedLists, used the modulo as a hash function,
  and after hashing for the index in the array, ran the relevant add/delete/search on the underlying list.
*/
class MyHashSet {

    class MyLinkedList {
        class ListNode {
            int val;
            ListNode next;
            ListNode prev;

            ListNode() {
            }
            
            ListNode(int val) {
                this.val = val;
            }
        }

        ListNode head;
        ListNode tail;

        MyLinkedList() {
            head = null;
            tail = null;
        }

        public void add(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
            tail.next = null;
        }

        public void remove(int val) {
            ListNode ptr = head;
                

            while (ptr != null) {
                if (ptr.val == val) {
                    break;
                }
                ptr = ptr.next;
            }
            if (ptr == null) return;
            if (head == ptr) {
                head = null;
                tail = null;
                return;
            }
            if (tail == ptr) {
                tail = ptr.prev;
            }
            if (ptr.prev != null) ptr.prev.next = ptr.next;
            if (ptr.next != null) ptr.next.prev = ptr.prev;
            ptr.prev = null;
            ptr.next = null;
        }

        public boolean search(int val) {
            ListNode ptr = head;
            while(ptr != null) {
                if (ptr.val == val) {
                    break;
                }
                ptr = ptr.next;
            }
            return ptr != null;
        }
    }

    private final int capacity = 100;
    MyLinkedList[] hashTable;


    public MyHashSet() {
        hashTable = new MyLinkedList[capacity];
    }
    
    public void add(int key) {
        int index = key % capacity;
        if (hashTable[index] == null) {
            hashTable[index] = new MyLinkedList();
        }
        if (this.contains(key)) return;
        hashTable[index].add(key);
    }
    
    public void remove(int key) {
        int index = key % capacity;
        if (hashTable[index] == null) {
            return; // do nothing
        }
        hashTable[index].remove(key);
    }
    
    public boolean contains(int key) {
        int index = key % capacity; 
        if (hashTable[index] == null) {
            return false;
        }
        return hashTable[index].search(key);
    }
}

