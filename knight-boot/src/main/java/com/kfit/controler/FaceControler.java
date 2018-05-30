package com.kfit.controler;

import cn.com.reformer.netty.communication.CarLockTcpMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/5/29/029.
 */
@Controller
@RequestMapping("/c")
public class FaceControler {
    @Autowired
    private CarLockTcpMessageSender carLockTcpMessageSender;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @RequestMapping(name = "/face", method = {RequestMethod.GET})
    public String face( String sn, Integer num) {
        carLockTcpMessageSender.face(sn,num);
        return "open success";
    }

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String hello() {
       // carLockTcpMessageSender.face(sn,num);
        return "open success";
    }
}
