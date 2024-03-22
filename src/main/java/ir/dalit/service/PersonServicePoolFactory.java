package ir.dalit.service;

import ir.dalit.pool.PoolFactory;

public class PersonServicePoolFactory implements PoolFactory<PersonService> {

    @Override
    public PersonService create() {
        return new PersonService();
    }

    @Override
    public void refresh(PersonService personService) {
        personService.setServiceProvider(null);
    }
}
