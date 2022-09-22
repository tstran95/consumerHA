package vnpay.vn.ha.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vnpay.vn.ha.consumer.DirectExchangeConsumer;
import vnpay.vn.ha.producer.DirectExchangeProducer;
import vnpay.vn.ha.response.ResponseApp;
import vnpay.vn.ha.services.AppService;

/**
 * @author sontt1
 * Date:9/20/2022
 * Time:3:31 PM
 */
@RestController
@RequestMapping("/api/v1/cons")
@Slf4j
public class AppController {
    private final AppService appService;

    private final DirectExchangeConsumer exchangeConsumer;

    public AppController(AppService appService, DirectExchangeConsumer exchangeConsumer) {
        this.appService = appService;
        this.exchangeConsumer = exchangeConsumer;
    }

    @PostMapping
    public ResponseApp receiveMessage() {
        ResponseApp responseApp;
        try {
            log.info("Method receiveMessage() START");
//            exchangeConsumer.start();
//            String message = exchangeConsumer.subscribe();
//            String message = appService.receiveMessage();
            responseApp = ResponseApp.builder()
                    .code("00")
                    .message("message")
                    .description("SUCCESS")
                    .build();
            log.info("Method receiveMessage() END with response {}" , responseApp);
        }catch (Exception e) {
            responseApp = ResponseApp.builder()
                    .code("01")
                    .message(e.getMessage())
                    .description("FAIL")
                    .build();
            log.info("Method receiveMessage() ERROR with message" , e);
        }
        return responseApp;
    }
}
