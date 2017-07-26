package com.example.studentms.amq.impl;

import com.example.studentms.amq.ProducerService;
import com.example.studentms.controller.StudentController;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class StudentMessageProducerImpl implements ProducerService {
    private static final Logger LOGGER = Logger.getLogger(StudentController.class);
    JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, final String message) {
        LOGGER.debug("发送消息");
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    @Resource
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
