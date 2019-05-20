import java.util.Arrays;

public class MP7_20 {
    private int heapSize = 0;
    private int length = 10;
    private int[] A;
    private String dequeued="";


    public MP7_20(int x){
        length = x;
        A = new int[x];
    }
    public int left(int x){
        return 2*x;
    }
    public int right(int x){
        return 2*x+1;
    }
    public int parent(int x){
        return  (int)Math.floor(x/2);
    }
    public int heapEnqueue(int x){
        if(heapSize + 1 > length) return -999;
        heapSize = heapSize +1;
        A[heapSize] = x;
        heapifyUp(heapSize);
        return 1;
    }
    public int heapDequeue(){
        if(heapSize == 0) return -999;
        int max = A[1];
        A[1]=A[heapSize];
        heapSize = heapSize -1;
        heapifyDown(1);
        dequeued = dequeued + ", "+ max;
        return  max;
    }
    public void heapifyUp(int x){
        int el = A[x];
        while(x > 1 && A[parent(x)]< el){
            A[x] = A[parent(x)];
            x = parent(x);
        }
        A[x]=el;
    }
    public void heapifyDown(int x){
        int l = left(x);
        int r = right(x);
        int largest;
        if((l <= heapSize)&&(A[l]>A[x])){
            largest = l;
        }else largest =x;
        if((r<=heapSize)&&(A[r]>A[largest])) largest = r;
        if(largest != x){
            int temp = A[x];
            A[x] = A[largest];
            A[largest] = temp;
            heapifyDown(largest);
        }

    }
    public String finalHeap(){
        int[] x = new int[heapSize];
        for(int i = 0; i < heapSize; i++){
            x[i] = A[i+1];
        }
        String t = Arrays.toString(x);
        return t;
    }


    public static void main(String args[]) {

        MP7_20 H = new MP7_20(10);

        H.heapEnqueue(30);
        H.heapEnqueue(50);
        H.heapEnqueue(20);
        H.heapEnqueue(70);
        H.heapEnqueue(60);
        H.heapEnqueue(80);
        H.heapEnqueue(10);
        H.heapEnqueue(40);
        H.heapEnqueue(90);

        System.out.println("Final Heap: "+H.finalHeap());
        H.heapDequeue();
        H.heapDequeue();
        H.heapDequeue();
        H.heapDequeue();
        System.out.println("First 4 keys to dequeue: "+ H.dequeued);
        System.out.println("Total number of Keys left: "+ H.heapSize);
        System.out.println("Final Heap: " + H.finalHeap());







    }
}
