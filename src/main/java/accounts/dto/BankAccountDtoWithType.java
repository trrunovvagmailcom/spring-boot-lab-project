package accounts.dto;

import java.util.Random;
import java.util.UUID;

public class BankAccountDtoWithType{
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String patronymic;
    private long accountNumber;
    private AccountType accountType;

    public BankAccountDtoWithType(BankAccountDto bankAccountDto) {
        this.uuid = bankAccountDto.getUuid();
        this.firstName = bankAccountDto.getFirstName();
        this.lastName = bankAccountDto.getLastName();
        this.patronymic = bankAccountDto.getPatronymic();
        this.accountNumber = bankAccountDto.getAccountNumber();
        this.accountType = new AccountType(new Random().nextBoolean());
    }

    public AccountType getAccountType() {
        return accountType;
    }
}