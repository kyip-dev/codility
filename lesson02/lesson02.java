import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		int oddOccurrencesInArray = oddOccurrencesInArray(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println(oddOccurrencesInArray);
	}

	// question 1, Correctness 100%, performance: 25%
    public static int oddOccurrencesInArray(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        Map<String, Integer> occurMap = new HashMap<String, Integer>();
        String[] a = Arrays.toString(A).split("[\\[\\]]")[1].split(", ");

        Arrays.stream(a)
                .collect(Collectors.groupingBy(s -> s))
                .forEach((k, v) -> occurMap.put(k, v.size()));

        for (Map.Entry<String, Integer> entry : occurMap.entrySet()) {
            if (entry.getValue()%2 >0) {
                return Integer.valueOf(entry.getKey());
            }
        }
        // should not go to this line
        return 1;
    }

}