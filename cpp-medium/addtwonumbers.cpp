#include <iostream>
#include <vector>
#include <string>

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class AddTwoNumbers
{
public:
    static ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        ListNode *head = nullptr, *prev = nullptr;
        int carry = 0;
        while (l1 || l2)
        {
            // check if the listnode is null or not, if not take the integer other wise use 0 for padding
            int v1 = l1 ? l1->val : 0;
            int v2 = l2 ? l2->val : 0;
            // get the sum of the 2 number AND THE CARRY OVER
            int tmp = v1 + v2 + carry;
            // find the new carry 
            carry = tmp / 10;
            // find digit when over 10
            int val = tmp % 10;
            // create a new node with val
            ListNode *cur = new ListNode(val);
            // if head is NULL set head to new node with digit because this will first node in linkedlist
            if (!head)
                head = cur;
            // if prev is NOT NULL then set prev->next to curr
            if (prev)
                prev->next = cur;
            // 
            prev = cur;
            l1 = l1 ? l1->next : NULL;
            l2 = l2 ? l2->next : NULL;
        }
        // final case if there is still a carry left after both lists are exhausted then add one more node
        if (carry > 0)
        {
            ListNode *l = new ListNode(carry);
            prev->next = l;
        }
        return head;
    }

    static ListNode* addTwoNumbersV2(ListNode* l1, ListNode* l2) {
        ListNode* head = nullptr;
        ListNode* prev = nullptr;
        int carry = 0;
        while (l1 || l2) {
            int v1 = l1 ? l1->val : 0;
            int v2 = l2 ? l2->val : 0;
            int sum = v1 + v2 + carry;
            int remainder = sum % 10;
            carry = sum / 10;
            
            ListNode* curr = new ListNode(remainder);
            if (!head) {
                head = curr;
            }
            if (!prev) {
                prev = curr;
            } else {
                prev->next = curr;
            }
            prev = curr;
            // SHOULD NEVER CALL l1->next as condition because it might be NULL->NULL this is undefined
            l1 = l1 ? l1->next : nullptr;
            l2 = l2 ? l2->next : nullptr;
        }
        if (carry > 0) {
            ListNode* carryNode = new ListNode(1);
            prev->next = carryNode;
        }
        return head;
    }
};

int main(int argc, char const *argv[])
{

    ListNode n1 = ListNode(2);
    ListNode n2 = ListNode(4);
    ListNode n3 = ListNode(3);
    n1.next = &n2;
    n2.next = &n3;

    ListNode l1 = ListNode(5);
    ListNode l2 = ListNode(6);
    ListNode l3 = ListNode(4);
    l1.next = &l2;
    l2.next = &l3;

    /* ListNode n1 = ListNode(5);
    ListNode l1 = ListNode(5);*/
    ListNode *ret = AddTwoNumbers::addTwoNumbersV2(&n1, &l1); 

    return 0;
}
