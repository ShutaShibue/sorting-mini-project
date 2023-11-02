import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Your Name Here
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {} // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(values, 0, values.length-1, order);
    // STUB
  } // sort(T[], Comparator<? super T>

   public <T> void sort(T[] values, int lb, int ub, Comparator<? super T> order) {
    if(lb >= ub) return;
    int pivotIndex = partition(values, lb, ub, order);
    sort(values, lb, pivotIndex-1, order);
    sort(values, pivotIndex+1, ub, order);
    // STUB
  } // sort(T[], Comparator<? super T>

  

  private <T> int partition(T[] values, int lb, int ub, Comparator<? super T> order) {
    T pivot = values[ub];
    int i = lb - 1;

    for (int j = lb; j < ub; j++) {
      if (order.compare(values[j], pivot) <= 0) {
        i++;

        //swap
        T temp= values[i];
        values[i] = values[j];
        values[j] = temp;
      }
    }

    //put pivot to the middle
    T temp = values[i + 1];
    values[i + 1] = values[ub];
    values[ub] = temp;
    return i + 1;
  }
}
// class Quicksort
