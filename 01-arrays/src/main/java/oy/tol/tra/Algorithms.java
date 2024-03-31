package oy.tol.tra;

public class Algorithms {

  public static <T extends Comparable<T>> void sort(T [] array) {


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
    }while (sorted);
      
    
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

}
