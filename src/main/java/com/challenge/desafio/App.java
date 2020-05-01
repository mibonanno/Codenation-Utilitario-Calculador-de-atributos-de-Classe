package com.challenge.desafio;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args){

        Calculadora calculadora = new Calculadora();
        calculadora.setValor1(BigDecimal.valueOf(10));
        calculadora.setValor2(10);
        calculadora.setValor3(BigDecimal.valueOf(15));
        calculadora.setValor4(BigDecimal.valueOf(20));


        CalculadorDeClasses calculadorDeClasses = new CalculadorDeClasses();

        System.out.println(calculadorDeClasses.somar(calculadora));
        System.out.println(calculadorDeClasses.subtrair(calculadora));
        System.out.println("------------------");
        System.out.println(calculadorDeClasses.totalizar(calculadora));


    }
}

