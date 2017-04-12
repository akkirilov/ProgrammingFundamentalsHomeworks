#include <stdio.h>

int main() {
    short myShort = 8;
    int myInt = 32;
    long myLong = 64;
    float myFloat = 32;
    double myDouble = 64;
    long double myLongDouble = 128.00;
    char myChar  = '8';

    printf("Short = %d bits\n", myShort);
    printf("Int = %d bits\n", myInt);
    printf("Long = %ld bits\n", myLong);
    printf("Float = %.0f bits\n", myFloat);
    printf("Double = %.0lf bits\n", myDouble);
    printf("Long double = %lf bits\n", myLongDouble);
    printf("Char = %c bits\n", myChar);

    return 0;
}
