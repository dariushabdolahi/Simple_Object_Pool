package ir.dalit.pool;

public interface PoolFactory<T> {
     T create();
     void refresh(T t);
}
