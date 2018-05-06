package com.example.yann.classroom_community.BDD2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Friend {

    int id;
    String prenom;
    String nom;
    int isPresent;
    String photo_path;
    int lastScore;



    public Friend(String prenom, String nom){
        this.id = 0;
        this.prenom = prenom;
        this.nom = nom;
        photo_path = "";
        isPresent = 0;
        lastScore = -1;
    }

    public Friend(int id,String prenom,String nom,int isPresent,String photo_path,int lastScore){
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.isPresent = isPresent;
        this.photo_path = photo_path;
        this.lastScore = lastScore;
    }

    public static Friend getFriendFromJson(String json){

        Gson gson = new Gson();
        Friend friend = gson.fromJson(json, Friend.class);
        return friend;

    }


    public static List<Friend> getListOfFriendsFromJson(String json){

        Gson gson = new Gson();
        Type type = new TypeToken<List<Friend>>(){}.getType();
        List<Friend> friends = gson.fromJson(json, type);
        return friends;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public int isPresent() {
        return isPresent;
    }
}
