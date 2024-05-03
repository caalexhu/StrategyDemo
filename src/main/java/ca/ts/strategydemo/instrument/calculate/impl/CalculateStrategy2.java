package ca.ts.strategydemo.instrument.calculate.impl;


import ca.ts.strategydemo.instrument.calculate.CalculateStrategy;

/**
 * @author: Alex Hu
 * @createTime: 2024/05/02 21:55
 * @description:
 */
public class CalculateStrategy2 implements CalculateStrategy {
    @Override
    public boolean calculate(String parameters) {
        System.out.println("CalculateStrategy2 Executed, Parameters: " + parameters + ".");
        return true;
    }
}
