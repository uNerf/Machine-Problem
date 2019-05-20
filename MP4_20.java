
public class MP4_20 {
    public static void main (String []args){

        Queue q1 = new Queue(4);

        System.out.println("Case 1:");
        q1.enqueueFront('A');
        q1.enqueueRear('B');
        q1.enqueueFront('C');
        q1.enqueueRear('D');
        System.out.print(q1.dequeueFront());
        System.out.print(q1.dequeueRear());
        System.out.print(q1.dequeueFront());
        System.out.print(q1.dequeueRear());
        q1.clear();
        q1.enqueueFront('E');
        q1.enqueueFront('F');
        q1.enqueueFront('G');
        System.out.println(q1.dequeueRear());
        System.out.println("============================");
        System.out.println("Case 2:");
        Queue q2 = new Queue(4);
        q2.enqueueRear('A');
        q2.enqueueRear('B');
        System.out.print(q2.dequeueRear());
        System.out.print(q2.peek());
        q2.enqueueFront('C');
        q2.enqueueFront('D');
        System.out.print(q2.dequeueFront());
        System.out.print(q2.peek());
    }
}




class Queue<T>{
    private int maxQsize;
    private int front = -1, rear = -1;
    private Object[] que;
    public Queue (int n){
        if (n>0) maxQsize = n;
        que = new Object[maxQsize];
    }
    public void clear(){
        front = rear = -1;
    }
    public boolean isEmpty(){
        return (front == -1);
    }
    public boolean isFull(){
        return (( rear +1)%maxQsize==front);
    }

    public int enqueueRear (T el){
        if (isFull()) return -999;
        if (isEmpty()) front = 0;
        rear = (rear +1)%maxQsize;
        que[rear] = el;
        return 1;
    }
    public int enqueueFront (T el){
        if (isFull()) return -999;
        if (rear == -1) rear =0;
        if (isEmpty()) front = 1;
        front =  (((front -1)%maxQsize)+maxQsize)%maxQsize;
        que[front]=el;
        return 1;
    }
    public T dequeueFront (){
        if (isEmpty()) return null;
        T el = (T) que [front];
        if (front == rear) clear();
        else front = (front +1)%maxQsize;
        return el;
    }
    public T dequeueRear (){
        if (isEmpty()) return null;
        T el = (T) que [rear];
        if (rear ==front) clear();
        else rear = (((rear -1)%maxQsize)+maxQsize)%maxQsize;
        return el;
    }

    public T peek(){
        if (isEmpty()) return null;
        else
            return (T) que[front];
    }

    public T element(int n){
        return (T) que[n];
    }
    public int front(){
        return front;
    }
    public int rear(){
        return rear;
    }

}