/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *head1, ListNode *head2) {
        
        int l1 = 0;
        
        ListNode* temp1 = head1;
        
        while(temp1 != NULL){
            l1++;
            temp1 = temp1 -> next;
        }
        
        int l2 = 0;
        
        ListNode* temp2 = head2;
        
        while(temp2 != NULL){
            l2++;
            temp2 = temp2 -> next;
        }
        
        int diff = abs(l1 - l2);
        //cout<<diff<<" ";
        if(l1 >= l2){
            temp1 = head1;
            while(diff--){
                temp1 = temp1 -> next;
            }
            temp2 = head2;
            //cout<<temp1->data<<" "<<temp2->data;
            while(temp1 != NULL && temp2 != NULL){
                if(temp1 == temp2){
                    return temp1;
                }
                temp1 = temp1 -> next;
                temp2 = temp2 -> next;
            }
            return NULL;
        }
        else{
            temp2 = head2;
            while(diff--){
                temp2 = temp2 -> next;
            }
            temp1 = head1;
            while(temp1 != NULL && temp2 != NULL){
                if(temp1 == temp2){
                    return temp1;
                }
                temp1 = temp1 -> next;
                temp2 = temp2 -> next;
            }
            return NULL;
        }
    }
};