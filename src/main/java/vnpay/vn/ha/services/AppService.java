package vnpay.vn.ha.services;

import org.springframework.amqp.core.Message;

/**
 * @author sontt1
 * Date:9/20/2022
 * Time:3:50 PM
 */
public interface AppService {
    String receiveMessage();
}
