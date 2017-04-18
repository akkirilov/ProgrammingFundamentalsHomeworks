#include <stdio.h>
#include <math.h>

int main() {
    double a;
    double b;
    double c;
    double p;
    double area;

    printf("%s: ", "Enter side a");
    scanf("%lf", &a);
    printf("%s: ", "Enter side b");
    scanf("%lf", &b);
    printf("%s: ", "Enter side c");
    scanf("%lf", &c);

    p = (a + b + c) / 2;

    area = sqrt(p * (p - a) * (p - b) * (p - c));

    printf("%lf", area);

    return 0;
}
