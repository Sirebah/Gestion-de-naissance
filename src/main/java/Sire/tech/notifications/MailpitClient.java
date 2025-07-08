package Sire.tech.notifications;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.PostExchange;

public interface MailpitClient {

    @PostExchange("/api/v1/send")
    void send(@RequestBody Map<String, Object> data);
}
