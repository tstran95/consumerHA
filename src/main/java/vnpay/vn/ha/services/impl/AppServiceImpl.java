package vnpay.vn.ha.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import vnpay.vn.ha.services.AppService;

import java.util.Objects;

/**
 * @author sontt1
 * Date:9/20/2022
 * Time:3:51 PM
 */
@Component
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {
//    private String message;

    //    @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
//    public void receiveMessage(Message message) {
//        this.message = message.toString();
//    }
    private final RabbitTemplate rabbitTemplate;

    @Override
    public String receiveMessage() {
        return Objects.requireNonNull(rabbitTemplate.receiveAndConvert("custom.myqueue1")).toString();
    }
}
