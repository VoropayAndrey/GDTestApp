package com.hardway.gdtest;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;




public class PrimeChecker {
    static final String EXPECTED_RESULT = "2\n2 \n2 3\n2 3 5";

    class Prime {
        public String checkPrime(Integer... numbers) {

            String output = "";
            for(Integer number:numbers) {
                if (number > 1) {
                    if(number > 2) {
                        for (int i = 2; i < number; ++i) {
                            if (number % i == 0) {
                                output += ' ';
                            } else {
                                output += number;
                            }
                            break;
                        }
                    } else {
                        output += number;
                    }
                } else {
                    output += ' ';
                }
            }
            return output;
        }
    }

    @Test
    public void test() {
        String result = "";
        try{

            int n1=2;
            int n2=1;
            int n3=3;
            int n4=4;
            int n5=5;

            Prime ob = new Prime();
            result += ob.checkPrime(n1) + "\n";
            result += ob.checkPrime(n1,n2) + "\n";
            result += ob.checkPrime(n1,n2,n3) + "\n";
            result += ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        Assert.assertEquals(EXPECTED_RESULT, result);
    }
}
