class Solution {
public:
    int modu=1000000007;
    bool is_prime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    long long moduloMultiplication(long long a,
                            long long b,
                            long long mod){
    long long res = 0;
    a %= mod;

    while (b)
    {
        if (b & 1)
            res = (res + a) % mod;
        a = (2 * a) % mod;
        b >>= 1;
    }
 
    return res;
}
    int numPrimeArrangements(int n) {
        int pn=0;
        for(int i=2;i<=n;i++){
            if(is_prime(i)){
                pn++;
            }
        }
        int npn=n-pn;
        //cout<<pn<<" "<<npn;
        long long int ans1=1,ans2=1;
        while(npn>1){
            ans1=moduloMultiplication(ans1,npn,modu);
            //cout<<ans1<<endl;
            npn--;
        }
        while(pn>1){
            ans2=moduloMultiplication(ans2,pn,modu);
            pn--;
        }
       // cout<<ans1<<" "<<ans2;
        int result=moduloMultiplication(ans1,ans2,modu);
        return result;
    }
};