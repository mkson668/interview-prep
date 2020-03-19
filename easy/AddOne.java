class AddOne {
    public static void main(String[] args) {
        
    }

    public static int[] addOneToArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i] += 1;
                return arr;
            }
            arr[i] = 0;
        }
        int[] newA = new int[arr.length + 1];
        newA[0] = 1;
        return newA;
    }
}