package com.pahlsoft.booster.com.pahlsoft.booster.service;

import com.pahlsoft.booster.com.pahlsoft.booster.model.Server;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/booster")
public class BoosterRequestService {
    private ArrayList<Server> singleEvent = new ArrayList<>();

    public BoosterRequestService() {
        this.buildServerMock();
    }

    private void buildServerMock() {

        for (int x = 0; x <= 9; x++) {
            Server targetServer = new Server();
            targetServer.setChangeRecord("CR12345");
            targetServer.setChangeRecordStatus("RFC");
            targetServer.setServerName("server000" + x + ".company.com");
            targetServer.setServerOwnerName("Steve Jones");
            targetServer.setServerOwnerID("x1234111");
            if (x % 3 == 0) {
                targetServer.setRebootRequired(true);
            } else {
                targetServer.setRebootRequired(false);
            }

            if (x % 1 == 0) {
                targetServer.setPatchingRequired(true);
            } else {
                targetServer.setPatchingRequired(false);
            }

            ArrayList<String> serverUAIDs = new ArrayList<String>();
            serverUAIDs.add("APP001");
            serverUAIDs.add("APP002");
            serverUAIDs.add("APP003");
            targetServer.setServerUAIDs(serverUAIDs);

            ArrayList<String> patchInfo = new ArrayList<String>();
            patchInfo.add("PATCH-001");
            patchInfo.add("PATCH-12");
            patchInfo.add("PATCH-2313X");
            patchInfo.add("PATCH-POODLE");
            targetServer.setPendingPatchInfo(patchInfo);

            targetServer.setLastPatchingDate("12-02-1923");

            singleEvent.add(targetServer);
        }
    }

    @GET
    @Path("/retrieve/all")
    @Produces("application/json")
    public List<Server> retrieveServerList() {
        return singleEvent;
     }

    @GET
    @Path("/retrieve/owners/{ownerId}")
    @Produces("application/json")
    public List<Server> findServersByOwnerId(@PathParam("ownerId") String ownerId) {
        ArrayList<Server> servers = new ArrayList<>();

        singleEvent.forEach((temp) -> {
            if (temp.getServerOwnerID().equalsIgnoreCase(ownerId)) {
                servers.add(temp);
            }
        });
        return servers;
    }

    public List<Server> findServersByUaid(@PathParam("uaId") String uaId) {
        ArrayList<Server> servers = new ArrayList<>();

        singleEvent.forEach((temp) -> {
            for (String id : temp.getServerUAIDs()){
                if (id.matches(uaId)) {
                    servers.add(temp);
                }
            }
        });
        return servers;
    }

    public List<Server> findServersByHostName(@PathParam("hostname")String hostname){
        ArrayList<Server> servers = new ArrayList<>();

        singleEvent.forEach((temp) -> {
               if (temp.getServerName().contains(hostname)) {
                    servers.add(temp);
                }
        });
        return servers;
    }
}
