/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

class Solution {
public:
    Node* flatten(Node* head) {
        if(head == NULL){
            return head;
        }
        
        if(head -> next == NULL && head -> child == NULL){
            return head;
        }
        
        Node* small_ans1 = flatten(head -> next);
        
        if(head -> child != NULL){
            Node* small_ans2 = flatten(head -> child);
            Node* temp = small_ans2;
            while(temp -> next != NULL){
                temp = temp -> next;
            }
            if(small_ans1 != NULL){
                temp -> next = small_ans1;
                small_ans1 -> prev = temp;
            }
            head -> child = NULL;
            small_ans2 -> prev = NULL;
            head -> next = small_ans2;
            small_ans2 -> prev = head;
        }
        return head;
    }
};