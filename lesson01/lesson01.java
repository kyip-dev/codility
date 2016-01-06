import java.util.*;

public class Main {
	public static void main(String[] args) {
		int q1 = solution(20);
        System.out.println(q1);
	}

	// question 1, Correctness 100%, performance: 100%
    public static int binaryGap(int N) {
        String binaryStr = Integer.toBinaryString(N);
        char[] charArray = binaryStr.toCharArray();

        SortedSet<Integer> gapSet = new TreeSet<Integer>();
        int gap = 0;
        for (char a : charArray) {
            if (a=='1') {
                gapSet.add(gap);
                gap = 0;
            } else {
                gap = gap+1;
            }
        }

        return gapSet.last();
    }

}