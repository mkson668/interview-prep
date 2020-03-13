class NumberStepsReduceNumberToZero {
    public static void main(String[] args) {
        int ret = numberOfSteps(123);
        System.out.println(ret);
    }

    public static int numberOfSteps(int num) {
        int counter = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                // even
                num /= 2;
            } else {
                // odd
                num -= 1;
            }
            counter++;
        }
        return counter;
    }
}