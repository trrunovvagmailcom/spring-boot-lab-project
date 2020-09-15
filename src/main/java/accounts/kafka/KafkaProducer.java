package accounts.kafka;

import accounts.dto.BankAccountDtoWithType;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<Object, String> kafkaTemplate;

    public void sendAccount(BankAccountDtoWithType account) {
        String jsonAccount = new Gson().toJson(account);
        kafkaTemplate.send("BankAccounts", jsonAccount);
        System.out.println("kafka send");
    }
}
