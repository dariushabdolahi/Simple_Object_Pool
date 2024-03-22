package ir.dalit.pool;

import java.util.concurrent.atomic.AtomicBoolean;
public class PooledInstance<T> {
    private AtomicBoolean inUse = new AtomicBoolean(false);
    private T instance;

    public PooledInstance<T> setInstance(T instance) {
        this.instance = instance;
        return this;
    }

    public T getInstance() {
        return instance;
    }

    public PooledInstance<T> setInUse(boolean inUse) {
        this.inUse.set(inUse);
        return this;
    }

    public AtomicBoolean getInUse() {
        return inUse;
    }
}
