package week_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyIndexedSort {

    @SuppressWarnings("unchecked")
    public static <T> T[] Sort(int R, List<Indexed<T>> data) {
        int N = data.size();
        int[] freq = new int[N + 1];
        T[] sorted = (T[]) new Object[N];
        for (Indexed<T> elem : data)
            freq[elem.getKey() + 1]++;
        for (int i = 1; i < N; i++)
            freq[i + 1] += freq[i];
        for (Indexed<T> elem : data)
            sorted[freq[elem.getKey()]++] = elem.getVal();
        return sorted;
    }

    public static void main(String[] args) {
        List<Indexed<Integer>> m = new ArrayList<Indexed<Integer>>(100);
        for (int i = 1; i < 10; i++)
            for (int j = i; j < 1000; j *= 10)
                m.add(new Indexed<Integer>(i, j));
        Object[] sorted = KeyIndexedSort.Sort(10, m);
        System.out.println(Arrays.toString(sorted));
    }
}
