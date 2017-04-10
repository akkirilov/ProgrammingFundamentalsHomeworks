#include <stdio.h>

int main() {
    int a = 0;
    int b = 0;
    int c = 0;
    int perimeter = 0;

    printf("Enter side a: ");
    scanf("%d", &a);
    printf("Enter side b: ");
    scanf("%d", &b);
    printf("Enter side c: ");
    scanf("%d", &c);

    perimeter = a + b + c;

    printf("The perimeter is: %d", perimeter);

    return 0;
}
