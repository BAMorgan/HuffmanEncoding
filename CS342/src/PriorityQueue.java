/*Lewis, J., &amp; Chase, J. (2014). Chapter 12: Heaps and Priority Queues.
  In Java software structures: Designing and using data structures (4th ed., pp. 357–384). essay, Pearson.
*/
public class PriorityQueue<T> extends ArrayHeap {
    T node;


    void add(T elem, int priority){
        PrioritizedObject<T> temp = new PrioritizedObject(elem,priority);
        addElement(temp);
    }

    T remove(){

        PrioritizedObject<T> obj = (PrioritizedObject<T>) removeMin();

       return obj.elem;

    }



}
//priority queue node which has priority comparison
class PrioritizedObject<T> implements Comparable<PrioritizedObject>{
    T elem;
    int priority;

    PrioritizedObject(T elem, int priority){
        this.elem = elem;
        this.priority = priority;
    }

    @Override
    public int compareTo(PrioritizedObject object) {
        return Integer.compare(priority, object.priority);
    }

    @Override
    public String toString() {
        return elem + "}\n";
    }


}
