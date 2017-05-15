#include <stdio.h>
#include <stdlib.h>

typedef enum {
	EXCELENT = 6,
	VERY_GOOD = 5,
	GOOD = 4,
	MIDLLE = 3,
	BAD = 2
} Grade;

int main(void) {
	printf("Enter number of students: \n");
	int students = 0;
	scanf("%d", &students);

	printf("Enter number of subjects: \n");
	int subjects = 0;
	scanf("%d", &subjects);

	float avarage [students];
	for (int i = 0; i < students; i++) {
		avarage[i] = 0.0;
	}

	int divider;
	float currNum;

	for (int i = 0; i < students; i++) {
		divider = 0.0;
		for (int j = 0; j < subjects; j++) {
			printf("Student %d subject %d : ", i + 1, j + 1);
			currNum = 0.0;
			divider++;
			scanf("%f", &currNum);
			avarage[i] += currNum;
		}

		avarage[i] /= divider;
	}

	for (int i = 0; i < students; i++) {
		int grade = avarage[i];
		switch (grade) {
			case EXCELENT:
				printf("Student %d -> EXCELENT\n", avarage[i] + 1);
				break;
			case VERY_GOOD:
				printf("Student %d -> VERY_GOOD\n", avarage[i] + 1);
				break;
			case GOOD:
				printf("Student %d -> GOOD\n", avarage[i] + 1);
				break;
			case MIDLLE:
				printf("Student %d -> MIDLLE\n", avarage[i] + 1);
				break;
			case BAD:
				printf("Student %d -> BAD\n", avarage[i] + 1);
		}
	}

	return 0;
}
