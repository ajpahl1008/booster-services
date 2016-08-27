package com.pahlsoft.booster.com.pahlsoft.booster.service;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.ws.rs.*;


@Path("/booster")
public class BoosterRequestService {
    static MongoClientURI mongoClientURI = new MongoClientURI("mongodb://localhost:2017?ssl=true");
    static MongoClient client = new MongoClient(mongoClientURI);
    static MongoDatabase db = client.getDatabase("boosterDB");
    static MongoCollection collection = db.getCollection("booster");

    public BoosterRequestService() {

    }

    @GET
    @Path("/retrieve/servers/all")
    @Produces("application/json")
    public FindIterable retrieveServerList() {
        System.out.println("Retrieving All Servers");
        return  collection.find();
     }

    @GET
    @Path("/retrieve/owners/all")
    @Produces("application/json")
    public FindIterable retrieveOwnerList() {
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

    @GET
    @Path("/retrieve/uaid/{uaID}")
    @Produces("application/json")
    public FindIterable findServersByUaid(@PathParam("uaID")String uaId){
        return collection.find(new BasicDBObject("serverUAIDs", uaId));
    }

}

