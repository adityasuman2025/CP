#include <iostream>
using namespace std;

int main() 
{
	//code
	int num;
	cin>>num;
	
	while(num--)
	{
	    int m,n;
	    cin>>m>>n;
	    int R[m] = {0};
	    int C[n] = {0};
	    
	    int x;
	    for(int i=0; i<m; i++)
	    {
	        for(int j=0; j<n; j++)
	        {
	            cin>>x;
	            if(x==1)
	            {
	                R[i] = 1;
	                C[j] = 1;
	            }
	        }
	    }
	    
	    for(int i=0; i<m; i++)
	    {
	        for(int j=0; j<n; j++)
	        {
	            if(R[i] || C[j])
	                cout<<1<<" ";
	            else
	                cout<<0<<" ";
	        }
	        cout<<"\n";
	    }
	}
	
	return 0;
}