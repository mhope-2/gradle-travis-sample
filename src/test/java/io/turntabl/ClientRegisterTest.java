package io.turntabl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;




public class ClientRegisterTest {

    @Test
    public void testGetClientNames(){


        // create an a/c manager
        AccountManager c2 = new AccountManager("C2 Account Manager Name");
        AccountManager c3 = new AccountManager("C3 Account Manager Name");

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
                "C1", "C2 Account Manager Name",
                "C3 Account Manager Name", "C4"
        ));

    }

    @Test
    public void testGetGoldClients(){

        // create an a/c manager
        AccountManager c2 = new AccountManager("C2 Account Manager Name");
        AccountManager c3 = new AccountManager("C3 Account Manager Name");

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
                "C1", "C3 Account Manager Name"
        ));
    }

    @Test
    public void getClientNameById(){
        // create an a/c manager
        AccountManager c2 = new AccountManager("C2 Account Manager Name");
        AccountManager c3 = new AccountManager("C3 Account Manager Name");

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

    }


}
