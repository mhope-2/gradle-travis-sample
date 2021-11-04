package io.turntabl;

import java.util.List;
import java.util.stream.Collectors;

public class ClientRegister {

    private List<Client> clients;

    public ClientRegister(List<Client> clients) {
        this.clients = clients;
    }

    public List<String> getClients() {
        return this.clients.stream()
                .map(Client::getName)
                .collect(Collectors.toList());
    }
}
