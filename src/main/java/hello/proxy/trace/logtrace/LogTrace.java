package hello.proxy.trace.logtrace;

import hello.advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String meassage);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
