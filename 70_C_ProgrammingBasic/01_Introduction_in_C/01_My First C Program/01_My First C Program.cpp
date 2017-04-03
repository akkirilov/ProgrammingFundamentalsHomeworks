// 01_My First C Program.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdio.h>
#include <math.h>


int main()
{
	char stringTest[31] = "String with specific length 31";
	printf("%s = %c%s%c \n", "char stringTest[31]", '\"', stringTest, '\"');
	
	printf("%c%c - %s\n", '%', 's', "formating string");
	printf("%c%c - %s\n", '%', 'd', "formating int");
	printf("%c%c - %s\n", '%', 'f', "formating float");
	printf("%c%c - %s\n", '%', 'c', "formating char");

    return 0;
}