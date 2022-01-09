package hello.proxy.config.proxy.concreteproxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;

    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
        super(null);    // 부모 OrderControllerV2의 기능을 사용하지 않는 프록시이기 때문
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderController.request()");

            // target 호출
            String result = target.request(itemId);

            logTrace.end(status);

            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);

            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
