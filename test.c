#include <curses.h>
#include <stdio.h>
//#include <stdlib.h>

void main()
{
	void foo(), f();
	f();
}

void foo()
{
	printf("\ti");
}

void f()
{
	//clear();

	printf("j\n");

	foo();

	//getch();
}