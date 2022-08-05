package com.helper;

// Java program to reduce a fraction x/y to its lowest form
public class Gfg {

    // Function to reduce a fraction to its lowest form
    public int reduceFraction(int x, int y) {
        int d;
        d = __gcd(x, y);

        x = x / d;
        y = y / d;

        return d;
    }

    public int __gcd(int a, int b) {
        if (b == 0)
            return a;
        return __gcd(b, a % b);

    }
}

