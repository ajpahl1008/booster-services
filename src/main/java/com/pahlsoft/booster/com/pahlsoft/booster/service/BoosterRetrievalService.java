package com.pahlsoft.booster.com.pahlsoft.booster.service;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.ws.rs.*;


@Path("/retrieve")
public class BoosterRetrievalService {

    static MongoClient client = new MongoClient(new ServerAddress("localhost",27017));

    static MongoDatabase db = client.getDatabase("boosterDB");

    static MongoCollection collection;

    public BoosterRetrievalService() {

    }

    @GET
    @Path("/booster/getAll")
    @Produces("application/json")
    public FindIterable retrieveBoosterList() {
        System.out.println("Retrieving All Booster Items");
        collection = db.getCollection("booster");
        return  collection.find();
     }

    @GET
    @Path("/owners/getAll")
    @Produces("application/json")
    public FindIterable retrieveOwnerList() {
        System.out.println("Retrieving All Owners");
        collection = db.getCollection("owners");
        return  collection.find();
    }

    @GET
    @Path("/applications/getAll")
    @Produces("application/json")
    public FindIterable retrieveUaidList() {
        System.out.println("Retrieving All UAIDs");
        collection = db.getCollection("applications");
        return  collection.find();
    }


    @GET
    @Path("/patches/getAll")
    @Produces("application/json")
    public FindIterable retrievePatchList() {
        System.out.println("Retrieving All Patches");
        collection = db.getCollection("patches");
        return  collection.find();
    }

    @GET
    @Path("/inventory/getAll")
    @Produces("application/json")
    public FindIterable retrieveInventoryList() {
        System.out.println("Retrieving Entire Inventory");
        collection = db.getCollection("inventory");
        return  collection.find();
    }

    @GET
    @Path("/booster/getBoosterByOwners/{ownerId}")
    @Produces("application/json")
    public FindIterable findBoosterByOwnerId(@PathParam("ownerId") String ownerId) {
        System.out.println("Retrieving Booster Item by Owner: " + ownerId);
        collection = db.getCollection("booster");
        return collection.find(new BasicDBObject("serverOwnerID", ownerId));
    }

    @GET
    @Path("/booster/getBoosterByServername/{serverName}")
    @Produces("application/json")
    public FindIterable findBoosterByName(@PathParam("serverName")String serverName){
        System.out.println("Retrieving Booster Item by Server Name: " + serverName);
        collection = db.getCollection("booster");
        return collection.find(new BasicDBObject("serverName", serverName));
    }

    @GET
    @Path("/booster/getBoosterByApplicationId/{uaID}")
    @Produces("application/json")
    public FindIterable findBoosterByUaid(@PathParam("uaID")String uaId){
        collection = db.getCollection("booster");
        return collection.find(new BasicDBObject("serverUAIDs", uaId));
    }

    @GET
    @Path("/booster/getBoosterByPatchId/{patchId}")
    @Produces("application/json")
    public FindIterable findBoosterByPatchId(@PathParam("patchId")String patchId){
        collection = db.getCollection("booster");
        return collection.find(new BasicDBObject("patchInfo", patchId));
    }

    @GET
    @Path("/inventory/getInventoryByOwners/{ownerId}")
    @Produces("application/json")
    public FindIterable findInventoryByOwnerId(@PathParam("ownerId") String ownerId) {
        System.out.println("Retrieving Inventory by Owner: " + ownerId);
        collection = db.getCollection("inventory");
        return collection.find(new BasicDBObject("serverOwnerID", ownerId));
    }

    @GET
    @Path("/inventory/getInventoryByServername/{serverName}")
    @Produces("application/json")
    public FindIterable findInventoryByName(@PathParam("serverName")String serverName){
        System.out.println("Retrieving Inventory by Server Name: " +serverName);
        collection = db.getCollection("inventory");
        return collection.find(new BasicDBObject("_id", serverName));
    }

    @GET
    @Path("/inventory/getInventoryByApplicationId/{uaID}")
    @Produces("application/json")
    public FindIterable findInventoryByUaid(@PathParam("uaID")String uaId){
        collection = db.getCollection("inventory");
        return collection.find(new BasicDBObject("relatedUaids", uaId));
    }

    @GET
      @Path("/patches/getPatchById/{patchId}")
      @Produces("application/json")
      public FindIterable findPatchById(@PathParam("patchId")String patchId){
        System.out.println("Retrieving Patch by ID: " +patchId);
        collection = db.getCollection("patches");
        return collection.find(new BasicDBObject("_id", patchId));
    }

    @GET
    @Path("/patches/getPatchesByPlatform/{platform}")
    @Produces("application/json")
    public FindIterable findPatchesByPlatform(@PathParam("platform")String platform){
        System.out.println("Retrieving Patch by Platform: " +platform);
        collection = db.getCollection("patches");
        return collection.find(new BasicDBObject("platform", platform));
    }


    @GET
    @Path("/applications/getApplicationsByUaid/{uaidName}")
    @Produces("application/json")
    public FindIterable findUaidByName(@PathParam("uaidName")String uaidName){
        System.out.println("Retrieving UAID by Name: " +uaidName);
        collection = db.getCollection("applications");
        return collection.find(new BasicDBObject("name", uaidName));
    }

    @GET
    @Path("/applications/getApplicationsByOwnerId/{ownerId}")
    @Produces("application/json")
    public FindIterable findUaidByOwnerId(@PathParam("ownerId")String ownerId){
        System.out.println("Retrieving UAID by Owner: " +ownerId);
        collection = db.getCollection("applications");
        return collection.find(new BasicDBObject("ownerId", ownerId));
    }




}

