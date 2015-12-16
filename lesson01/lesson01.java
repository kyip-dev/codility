import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		int result01 = tapeEquilibrium(new int[]{3, 1, 2, 4, 3});
		int result = PermMissing(new int[]{1, 3, 5, 2});
		int jump = frogJump(10, 85, 30);
	}

	// question 1, Correctness 100%, performance: 0%
    public static int tapeEquilibrium(int A[]) {
        int leftSum = 0;
        int rightSum = 0;

        int minDiff = 999999999;
        for (int i = 1; i < A.length; i++) {
            int[] leftArray = Arrays.copyOfRange(A, 0, i);
            int[] rightArray = Arrays.copyOfRange(A, i, A.length);
            int sumLeft = IntStream.of(leftArray).sum();
            int sumRight = IntStream.of(rightArray).sum();
            System.out.println("sum l: " + sumLeft + " sumR: " + sumRight);
            if (Math.abs(sumRight - sumLeft) < minDiff) {
                minDiff = Math.abs(sumRight - sumLeft);
            }
        }
        System.out.println("minDiff: " + minDiff);
        return minDiff;
    }

	// question 02, Correctness 100%, performance: 100%
    public static int permMissing(int A[]) {
        if (A.length == 0) {
            return 1;
        }

        Arrays.sort(A);
        int lastElement = A[A.length - 1];
        int startElement = A[0];
        if (startElement != 1) {
            return 1;
        }

        int sumOfArray = 0;
        int sumTarget = 0;
        for (int n : A) {
            sumOfArray += n;
        }

        for (int i = 0; i < A.length+1; i++) {
            sumTarget = sumTarget + startElement + i;
        }

        return sumTarget - sumOfArray;
    }

	// question 03, Correctness 100%, performance: 100%
	public static int frogJump(int x, int y, int d) {
        int jump = (y - x) / d;
        int remain = (y - x) % d;

        if (remain > 0) {
            jump = jump + 1;
        }
        return jump;
    }
	
}