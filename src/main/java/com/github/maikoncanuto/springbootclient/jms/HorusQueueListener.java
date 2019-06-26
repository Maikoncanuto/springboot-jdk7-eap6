package com.github.maikoncanuto.springbootclient.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class HorusQueueListener {

    @JmsListener(destination = "queueHorus", containerFactory = "factoryJms")
    public void onMessage(){
       System.out.println("Teste");
    }

}
