package com.pahlsoft.booster.com.pahlsoft.booster.service;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pahlsoft.booster.com.pahlsoft.booster.model.Application;
import com.pahlsoft.booster.com.pahlsoft.booster.model.Patch;
import com.pahlsoft.booster.com.pahlsoft.booster.model.Server;
import org.bson.Document;


import javax.ws.rs.*;

@Path("/update")
public class BoosterUpdateService {

    static MongoClient client = new MongoClient(new ServerAddress("localhost",27017));

    static MongoDatabase db = client.getDatabase("boosterDB");

    static MongoCollection collection;

    public BoosterUpdateService() {

    }

    @POST
    @Path("/patches/addPatch")
    @Produces("application/json")
    public Document addPatch(Patch patch) throws Exception {
        System.out.println("Adding Patch: " + patch.getId());
        Gson gson = new Gson();
        String json = gson.toJson(patch);
        Document document = Document.parse(json);

        collection = db.getCollection("patches");

        try {
           collection.insertOne(document);
        } catch (MongoException me) {
            Document responseDoc = new Document();
            if ( me.getCode() == 11000 ) {
                responseDoc.append("error", "Patch Already Exists");
            } else {
                responseDoc.append("error", "General Write Exception Thrown");
            }
             return responseDoc;
        }
        Document responseDoc = new Document();
        responseDoc.append("success","Patch Added");
        return responseDoc;



    }

    @POST
    @Path("/inventory/addServer")
    @Produces("application/json")
    public Document addServer(Server server) throws Exception {
        System.out.println("Adding Server: " + server.getId());
        Gson gson = new Gson();
        String json = gson.toJson(server);
        Document document = Document.parse(json);

        collection = db.getCollection("inventory");

        try {
            collection.insertOne(document);
        } catch (MongoException me) {
            Document responseDoc = new Document();
            if ( me.getCode() == 11000 ) {
                responseDoc.append("error", "Server Already Exists");
            } else {
                responseDoc.append("error", "General Write Exception Thrown");
            }
            return responseDoc;
        }
        Document responseDoc = new Document();
        responseDoc.append("success","Server Added");
        return responseDoc;



    }

    @POST
    @Path("/applications/addApplication")
    @Produces("application/json")
    public Document addApplication(Application application) throws Exception {
        System.out.println("Adding Application: " + application.getId());
        Gson gson = new Gson();
        String json = gson.toJson(application);
        Document document = Document.parse(json);

        collection = db.getCollection("applications");

        try {
            collection.insertOne(document);
        } catch (MongoException me) {
            Document responseDoc = new Document();
            if ( me.getCode() == 11000 ) {
                responseDoc.append("error", "Application Already Exists");
            } else {
                responseDoc.append("error", "General Write Exception Thrown");
            }
            return responseDoc;
        }
        Document responseDoc = new Document();
        responseDoc.append("success","Application Added");
        return responseDoc;



    }

}
