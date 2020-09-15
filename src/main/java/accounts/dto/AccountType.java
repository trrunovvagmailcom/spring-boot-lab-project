package accounts.dto;

public class AccountType {
    private boolean vip = true;

    public AccountType(boolean vip) {
        this.vip = vip;
    }

    public boolean isVip() {
        return vip;
    }
}
