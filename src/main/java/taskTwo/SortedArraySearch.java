package taskTwo;

public class SortedArraySearch {

    public static int search(String[] arr, String target) {
        if (arr == null || arr.length == 0 || target == null) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            while (mid < right && arr[mid].isEmpty()) {
                mid++; 
            }

            if (mid > right) {

                mid = left + (right - left) / 2;
                while (mid > left && arr[mid].isEmpty()) {
                    mid--;
                }
            }

            int compareResult = compareStrings(arr[mid], target);

            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private static int compareStrings(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) {
            return 0;
        } else if (str1.isEmpty()) {
            return -1;
        } else if (str2.isEmpty()) {
            return 1;
        } else {
            return str1.compareTo(str2);
        }
    }

    public static void main(String[] args) {
        String[] sortedArray = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "", ""};
        String targetString = "ball";
        int position = search(sortedArray, targetString);

        System.out.println("Position of \"" + targetString + "\": " + position);
    }
}
