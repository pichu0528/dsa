public class MyClass {
  public static void printArr(int[] arr) {
    for(int i : arr) System.out.println(i);
  }
  
  // {20, 35, -15, 7, 55, 1, -22}
  public static void merge(int[] input, int start, int mid, int end) {
    
    // [optimization 1]
    // mid - 1 is the last index of the left array
    // mid is the first index of the right array
    if (input[mid - 1] <= input[mid]) {
      return;
    }
    
    int i = start;
    int j = mid;
    int tempIndex = 0;
    
    int[] temp = new int[end - start];
    
    while(i < mid && j < end) {
      temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
    }
    
    // [optimization 2] ==
    // case 1 when the leftover is in the right arr
    // don't need to do the extra work to merge the rest of the right arr
    // {32, 34}, {33, 36}
    // {32, 33, 34, 36}
    
    // case 2 when the leftover is in the left arr
    // need to do the extra work to move what is left in the left arr
    // to the correct index
    // case 2
    // {32,36}, {33, 34}
    // {32, 33, 34, 36}
    // ==
    
    // handle case 2
    // params: src, srcPos, dest, destPos, length from src
    System.arraycopy(input, i, input, start + tempIndex, mid - i);
    
    // copy the temp arr
    System.arraycopy(temp, 0, input, start, tempIndex);
  }
  
  public static void mergeSort(int[] input, int start, int end) {
    if (end - start < 2) {
        return;
    }
    
    int mid = (start + end) / 2;
    mergeSort(input, start, mid);
    mergeSort(input, mid, end);
    
    merge(input, start, mid, end);
  }
  
  public static void main(String args[]) {
    int[] intArr = {20, 35, -15, 7, 55, 1, -22};
    
    mergeSort(intArr, 0, intArr.length);
    
    printArr(intArr);
  }
}
