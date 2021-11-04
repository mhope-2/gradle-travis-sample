package io.turntabl;

public abstract class Client {

    private ClientType type;
    private String name;
    private String ID;
    private Level serviceLevel;

    public Client(ClientType type, String name, String ID, Level serviceLevel) {
        this.type = type;
        this.name = name;
        this.ID = ID;
        this.serviceLevel = serviceLevel;
    }


    public Client(ClientType type, String ID, Level serviceLevel) {
        this.type = type;
        this.ID = ID;
        this.serviceLevel = serviceLevel;
    }

    public String getName() {
        return name;
    }
}
