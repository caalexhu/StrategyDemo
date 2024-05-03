package ca.ts.strategydemo;

import ca.ts.strategydemo.instrument.calculate.InstrumentCalculate;
import ca.ts.strategydemo.instrument.calculate.InstrumentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: Alex Hu
 * @createTime: 2024/05/02 22:06
 * @description:
 */
@SpringBootTest
public class InstrumentCalculateTest {
    @Autowired
    private InstrumentCalculate instrumentCalculate;

    @Test
    public void testInstrumentCalculate() {
        // 创建要计算的参数
        String parameters = "I‘m a parameter.";
        // 定义仪器类型
        //InstrumentType instrumentType = InstrumentType.INSTRUMENT_1; //直接枚举值
        InstrumentType instrumentType = InstrumentType.valueOf("INSTRUMENT_1"); //通过枚举值字符串获取枚举值
        // 调用计算方法
        boolean isOk = instrumentCalculate.Calculate(parameters, instrumentType);
        assertTrue(isOk);

    }
}
