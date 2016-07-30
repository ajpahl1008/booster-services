package com.pahlsoft.booster;

import com.pahlsoft.booster.com.pahlsoft.booster.model.Server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/booster")
public class BoosterMaintenanceService {
    private ArrayList<Server> singleEvent = new ArrayList<>();

    public BoosterMaintenanceService() {
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
    @Path("/update/{server}")
    @Produces("application/json")
    public Server updateServerInfo(@PathParam("server") Server server) {
        return server;
     }

}
