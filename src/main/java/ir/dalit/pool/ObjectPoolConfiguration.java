package ir.dalit.pool;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class ObjectPoolConfiguration<T> {
    private int poolSize;
    private int providingInstanceWait;
    private PoolFactory<T> poolFactory;
}
