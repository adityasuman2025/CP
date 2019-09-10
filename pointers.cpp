#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
//basic pointers	
	int x;
	int* ptr = &x; //int* ptr and int *ptr are same thing
	//*ptr = 8;

	cout<<x<<endl; //value of x
	cout<<&x<<endl; //address of x
	cout<<ptr<<endl; //address of x
	cout<<*ptr<<endl; //value of x
	cout<<endl;

	*ptr = 5; //dereferencing //changing value of x by using its pointer
	cout<<x<<endl; //value of x
	cout<<*ptr<<endl; //value of x
	cout<<endl;

	int b = 21;
	//*ptr = b; //value of x will change but address remain same

	cout<<x<<endl; //value of x
	cout<<*ptr<<endl; //value of x
	cout<<ptr<<endl; //address of x
	cout<<endl;

	ptr = &b; //now ptr will point to b i.e address of ptr will change

	cout<<x<<endl; //value of x
	cout<<*ptr<<endl; //value of b
	cout<<ptr<<endl; //address of b
	cout<<ptr+1<<endl; //address of b + 4 bytes(size of int)
	cout<<*ptr+1<<endl; //value of b + 1
	cout<<*ptr<<endl; //original value of b	
	cout<<endl;

	cout<<*(ptr+10)<<endl; //some garbage value //becauz we have not defined any varable at this address

//pointers to pointers
	int **q = &ptr;
	cout<<ptr<<endl; //address of b
	cout<<&ptr<<endl; //address of ptr
	cout<<q<<endl; //address of ptr
	cout<<**q<<endl; //value of b
	cout<<endl;

	int ***r = &q;
	***r = 91; //changing value of b
	
	cout<<b<<endl; //value of b
	cout<<*ptr<<endl; //value of b
	cout<<**q<<endl; //value of b
	cout<<***r<<endl; //value of b
	cout<<endl;

	cout<<ptr<<endl; //address of b
	cout<<q<<endl; //address of ptr
	cout<<r<<endl; //address of q
	cout<<&r<<endl; //address of r
	cout<<endl;

	***r = **q + 9; //changing value of b
	cout<<b<<endl; //value of b
	
	return 0;
}