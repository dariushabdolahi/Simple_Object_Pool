package ir.dalit;

import ir.dalit.pool.ObjectPoolConfiguration;
import ir.dalit.pool.ObjectPoolProvider;
import ir.dalit.pool.PoolFactory;
import ir.dalit.service.PersonService;
import ir.dalit.service.PersonServicePoolFactory;

public class Main {
    public static void main(String[] args) {

        PoolFactory<PersonService> personPoolFactory = new PersonServicePoolFactory();
        ObjectPoolConfiguration<PersonService> poolConfiguration = new ObjectPoolConfiguration<PersonService>()
                .setPoolSize(1)
                .setProvidingInstanceWait(10)
                .setPoolFactory(personPoolFactory);
        ObjectPoolProvider<PersonService> objectPoolProvider = new ObjectPoolProvider<>(poolConfiguration);

        objectPoolProvider.autoPooling(personService -> {
            personService.setServiceProvider(Thread.currentThread().getName());
            personService.callProvider();
        });
    }
}
