package ir.dalit.pool;

import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ObjectPool<T> {
    private final ObjectPoolConfiguration<T> poolConfiguration;
    private final ConcurrentLinkedQueue<T> objectPoolQueue;

    public ObjectPool(ObjectPoolConfiguration<T> poolConfiguration) {
        this.poolConfiguration = poolConfiguration;
        this.objectPoolQueue = new ConcurrentLinkedQueue<>();
        configure(poolConfiguration.getPoolSize());
    }

    public T borrow() {
        T poll = objectPoolQueue.poll();
        if (Objects.nonNull(poll)) {
            return poll;
        } else {
            pleaseWait();
        }
        return borrow();
    }

    public void pleaseWait() {
        try {
            Thread.sleep(poolConfiguration.getProvidingInstanceWait());
        } catch (InterruptedException ignore) {}
    }

    private void configure(int end) {
        for (int i = 0; i < end; i++) {
            T instance = poolConfiguration.getPoolFactory().create();
            objectPoolQueue.offer(instance);
        }
    }

    public void giveBack(T pooledInstance) {
        poolConfiguration.getPoolFactory().refresh(pooledInstance);
        objectPoolQueue.offer(pooledInstance);
    }
}
