class Node {
    private int val;
    private Node next;
    
    public Node(int val){
        this.val = val;
        this.next = null;
    }
    
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
    
    public int getVal(){
        return this.val;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public void setVal(int val){
        this.val = val;
    }
    
    public void setNext(Node node){
        this.next = node;
    }
}



class MyLinkedList {
    
    private Node head;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        int cnt = 0;
        Node temp = head;
        
        while(temp != null && cnt < index){
            cnt++;
            temp = temp.getNext();
        }
        
        if(temp == null){
            return -1;
        }
        
        return temp.getVal();
    }
    
    public void addAtHead(int val) {
        Node newHead = new Node(val, head);
        head = newHead;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            head = new Node(val);
            return;
        }
        
        Node temp = head;
        
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        
        Node newTail = new Node(val);
        temp.setNext(newTail);
    }
    
    public void addAtIndex(int index, int val) {
        if(head == null) {
            if(index == 0)
                head = new Node(val);
            return;
        }
        
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        
        while(temp != null && cnt < index){
            cnt++;
            prev = temp;
            temp = temp.getNext();
        }
        
        Node midNode = new Node(val, temp);
        if(prev == null){
            head = midNode;
            return;
        }
        prev.setNext(midNode);
        return;
    }
    
    public void deleteAtIndex(int index) {
        if(head == null) return;
        
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        
        while(temp != null && cnt < index){
            cnt++;
            prev = temp;
            temp = temp.getNext();
        }
        
        if(temp == null){
            return;
        }
        
        if(prev == null){
            head = temp.getNext();
            return;
        }
        
        prev.setNext(temp.getNext());
        return;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */