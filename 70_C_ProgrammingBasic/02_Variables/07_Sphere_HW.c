#include <stdio.h>
#include <math.h>

int main() {
    double r;
    double surface;
    double volume;
    double perimeter;

    printf("%s: ", "Enter radius");
    scanf("%lf", &r);


    perimeter = 2 * M_PI * r;
    surface = 4 * M_PI * (r * r);
    volume = (4.0 / 3.0) * M_PI *(r * r * r);

    printf("Perimeter: %lf\n", perimeter);
    printf("Surface: %lf\n", surface);
    printf("Volume: %lf\n", volume);

    return 0;
}
