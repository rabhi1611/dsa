// { Driver Code Starts
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};


 // } Driver Code Ends
/* Structure of the linked list node is as
struct Node 
{
    int data;
    struct Node* next;
    Node(int x) { data = x;  next = NULL; }
};
*/

class Solution{
  public:
    //Function to sort the given linked list using Merge Sort.
    
    
    Node* find_mid(Node* head){
        Node* slow = head;
        Node* fast = head -> next;
        
        while(fast != NULL){
            fast = fast -> next;
            if(fast != NULL){
                fast = fast -> next;
                slow = slow -> next;
            }
        }
        return slow;
    } 
    
    Node* merge(Node* head1, Node* head2){
        
        Node* temp = new Node(0);
        Node* ans = temp;
        
        Node* temp1 = head1;
        Node* temp2 = head2;
        
        while(temp1 != NULL && temp2 != NULL){
            if(temp1 -> data <= temp2 -> data){
                temp -> next = temp1;
                temp = temp -> next;
                temp1 = temp1 -> next;
            }else{
                temp -> next = temp2;
                temp = temp -> next;
                temp2 = temp2 -> next;
            }
        }
        
        while(temp1 != NULL){
            temp -> next = temp1;
            temp = temp -> next;
            temp1 = temp1 -> next;
        }
        
        while(temp2 != NULL){
            temp -> next = temp2;
            temp = temp -> next;
            temp2 = temp2 -> next;
        }
        
        return ans -> next;
        
    }
    
    Node* mergeSort(Node* head) {
        // your code here
        
        if(head == NULL || head -> next == NULL){
            return head;
        }
        
        Node* ll1, *ll2;
        
        ll1 = head;
        
        Node* mid = find_mid(head);
        
        ll2 = mid -> next;
        mid -> next = NULL;
        
        ll1 = mergeSort(ll1);
        ll2 = mergeSort(ll2);
        
        return merge(ll1, ll2);
    }
};


// { Driver Code Starts.

void printList(Node* node) {
    while (node != NULL) {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
}

void push(struct Node** head_ref, int new_data) {
    Node* new_node = new Node(new_data);

    new_node->next = (*head_ref);
    (*head_ref) = new_node;
}

int main() {
    long test;
    cin >> test;
    while (test--) {
        struct Node* a = NULL;
        long n, tmp;
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> tmp;
            push(&a, tmp);
        }
        Solution obj;
        a = obj.mergeSort(a);
        printList(a);
    }
    return 0;
}  // } Driver Code Ends