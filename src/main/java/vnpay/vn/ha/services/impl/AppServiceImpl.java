package vnpay.vn.ha.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import vnpay.vn.ha.constant.Constant;
import vnpay.vn.ha.services.AppService;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author sontt1
 * Date:9/20/2022
 * Time:3:51 PM
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class AppServiceImpl implements AppService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public String receiveMessage() {
        log.info("Method receiveMessage() START");
        String result = new String(Objects.requireNonNull(rabbitTemplate.receive(Constant.QUEUE)).getBody(),
                StandardCharsets.UTF_8);
        log.info("Method receiveMessage() END with result {} " , result);
        return result;
    }
}
