import java.lang.*;
import java.util.Arrays;


public class Eval {
    public static void main(String args[]) {
        //Infix: (5 + 3) * (2 + 7)
        //Postfix: 5 3 + 2 7 + *
        String[] postfix = {"5","3","+","2","7","+","*"}; // Gawin mo nalang input ito kung kailangan
        
        int postEval = evalPostfix(postfix);
        
        System.out.println("Evaluate the Postfix: " + Arrays.toString(postfix));
        System.out.println("Answer: " + postEval);
    }
    public static int evalPostfix(String[] c){
        Stack s = new Stack(100);
        int n = c.length;
        for(int i=0;i<n;i++){
            if(isNumeric(c[i])){
                s.push(c[i]);
            }
            else{
                String s1 = s.pop().toString();
                String s2 = s.pop().toString();
                int b = Integer.parseInt(s1);
                int a = Integer.parseInt(s2);
                int ans = 0;
                if(c[i].equals("+")){
                    ans = a + b;
                }
                else if(c[i].equals("-")){
                    ans = a - b;
                }
                else if(c[i].equals("*")){
                    ans = a * b;
                }
                else if(c[i].equals("/")){
                    ans = a / b;
                }
                s.push(ans);
            }
        }
        return (int) s.pop();
    }
    public static boolean isNumeric(String str) { 
        try {  
            Double.parseDouble(str);  
            return true;
        } catch(NumberFormatException e){  
        return false;  
    }  
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