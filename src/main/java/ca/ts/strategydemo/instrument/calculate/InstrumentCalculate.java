package ca.ts.strategydemo.instrument.calculate;

import ca.ts.strategydemo.instrument.calculate.impl.CalculateStrategy1;
import ca.ts.strategydemo.instrument.calculate.impl.CalculateStrategy2;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Alex Hu
 * @createTime: 2024/05/02 21:59
 * @description:
 */
@Component
public class InstrumentCalculate {
    private Map<InstrumentType, CalculateStrategy>  strategyMap = new HashMap<>();

    /**
     * 构造函数,装配仪器与对应的计算策略
     */
    public InstrumentCalculate() {
        this.strategyMap.put(InstrumentType.INSTRUMENT_1, new CalculateStrategy1());
        this.strategyMap.put(InstrumentType.INSTRUMENT_2, new CalculateStrategy2());
        // 其他仪器类型
    }

    public boolean Calculate(String parameters, InstrumentType instrumentType) {
        CalculateStrategy strategy = strategyMap.get(instrumentType);
        if (strategy == null) {
            throw new IllegalArgumentException("No calculate strategy found for instrument type: " + instrumentType);
        }
        return strategy.calculate(parameters);
    }
}
