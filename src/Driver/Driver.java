/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Apps.Apps;
import Controller.Controller;

/**
 *
 * @author ASUS
 */
public class Driver {
    public static void main(String[] args) {
        Apps apps = new Apps();
        apps.createDosen(1);
        apps.getDosen(1).setUsername("riksa");
        apps.getDosen(1).setPassword("yu");
        System.out.println(apps.getDosen("riksa").getUsername());
        System.out.println(apps.getDosen("riksa").getPassword());
        Controller c = new Controller(apps);
        
    }
    
}
