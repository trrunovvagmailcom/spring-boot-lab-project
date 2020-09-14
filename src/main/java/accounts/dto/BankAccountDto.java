package accounts.dto;

import java.util.UUID;

public class BankAccountDto {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String patronymic;
    private long accountNumber;
    private AccountType accountType;

    public BankAccountDto(UUID uuid, String firstName, String lastName, String patronymic, long accountNumber, AccountType accountType) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }
}
