package org.jun.exception;

public class AsyncException extends ContextException {

    private final String threadName;

    public AsyncException(Throwable ex, String threadName) {
        super(Type.ASYNC_EXCEPTION, ex);
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }
}
