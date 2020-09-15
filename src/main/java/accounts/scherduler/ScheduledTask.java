package accounts.scherduler;

import accounts.dto.BankAccountDto;
import accounts.dto.BankAccountDtoWithType;
import accounts.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
class ScheduledTask {

    @Value("${account.generator.url}")
    String url;

    private final RestTemplate restTemplate;
    private final KafkaProducer kafkaProducer;

    public ScheduledTask(RestTemplateBuilder restTemplate, KafkaProducer kafkaProducer) {
        this.restTemplate = restTemplate.build();
        this.kafkaProducer = kafkaProducer;
    }

    public BankAccountDto getBankAccountClass() {
        return this.restTemplate.getForObject(url, BankAccountDto.class);
    }

    @Scheduled(initialDelayString = "${scheduler.initial.delay}", fixedDelayString = "${scheduler.fixed.delay}")
    public void sendToKafka() {
        BankAccountDtoWithType account = new BankAccountDtoWithType(getBankAccountClass());
        if (account.getAccountType().isVip()) {//filter
            kafkaProducer.sendAccount(account);
        }
    }
}
