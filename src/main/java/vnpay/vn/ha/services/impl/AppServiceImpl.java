package vnpay.vn.ha.services.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vnpay.vn.ha.services.AppService;

import java.util.List;

/**
 * @author sontt1
 * Date:9/20/2022
 * Time:3:51 PM
 */
@Component
public class AppServiceImpl implements AppService {
    private List<String> messages;

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
    public void receiveMessage(List<String> message) {
        this.messages = message;
    }

    @Override
    public String receiveMessage() {
        return messages.toString();
    }
}
