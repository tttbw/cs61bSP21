package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    public Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        T maxOne = null;
        if(this.isEmpty()) {
            return null;
        }
        if(this.size() == 1) {
            maxOne =  this.get(0);
        }
        for(int i = 0; i < this.size() - 1; i++) {
            maxOne = this.get(i);
            if(comparator.compare(maxOne,this.get(i +1)) < 0) {
                maxOne = this.get(i + 1);
            }
        }
        return maxOne;
    }

    public T max(Comparator<T> c) {
        comparator = c;
        T maxOne = null;
        if(this.isEmpty()) {
            return null;
        }
        if(this.size() == 1) {
            maxOne = this.get(0);
        }
        for(int i = 0; i < this.size() - 1; i++) {
            maxOne = this.get(i);
            if(comparator.compare(maxOne,this.get(i +1)) < 0) {
                maxOne = this.get(i + 1);
            }
        }
        return maxOne;
    }


}
