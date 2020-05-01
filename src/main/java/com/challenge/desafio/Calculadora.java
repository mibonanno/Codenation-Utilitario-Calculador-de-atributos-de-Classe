package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Calculadora {

    @Somar
    private BigDecimal valor1;

    @Somar
    private Integer valor2;

    @Somar
    private BigDecimal valor3;

    @Subtrair
    private BigDecimal valor4;

    public BigDecimal getValor1() {
        return valor1;
    }

    public void setValor1(BigDecimal valor1) {
        this.valor1 = valor1;
    }

    public Integer getValor2() {
        return valor2;
    }

    public void setValor2(Integer valor2) {
        this.valor2 = valor2;
    }

    public BigDecimal getValor3() {
        return valor3;
    }

    public void setValor3(BigDecimal valor3) {
        this.valor3 = valor3;
    }

    public BigDecimal getValor4() {
        return valor4;
    }

    public void setValor4(BigDecimal valor4) {
        this.valor4 = valor4;
    }
}
