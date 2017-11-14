package com.websystique.springmvc.actionproducer;

import com.websystique.springmvc.model.Devices;
import com.websystique.springmvc.model.SubscriberTarifs;
import com.websystique.springmvc.model.Subscribers;
import com.websystique.springmvc.model.Subscribertarifsview;
import com.websystique.springmvc.service.DevicesService;
import com.websystique.springmvc.service.SubscriberHasTarifsService;
import com.websystique.springmvc.service.SubscriberTarifsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShapeProducer {
    @Autowired
    private static SubscriberTarifsService subscriberTarifsService;

    @Autowired
    private static SubscriberHasTarifsService subscriberHasTarifsService;
    @Autowired
    private static DevicesService devicesService;

     public static void shape(Subscribers subscribers) {
        List<Subscribertarifsview> subscriberTarifs = subscriberTarifsService.getBySubscriber(subscribers.getId());
        subscriberTarifs.forEach(st -> configureTarif(st));
    }

    public static void configureTarif(Subscribertarifsview subscribertarifsview) {
        Devices devices = devicesService.getById(subscribertarifsview.getDevice());
        SshProducer sshProducer = new SshProducer(devices.getIpaddress(), devices.getLogin(), devices.getPassword());


        if (subscribertarifsview.getActive() == 0) {
            sshProducer.disablePort(subscribertarifsview.getPort());

        } else {
            sshProducer.shape(subscribertarifsview.getSpeed(),subscribertarifsview.getPort());
        }

    }
}
