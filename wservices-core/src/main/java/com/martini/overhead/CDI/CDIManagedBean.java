/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martini.overhead.CDI;

import com.martini.utils.Utils;

/**
 *
 * @author omartini
 */
public class CDIManagedBean {
    public String SomeOutPut(){
        return "Retorna CDI \n Date: " + Utils.DateNowMMMddyyyyHHmmssSSS(); //System.currentTimeMillis();
    }
}
