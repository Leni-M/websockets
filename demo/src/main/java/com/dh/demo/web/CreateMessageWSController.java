package com.dh.demo.web;

import com.dh.demo.modelws.Greeting;
import com.dh.demo.modelws.HelloMessage;
import com.dh.demo.modelws.Notification;
import com.dh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Created by jhonny on 6/17/17.
 */
@Controller
//controller for WS: !=HTTP
public class CreateMessageWSController {
    @Autowired
    UserService userService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    // full path /app/hello
    //for WS:(websockets)
    //localhost:8080/app/hello
    @MessageMapping("/hello")
    //for http: (http verbs)
    //@MessageMapping("/hello")

    // broadcast
    //@SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        //slack channel /topic/greetings --broadcast
        simpMessagingTemplate.convertAndSend("/topic/greetings", new Greeting("Hello, static " + message.getName() + "!"));
        //simpMessagingTemplate.convertAndSend("/topic/greetings", new Greeting("Hello, static " + message.getName() + "!"));
        return new Greeting("Hello,<hi> " + message.getName() + "!");
        //userService.addUser();

    }
    // broadcast
    //@SendTo("/topic/notifications")
    public Greeting greeting(Notification notification) throws Exception {
        Thread.sleep(1000); // simulated delay
        //slack channel /topic/greetings --broadcast
        simpMessagingTemplate.convertAndSend("/topic/notifications", new Greeting("Hello, static " + notification.getTextoContent() + "!"));
        //simpMessagingTemplate.convertAndSend("/topic/greetings", new Greeting("Hello, static " + message.getName() + "!"));
        return new Greeting("Hello,<hi> " + notification.getTextoContent() + "!");
        //userService.addUser();

    }

}
