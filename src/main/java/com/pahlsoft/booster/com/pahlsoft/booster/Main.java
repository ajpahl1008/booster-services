package com.pahlsoft.booster.com.pahlsoft.booster;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class Main {

    static MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

    static MongoDatabase db = client.getDatabase("boosterDB");

    static MongoCollection collection = db.getCollection("booster");

    public static void main(String[] args) {
        for (int x = 0; x <= 9; x++) {
            Document document = new Document();
            document.put("serverName", "server000" + x + ".company.com");
            document.put("changeRecord", "CR12345" + x);
            document.put("changeRecrdStatus","RFC");
            document.put("serverOwnerName", "Steve Jones");
            document.put("serverOwnerID", "x1234111");
            document.put("lastPatchingDate", "12-02-1923");

            Document patchInfo = new Document();
            patchInfo.put("PATCH-001", "Some Shit is broken");
            patchInfo.put("PATCH-12", "Broke again");
            patchInfo.put("PATCH-DOOGLE", "Fo shizzle");
            document.put("patchInfo", patchInfo);

            Document serverUAIDs = new Document();
            serverUAIDs.put("1","UAID-1");
            serverUAIDs.put("2", "UAID-12");
            serverUAIDs.put("3", "UAID-111");
            document.put("serverUAIDs", serverUAIDs);

            if (x % 3 == 0) {
                document.put("rebootRequired", true);
            } else {
                document.put("rebootRequired", false);
            }

            if (x % 1 == 0) {
                document.put("patchingRequired", true);
            } else {
                document.put("patchingRequired", false);
            }

            if (x % 2 ==0 ) {
                document.put("patchingStatus", "CR: Pending Approval");
            } else {
                document.put("patchingStatus", "CR: Approved");
            }

            collection.insertOne(document);

        }
    }
}
