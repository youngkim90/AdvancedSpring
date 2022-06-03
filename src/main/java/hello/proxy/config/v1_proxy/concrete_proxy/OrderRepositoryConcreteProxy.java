package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.proxy.app.v2.OrderRepositoryV2;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace trace) {
        this.target = target;
        this.logTrace = trace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.orderItem()");
            target.save(itemId);
            logTrace.end(status);
        } catch(Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
