package ca.ts.strategydemo.instrument.calculate.impl;


import ca.ts.strategydemo.instrument.calculate.CalculateStrategy;
import ca.ts.strategydemo.instrument.calculate.InstrumentType;
import org.springframework.stereotype.Service;

/**
 * @author: Alex Hu
 * @createTime: 2024/05/02 21:55
 * @description:
 */
@Service
public class CalculateStrategy3 implements CalculateStrategy {
    @Override
    public boolean support(InstrumentType type) {
        return (InstrumentType.INSTRUMENT_3).equals(type);
    }

    @Override
    public boolean calculate(String parameters) {
        System.out.println("CalculateStrategy3 Executed, Parameters: " + parameters + ".");
        return true;
    }
}
