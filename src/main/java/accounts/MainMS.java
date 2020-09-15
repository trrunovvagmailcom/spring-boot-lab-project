package accounts;

import accounts.dto.BankAccountDtoWithType;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
@EnableKafka
@SpringBootApplication
public class MainMS {
    @KafkaListener(topics = "BankAccounts")
    public void msgListener(String msg) {
        BankAccountDtoWithType bankAccountDtoWithType = new Gson().fromJson(msg, BankAccountDtoWithType.class);
        System.out.println(bankAccountDtoWithType);
    }

    public static void main(String[] args){
        SpringApplication.run(MainMS.class, args);
    }

}


