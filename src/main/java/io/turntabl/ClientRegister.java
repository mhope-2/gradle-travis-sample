package io.turntabl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    public List<String> getGoldClients(){
        return this.clients.stream()
                .filter(client -> client.getServiceLevel().equals(Level.GOLD))
                .map(Client::getName)
                .collect(Collectors.toList());
    }

    public Optional<String> getClientNameById(String id){

        return this.clients.stream()
                .filter(client -> client.getID().equals(id))
                .map(Client::getName)
                .findFirst();

    }

    public Map<Level, Long> countClientsAtAllLevels(){
        return this.clients.stream()
                .collect(Collectors.groupingBy(Client::getServiceLevel, Collectors.counting()));
    }

}
