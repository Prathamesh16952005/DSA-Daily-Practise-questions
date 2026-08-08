class Solution {
    public int smallestNumber(int n, int t) {
        while (true){
            int num = n;
            int Product = 1;

            while(num> 0){
                int digit = num%10;
                Product *=digit;
                num/=10;
             }
            if(Product%t==0){
                return n;
            }
            n++;              
        }

    }
}