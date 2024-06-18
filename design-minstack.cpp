/*
 * Design-1 : Min Stack
 *
 * Problem 1:(https://leetcode.com/problems/min-stack/description/)
 *
 * Time Complexity  : Average case : O(1) 
 * Space Complexity : O(n), where n is the number of nodes.
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : -
 * Your code here along with comments explaining your approach :

 *      Optimal approach : Using linked list
 *          - Create a linked list whose node maintains a minimum value so that it returns this 
 *            value when asked for.
 */
#include<iostream>
#include<algorithm>

using namespace std;

class minStack {
    private:
        class Node {
            public:
                int data;
                int minimum;
                Node* next;

            Node(int data, int minimum, Node* next) : data(data), minimum(minimum), next(next) {};
        };

    Node* head;

    public:
    minStack() : head(nullptr) {};

    ~minStack() {
        while (head != nullptr) {
            Node* temp = head;
            head = head->next;
            delete temp;
        }
    }

    void push(int data) {
        int min_val = 0;

        if (head == nullptr) {
            min_val = data;
        } else {
            min_val = std::min(data, head->minimum);
        }

        Node* newNode = new Node(data, min_val, head);
        head = newNode;
    }

    void pop() {
        if(head != nullptr) {
            Node* temp = head;
            head = head->next;
            delete temp;
        }
    }

    int top() {
        if(head != nullptr) {
            return head->data;
        }
        return 0;
    }

    int getMin() {
        if(head != nullptr) {
            return head->minimum;
        }
        return 0;
    }

    void display() {
        Node* current = head;
        while(current != nullptr) {
            cout << current->data << " <- ";
            current = current->next;
        }
        if (current == nullptr) {
            cout << "HEAD ";
        }
    }
};

int main() {
    minStack stack;

    stack.push(2);
    stack.push(4);
    stack.push(6);
    stack.push(8);
    stack.push(9);
    stack.push(10);

    cout << "Before popping an element :" << endl;
    stack.display();
    cout << endl;
    cout << "Min: " << stack.getMin() << endl;
    cout << "Top: " << stack.top() << endl;

    stack.pop();
    cout << "\nAfter popping an element :" << endl;
    stack.display();
    cout << endl;
    cout << "Min: " << stack.getMin() << endl;
    cout << "Top: " << stack.top() << endl;
    return 0;
}

/*
 * Output :
    Before popping an element :
    10 <- 9 <- 8 <- 6 <- 4 <- 2 <- HEAD 
    Min: 2
    Top: 10

    After popping an element :
    9 <- 8 <- 6 <- 4 <- 2 <- HEAD 
    Min: 2
    Top: 9
 */