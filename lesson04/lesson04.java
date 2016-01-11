import java.util.*;

public class Main {
	public static void main(String[] args) {
		int frogRiverOne = frogRiverOne(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
	}

	// question 1, Correctness 100%, performance: 100%
    public static int frogRiverOne(int X, int A[]) {
        // create the map to store the earliest second to have leave
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (m.containsKey(A[i])) {
                if (i < m.get(A[i])) {
                    m.put(A[i], i);
                }
            } else {
                m.put(A[i], i);
            }
        }

        // get the last fallen leave second
        int lastSecond = -1;
        for (int i = 1; i <= X; i++) {
            if (!m.containsKey(i)) {
                return -1;
            }
            else if (lastSecond < m.get(i)) {
                lastSecond = m.get(i);
            }
        }

        return lastSecond;
    }

}