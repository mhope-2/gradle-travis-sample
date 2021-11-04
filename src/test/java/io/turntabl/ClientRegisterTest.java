package io.turntabl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Year;
import java.util.*;

import static org.junit.Assert.*;




public class ClientRegisterTest {

    @Test
    public void testGetClientNames(){


        // create an a/c manager
        AccountManager c2 = new AccountManager("Salim Inc.");
        AccountManager c3 = new AccountManager("Jay Corp.");

        List<Client> clientList = new ArrayList<>(
                Arrays.asList(
                        new PrivateClient(ClientType.PRIVATE, "C1", "001", Level.GOLD),
                        new CorporateClient(ClientType.CORPORATE, "002", Level.PLATINUM,
                                c2),
                        new CorporateClient(ClientType.CORPORATE, "003", Level.GOLD, c3),
                        new PrivateClient(ClientType.PRIVATE, "C4", "004", Level.PREMIUM)
                )
        );


        ClientRegister clientRegister = new ClientRegister(clientList);

        assertEquals(clientRegister.getClients(), Arrays.asList(
                "C1", "Salim Inc.",
                "Jay Corp.", "C4"
        ));

    }

    @Test
    public void testGetGoldClients(){

        // create an a/c manager
        AccountManager c2 = new AccountManager("Salim Inc.");
        AccountManager c3 = new AccountManager("Jay Corp.");

        List<Client> clientList = new ArrayList<>(
                Arrays.asList(
                        new PrivateClient(ClientType.PRIVATE, "C1", "001", Level.GOLD),
                        new CorporateClient(ClientType.CORPORATE, "002", Level.PLATINUM,
                                c2),
                        new CorporateClient(ClientType.CORPORATE, "003", Level.GOLD, c3),
                        new PrivateClient(ClientType.PRIVATE, "C4", "004", Level.PREMIUM)
                )
        );


        ClientRegister clientRegister = new ClientRegister(clientList);

        assertEquals(clientRegister.getGoldClients(), Arrays.asList(
                "C1", "Jay Corp."
        ));
    }

    @Test
    public void getClientNameById(){
        // create an a/c manager
        AccountManager c2 = new AccountManager("Salim Inc.");
        AccountManager c3 = new AccountManager("Jay Corp.");

        List<Client> clientList = new ArrayList<>(
                Arrays.asList(
                        new PrivateClient(ClientType.PRIVATE, "C1", "001", Level.GOLD),
                        new CorporateClient(ClientType.CORPORATE, "002", Level.PLATINUM,
                                c2),
                        new CorporateClient(ClientType.CORPORATE, "003", Level.GOLD, c3),
                        new PrivateClient(ClientType.PRIVATE, "C4", "004", Level.PREMIUM)
                )
        );

        ClientRegister clientRegister = new ClientRegister(clientList);

        assertEquals(clientRegister.getClientNameById("001"), Optional.of("C1"));
    }

    @Test
    public void testCountClientsAtAllLevels(){
        // create an a/c manager
        AccountManager c2 = new AccountManager("Salim Inc.");
        AccountManager c3 = new AccountManager("Jay Corp.");

        List<Client> clientList = new ArrayList<>(
                Arrays.asList(
                        new PrivateClient(ClientType.PRIVATE, "C1", "001", Level.GOLD),
                        new CorporateClient(ClientType.CORPORATE, "002", Level.PLATINUM,
                                c2),
                        new CorporateClient(ClientType.CORPORATE, "003", Level.GOLD, c3),
                        new PrivateClient(ClientType.PRIVATE, "C4", "004", Level.PREMIUM)
                )
        );

        ClientRegister clientRegister = new ClientRegister(clientList);

        Map<Level, Long> countMap  = new HashMap<>();
        countMap.put(Level.PLATINUM, 1L);
        countMap.put(Level.GOLD, 2L);
        countMap.put(Level.PREMIUM, 1L);

        assertEquals(clientRegister.countClientsAtAllLevels(),countMap);
    }


}
