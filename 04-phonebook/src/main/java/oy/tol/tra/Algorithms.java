package oy.tol.tra;

import java.util.Comparator;
import java.util.function.Predicate;

public class Algorithms {

    public static <T extends Comparable<T>> void sort(T[] array) {
        int i = array.length;
        boolean sorted;
        do {
            sorted = false;
            for (int j = 1; j < i; j++) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    sorted = true;
                }
            }
            i--;
        } while (sorted);
    }

    public static <T> void reverse(T[] array) {
        int i = 0;
        while (i < array.length / 2) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
            i++;
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int cmp = aValue.compareTo(fromArray[mid]);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                toIndex = mid - 1;
            } else {
                fromIndex = mid + 1;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> void fastSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
        E pivot = array[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        E temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static <T> int partitionByRule(T[] array, int count, Predicate<T> rule) {
        // Find first element rules applies to.
        // Index of that element will be in variable index.
        int index = 0;
        for (; index < count; index++) {
           if (rule.test(array[index])) {
              break;
           }
        }
        // If went to the end, nothing was selected so quit here.
        if (index >= count) {
           return count;
        }
        // Then start finding not selected elements starting from next from index.
        // If the element is not selected, swap it with the selected one.
        int nextIndex = index + 1;
        // Until end of array reached.
        while (nextIndex != count) {
           if (!rule.test(array[nextIndex])) {
              swap(array, index, nextIndex);
              // If swapping was done, add to index since now it has non-selected element.
              index++;
           }
           nextIndex++;
        }
        return index;
     }
   public static <T> void sortWithComparator(T[] array, Comparator<? super T> comparator) {
        int n = array.length;
        boolean sorted;
        do {
            sorted = false;
            for (int j = 1; j < n; j++) {
                if (comparator.compare(array[j], array[j - 1]) < 0) {
                    T tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    sorted = true;
                }
            }
            n--;
        } while (sorted);
    }
}