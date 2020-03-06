class SearchBegLastIndex {
    public static void main(String[] args) {
        int[] in = new int[]{5,7,7,8,8,10};
        int[] out = searchIndices(in, 8);
        System.out.println(out);
    }

    public static int[] searchIndices(int[] arr, int target) {
        if (arr.length == 0 || arr == null) return new int[]{-1, -1};
        boolean found = false;
        int i = 0;
        int beg = 0; 
        int end = 0;
        while (!found && i < arr.length) {
            if (arr[i] == target) {
                found = true;
                beg = i;
                break;
            } 
            i++;
        }
        if (!found) {
            return new int[]{-1, -1};
        }
        i = arr.length - 1;
        found = false;
        while (!found && i >= 0) {
            if (arr[i] == target) {
                found = true;
                end = i;
                break;
            }
            i--;
        }
        return new int[]{beg, end};
    }
}