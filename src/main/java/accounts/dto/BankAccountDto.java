package accounts.dto;

import java.util.UUID;

public class BankAccountDto {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String patronymic;
    private long accountNumber;

    public BankAccountDto(UUID uuid, String firstName, String lastName, String patronymic, long accountNumber) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.accountNumber = accountNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getPatronymic() {
        return patronymic;
    }


    public long getAccountNumber() {
        return accountNumber;
    }


}
