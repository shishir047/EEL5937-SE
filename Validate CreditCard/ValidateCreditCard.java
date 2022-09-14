package io.github.shishir;

class ValidateCreditCard implements Validator{

    @Override
    public void validate(long num) {

        long length = (long) (Math.log10(num) + 1); // getting length of credit card
        if(length<13 || length>16){ // length of credit card number should be in between 13 and 16 (both inclusive)
            System.out.println("This is invalid credit card number");
        }else{
            long n = (long) (num/(Math.pow(10,length-1))); // getting initial digit of credit card
            long m = (long) (num/(Math.pow(10,length-2)));
            if(n==4 || n==5 || n==6 || m==37){ // validating initial digit of credit card
                long reversedCCNo = reversed(num);
                long se = sumOfOdd(reversedCCNo);
                long so = sumOfEven(reversedCCNo);
                if(((se+so)%10) == 0){ // validating if the given credit card is a valid number.
                    System.out.println("This is a valid credit card number");
                } else{
                    System.out.println("This is invalid credit card number");
                }
            } else{
                System.out.println("This is invalid credit card number");
            }
        }
    }
    public long reversed(long num){ // reversing the credit card number
        long rev = 0;
        long x = num;
        while(x != 0) {
            long digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return rev;
    }
    public long sumOfOdd(long rev){ // sum of even digits from the right of credit card by reversing the number and counting from left
        long so = 0;
        long length = (long) (Math.log10(rev) + 1); // getting the length of the Credit Card number
        for(long i=length-1; i>=0; i-=2 ){ // looping to add every odd place digit
            long d = (long) (rev/(Math.pow(10,i))); //getting desired digit to the left.
            so = so + d%10; // adding up last digit which is desired to variable so.
        }
        return so;
    }
    public long sumOfEven(long rev){ // sum of even place digits from the right of credit card by reversing the number and counting from left
        long se = 0;
        long length = (long) (Math.log10(rev) + 1); // getting the length of the Credit Card number
        for(long i=length-2; i>=0; i-=2 ){  // looping to add doubles of every even place digit
            long e = (long) (rev/(Math.pow(10,i))); //getting desired digit to the left.
            if((e%10)>=5){
                se = se + ((e%10)*2)%10 + 1; // if the double of digit is in 2 digits then adding up the digit together to make single digit.
            }else {
                se = se + ((e % 10)*2); // if its single digit after doubling, then add them to variable se.
            }
        }
        return se;
    }
}
