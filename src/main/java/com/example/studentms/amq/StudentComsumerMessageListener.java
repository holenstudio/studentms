package com.example.studentms.amq;

import com.example.studentms.controller.StudentController;
import org.apache.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class StudentComsumerMessageListener implements MessageListener {
    private static final Logger LOGGER = Logger.getLogger(StudentController.class);

    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            LOGGER.debug("接收到消息：" + msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
