/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* p1 = NULL;
        ListNode* p2 = head;
        
        int sz = 1;
        while(p2 -> next != NULL){
            p2 = p2 -> next;
            sz++;
        };

        p2 = head;
        int ptr = 1;
        while((sz - ptr + 1) != n){
            p1 = p2;
            p2 = p2 -> next;
            ptr++;
        }
      
        if(p1 == NULL){
            if(p2 == NULL){
                return NULL;
            }
            p1 = p2 -> next;
            return p1;
        }
        p1 -> next = p2 -> next;
        delete p2;
        p2 = NULL;
        return head;
    }
};