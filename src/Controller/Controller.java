/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Apps.Apps;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Controller implements ActionListener{

    private Apps apps;
    private View view;
    private SignUpView signup;
    private LoginView login;
    private DosenUtamaView dosenUtama;
    private MahasiswaUtamaView mahasiswaUtama;
    
    private  String username="";
    private  String password="";
    
    private String currentUsername;
    
    public Controller(Apps apps){
        this.apps = apps;
        view = new LoginView();
        login = new LoginView();
        login.setVisible(true);
        login.addListener(this);
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int idx;
        Object source = e.getSource();
       if(view instanceof LoginView){          
           if(source.equals( (Object) login.getTextFieldUsername())){
               username = login.getTextFieldUsername().getText();
               login.addListener(this);
               
              
               
           }
           else if(source.equals((Object)login.getTextFieldPassword())){
               password = login.getTextFieldPassword().getText();
               login.addListener(this);
               
           }
           else if(source.equals((Object)login.getBtnLogin())){
               if(username.equals("")||password.equals("")){
                   login.setNotification("Username/Password Kosong");
                   login.setTextFieldUsername("");
                   login.setTextFieldPassword("");
                   login.addListener(this);
               
               }
               else{
                   //if not kosong
                   if(apps.searchMhs(username)!= -1){
                   //punya Mahasiswa
                        
                        if(apps.getMhs(username)==null){
                            login.setNotification("Username/Password Mahasiswa Salah");
                            login.setTextFieldUsername("");
                            login.setTextFieldPassword(""); 
                            login.addListener(this);
                        }
                        else{
                            if(apps.getMhs(username).getPassword().equals(password)){
                                login.setNotification("Login Berhasil sebagai Mahasiswa");
                                //belom diisi
                            }
                            else{
                                login.setNotification("Username/Password Mahasiswa Salah");
                                login.setTextFieldUsername("");
                                login.setTextFieldPassword("");
                                login.addListener(this);
                                
                            }
                        }
                   
                   }
                   else{
                   //punya Dosen
                    
                        if(apps.getDosen(username)==null){
                            login.setNotification("Username/Password Dosen Salah");
                            login.setTextFieldUsername("");
                            login.setTextFieldPassword("");
                            login.addListener(this);
                        }
                        else{
                            if(apps.getDosen(username).getPassword().equals(password)){
                                login.setNotification("Login Berhasil sebagai Dosen");
                                login.setVisible(false);
                                dosenUtama = new DosenUtamaView();
                                dosenUtama.setVisible(true);
                                //dosenUtama.addListener(this);
                                login.dispose();
                                view = new DosenUtamaView();
                            }
                            else{
                                login.setNotification("Username/Password Dosen Salah");
                                login.setTextFieldUsername("");
                                login.setTextFieldPassword("");
                                login.addListener(this);
                            }
                        }
                        
                   }
                   
                   
                   
               }
       
          }
           else if(source.equals((Object)login.getBtnSignUp())){
                signup = new SignUpView();
                signup.setVisible(true);
                login.dispose();
                view = new SignUpView();
                signup.addListener(this);
           
           
           }
       
       }
       else if(view instanceof SignUpView){
           
       
       
       
       }
       else if(view instanceof DosenUtamaView){
           
       }
       
       else if(view instanceof MahasiswaUtamaView){
           
       
       }
    }
    
    
}
