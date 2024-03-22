package ir.dalit.pool;

public interface PoolJob<T> {
    void doJob(T t);
}
