/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Apps.Apps;
import Controller.Controller2;

/**
 *
 * @author ASUS
 */
public class Driver {
    public static void main(String[] args) {
        Apps apps = new Apps();
        apps.createDosen(1);
        apps.getDosen(1).setUsername("r");
        apps.getDosen(1).setPassword("y");
        System.out.println(apps.getDosen("r").getUsername());
        System.out.println(apps.getDosen("r").getPassword());
        
        Controller2 c = new Controller2(apps);
        
    }
    
}
