策略模式(Strategy Pattern): 简化复杂业务逻辑实现的一个选项

## 1.场景：
    不通的Instrument对象有不同的计算逻辑，很容易造成太多的 IF-ELSE 判断，实现与维护带来挑战

## 2.解决方案：
    使用策略模式，将不同的计算逻辑封装到不同的策略类中，然后通过上下文类来选择不同的策略类

## 3.实现方式：
    1. 定义Instrument与策略接口
```java
public enum InstrumentType {
    INSTRUMENT_1,
    INSTRUMENT_2,
    // 其他仪器类型
}
```
```java
    public interface CalculateStrategy {
        void calculate();
    }
```
    2. 实现不同的策略实现类
```java
public class CalculateStrategy1 implements CalculateStrategy {
    @Override
    public boolean calculate(String parameters) {
        System.out.println("CalculateStrategy1 Executed. Parameters: " + parameters + ".");
        return true;
    }
}
```
```java
public class CalculateStrategy2 implements CalculateStrategy {
    @Override
    public boolean calculate(String parameters) {
        System.out.println("CalculateStrategy2 Executed, Parameters: " + parameters + ".");
        return true;
    }
}
```
    3. 定义上下文类,在上下文类中装配的策略实现类
```java
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
```
    4. 客户端调用上下文类
```java
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
```
### 4.扩展及维护
若有新的仪器类型，只需要实现新的策略类，并在上下文类中装配即可，不需要修改原有代码，符合开闭原则(OCP，Open Closed Principle)；若要修改某个仪器的计算逻辑，只需要修改对应的策略类即可，不需要修改其他策略类，符合单一职责原则(SRP，Single Responsibility Principle)。
