package ca.terrasoft.strategydemo.instrument.calculate.impl;


import ca.terrasoft.strategydemo.instrument.calculate.CalculateStrategy;

/**
 * @author: Alex Hu
 * @createTime: 2024/05/02 21:54
 * @description:
 */
public class CalculateStrategy1 implements CalculateStrategy {
    @Override
    public boolean calculate(String parameters) {
        System.out.println("CalculateStrategy1 Executed. Parameters: " + parameters + ".");
        return true;
    }
}
