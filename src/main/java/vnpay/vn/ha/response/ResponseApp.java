package vnpay.vn.ha.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

/**
 * @author sontt1
 * Date:9/20/2022
 * Time:3:32 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseApp {
    private String code;
    private String message;
    private String description;
}
