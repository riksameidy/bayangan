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
    private ProfileView profile;
    
    private  String username="";
    private  String password="";
    private  String nama;
    private  String nimnip;
    private long nip;
    private long nim;
    
    private int status = 0; //1 jika Mhs , 2 jika Dosen;
    
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
           if(source.equals( login.getTextFieldUsername())){
               
               username = login.getTextFieldUsername().getText();
               login.addListener(this);
               
              
               
           }
           else if(source.equals(login.getTextFieldPassword())){
               password = login.getTextFieldPassword().getText();
               login.addListener(this);
               
           }
           else if(source.equals(login.getBtnLogin())){
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
                                currentUsername = username;
                                login.setVisible(false);
                                dosenUtama = new DosenUtamaView();
                                dosenUtama.setVisible(true);
                                dosenUtama.addListener(this);
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
           else if(source.equals(login.getBtnSignUp())){
                signup = new SignUpView();
                signup.setVisible(true);
                login.dispose();
                view = new SignUpView();
                signup.addListener(this);
           
           
           }
       
       }
       else if(view instanceof SignUpView){
           if(source.equals(signup.gettFNama())){
               nama = signup.gettFNama().getText();
           
           }
           else if(source.equals( signup.gettFUsername())){
               username = signup.gettFUsername().getText();
           
           }
           else if(source.equals( signup.gettFPass())){
               password = signup.gettFPass().getText();
           
           
           }
           else if(source.equals( signup.gettFNimNip())){
               nimnip = signup.gettFNimNip().getText();
               
           
           }
           else if(source.equals( signup.getjRadioMhs())){
               if(signup.getjRadioMhs().isSelected()){
                   status = 2; 
               }
           
           }
           else if(source.equals( signup.getjRadioDosen())){
                if(signup.getjRadioDosen().isSelected()){
                   status = 1; 
               }
           
           }
           else if(source.equals(signup.getBtnSubmit())){
               if(username.equals("")||password.equals("")||nama.equals("")||nimnip.equals("")||status==0){
                   
                   signup.setNotification("Data Tidak Boleh Kosong");
                   signup.settFNama("");
                   signup.settFNimNip("");
                   signup.settFPass("");
                   signup.settFUsername("");
               }
               else{
                  if(apps.searchDosen(username)==-1 && apps.searchMhs(username)==-1){
                      //belum ada di dosen maupun Mhs
                      if(status==1){
                          try {
                            nip = Long.parseLong(nimnip);
                            apps.SignupDosen(username, password, nama, nip);
                            login = new LoginView();
                            login.setVisible(true);
                            signup.dispose();
                            view = new LoginView();
                            login.addListener(this);
                          } catch (NumberFormatException numberFormatException) {
                                System.out.println("Bukan number");
                                signup.setNotification("NIM / NIP haruslah Angka 0~1");
                            
                          }
                          
                      }
                      
                      else if(status==2){
                          try {
                              nim = Long.parseLong(nimnip);
                          } catch (NumberFormatException numberFormatException) {
                              
                          }
                          apps.SignupMhs(username, password, nama, nim);
                          login = new LoginView();
                          login.setVisible(true);
                          signup.dispose();
                          view = new LoginView();
                          login.addListener(this);
                      }
                  
                      
                  }
                  else{
                      signup.setNotification("Username sudah terdaftar");
                      signup.settFNama("");
                      signup.settFNimNip("");
                      signup.settFPass("");
                      signup.settFUsername("");
                  }
           
            }
           }
           else if(source.equals(signup.getBtnCancel())){
                          login = new LoginView();
                          login.setVisible(true);
                          signup.dispose();
                          view = new LoginView();
                          login.addListener(this);
           
           }
           
       }
       else if(view instanceof DosenUtamaView){
           if(source.equals(dosenUtama.getBtnProfile())){
               view = new ProfileView();
               profile = new ProfileView();
               profile.AddListener(this);
               dosenUtama.dispose();
               profile.setVisible(true);
               //inisiasi view
               if(apps.searchMhs(currentUsername)==-1){
                //dosen
                
                profile.setJenisUserLabel("Dosen");
                profile.setNimnipLabel("NIP");
                profile.setUsernameL(apps.getDosen(currentUsername).getUsername());
                profile.setNamaL(apps.getDosen(currentUsername).getNama());
                profile.setNipnimL(Long.toString(apps.getDosen(currentUsername).getNip()));
                profile.setEmailL(apps.getDosen(currentUsername).getEmail());
                
                }
               else{
               
               }
           
           }
           
           else if(source.equals(dosenUtama.getBtnKelas())){
           
           
           }
           else if(source.equals(dosenUtama.getBtnDeleteKelas())){
           
           
           }
           else if(source.equals(dosenUtama.getBtnAddKelas())){
           
           
           }
           else if(source.equals(dosenUtama.getBtnLogout())){
           
           
           }
       }
       
       else if(view instanceof ProfileView){
                
           
           if(source.equals(profile.getBtnEditProfile())){
               
           }
           else if(source.equals(profile.getBtnBack())){
               
           }
       
       }
       
       else if(view instanceof MahasiswaUtamaView){
           
       
       }
    }
    
    
}
