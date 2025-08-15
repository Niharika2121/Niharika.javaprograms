import java.util.Arrays;
import java.util.Scanner;
public class ArraysOperations {
    public static int access(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Index out of bounds");
            return -1;
        }
        return arr[index];
    }
    public static int[] insert(int[] arr, int element, int position) {
        if (position < 0 || position > arr.length) {
            System.out.println("Invalid insertion position");
            return arr;
        }
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == position) {
                newArr[i] = element;
            } else {
                newArr[i] = arr[j++];
            }
        }
        return newArr;
    }
    public static int[] delete(int[] arr, int position) {
        if (position < 0 || position >= arr.length) {
            System.out.println("Invalid deletion position");
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == position) continue;
            newArr[j++] = arr[i];
        }
        return newArr;
    }
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n-1; i++) {
            swapped = false;
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int insertedPosition = binarySearchInsertPosition(arr, key, 0, i - 1);
            int j = i - 1;
            while (j >= insertedPosition) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[insertedPosition] = key;
        }
    }
    private static int binarySearchInsertPosition(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid + 1;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {5, 2, 9, 1, 7};
        System.out.println("Initial array: " + Arrays.toString(arr));
        System.out.print("Enter index to access: ");
        int accessIndex = sc.nextInt();
        int accessedValue = access(arr, accessIndex);
        if (accessedValue != -1) {
            System.out.println("Element at index " + accessIndex + ": " + accessedValue);
        }
        System.out.print("Enter element to insert: ");
        int elemToInsert = sc.nextInt();
        System.out.print("Enter position to insert (0-based): ");
        int insertPos = sc.nextInt();
        arr = insert(arr, elemToInsert, insertPos);
        System.out.println("Array after insertion: " + Arrays.toString(arr));
        System.out.print("Enter position to delete (0-based): ");
        int deletePos = sc.nextInt();
        arr = delete(arr, deletePos);
        System.out.println("Array after deletion: " + Arrays.toString(arr));
        int[] arrSelectionSort = Arrays.copyOf(arr, arr.length);
        selectionSort(arrSelectionSort);
        System.out.println("Array after Selection Sort: " + Arrays.toString(arrSelectionSort));
        int[] arrBubbleSort = Arrays.copyOf(arr, arr.length);
        bubbleSort(arrBubbleSort);
        System.out.println("Array after Bubble Sort: " + Arrays.toString(arrBubbleSort));
        int[] arrBinaryInsertionSort = Arrays.copyOf(arr, arr.length);
        binaryInsertionSort(arrBinaryInsertionSort);
        System.out.println("Array after Binary Insertion Sort: " + Arrays.toString(arrBinaryInsertionSort));
        System.out.print("Enter element to search (linear search): ");
        int linearSearchKey = sc.nextInt();
        int linearSearchResult = linearSearch(arr, linearSearchKey);
        if (linearSearchResult == -1)
            System.out.println(linearSearchKey + " not found in the array");
        else
            System.out.println(linearSearchKey + " found at index " + linearSearchResult);
        Arrays.sort(arr);
        System.out.println("Sorted array for binary search: " + Arrays.toString(arr));
        System.out.print("Enter element to search (binary search): ");
        int binarySearchKey = sc.nextInt();
        int binarySearchResult = binarySearch(arr, binarySearchKey);
        if (binarySearchResult == -1)
            System.out.println(binarySearchKey + " not found in the array");
        else
            System.out.println(binarySearchKey + " found at index " + binarySearchResult);
        sc.close();
    }
}
