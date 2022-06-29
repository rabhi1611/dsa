// { Driver Code Starts
#include <bits/stdc++.h>

struct Node{
	int data;
	struct Node * next;
	struct Node * bottom;
	
	Node(int x){
	    data = x;
	    next = NULL;
	    bottom = NULL;
	}
	
};

using namespace std;

void printList(Node *Node)
{
    while (Node != NULL)
    {
        printf("%d ", Node->data);
        Node = Node->bottom;
    }
}

Node* flatten (Node* root);

int main(void) {

	int t;
	cin>>t;
	while(t--){
    int n,m,flag=1,flag1=1;
    struct Node * temp=NULL;
	struct Node * head=NULL;
	struct Node * pre=NULL;
	struct Node * tempB=NULL;
	struct Node * preB=NULL;
		cin>>n;
        int work[n];
		for(int i=0;i<n;i++)
            cin>>work[i];
		for(int i=0;i<n;i++){
			m=work[i];
			--m;
			int data;
			scanf("%d",&data);
			temp = new Node(data);
			temp->next = NULL;
			temp->bottom = NULL;
			
			if(flag){
				head = temp;
				pre = temp;
				flag = 0;
				flag1 = 1;
			}
			else{
				pre->next = temp;
				pre = temp;
				flag1 = 1;
			}
			for(int j=0;j<m;j++){
				
				int temp_data;
				scanf("%d",&temp_data);
				tempB = new Node(temp_data);

				if(flag1){
					temp->bottom=tempB;
					preB=tempB;
					flag1=0;
				}
				else{
					preB->bottom=tempB;
					preB=tempB;
				}
			}
		}
		   Node *fun = head;
		   Node *fun2=head;

            Node* root = flatten(head);
            printList(root);
            cout<<endl;

	}
	return 0;
}
// } Driver Code Ends


/* Node structure  used in the program

struct Node{
	int data;
	struct Node * next;
	struct Node * bottom;
	
	Node(int x){
	    data = x;
	    next = NULL;
	    bottom = NULL;
	}
	
};
*/

/*  Function which returns the  root of 
    the flattened linked list. */
Node *flatten(Node *root)
{
   // Your code here
   if(root == NULL){
       return root;
   }
   
   if(root -> next == NULL){
       return root;
   }
   
   Node* small_ans = flatten(root -> next);
   
   root -> next = NULL;
   
   if(small_ans == NULL){
       return root;
   }
   
   Node* temp = root;
   Node* pre = NULL;
   
   Node* temp2 = small_ans;
   Node* pre2 = NULL;
   
   //cout<<small_ans -> data<<endl;
   
           while(temp != NULL && temp2 != NULL){
                
                   while(temp != NULL && temp -> data <= temp2 -> data){
                       pre = temp;
                       temp = temp -> bottom;
                   }
                   
                   if(temp == NULL){
                       pre -> bottom = temp2;
                  //     root -> next = NULL;
                       break;
                   }
                   
                   if(pre != NULL)
                        pre -> bottom = temp2;
                   //pre -> next = NULL;
                   
                   while(temp2 != NULL && temp2 -> data <= temp -> data){
                       pre2 = temp2;
                       temp2 = temp2 -> bottom;
                   }
                   
                   if(temp2 == NULL){
                       pre2 -> bottom = temp;
                //       root -> next = NULL;
                       break;
                   }
                   if(pre2 != NULL)
                        pre2 -> bottom = temp;
                
               //pre2 -> next = NULL;
           }
           
           if(temp == NULL){
              pre -> bottom = temp2;
              //root -> next = NULL;
           }
           
           if(temp2 == NULL){
              pre2 -> bottom = temp;
           }
           //root -> next = NULL;
           
           if(root -> data > small_ans -> data){
               return small_ans;
           }
           return root;
}

