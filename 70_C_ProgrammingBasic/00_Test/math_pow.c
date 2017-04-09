#include <stdio.h>
#include <math.h>

int main() {
    int x = 5;
    int b = 2;

    //correct
    //int result = myIntPow(x, b);

    //correct
    //double result = pow(5.0, 2.0);

    //correct
    //int result = pow(5, 2);

    //result is 24 ????
    int result = pow(x, b);

    //correct
    //int result = (int)(pow(x, b) + 0.5);

    //correct
    //int result = (int)(pow(5, 2) + 0.5);

    printf("result: %d", result);

    return 0;
}

int myIntPow(int x, int b) {
    int res = x;
    for (int i = 1; i < b; i++) {
        res *= x;
    }
    return res;
}
