
import java.util.*;

class comparing implements Comparator<int []>{
    public int compare(int [] a, int [] b){
        return a[1] - b[1];
    }
}

public class nonoverlappingintervals {
        public static  int eraseOverlapIntervals(int[][] intervals) {
            if(intervals.length <= 1){
                return 0;
            }
            PriorityQueue<int []> pq = new PriorityQueue<int[]>(new comparing());
            int removeCount = 0;
            Stack<int []> st = new Stack<int []>();
            for(int i = 0; i < intervals.length; i++){
                pq.add(intervals[i]);
            }
            printpq(pq);
            st.push(pq.poll());
            while(!pq.isEmpty()){
                int [] stval = st.peek();
                int [] curr = pq.poll();
                //System.out.println(Arrays.toString(stval) + ":" + Arrays.toString(curr));
                if(Arrays.equals(stval,curr)){ // check if they're the same
                    removeCount++;
                }else if(stval[1] > curr[0]){ // checking if they overlap 
                    //System.out.println(stval[1] + ":" + curr[0]);
                    removeCount++;
                }else{
                    st.push(curr);
                }
            }
            while(!st.isEmpty()){
                System.out.print(Arrays.toString(st.pop()));
            }
            System.out.println();
            return removeCount;
        }
        public static void printpq(PriorityQueue<int []> p){
        PriorityQueue<int []> pq = new PriorityQueue<int[]>(p);
        while(!pq.isEmpty()){
            System.out.print(Arrays.toString(pq.poll()));
        }
        System.out.println();
    }
    public static void main (String [] args){
        int [] [] m = new int [] [] {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(m));
    }
}