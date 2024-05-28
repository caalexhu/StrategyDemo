package ca.ts.strategydemo.instrument.calculate;

/**
 * @author: Alex Hu
 * @createTime: 2024/05/02 21:52
 * @description:
 */
public interface CalculateStrategy {
    /**
     * support 判断是否支持
     * @param type 类型
     * @return
     */
    boolean support(InstrumentType type);

    /**
     * calculate
     * @param parameters 参数
     * @return 计算结果
     */
    boolean calculate(String parameters);
}
