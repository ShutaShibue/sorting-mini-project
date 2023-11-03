import java.util.Comparator;

/**
 * Shuta's original sorting algorithm. Use partition twice to move elements briefly with small cost,
 * and then sort with quicksort.
 *
 * @author Shuta Shibue
 */

public class ShutaShibueSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new ShutaShibueSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  ShutaShibueSort() {} // ShutaShibueSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int pivotIndex = partition(values, 0, values.length - 1, order);
    partition(values, 0, pivotIndex - 1, order);
    partition(values, pivotIndex + 1, values.length - 1, order);

    InsertionSort sorter = new InsertionSort();
    sorter.sort(values, order);

  } // sort(T[], Comparator<? super T>

  private <T> int partition(T[] values, int lb, int ub, Comparator<? super T> order) {
    if (ub - lb < 2)
      return 0;
    T pivot = values[ub];
    int i = lb - 1;

    for (int j = lb; j < ub; j++) {
      if (order.compare(values[j], pivot) <= 0) {
        i++;

        // swap
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
      }
    }

    // put pivot to the middle
    T temp = values[i + 1];
    values[i + 1] = values[ub];
    values[ub] = temp;
    return i + 1;
  }
} // class ShutaShibueSort
