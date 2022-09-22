package vnpay.vn.ha;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ConsumerHaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHaApplication.class, args);
    }

}
