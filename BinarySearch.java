public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50}; 
        int target = 30;                       
        int result = binarySearch(numbers, target);
        if (result == -1) {
            System.out.println("Element " + target + " not found in the array.");
        } else {
            System.out.println("Element " + target + " found at index " + result);
        }
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left);
            if (arr[mid] == target) {
                return mid;  
            }
            if (arr[mid] < target) {
                left = mid + 1;  
            } else {
                right = mid - 1; 
            }
        }
        return -1;  
    }
}