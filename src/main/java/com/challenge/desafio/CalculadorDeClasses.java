package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;


public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object object) {
        return this.findAnnotation(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return this.findAnnotation(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }


    private BigDecimal findAnnotation(Object object, Class nomeAnnotation){

        if(!this.temAnnotation(object)){
            return BigDecimal.ZERO;
        }

        BigDecimal soma = BigDecimal.ZERO;
        Field[] fields = object.getClass().getDeclaredFields();

        for(Field field: fields){
            try {
                if (field.getType().getName().contains("BigDecimal") & field.getDeclaredAnnotation(nomeAnnotation) != null) {

                    Method[] methods = object.getClass().getDeclaredMethods();
                    for(Method method : methods){
                        if(method.getName().toUpperCase().equals("GET"+field.getName().toUpperCase()) ){
                            BigDecimal valor = (BigDecimal) method.invoke(object);
                            soma = soma.add(valor);
                        }
                    }
                }else{
                    soma = soma.add(BigDecimal.ZERO);
                }
            }catch( IllegalAccessException| InvocationTargetException e){
                e.printStackTrace();
            }
        }
        return soma;
    }

    private boolean temAnnotation(Object object){

        Field[] fields = object.getClass().getDeclaredFields();

        for(Field field: fields){
            if(field.getDeclaredAnnotations().length > 0){
                return true;
            }
        }

        return false;
    }
}
