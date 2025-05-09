package org.jun.exception;

public class AsyncExceptionInfo extends ContextExceptionInfo {

    private final String threadName;

    public AsyncExceptionInfo(Throwable ex, String threadName) {
        super(Type.ASYNC_EXCEPTION, ex, "NO_URI");
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }
}
