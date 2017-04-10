#include <stdio.h>

int main() {
    int a = 5;
    int b = 3;

    printf("a = %d\n", a);
    printf("b = %d\n", b);

    printf("%d + %d = %d\n", a, b, a + b);
    printf("%d - %d = %d\n", a, b, a - b);
    printf("%d * %d = %d\n", a, b, a * b);
    printf("%d / %d = %d\n", a, b, a / b);

    int res1 = a++;
    printf("int res = a++ (res = %d and a = %d)\n", res1, a);

    a--;
    int res2 = ++a;
    printf("int res = ++a (res = %d)\n", res2);

    return 0;
}
