import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Your Name Here
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {} // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int j;
    for (int i = 1; i < values.length; i++) {
      j = i;
      while ((j > 0) && (order.compare(values[j - 1], values[j])) > 0) {
        // swap
        T temp = values[j];
        values[j] = values[j-1];
        values[j-1] = temp;

        j--;
      }
    }
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
