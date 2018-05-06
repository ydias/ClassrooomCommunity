package com.example.yann.classroom_community.BDD1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.Hashtable;

public class CompteDAO extends DAOBase {

    public static final String TABLE_NAME = "compte";
    public static final String KEY = "id";
    public static final String LOGIN = "login";
    public static final String MDP = "mdp";

    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LOGIN + " TEXT, " + MDP + " TEXT);";

    public static final String TABLE_DROP =  "DROP TABLE IF EXISTS " + TABLE_NAME + ";";


    public CompteDAO(Context pContext){
        super(pContext);
        //open();
        //instantiate();
    }

    /**
     * @param c le COMPTE à ajouter à la base
     */
    public void ajouter(Compte c) {
        ContentValues value = new ContentValues();
        value.put(CompteDAO.LOGIN, c.getLogin());
        value.put(CompteDAO.MDP, c.getMdp());
        mDb.insert(CompteDAO.TABLE_NAME, null, value);

    }

    /**
     * @param id l'identifiant du COMPTE à supprimer
     */
    public void supprimer(long id) {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param c le compte modifié
     */
    public void modifier(Compte c) {
        ContentValues value = new ContentValues();
        value.put(MDP, c.getMdp());
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(c.getId())});

    }

    /**
     * @param 'identifiant du compte à récupérer
     */
    public Compte selectionner(String login) {
        Cursor cursor = mDb.rawQuery("select * from " + TABLE_NAME + " where login = " + login , new String[]{"1"});
        return new Compte(cursor.getLong(0),cursor.getString(1),cursor.getString(2));
    }

    public Hashtable getTable(){
        Hashtable ht = new Hashtable();
        Cursor cursor = mDb.rawQuery("select * from " + TABLE_NAME , null);
        long id = -1;
        String login = "";
        String mdp = "";
        while (cursor.moveToNext()) {
            id = cursor.getLong(0);
            login = cursor.getString(1);
            mdp = cursor.getString(2);

            ht.put(login,mdp);
        }
        cursor.close();
        return ht;

     /*   if(ht.containsKey(login) && ht.containsValue(mdp)){
            ht.get
        }*/

    }

    public boolean connect(String login, String mdp){
        Hashtable ht = getTable();

        if(ht.containsKey(login) && ht.containsValue(mdp)){
            if(ht.get(login).equals(mdp)){
                return true;
            }
        }

        return false;

    }

    public void instantiate(){
        Compte c1 = new Compte(0,"livio","livio");
        Compte c2 = new Compte(0,"yann","yann");
        Compte c3 = new Compte(0,"admin","admin");
        Compte c4 = new Compte(0,"amine","amine");
        ajouter(c1);
        ajouter(c2);
        ajouter(c3);
        ajouter(c4);
    }
}
