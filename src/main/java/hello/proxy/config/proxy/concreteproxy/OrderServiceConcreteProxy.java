package hello.proxy.config.proxy.concreteproxy;

import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;

    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null);    // 부모 OrderRepository의 기능을 사용하지 않는 프록시이기 때문에
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        super.orderItem(itemId);
    }
}
