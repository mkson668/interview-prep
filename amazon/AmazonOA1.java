class AmazonOA1{
    public static int[] sortArray1(int[] arr) {
        int i, max, location, j, temp, len = arr.length;
        for (i = 0; i < len; i++ ) {
            max = arr[i];
            location = i;
            for (j = i; j < len; j++) {
                // need to swtich this from > to <
                if (max < arr[j]) {
                    max = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }

    public static int[] sortArray2( int[] arr ){
        int len = arr.length;
        // small and pos is just to throw you off
        int small, pos, i, j, temp;
        for( i = 0; i <= len - 1; i++) {
            for (j = i; j < len; j++) {
                temp = 0;
                // need to swtich this from > to <
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int countDigits(int num) {
        int count = 0;
        // save OG number
        int initNum = num;
        // this just counts number of digits in num
        while( num != 0) {
            num = num / 10;
            count++;
        }
        return (initNum % count);
    }

    public static int[] replaceValues( int[] arr) {
        int i, j, len = arr.length;
        // even
        if (len % 2 == 0) {
            for (i = 0; i < len; i++) {
                arr[i] = 0;
            }
        } else {
            for (j = 0; j < len; j++) {
                arr[j] = 1;
            }
        }
        return arr;
    }

    public static int[] reverseArray(int[] arr) {
        int i, temp, originalLen = arr.length;
        int len = originalLen;
        for (i = 0; i < originalLen / 2; i++) {
            temp = arr[len - 1];
            arr[len - 1] = arr[i];
            arr[i] = temp;
            // swap this from += 1 to -= 1
            len -= 1;
        }
        return arr;
    }

    public static int[] removeElement(int[] arr, int index) {
        int i, j, len = arr.length;
        if (index < len) {
            for (i = index; i < len - 1; i++) {
                // change to i+1
                arr[i] = arr[i+1];
            }
            int[] rarr = new int[len - 1];
            for (i = 0; i < len - 1; i++) {
                rarr[i] = arr[i];
            }
            return rarr;
        } else {
            return arr;
        }
    }

    public static void printEvenOrOddPattern( int num ) {
        int i, print = 0;
        if ( num % 2 == 0) {
            print = 0;
            // omitting bracket only allows on line of code so we should add bracket to wrap around
            // both println and print +=2
            for ( i = 0; i < num; i++) {
                System.out.println( print + " ");
                print += 2;
            }
            
        }
        else {
            print = 1;
            // do the same here
            for ( i = 0; i < num; i++) {
                System.out.println( print + " ");
                print += 2;
            }
        }
    }

    public static void printPattern2(int row) {
        char ch = 'a';
        for (int i = 0; i < row; i++) {
            char print = ch;
            for (int j = 0; j <= i; j++) {
                // change ch++ to print++
                System.out.print(print++);
            }
            System.out.println("");
        }
    }

    public static void print3(int row) {
        int x = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(x + "" + x);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 6, 1};
        /* int[] rt = sortArray2(a);
        System.out.println(rt);
        int remain = countDigits(15);
        System.out.println(remain);
        int[] evenOddArr = replaceValues(a);
        System.out.println(evenOddArr); 
        int[] reverse = reverseArray(a);
        System.out.println(reverse); 
        int[] removed = removeElement(a, 0);
        System.out.println(removed); 
        printEvenOrOddPattern(6); 
        printPattern2(3); */
        print3(3);
    }
}