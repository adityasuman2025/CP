#include <bits/stdc++.h>
using namespace std;
typedef long long int lli;
const lli N=100005;
lli a[N];
int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);cout.tie(NULL);
    lli t,n,k;
    cin>>t;
    while(t--){
        lli ans=0;
        lli pr=1;
        cin>>n>>k;
        for(lli i=0;i<n;i++) cin>>a[i];

        lli st=0;
        for(lli i=0;i<n;i++)
        {
            pr*=a[i];
            if(pr>=k)
            {
                while(pr>=k)
                {
                    ans+=i-st;
                    pr/=a[st];
                    st++;
                }
            }
        }

        if(pr>=1)
        {
            lli r=n-st;
            ans+=(r*(r+1))/2;
        }

        cout<<ans<<endl;
    }
}