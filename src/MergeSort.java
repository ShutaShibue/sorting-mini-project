import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Shuta Shibue
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {} // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  public <T> void sort(T[] vals, Comparator<? super T> comparator) {
    sort(vals, comparator, 0, vals.length - 1);
    // STUB
  } // sort(T[], Comparator<? super T>

  /**
   * @param vals array
   * @param comparator Comparator
   * @param lo low end of index, inclusive
   * @param mid midpoint
   * @param hi hi end of index, inclusive
   */
  public <T> void sort(T[] vals, Comparator<? super T> comparator, int lo, int hi) {

    if (hi > lo) {
      int m = (lo + hi) / 2;
      // sort left half and then right half
      sort(vals, comparator, lo, m);
      sort(vals, comparator, m + 1, hi);
      merge(vals, lo, m, hi, comparator);
    }

  }

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  @SuppressWarnings("unchecked")
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    // STUB
    int i = 0;
    int loi = lo;
    int hii = mid;
    T[] temp = vals.clone();

    while (loi < mid && hii < hi) {
      if (comparator.compare(temp[loi], temp[hii]) > 0) {
        vals[i] = temp[hii];
        hii++;
        i++;
      } else {
        vals[i] = temp[loi];
        loi++;
        i++;
      }
    }
    while (hii < hi) {
      vals[i] = temp[hii];
      i++;
      hii++;
    }
    while (hii < hi) {
      vals[i] = temp[loi];
      i++;
      loi++;
    }
  } // merge

} // class MergeSort
