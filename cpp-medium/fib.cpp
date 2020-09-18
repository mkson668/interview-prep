#include <iostream>
int fib(int);
int fibNoLoop(int);
int fibNoLoopHelper(int, int, int*);


int fib(int val) {
    int arr[val + 1];
    if (val == 0) return 0;
    if (val == 1) return 1;
    arr[0] = 0;
    arr[1] = 1;
    for (int i = 2; i <= val; i++)
    {
        /* code */
        arr[i] = arr[i - 1] + arr[i - 2];
    }
    return arr[val];
}

int fibNoLoop(int N) {
    if (N == 0) return 0;
    if (N == 1) return 1;
    int* arr = new int[N + 1];
    arr[0] = 0;
    arr[1] = 1;
    return fibNoLoopHelper(1, N, arr);;
}

int fibNoLoopHelper(int currN, int N, int arr[]) {
    if (currN == N) return arr[currN];
    arr[currN + 1] = arr[currN - 1] + arr[currN];
    return fibNoLoopHelper(currN + 1, N, arr);
}

int main() {
    int ret = fibNoLoop(5);
    std::cout << ret << std::endl;
}