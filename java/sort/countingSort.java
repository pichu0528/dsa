public class countingSort {
    public static void printArr(int[] arr) {
      for(int i : arr) System.out.println(i);
    }    
    
    public static void countingSort(int[] input, int min, int max) {
      int[] countArr = new int[(max - min) + 1];

      for(int i = 0; i < input.length; i++) {
        // find the appropriate location for the counter
        // ex: min = 1
        // 5 will be at 5 - 1 = 4 index
        countArr[input[i] - min]++;
      }

      int j = 0;

      // set i to min, so we don't need to calculate the inserted value
      for(int i = min; i <= max; i++) {
        while(countArr[i - min] > 0) {
          input[j++] = i;
          // decrement the count ex: 2: 2 -> 2: 1
          countArr[i - min]--;
        }
      }
    }
    
    public static void main(String args[]) {
      int[] intArr = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
      
      // assume our array has min of 1 and max of 10
      countingSort(intArr, 1, 10);
      
      printArr(intArr);
    }
  }
  