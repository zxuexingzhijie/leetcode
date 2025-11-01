public class StrategyExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new AlipayStrategy());
        context.pay(100);

        context.setStrategy(new WeChatPayStrategy());
        context.pay(200);

        context.setStrategy(new CreditCardStrategy());
        context.pay(300);
    }
}


// 策略接口
interface PaymentStrategy {
    void pay(int amount);
}

// 具体策略：使用支付宝支付
class AlipayStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("使用支付宝支付 " + amount + " 元");
    }
}

// 具体策略：使用微信支付
class WeChatPayStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("使用微信支付 " + amount + " 元");
    }
}

// 具体策略：使用信用卡支付
class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("使用信用卡支付 " + amount + " 元");
    }
}

// 上下文类
class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(int amount) {
        if (strategy == null) {
            throw new IllegalStateException("未设置支付策略！");
        }
        strategy.pay(amount);
    }
}

