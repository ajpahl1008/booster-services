package com.pahlsoft.booster.com.pahlsoft.booster.service;

import com.google.gson.Gson;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import com.pahlsoft.booster.com.pahlsoft.booster.model.Patch;
import org.bson.Document;

import javax.json.Json;
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


}