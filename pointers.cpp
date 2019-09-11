#include <iostream>
using namespace std;

void workingIncrement(int *a)
{
	*a = *a + 1;
	cout<<"address of a in increment function "<<&a<<endl;
}

void notWorkingIncrement(int a)
{
	a = a + 1;
}

int sumArray(int *A, int size)
{	
	int sum = 0;
	for(int i=0; i<size; i++)
	{
		sum += A[i];
	}

	return sum;
}

void Double(int *A, int size)
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

	cout<<*A<<endl; //value of first element of array A
	cout<<A[0]<<endl; //value of first element of array A
	cout<<&A<<endl; //address of first element of array A
	cout<<A<<endl; //address of first element of array A

	for(int i=1; i<5; i++)
	{
		cout<<*(A+i)<<endl; //value of i element of array A
		cout<<A[i]<<endl; //value of i element of array A
		cout<<&A[i]<<endl; //address of first element of array A
		cout<<A+i<<endl; //address of i element of array A		
	}
	cout<<endl;

	int size = sizeof(A)/sizeof(A[0]);

	cout<<"size of array: "<<size<<endl;
	cout<<"sum of elements: "<<sumArray(&A[0], size)<<endl;


	Double(A, size);
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
 
//2D arrays
	int arr[2][3] = {{1,2,3}, {4,5,6}};
	cout<<arr<<endl; //address of first element of arr i.e arr[0][0] //same as &arr[0] or arr[0] or arr[0][0] or *arr
	cout<<arr+1<<endl; //address of 2nd element of arr i.e arr[1][0] //same as &arr[1] or arr[1] or *(arr+1)
	cout<<(arr+1)+2<<endl; //address of  arr[1][2] //same as arr[1]+2
	cout<<*(*(arr+1)+2)<<endl; //value of  arr[1][2] //same as arr[1]+2
	cout<<*(*(arr)+1)<<endl; //2

	//B[i][j] = *(B[i]+j) = *(*(B+i)+j)

//const
	const int* bro = &b; 
	cout<<*bro<<endl;
	//*bro = 17; //it will give error as pointer bro is constant
	cout<<b<<endl;

	return 0;
}