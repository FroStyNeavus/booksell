/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Booksell.dao;

import java.sql.Connection;
import java.util.List;

/**
 * @author Mu Tian Wang
 */
public abstract class DAO<T> {
    protected Connection cnx;

    public DAO(Connection cnx) {
        this.cnx = cnx;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public abstract boolean ajouter(T x);

    public abstract T trouverParId(String id);

    public abstract boolean modifier(T x);    //UPDATE

    public abstract boolean supprimer(T x);    //DELETE

    public abstract List<T> trouverTout();      //SELECT
}
