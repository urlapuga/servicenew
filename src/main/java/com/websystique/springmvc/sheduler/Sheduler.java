package com.websystique.springmvc.sheduler;

import com.websystique.springmvc.actionproducer.MailProducer;
import com.websystique.springmvc.actionproducer.PingProducer;
import com.websystique.springmvc.model.Pinger;
import com.websystique.springmvc.service.PingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sheduler {

    @Autowired
    private PingerService pingerService;

    @Scheduled(fixedDelay = 1000000)
    public void doPing() {

        List<Pinger> pingers = pingerService.findAll();
        for(Pinger p:pingers){
            boolean pingResult = PingProducer.ping(p.getIp());
            String out = pingResult?"up":"down";
            if(pingResult!=p.pinged()){
                p.setStatus(pingResult?1:0);
                pingerService.update(p);
                MailProducer.send("urlapuga1@mail.ru","pinger",p.getIp()+
                        " " + out);

            }
        }
    }
}
