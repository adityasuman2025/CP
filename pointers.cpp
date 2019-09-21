#include <iostream>
using namespace std;

void workingIncrement(int *a)
{
	*a = *a + 1;
	cout<<"address of a in working increment function "<<&a<<endl;
}

void notWorkingIncrement(int a)
{
	a = a + 1;
	cout<<"address of a in not-working increment function "<<&a<<endl;
}

int sumArray(int A[], int size)
{	
	int sum = 0;
	for(int i=0; i<size; i++)
	{
		sum += A[i];
	}

	return sum;
}

void Double(int A[], int size)
{	
	//int sum = 0;
	for(int i=0; i<size; i++)
	{
		A[i] = 2*A[i];
	}
}

void print2dArray(int *arr[], int N)
{
	for(int i = 0;i<N;i++)
    {
        for(int j = 0;j<N;j++)
        {
            cout<<arr[i][j]<<" "; // *(*(arr+i)+j)
        }
        cout << endl;
    }
}

int Add(int a, int b)
{
	return a+b;
}

void printHello(string str)
{
	cout<<"Hello "<<str<<endl;
}

void function() //call-back function
{
	cout<<"Hello "<<"frnds"<<endl;
}

void caller(void (*pff)()) //calling function
{
	pff();
}

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

	cout<<*(ptr+1)<<endl; //some garbage value //becauz we have not defined any varable at this address
	cout<<endl;

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

//pointers as function arguments
	int a = 10;
	//a++;
	workingIncrement(&a);
	//notWorkingIncrement(a);
	cout<<"address of a in main function "<<&a<<endl;
	cout<<a<<endl;
	cout<<endl;

//arrays & pointers
	int A[] = {1,2,3,4,5};
	
	int *ptr11 = A;
    int *ptr12 = ptr11 + 3;
    
    cout<<endl;
    cout<<"hey bro"<<endl;
    cout<<*ptr12<<endl;
    cout<<A[3]<<endl;    
    cout<<"ADDRESS OF pointer ptr11: "<<ptr11<<endl;
    cout<<"ADDRESS OF pointer ptr12: "<<ptr12<<endl;
    cout<<ptr12 - ptr11<<endl;
    cout<<"hey bro"<<endl;
    cout<<endl;
    cout<<endl;

	cout<<*(ptr11+4)<<endl; //value of last element of array A
	cout<<*(A+4)<<endl; //value of last element of array A
	cout<<A[0]<<endl; //value of first element of array A
	cout<<&A<<endl; //address of first element of array A
	cout<<ptr11<<endl; //address of first element of array A
	cout<<A<<endl; //address of first element of array A

	// for(int i=1; i<5; i++)
	// {
	// 	cout<<*(A+i)<<endl; //value of i element of array A
	// 	cout<<A[i]<<endl; //value of i element of array A
	// 	cout<<&A[i]<<endl; //address of first element of array A
	// 	cout<<A+i<<endl; //address of i element of array A		
	// }
	cout<<endl;

	int size = sizeof(A)/sizeof(A[0]);

	cout<<"size of array: "<<size<<endl;
	cout<<"sum of elements: "<<sumArray(A, size)<<endl;

	Double(ptr11, size);
	for(int i=0; i<5; i++)
	{
		cout<<*(A+i)<<" "; //value of i element of array A
	}
	cout<<endl;

//character array 
	char str[] = "Bro";
	char *s = str;
	s[0] = 'V';
	cout<<*(s+2)<<endl; //same is s[2] //same as (s+2)
	cout<<s<<endl; //same as str
	cout<<endl;
 
//2D arrays
	int arr[2][3] = {{1,2,3}, {4,5,6}};
	cout<<arr<<endl; //address of first element of arr i.e arr[0][0] //same as &arr[0] or arr[0] or arr[0][0] or *arr
	cout<<arr+1<<endl; //address of 2nd element of arr i.e arr[1][0] //same as &arr[1] or arr[1] or *(arr+1)
	cout<<(arr+1)+2<<endl; //address of  arr[1][2] //same as arr[1]+2
	cout<<*(*(arr+1)+2)<<endl; //value of  arr[1][2] //same as arr[1][2]
	cout<<*(*(arr)+2)<<endl; //value of  arr[0][2] //same as *(arr[0]+2)
	cout<<*(arr[1]+2)<<endl; //value of  arr[1][2] //same as *(arr[1]+2)
	cout<<endl;
	//B[i][j] = *(B[i]+j) = *(*(B+i)+j)

//const
	const int* bro = &b; 
	cout<<*bro<<endl;
	//*bro = 17; //it will give error as pointer bro is constant
	cout<<b<<endl;
	cout<<endl;

//pointers to function 
	int (*pf)(int, int); //declaring pointer to point a function
	pf = Add; //pointing the pointer to the function
	int ans = (*pf)(2,3); //de-referencing and executing the function
	cout<<ans<<endl;

	void (*pf1)(string) = printHello; //declaring pointer to point a function and pointing the pointer to the fucntion
	pf1("Brother"); //executing the function

	caller(function);

	int k = 2;
	int l = 8;
	int m = ++k + l++;
	cout<<m<<endl;

//bro
	int i;
	int *pi = &i;
	scanf("%d", pi);
	printf("%dn", i+5);

	return 0;
}