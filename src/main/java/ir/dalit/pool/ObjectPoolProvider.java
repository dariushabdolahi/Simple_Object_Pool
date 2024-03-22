package ir.dalit.pool;

import java.util.Objects;

public class ObjectPoolProvider<T> {
    private final ObjectPool<T> objectPool;

    public ObjectPoolProvider(ObjectPoolConfiguration<T> poolConfiguration) {
        this.objectPool = new ObjectPool<>(poolConfiguration);
    }

    public void autoPooling(PoolJob<T> poolJob) {
        T borrow = null;
        try {
            borrow = objectPool.borrow();
            poolJob.doJob(borrow);
        } finally {
            if (Objects.nonNull(borrow)) {
                objectPool.giveBack(borrow);
            }
        }
    }
}
