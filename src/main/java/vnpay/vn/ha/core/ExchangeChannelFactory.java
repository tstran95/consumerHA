package vnpay.vn.ha.core;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
public class ExchangeChannelFactory {
    private static Channel channel;

    public ExchangeChannelFactory() {
        if (Objects.isNull(channel)) {
            log.info("CREATE NEW CHANNEL");
            ChannelPool channelPool = new ChannelPool();
            channel = channelPool.getChannel();
        }
    }

    public void declareExchange(BuiltinExchangeType exchangeType, String... exchangeNames) throws IOException {
        log.info("method declareExchange() START with exchangeNames {}", (Object) exchangeNames);
        for (String exchangeName : exchangeNames) {
            // exchangeDeclare( exchange, builtinExchangeType, durable)
            channel.exchangeDeclare(exchangeName, exchangeType, true);
        }
        log.info("method declareExchange() END");
    }


    public void declareQueues(String... queueNames) throws IOException {
        log.info("method declareQueues() START with queueNames {}", (Object) queueNames);
        for (String queueName : queueNames) {
            // queueDeclare  - (queueName, durable, exclusive, autoDelete, arguments)
            channel.queueDeclare(queueName, true, false, false, null);
        }
        log.info("method declareQueues() END");
    }

    public void performQueueBinding(String exchangeName, String queueName, String routingKey) throws IOException {
        // Create bindings - (queue, exchange, routingKey)
        channel.queueBind(queueName, exchangeName, routingKey);
    }

    public String subscribeMessage(String queueName) throws IOException {
        log.info("method subscribeMessage() START with queueName {}", queueName);
//        final String[] result = {""};
        // basicConsume - ( queue, autoAck, deliverCallback, cancelCallback)
        channel.basicConsume(queueName, true, ((consumerTag, message) -> {
//            result[0] = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println(1234);
            writeFile(message.getBody());
            log.info("method subscribeMessage() RUNNING with message {}", new String(message.getBody(), StandardCharsets.UTF_8));
        }), consumerTag -> {
        });
        log.info("method subscribeMessage() END");
        return "OK";
    }

    public void publishMessage(String exchangeName, String message, String routingKey) throws IOException {
        log.info("method publishMessage() START with message {}", message);
        // basicPublish - ( exchange, routingKey, basicProperties, body)
        channel.basicPublish(exchangeName, routingKey, null, message.getBytes());
        log.info("method publishMessage()  [Send] routing-key {} with message {} ", routingKey, message);
        log.info("method publishMessage() END with message {}", message);
    }

    private void writeFile(byte[] data) {
        try {
            Path file = Paths.get("data-file");
            Files.write(file, data , StandardOpenOption.APPEND);
        }catch (Exception e) {
            throw new RuntimeException("IO Exception");
        }
    }
}
