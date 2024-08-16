import java.util.Arrays;

class insertionsort {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 56, 7, 8, 9, 5, 6, 89, 5, 4, 5, 5, 2, 25 };
        Insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void Insertion(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }

        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
