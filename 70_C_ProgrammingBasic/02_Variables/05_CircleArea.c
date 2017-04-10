#include "stdio.h"
#include "math.h"

int main() {
    double param = 0;
    double area = 0;

    printf("Enter diameter: ");
    scanf("%lf", &param);

    param /= 2;

    area = pow(param, 2) * M_PI;

    printf("The area is: %lf\n", area);

    return 0;
}
