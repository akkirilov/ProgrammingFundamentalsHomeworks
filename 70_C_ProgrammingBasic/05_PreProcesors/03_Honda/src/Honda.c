#include <stdio.h>
#include <stdlib.h>
/*
#define CIVIC 1
#define ACCORD 2
#define JAZZ 3
*/
typedef enum{
	CIVIC = 1,
	ACCORD = 2,
	JAZZ = 3
} Car;


int main(void) {
	while(1){
			int num = 0;
			printf("Enter car model (1 - Civic; 2 - Accord; 3 - Jazz):\n");
			scanf("%d", &num);
			switch(num){
				case CIVIC:
					printf("CIVIC: MK1 - 1992 - 1995; MK2 - 1992 - 1995; MK3 - 1992 - 1995\n");
					break;
				case ACCORD:
					printf("ACCORD: MK1 - 1992 - 1995; MK2 - 1992 - 1995; MK3 - 1992 - 1995\n");
					break;
				case JAZZ:
					printf("JAZZ: MK1 - 1992 - 1995; MK2 - 1992 - 1995; MK3 - 1992 - 1995\n");
					break;
				default:
					printf("!!!Invalid number!!!\n");
					break;
			}
		}
		return 0;
}
