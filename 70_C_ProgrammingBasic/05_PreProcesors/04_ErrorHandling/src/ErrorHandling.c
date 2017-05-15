#include <stdio.h>
#include <stdlib.h>

#define SUCCESS 0
#define INCORECT_NUMBER 1

int main(void) {
	int n;
	printf("Enter number: \n");
	scanf("%d", &n);

	int res = INCORECT_NUMBER;
	if(n % 3 == 0 && n % 5 == 0 && n % 8 == 0){
		res = SUCCESS;
	}

	switch(res){
		case INCORECT_NUMBER:
			printf("INCORECT NUMBER!!!");
			break;
		case SUCCESS:
			printf("SUCCESS!!!");
			break;
	}

	return res;
}
