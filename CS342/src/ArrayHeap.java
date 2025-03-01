/*Lewis, J., &amp; Chase, J. (2014). Chapter 12: Heaps and Priority Queues.
  In Java software structures: Designing and using data structures (4th ed., pp. 357–384). essay, Pearson.
*/
import java.util.Arrays;


public class ArrayHeap<T> {

    private static final int DEFAULT_STARTING_SIZE = 40;

    private T[] heapArr;
    private int count;


    public ArrayHeap(){
        count = 0;
        heapArr = (T[]) new Object[DEFAULT_STARTING_SIZE];
    }

    public ArrayHeap(T[] array){
        heapArr = (T[]) new Object[DEFAULT_STARTING_SIZE];
        count = 0;

        for (T each : array){
            addElement(each);
        }

    }

    void addElement(T elem){
        //check overflow and underflow
        if(isFull()){
            heapArr = this.resize();
        }else if(isEmpty()){

            heapArr[0] = elem;
        }

        heapArr[count] = elem;

        count++;


        if(count > 1){

            heapify();
        }

    }

    private void heapify(){
        T temp;

        int next = count - 1;

        temp = heapArr[next];

        while(next != 0 && (((Comparable)temp).compareTo(heapArr[(next-1)/2]) < 0 )){

            heapArr[next] = heapArr[(next-1)/2];
            next = (next-1)/2;
        }

        heapArr[next] = temp;
    }

    T removeMin() throws IllegalStateException{
        if (isEmpty()){
            throw new IllegalStateException("Empty collection...");
        }

        T min = heapArr[0];
        heapArr[0] = heapArr[count - 1];
        heapifyRemoval();
        count--;

        return min;
    }

    void heapifyRemoval(){
        T temp;
        int root = 0;
        int left = 1;
        int right = 2;
        int next = getNext(left, right);

        temp = heapArr[root];

        while ((next < count) && (((Comparable)heapArr[next]).compareTo(temp) < 0)){
            heapArr[root] = heapArr[next];
            root = next;
            left = (2 * root) + 1;
            right = (2 * root) + 2;
            next = getNext(left, right);
        }
        heapArr[root] = temp;

    }

    private int getNext(int left, int right) {
        int next;

        if ((heapArr[left] == null) && (heapArr[right] == null)){
            next = count;
        }
        else if(heapArr[right] == null){
            next = left;
        }
        else if(((Comparable)heapArr[left]).compareTo(heapArr[right]) < 0){
            next = left;
        }
        else
            next = right;

        return next;
    }


    private T[] resize(){
        System.out.println("Resizing...");
        return Arrays.copyOf(heapArr, heapArr.length * 2);
    }

    boolean isEmpty(){
        return heapArr.length == 0;
    }

    boolean isFull(){
        return count >= heapArr.length;
    }



    public int getCount() {
        return count;
    }


    @Override
    public String toString()
    {
        String retval = "";
        for (T each : heapArr)
        {
            if (each != null) retval += each + "";
        }
        return retval + "\n";

    }




}
