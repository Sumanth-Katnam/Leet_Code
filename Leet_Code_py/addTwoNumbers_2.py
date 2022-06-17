class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    sum = 0
    carry = 0
    tempNode = ListNode()
    result = None
    while l1 != None or l2 != None:
        if l1 != None:
            sum += l1.val
            l1 = l1.next
        
        if l2 != None:
            sum += l2.val
            l2 = l2.next
        
        sum += carry
        tempNode.val = sum % 10
        carry = sum / 10
        sum = 0
        
        if result == None:
            result = tempNode
        
        if l1 != None or l2 != None or carry != 0:
            tempNode.next = ListNode()
            tempNode = tempNode.next
        
    
    if carry > 0:
        tempNode.val = carry
    
    return result