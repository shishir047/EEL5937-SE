package io.github.shishir;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
         long ccNo = 4160211504265175L; 
          main.validate(ccNo); 
    }
    public void validate(long num) {
        long length = (long) (Math.log10(num) + 1);
        if(length<13 || length>16){
            System.out.println("Invalid Credit Card");
        }else{
            long n = (long) (num/(Math.pow(10,length-1)));
            long m = (long) (num/(Math.pow(10,length-2)));
            if(n==4 || n==5 || n==6 || m==37){
                long reversed = 0;
                long x = num;
                while(x != 0) {
                    long digit = x % 10;
                    reversed = reversed * 10 + digit;
                    x /= 10;
                }
                long so = 0;
                for(long i=length-1; i>=0; i-=2 ){
                    long d = (long) (reversed/(Math.pow(10,i)));

                    so = so + d%10;


                }
                long se = 0;
                for(long i=length-2; i>=0; i-=2 ){
                    long e = (long) (reversed/(Math.pow(10,i)));
                    if((e%10)>=5){
                        se = se + ((e%10)*2)%10 + 1;
                    }else {
                        se = se + ((e % 10)*2);
                    }
                }
                if(((se+so)%10) == 0){
                    System.out.println("Yes");
                } else{
                    System.out.println("No");
                }
            }
        }
    }
}

