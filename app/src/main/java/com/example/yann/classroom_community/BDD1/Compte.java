package com.example.yann.classroom_community.BDD1;

public class Compte {

    private long id;
    private String login;
    private String mdp;

    public Compte(long id, String login, String mdp) {
        super();
        this.id = id;
        this.login=login;
        this.mdp =mdp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
