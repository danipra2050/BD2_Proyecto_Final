package com.ubosque.apicuatropatas.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ubosque.apicuatropatas.constant.Constante;

public class MongoUtil {

    private MongoDatabase mongoDatabase;
    private MongoCollection mongoCollection;

    public MongoUtil(){
        MongoClient mongoClient = new MongoClient(Constante.DbInfo.DB_SERVER, Constante.DbInfo.DB_PORT);
        setMongoDatabase(mongoClient.getDatabase(Constante.DbInfo.DB_NAME));
        setMongoCollection(mongoDatabase.getCollection(Constante.DbInfo.DB_COLLECTION));
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public MongoCollection getMongoCollection() {
        return mongoCollection;
    }

    public void setMongoCollection(MongoCollection mongoCollection) {
        this.mongoCollection = mongoCollection;
    }
}
