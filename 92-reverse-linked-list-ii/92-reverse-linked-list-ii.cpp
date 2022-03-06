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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        int l = 1;
        int r = 1;
        
        ListNode* temp1 = head;
        
        while(l != left){
            temp1 = temp1 -> next;
            l++;
        }
        //cout<<l<<"-> ";
        //cout<<temp1->val<<endl;
        ListNode* temp2 = temp1;
        r = l;
        
        stack<ListNode*>st;
        while(r != right){
            //cout<<temp2->val<<" ";
            st.push(temp2);
            temp2 = temp2 -> next;
            r++;
        }
        //cout<<st.size()<<endl;
        //if(st.size() != 0)
          //  st.pop();
        //cout<<temp2->val<<endl;
        //while(!st.empty()){
          //  cout<<st.top()->val<<" ";
            //st.pop();
        //}
        while(l < r){
            swap(temp2->val, temp1->val);
            temp1 = temp1 -> next;
            temp2 = st.top();
            st.pop();
            l++;
            r--;
        }
        return head;
    }
};