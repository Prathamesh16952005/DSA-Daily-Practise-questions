class Solution {
    public boolean checkDivisibility(int n) {
    int temp = n;
    int digs= 0;
    int digp =1;

    while(temp>0){
        int d = temp% 10;
        digs+=d;
        digp*=d;

        temp/=10;

    }

    int t = digs +digp;

    return n% t==0;


    }
}