// { Driver Code Starts
// driver

#include <bits/stdc++.h>
using namespace std;

/* Linked list Node */
struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

struct Node* buildList(int size)
{
    int val;
    cin>> val;
    
    Node* head = new Node(val);
    Node* tail = head;
    
    for(int i=0; i<size-1; i++)
    {
        cin>> val;
        tail->next = new Node(val);
        tail = tail->next;
    }
    
    return head;
}

void printList(Node* n)
{
    while(n)
    {
        cout<< n->data << " ";
        n = n->next;
    }
    cout<< endl;
}


 // } Driver Code Ends
/* node for linked list:

struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/

class Solution
{
    public:
    //Function to add two numbers represented by linked list.
    
    struct Node* addTwoLists(struct Node* first, struct Node* second)
    {
        // code here
        if(first != NULL && first -> next != NULL){
            Node* dm = NULL;
            Node* temp = first;
            
            while(temp != NULL){
                first = first -> next;
                temp -> next = dm;
                dm = temp;
                temp = first;
            }
            first = dm;
        }
        
        if(second != NULL && second -> next != NULL){
            Node* dm = NULL;
            Node* temp = second;
            
            while(temp != NULL){
                second = second -> next;
                temp -> next = dm;
                dm = temp;
                temp = second;
            }
            second = dm;
        }
        
        // dono reverse ho gya!
        
        int carry = 0;
        
        Node* res = new Node(-1);
        Node* ans = res;
        
        while(first != NULL && second != NULL){
            int sum = (first -> data + second -> data + carry);
            carry = 0;
            int node = sum % 10;
            carry = sum / 10;
            res -> next = new Node(node);
            res = res -> next;
            first = first -> next;
            second = second -> next;
        }
        
        while(first != NULL){
            int sum = first -> data + carry;
            carry = 0;
            int node = sum % 10;
            carry = sum / 10;
            res -> next = new Node(node);
            res = res -> next;
            first = first -> next;
        }
        
        
        while(second != NULL){
            int sum = second -> data + carry;
            carry = 0;
            int node = sum % 10;
            carry = sum / 10;
            res -> next = new Node(node);
            res = res -> next;
            second = second -> next;
        }
        
        if(carry){
            res -> next = new Node(carry);
            res = res -> next;
        }
        
        ans = ans -> next;
        Node* dm = NULL;
        
        if(ans != NULL && ans -> next != NULL){
            Node* dm = NULL;
            Node* temp = ans;
            
            while(temp != NULL){
                ans = ans -> next;
                temp -> next = dm;
                dm = temp;
                temp = ans;
            }
            ans = dm;
        }
        return ans;
        
        //return first;
    }
};


// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n, m;
        
        cin>>n;
        Node* first = buildList(n);
        
        cin>>m;
        Node* second = buildList(m);
        Solution ob;
        Node* res = ob.addTwoLists(first,second);
        printList(res);
    }
    return 0;
}
  // } Driver Code Ends