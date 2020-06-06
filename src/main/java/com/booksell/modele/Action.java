/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booksell.modele;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author PC
 */
public interface Action {
    public String execute();

    public void setRequest(HttpServletRequest request);

    public void setReponse(HttpServletResponse response);

}
