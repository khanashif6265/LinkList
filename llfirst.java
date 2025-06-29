public class llfirst {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //step1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail= newNode;
            return;
        }
         
        //step2 -newNode next = head
        newNode.next=head;
        //step3 - head = noweda
        head = newNode;
    }
   public void addLast(int data){
    Node newNode = new Node(data);
    size++;
    if(head == null){
        head = tail=newNode;
        return;
    }
    tail.next = newNode;
    tail = newNode;
   }
   public void print(){
    if(head == null){
        System.out.print   ("LL is empty");
        return;
    }
    Node temp = head;
    while(temp != null){
        System.out.print(temp.data+"-> ");
        temp = temp.next;

    }
    System.out.println("null");
   }
   public void add(int idx, int data){
    if(idx == 0){
        addFirst(data);
        return;
    }
    Node newNode = new Node(data);
    size++;
    Node temp = head;
    int i =0;
 
    while(i<idx-1){
        temp = temp.next;
        i++;
    }
    //i = idx-1; temp -> prev
    newNode.next = temp.next;
    temp.next = newNode;
   }
   public int removeFirst(){
    if(size==0){
        System.out.println("LL is empty");
        return Integer.MIN_VALUE;
    }else if(size == 1){
        int val=head.data;
        head = tail= null;
        size = 0;
        return val;

    }  
    int val = head.data;
    head = head.next;
    size--;
    return val;
}
 public int removeLast(){
    if(size == 0){
        System.out.println("LL is empty");
        return Integer.MIN_VALUE;

    }else if(size == 1){
        int val = head.data;
        head = tail = null;
        size = 0;
        return val;
    }
 

    Node prev = head;
    for(int i=0;i<size-2;i++){
        prev = prev.next;
    }

    int val = prev.next.data; //tail.data
    prev.next = null;
    tail = prev;
    size--;
    return val;
   }
   public int itrSearch(int key){
    Node temp = head;
    int i =0;
    while(temp != null){
        if(temp != null){ //key found

            return i;
        }
        temp = temp.next;
        i++;
    }

    //key not found
    return -1;
}
public int helper(Node head, int key){
    if(head == null){
        return -1;
    }
    if(head.data == key){
        return 0;
    }
    int idx = helper(head.next, key);
    if(idx == -1){
        return -1;

    }
    return idx+1;
}
public int recSearch(int key){
    return helper(head, key);
}
public void reverse(){
    Node prev = null;
    Node curr = tail=head;
    Node next;

    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    head = prev; 
}

public void deleteNthfromEnd(int n){
    //calculate size
    int size = 0;
    Node temp = head;
    while(temp != null){
        temp = temp.next;
        size++;
    }
    if(n == size){
        head = head.next;
        return;
    }
    //size-n
    int i=1;
    int iTofind = size-n; 
    Node prev = head;
    while(i<iTofind){
        prev = prev.next;
        i++;
    }
    prev.next = prev.next;
    return;
}
    public static void main(String[] args) {
         llfirst ll = new llfirst();
         ll.addFirst(2);
         ll.addFirst(1);
         ll.addFirst(4 );
         ll.addFirst(5);
         ll.add(2,3);

         ll.print();  //1->2->2->4->5
         ll.deleteNthfromEnd(3);
         ll.print();
         
    }
    
}
