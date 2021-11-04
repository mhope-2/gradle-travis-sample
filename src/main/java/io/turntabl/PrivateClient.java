package io.turntabl;

public class PrivateClient extends Client{
    public PrivateClient(ClientType type, String name, String ID, Level serviceLevel) {
        super(type, name, ID, serviceLevel);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
