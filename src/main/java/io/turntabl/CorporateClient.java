package io.turntabl;

public class CorporateClient extends Client {
    private AccountManager accountManager;

    public CorporateClient(ClientType type, String ID, Level serviceLevel, AccountManager accountManager) {
        super(type, ID, serviceLevel);
        this.accountManager = accountManager;
    }

    public String getName() {
        return accountManager.getName();
    }
}
