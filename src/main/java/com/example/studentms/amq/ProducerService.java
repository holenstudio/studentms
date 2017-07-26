package com.example.studentms.amq;

import javax.jms.Destination;

public interface ProducerService {
    void sendMessage(Destination destination, String message);
}
