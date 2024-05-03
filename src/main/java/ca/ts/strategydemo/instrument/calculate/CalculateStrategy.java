package ca.terrasoft.strategydemo.instrument.calculate;

/**
 * @author: Alex Hu
 * @createTime: 2024/05/02 21:52
 * @description:
 */
public interface CalculateStrategy {
    /**
     * calculate
     * @param parameters 参数
     * @return 计算结果
     */
    boolean calculate(String parameters);
}
