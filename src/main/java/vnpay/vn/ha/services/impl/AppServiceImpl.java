package vnpay.vn.ha.services.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vnpay.vn.ha.services.AppService;

/**
 * @author sontt1
 * Date:9/20/2022
 * Time:3:51 PM
 */
@Component
public class AppServiceImpl implements AppService {
    private String message;

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
    public void receiveMessage(String message) {
        this.message = message;
    }

    @Override
    public String receiveMessage() {
        return message;
    }
}
