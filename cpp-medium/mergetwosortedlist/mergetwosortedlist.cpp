
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    static ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode h;
        // return this head pointer
        ListNode* head;
        ListNode* currNode;
        // if one is empty just return other list (assuming its already sorted in ascended)
        if (l1 == nullptr) return l2;
        if (l2 == nullptr) return l1;
        // set the head
        if (l1->val >= l2->val) {
            h = ListNode(l2->val);
            head = &h;
            l2 = l2->next;
        } else {
            h = ListNode(l1->val);
            head = &h;
            l1 = l1->next;
        }
        currNode = h.next;
        while (l1 || l2) {
            if (l1 && l2) {
                if (l1->val >= l2->val) {
                    currNode = &ListNode(l2->val);
                    l2 = l2->next;
                } else {
                    currNode = &ListNode(l1->val);
                    l1 = l1->next;
                }
                currNode = currNode->next;
            } else if (l1 && !l2) {
                currNode = &ListNode(l1->val);
                currNode = currNode->next;
                l1 = l1->next;
            } else if (!l1 && l2) {
                currNode = &ListNode(l2->val);
                currNode = currNode->next;
                l2 = l2->next;
            }
        }
        return head;
    }
};

int main () {
    ListNode* h1 = &ListNode(1);
    h1->next = &ListNode(2);
    h1->next->next = &ListNode(4);
    ListNode* h2 = &ListNode(1);
    h2->next = &ListNode(3);
    h2->next->next = &ListNode(4);

    ListNode* ret = Solution::mergeTwoLists(h1, h2);
}