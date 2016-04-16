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
        
        apps.createMhs(1301142289);
        apps.getMhs(1301142289).setUsername("Riksa");
        apps.getMhs(1301142289).setPassword("Riksa");
        
        apps.createMhs(1301140389);
        apps.getMhs(1301140389).setUsername("Chii");
        apps.getMhs(1301140389).setPassword("Chii");
        
        apps.createDosen(1);
        apps.getDosen(1).setUsername("r");
        apps.getDosen(1).setPassword("y");
        System.out.println(apps.getDosen("r").getUsername());
        System.out.println(apps.getDosen("r").getPassword());
        
        Controller c = new Controller(apps);
        
    }
    
}
