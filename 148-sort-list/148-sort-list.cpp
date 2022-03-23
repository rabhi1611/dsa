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
    ListNode* sortList(ListNode* head) {
        ListNode* temp = head;
        vector<int>list;
        while(temp != NULL){
            list.push_back(temp->val);
            temp = temp -> next;
        }
        sort(list.begin(), list.end());
        temp = head;
        for(auto x: list){
            temp -> val = x;
            temp = temp -> next;
        }
        return head;
    }
};