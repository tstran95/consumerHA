package vnpay.vn.ha.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sontt1
 * Date:9/22/2022
 * Time:11:27 AM
 */
@Component
@Slf4j
public class RabbitMQReceiver implements RabbitListenerConfigurer {
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(List<Message> lstMessage) {
        log.info("Method receivedMessage() START with message {}" , lstMessage);
        byte[] data = lstMessage.toString().getBytes();
        writeFile(data);
        log.info("List message {}" , lstMessage);
        log.info("Method receivedMessage() END");
    }

    private void writeFile(byte[] data) {
        try {
            Path file = Paths.get("data-file");
            Files.write(file, data , StandardOpenOption.APPEND);
        }catch (Exception e) {
            throw new RuntimeException("IO Exception");
        }
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
