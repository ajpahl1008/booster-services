package com.pahlsoft.booster.com.pahlsoft.booster.service;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.ws.rs.*;


@Path("/booster")
public class BoosterRequestService {

    static MongoClient client = new MongoClient(new ServerAddress("localhost",27017));

    static MongoDatabase db = client.getDatabase("boosterDB");

    static MongoCollection collection;

    public BoosterRequestService() {

    }

    @GET
    @Path("/retrieve/getBooster/all")
    @Produces("application/json")
    public FindIterable retrieveServerList() {
        System.out.println("Retrieving All Servers");
        collection = db.getCollection("booster");
        return  collection.find();
     }

    @GET
    @Path("/retrieve/owners/all")
    @Produces("application/json")
    public FindIterable retrieveOwnerList() {
        System.out.println("Retrieving All Owners");
        collection = db.getCollection("owners");
        return  collection.find();
    }

    @GET
    @Path("/retrieve/uaids/all")
    @Produces("application/json")
    public FindIterable retrieveUaidList() {
        System.out.println("Retrieving All UAIDs");
        collection = db.getCollection("uaids");
        return  collection.find();
    }


    @GET
    @Path("/retrieve/patches/all")
    @Produces("application/json")
    public FindIterable retrievePatchList() {
        System.out.println("Retrieving All Patches");
        collection = db.getCollection("patches");
        return  collection.find();
    }

    @GET
    @Path("/retrieve/inventory/all")
    @Produces("application/json")
    public FindIterable retrieveInventoryList() {
        System.out.println("Retrieving Inventory");
        collection = db.getCollection("inventory");
        return  collection.find();
    }


    @GET
    @Path("/retrieve/getBoosterByOwners/{ownerId}")
    @Produces("application/json")
    public FindIterable findBoosterByOwnerId(@PathParam("ownerId") String ownerId) {
        System.out.println("Retrieving Servers for Owner: " + ownerId);
        collection = db.getCollection("booster");
        return collection.find(new BasicDBObject("serverOwnerID", ownerId));
    }

    @GET
    @Path("/retrieve/getBoosterByServername/{serverName}")
    @Produces("application/json")
    public FindIterable findBoosterByName(@PathParam("serverName")String serverName){
        collection = db.getCollection("booster");
        return collection.find(new BasicDBObject("serverName", serverName));
    }

    @GET
    @Path("/retrieve/boosterByUaid/{uaID}")
    @Produces("application/json")
    public FindIterable findBoosterByUaid(@PathParam("uaID")String uaId){
        collection = db.getCollection("booster");
        return collection.find(new BasicDBObject("serverUAIDs", uaId));
    }

    @GET
    @Path("/retrieve/getInventoryByOwners/{ownerId}")
    @Produces("application/json")
    public FindIterable findInventoryByOwnerId(@PathParam("ownerId") String ownerId) {
        System.out.println("Retrieving Servers for Owner: " + ownerId);
        collection = db.getCollection("inventory");
        return collection.find(new BasicDBObject("serverOwnerID", ownerId));
    }

    @GET
    @Path("/retrieve/getInventoryByServername/{serverName}")
    @Produces("application/json")
    public FindIterable findInventoryByName(@PathParam("serverName")String serverName){
        collection = db.getCollection("inventory");
        return collection.find(new BasicDBObject("_id", serverName));
    }

    @GET
    @Path("/retrieve/inventoryByUaid/{uaID}")
    @Produces("application/json")
    public FindIterable findInventoryByUaid(@PathParam("uaID")String uaId){
        collection = db.getCollection("inventory");
        return collection.find(new BasicDBObject("relatedUaids", uaId));
    }



}

