public class LinearSearch {
    public static void main(String[] args) {
        int[] numbers = {10, 25, 30, 45, 50}; 
        int target = 45;                      
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("Element " + target + " found at index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}