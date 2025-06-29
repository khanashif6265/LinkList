
import java.util.LinkedList;
import  java.util.Queue;
import  java.util.Stack;

public class reverseaqueue {
 public static void reversed(Queue<Integer> queue){
    Stack<Integer> stack = new Stack<>();
    while(!queue.isEmpty()){
        stack.push(queue.poll());

    }
    while(!stack.isEmpty()){
        queue.offer(stack.pop());

    }
 }
 public static void main(String[] args) {
    Queue<Integer> queue=new LinkedList<>();
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);
   System.out.println("Original queue is :"+queue);
   reversed(queue);
   System.out.println("Original Queue is :"+queue);

 }
    }
