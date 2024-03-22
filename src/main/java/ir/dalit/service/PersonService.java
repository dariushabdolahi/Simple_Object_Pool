package ir.dalit.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonService {
    private String serviceProvider;
    public void callProvider(){
        System.out.println("provider : "+serviceProvider+" - "+Thread.currentThread().getName());
    }
}
