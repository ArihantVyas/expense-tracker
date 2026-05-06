package com.arihant.expense_tracker.config;

import org.springframework.boot.web.server.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ServerPortLogger{

    int port;

    @EventListener
    public void onStartup(WebServerInitializedEvent event){
        this.port = event.getWebServer().getPort();
    }

    public int getPort(){
        return this.port;
    }
}
