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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int n1 = 0;
        ListNode* t = l1;
        while(t != NULL){
            n1++;
            t = t->next;
        }
        
        int n2 = 0;
        t = l2;
        while(t != NULL){
            n2++;
            t = t->next;
        }
        
        int arr1[101] = {};
        t = l1;
        int i1 = 0;
        while(i1 < n1){
            arr1[i1] = t->val;
            i1++;
            t = t -> next;
        }
        
        int arr2[101] = {};
        t = l2;
        int i2 = 0;
        while(i2 < n2){
            arr2[i2] = t->val;
            i2++;
            t = t -> next;
        }
        
        i1 = n1 - 1;
        i2 = n2 - 1;
        ListNode* ans = NULL;
        int carry = 0;
        while(i1 >= 0 && i2 >= 0){
            ListNode* temp = new ListNode((arr1[i1] + arr2[i2] + carry) % 10);
            temp->next = ans;
            carry = (arr1[i1] + arr2[i2] + carry) / 10;
            i1--;
            i2--;
            ans = temp;
        }
        while(i1 >= 0){
            ListNode* temp = new ListNode((arr1[i1] + carry) % 10);
            temp->next = ans;
            carry = (arr1[i1] + carry) / 10;
            i1--;
            ans = temp;
        }
        
        while(i2 >= 0){
            ListNode* temp = new ListNode((arr2[i2] + carry) % 10);
            temp->next = ans;
            carry = (arr2[i2] + carry) / 10;
            i2--;
            ans = temp;
        }
        //cout<<carry;
        if(carry > 0){
            ListNode* temp = new ListNode(carry % 10);
            temp->next = ans;
            carry = carry / 10;
            ans = temp;
        }
        return ans;
    }
};