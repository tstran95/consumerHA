package vnpay.vn.ha.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vnpay.vn.ha.response.ResponseApp;
import vnpay.vn.ha.services.AppService;

/**
 * @author sontt1
 * Date:9/20/2022
 * Time:3:31 PM
 */
@RestController
@RequestMapping("/api/v1/cons")
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping
    public ResponseApp receiveMessage() {
        String message = appService.receiveMessage();
        return ResponseApp.builder()
                .code("00")
                .message(message)
                .description("SUCCESS")
                .build();
    }
}
