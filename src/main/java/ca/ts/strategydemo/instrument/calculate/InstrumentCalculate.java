package ca.ts.strategydemo.instrument.calculate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Alex Hu
 * @createTime: 2024/05/02 21:59
 * @description:
 */
@Component
public class InstrumentCalculate {
    /**
     * 通过构造方法注入所有的策略类
     */
    private List<CalculateStrategy> strategyList;

    @Autowired
    public InstrumentCalculate(List<CalculateStrategy> strategyList) {
        this.strategyList = strategyList;
    }

    public boolean Calculate(String parameters, InstrumentType instrumentType) {
        // 如果策略列表为空，直接返回false
        if (this.strategyList == null || this.strategyList.isEmpty()) {
            return false;
        }
        // 遍历策略列表，找到支持当前类型的策略类，调用其calculate方法
        for (CalculateStrategy strategy : this.strategyList) {
            if (strategy.support(instrumentType)) {
                return strategy.calculate(parameters);
            }
        }
        return false;
    }
}
