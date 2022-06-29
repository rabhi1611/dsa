// { Driver Code Starts
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <stack>
using namespace std;
/* Link list Node */
struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};




 // } Driver Code Ends
/*
struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};
*/

class Solution{
    
  public:
  
  Node * rev(Node * head){
        
        if(head == NULL || head -> next == NULL){
            return head;
        }
        
        Node* short_ans = rev(head -> next);
        
        Node* temp = short_ans;
        
        while(temp -> next != NULL){
            temp = temp -> next;
        }
        
        temp -> next = head;
        head -> next = NULL;
        
        return short_ans;
    }
    
    //Function to check whether the list is palindrome.
    bool isPalindrome(Node *head)
    {
        //Your code here
        
        // find midddle
        Node * slow = head;
        Node * fast = head;
        
        while((fast -> next != NULL) && (fast -> next -> next != NULL)){
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        
        // slow is the middle
        // reverse (middle -> next);
        
        Node* n_l = rev(slow -> next);
        
        slow = n_l;
        Node* dum = head;
        
        while(slow != NULL){
        //    cout<<dum -> data <<" "<< slow -> data<<endl;
            if(dum -> data != slow -> data){
                return false;
            }
            dum = dum -> next;
            slow = slow -> next;
        }
        
        return true;
    }
};



// { Driver Code Starts.
/* Driver program to test above function*/
int main()
{
  int T,i,n,l,firstdata;
    cin>>T;
    while(T--)
    {
        
        struct Node *head = NULL,  *tail = NULL;
        cin>>n;
        // taking first data of LL
        cin>>firstdata;
        head = new Node(firstdata);
        tail = head;
        // taking remaining data of LL
        for(i=1;i<n;i++)
        {
            cin>>l;
            tail->next = new Node(l);
            tail = tail->next;
        }
    Solution obj;
   	cout<<obj.isPalindrome(head)<<endl;
    }
    return 0;
}

  // } Driver Code Ends