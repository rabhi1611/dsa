/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head==NULL){
            return NULL;
        }
        map<Node*,Node*>m;
        Node* temp=head;
        Node* h=new Node(temp->val);
        Node* t=h;
        m[temp]=t;
        while(temp->next!=NULL){
            t->next=new Node(temp->next->val);
            t=t->next;
            temp=temp->next;
            m[temp]=t;
        }
        temp=head;
        t=h;
        while(temp!=NULL){
            t->random=m[temp->random];
            temp=temp->next;
            t=t->next;
        }
        return h;
    }
};