package com.pahlsoft.booster.com.pahlsoft.booster.service;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pahlsoft.booster.com.pahlsoft.booster.model.Server;
import org.mongojack.JacksonDBCollection;

import javax.ws.rs.*;


@Path("/booster")
public class BoosterRequestService {

    static MongoClient client = new MongoClient(new ServerAddress("localhost",27017));

    static MongoDatabase db = client.getDatabase("boosterDB");

    static MongoCollection collection = db.getCollection("booster");

    public BoosterRequestService() {
            //this.buildServerMock();
    }

    @GET
    @Path("/retrieve/servers/all")
    @Produces("application/json")
    public FindIterable retrieveServerList() {
       System.out.println("Retrieving All Servers");
        return  collection.find();
     }

    @GET
    @Path("/retrieve/owners/{ownerId}")
    @Produces("application/json")
    public FindIterable findServersByOwnerId(@PathParam("ownerId") String ownerId) {
        System.out.println("Retrieving Servers for Owner: " + ownerId);
        return collection.find(new BasicDBObject("serverOwnerID", ownerId));
    }

    @GET
    @Path("/retrieve/servers/{serverName}")
    @Produces("application/json")
    public FindIterable findServersByName(@PathParam("serverName")String serverName){
        return collection.find(new BasicDBObject("serverName", serverName));
    }
//    @GET
//    @Path("/retrieve/uaids/{uaId}")
//    @Produces("application/json")
//    public List<Server> findServersByUaid(@PathParam("uaId") String uaId) {
//        ArrayList<Server> servers = new ArrayList<>();
//
//        singleEvent.forEach((temp) -> {
//            servers.addAll(temp.getServerUAIDs().stream().filter(id -> id.matches(uaId)).map(id -> temp).collect(Collectors.toList()));
//        });
//        return servers;
//    }
}
