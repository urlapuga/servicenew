package com.websystique.springmvc.sheduler;

import com.websystique.springmvc.actionproducer.MailProducer;
import com.websystique.springmvc.actionproducer.PingProducer;
import com.websystique.springmvc.actionproducer.ShapeProducer;
import com.websystique.springmvc.model.Idbalancecost;
import com.websystique.springmvc.model.Pinger;
import com.websystique.springmvc.model.SubscriberTarifs;
import com.websystique.springmvc.model.Subscribers;
import com.websystique.springmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sheduler {

    @Autowired
    private PingerService pingerService;

    @Autowired
    private IdBalanceCostService idBalanceCostService;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    SubscriberHasTarifsService subscriberHasTarifsService;


    //PINGER
   // @Scheduled(fixedDelay = 1000000)
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

    public void paymentsToSubscriber(){

    }

    public void disableDebtors(){
        List<Idbalancecost> idbalancecostList = idBalanceCostService.findAll();
        idbalancecostList.forEach(idb->checkBalance(idb));
    }


    public void checkBalance(Idbalancecost idbalancecost){
        double resultBalance = idbalancecost.getBalance()-idbalancecost.getCost();
        Subscribers subscribers = subscriberService.getById(idbalancecost.getId());
        if(resultBalance<0){

            List<SubscriberTarifs> subscriberTarifsList = subscriberHasTarifsService.getBySubscriber(subscribers.getId());
            subscriberTarifsList.forEach(st->disableAndUpdate(st));
            ShapeProducer.shape(subscribers);
            subscribers.setStatus(0);
        }
        else{
            subscribers.setBalance(resultBalance);
        }
        subscriberService.update(subscribers);
    }

    private void disableAndUpdate(SubscriberTarifs tarif){
        tarif.setActive(0);
        subscriberHasTarifsService.update(tarif);
    }
}
