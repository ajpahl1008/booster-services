package com.pahlsoft.booster;

import com.pahlsoft.booster.com.pahlsoft.booster.model.Server;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/testEvent")
public class BoosterService {
    static ArrayList<Server> singleEvent = new ArrayList<>();

    public BoosterService() {
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
            targetServer.setRebootRequired(true);

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
    @Path("/test")
    @Produces("application/json")
    public List<Server> retrieveServerList() {
        return singleEvent;
     }


    @GET
    @Path("/test/owners/{ownerId}")
    @Produces("application/json")
    public List<Server> findServerByOwnerId(@PathParam("ownerId") String ownerId) {
        ArrayList<Server> servers = new ArrayList<Server>();

        singleEvent.forEach((temp) -> {
            if (temp.getServerOwnerID().equalsIgnoreCase(ownerId)) {
                servers.add(temp);
            }
        });

        return servers;
    }
}
