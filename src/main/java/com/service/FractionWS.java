package com.service;

import com.entities.Input;
import com.helper.Gfg;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FractionWS {

    Gfg gfg = new Gfg();

    @GetMapping(path="/health")
    public Mono<String> health() {
        return Mono.just("running");
    }

    @GetMapping(path="/")
    public Mono<String> test() {
        return Mono.just("running");
    }

    @PostMapping(path="/calc")
    public Mono<List<String>> calc(@RequestBody Input input) {
        List<String> result = new ArrayList<>();
        int num1 = input.getNum1();
        int num2 = input.getNum2();
        int deno1 = input.getDeno1();
        int deno2 = input.getDeno2();

        result.add("" + num1 + " / " + deno1 + "   +   " + num2 + " / " + deno2);
        // find multiples of num1 and deno1
        int gcd1 = gfg.reduceFraction(num1, deno1);

        result.add("GCD of " + num1 + " and " + deno1 +" is " + gcd1);
        int gcd2 = gfg.reduceFraction(num2, deno2);
        result.add("GCD of " + num2 + " and " + deno2 +" is " + gcd2);

        result.add("");
        int pnum1 = num1;
        int pdeno1 = deno1;
        num1 = num1 / gcd1;

        deno1 = deno1 / gcd1;
        //result.add("" + pnum1 + " / " + pdeno1 + "  => " + num1 + " / " + deno1);

        int pnum2 = num2;
        int pdeno2 = deno2;
        num2 = num2 / gcd2;
        deno2 = deno2 / gcd2;
        //result.add("" + pnum2 + " / " + pdeno2 + "  => " + num2 + " / " + deno2);


        result.add("" + pnum1 + " / " + pdeno1 + "   +   " + pnum2 + " / " + pdeno2);
        //result.add("=> " + num1 + " / " + deno1 + "   +   " + num2 + " / " + deno2 + "   [GCD of " + pnum1 + " and " + pdeno1 + " is " + gcd1 + " hence " + pnum1 + " / " + pdeno1 + "  = " + num1 + " / " + deno1 + "]");
        result.add("=> " + num1 + " / " + deno1 + "   +   " + num2 + " / " + deno2);

        result.add("=> " + num1 + "*" + deno2 + " / " + deno1 + "*" + deno2 + "   +   " + num2 + "*" + deno1 + " / " + deno1 + "*" + deno2);
        result.add("=> " + num1 * deno2 + " / " + deno1 * deno2 + "   +   " + num2 * deno1 + " / " + deno1 * deno2);


        num1 = num1 * deno2;
        //result.add(num1 + " = " + num1 + " * " + deno2 + " [numerator = numerator1 * denominator2]");
        num2 = num2 * deno1;
        //result.add(num2 + " = " + num2 + " * " + deno1 + " [numerator = numerator2 * denominator1]");

        deno1 = deno1 * deno2;
        //result.add(deno1 + " = " + deno1 + " * " + deno2 + " [denominator1 = denominator1 * denominator2]");
        deno2 = deno1 * deno2;
        //result.add(deno2 + " = " + deno1 + " * " + deno2 + " [denominator2 = denominator1 * denominator2]");

        int num = num1 + num2;
        //result.add("numerator = " + num1 + " + " + num2 + " [numerator = numerator1 + numerator2]");
        int deno = deno1;
        //result.add("denominator = " + deno1 + " [denominator = denominator1 or denominator2]");

        result.add("=> (" + num1 + " + " + num2 + ") / " + deno);
        result.add("=> " + num + " / " + deno);

        int gcd = gfg.reduceFraction(num, deno);
        result.add("");
        result.add("GCD of " + num + " and " + deno + " is " + gcd);
        result.add("Final answer is " + num/gcd + " / " + deno/gcd);
        return Mono.just(result);
    }

   /* public static void main(String[] args) {
        FractionWS s = new FractionWS();
        Random random = new Random();
        int num1 = random.ints(1, 20)
                .findFirst()
                .getAsInt();

        int num2 = random.ints(1, 20)
                .findFirst()
                .getAsInt();

        int deno1 = random.ints(1, 30)
                .findFirst()
                .getAsInt();

        int deno2 = random.ints(1, 30)
                .findFirst()
                .getAsInt();

        List<String> result = s.calc(num1, num2, deno1, deno2, "+");
        result.stream().forEach(System.out::println);
    }*/
}
