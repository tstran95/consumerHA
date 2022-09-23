package vnpay.vn.ha.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vnpay.vn.ha.constant.Constant;
import vnpay.vn.ha.consumer.DirectExchangeConsumer;
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

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping
    public ResponseApp receiveMessage() {
        ResponseApp responseApp;
        try {
            log.info("Method receiveMessage() START");
            String message = appService.receiveMessage();
            responseApp = ResponseApp.builder()
                    .code(Constant.SUCCESS_CODE)
                    .message(message)
                    .description(Constant.SUCCESS)
                    .build();
            log.info("Method receiveMessage() END with response {}", responseApp);
        } catch (Exception e) {
            responseApp = ResponseApp.builder()
                    .code(Constant.ERROR_CODE)
                    .message(e.getMessage())
                    .description(Constant.FAIL)
                    .build();
            log.info("Method receiveMessage() ERROR with message", e);
        }
        return responseApp;
    }
}
