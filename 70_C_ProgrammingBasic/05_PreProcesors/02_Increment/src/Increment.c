/*
 ============================================================================
 Name        : Increment.c
 Author      : akk
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int increment = 0;

	while(1){
		int num = 0;
		printf("Enter number (1 - 6)!!!\n");
		scanf("%d", &num);
		switch(num){
			case 1:
				increment += 5;
				break;
			case 2:
				increment += 9;
				break;
			case 3:
				increment += 18;
				break;
			case 4:
				increment += 34;
				break;
			case 5:
				increment += 59;
				break;
			case 6:
				increment += 95;
				break;
			default:
				printf("!!!Invalid number!!!\n");
				continue;
				break;

		}
		printf("Incremented number: %d\n", increment);
	}
	return 0;
}
