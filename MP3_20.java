import java.util.Scanner;

public class MP3_20 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Stack s1 = new Stack();
        System.out.println("-Parenthesis Checker-");
        System.out.println("Input the Expression: ");
        String exp = scan.nextLine();
        int noError=0;


        for (int j = 0; j < exp.length(); j++) {
            char ch = exp.charAt(j);
            switch(ch){
                case '(':
                    s1.push(ch);
                    break;
                case ')':
                    if(s1.isEmpty()){
                        noError=1;

                    }
                    else s1.pop();
            }

        }
        if (s1.isEmpty()&&noError==0){
            System.out.println("No Error");
        }
        else if (s1.isEmpty()&&noError==1){
            System.out.println("Error: Missing Left parenthesis");
        }
        else System.out.println("Error: Missing Right parenthesis");
    }
}
class Stack<T> {
    private int top = -1;
    private int maxStkSize = 99999;
    private Object[] stk;
    private Object[] optr;
    private T el;

    public Stack() {
        this.stk = new Object[this.maxStkSize];
    }

    public Stack(int n) {
        if (n>0){
            this.maxStkSize = n;
            this.stk = new Object[this.maxStkSize];
        }
    }
    public void clear() {
        while(!this.isEmpty()){
            this.pop();
        }
    }
    public boolean isEmpty() {
        return (this.top == -1);
    }
    public boolean isFull() {
        return (this.top+1 == this.maxStkSize);
    }
    public Object push(T el) {
        if (isFull()) {
            return "Stack is full";
        }
        else{
            this.top++;
            this.stk[this.top] = el;
            return this.stk[this.top];
        }
    }

    public T pop(){
        if(isEmpty()) {
            return null;
        }
        else {
            this.el = (T)this.stk[this.top];
            this.top--;
            return this.el;
        }
    }
    public T peek() {
        if(isEmpty()) {
            return null;
        }
        else
            return (T)this.stk[top];
    }
    public void printStack() {
        int x=this.top;
        while(x >=0) {
            System.out.print(this.stk[x]);
            x--;

            if(x>=0){
                System.out.print(",");
            }
        }
        System.out.println("\n");
    }
    public String toString(){
        String s="";
        int x=this.top;

        while(x >=0) {
            s+=this.stk[x];
            x--;
        }
        return s;
    }


}