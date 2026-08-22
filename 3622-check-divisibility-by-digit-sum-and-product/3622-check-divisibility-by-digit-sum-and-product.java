class Solution {
    public boolean checkDivisibility(int n) {
        
        int num = n;
        int sumOfDigit = 0;
        long prodOfDigit = 1L;

        while(num > 0){
            int digit = num % 10;
            sumOfDigit += digit;
            prodOfDigit = (prodOfDigit * digit);
            num = num / 10;
        }

        return (n % (sumOfDigit + prodOfDigit)) == 0 ? true : false;
    }
}