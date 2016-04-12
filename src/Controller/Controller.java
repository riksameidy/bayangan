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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import tubesbayangan.POJO.Kelas;

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
    private EditProfileView editProfile;
    private AddKelasDosen dosenAddKelas;
    private KelolaKelasDosen kelolaKelas;
    private DeleteKelasDosen dosenDeleteKelas;
    private PilihKelasView pilKelas;
    private MenuKelasUtamaDosen kelasUtamaDosen;
    
    private JOptionPane j;
    
    
    private  String username="";
    private  String password="";
    private  String nama;
    private  String nimnip;
    private  String email;
    private long nip;
    private long nim;
    
    private String kodeMK;
    private String sJumlah;
    private int jumlah;
    private String kodeKelas;
    
    
    
    private int status = 0; //1 jika Mhs , 2 jika Dosen;
    
    private String currentUsername;
    private String currentKodeKelas;
    
    public Controller(Apps apps){
        this.apps = apps;
        view = new LoginView();
        login = new LoginView();
        login.setVisible(true);
        login.addListener(this);
        j = new JOptionPane();
        
        
        
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
                   //mahasiswa
               }
           
           }
           
           else if(source.equals(dosenUtama.getBtnKelas())){
                
                
                //
                int jum = apps.getDosen(currentUsername).getJumlahKelas();
                String[] namaKelas;
                if(jum==0){
                    JOptionPane.showMessageDialog(j,"Anda Belum Memiliki Kelas");
                    
                }
                else{
                    namaKelas = new String[jum];
                    int i=0;
                    while(i<jum){
                        namaKelas[i] = apps.getDosen(currentUsername).getKelas(i).getNama();
                        i++;
                    }
                    pilKelas.setList(namaKelas);
                    
                    view = new PilihKelasView();
                    pilKelas = new PilihKelasView();
                    pilKelas.setVisible(true);
                    dosenUtama.dispose();
                    pilKelas.AddListener(this);
                }
                
                
           
           }
           
           
           else if(source.equals(dosenUtama.getBtnAddKelas())){
               view= new AddKelasDosen();
               dosenAddKelas = new AddKelasDosen();
               dosenAddKelas.setVisible(true);
               dosenUtama.dispose();
               dosenAddKelas.addListener(this);
               
           }
           else if(source.equals(dosenUtama.getBtnLogout())){
                view = new LoginView();
                login = new LoginView();
                login.setVisible(true);
                dosenUtama.dispose();
                currentUsername = "";
                password = "";
                login.addListener(this);
           
           }
       }
       
       else if(view instanceof ProfileView){
                
           
           if(source.equals(profile.getBtnEditProfile())){
               view = new EditProfileView();
               editProfile = new EditProfileView();
               editProfile.setVisible(true);
               profile.dispose();
               editProfile.addListener(this);
               if(apps.searchMhs(currentUsername)==-1){
                    editProfile.setJenisUserVal("Dosen");
               }
               else{
                   //mahasiswa
               }
           }
           else if(source.equals(profile.getBtnBack())){
               view = new DosenUtamaView();
               dosenUtama = new DosenUtamaView();
               dosenUtama.setVisible(true);
               profile.dispose();
               dosenUtama.addListener(this);
           }
       
       }
       
       else if(view instanceof EditProfileView){
           if(source.equals(editProfile.getBtnSubmit())){
               if(email.equals("")||nama.equals("")||password.equals("")){
                    editProfile.setNotification("Data tidak boleh kosong");
                    editProfile.addListener(this);
               }
               else{
                   if(apps.searchMhs(currentUsername)==-1){
                    apps.EditDosen(currentUsername, password, nama, email);
                   
                    view = new ProfileView();
                    profile = new ProfileView();
                    profile.setVisible(true);
                    editProfile.dispose();
                    
                    profile.setJenisUserLabel("Dosen");
                    profile.setNimnipLabel("NIP");
                    profile.setUsernameL(apps.getDosen(currentUsername).getUsername());
                    profile.setNamaL(apps.getDosen(currentUsername).getNama());
                    profile.setNipnimL(Long.toString(apps.getDosen(currentUsername).getNip()));
                    profile.setEmailL(apps.getDosen(currentUsername).getEmail());
                    profile.AddListener(this);
                   
                   }
                   else{
                   //edit Mahasiswa
                   }
               }
           
           }
           else if(source.equals(editProfile.getBtnBack())){
               view = new ProfileView();
               profile = new ProfileView();
               profile.setVisible(true);
               editProfile.dispose();
               profile.AddListener(this);
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
                   //mahasiswa
               }
           }
           
           else if(source.equals(editProfile.gettFEmail())){
               email = editProfile.gettFEmail().getText();
               editProfile.addListener(this);
           
           }
           else if(source.equals(editProfile.gettFNamaEdit())){
               nama = editProfile.gettFNamaEdit().getText();
               editProfile.addListener(this);
           }
           else if(source.equals(editProfile.gettFPassEdit())){
               password = editProfile.gettFPassEdit().getText();
               editProfile.addListener(this);
           }
           
       }
       
       else if(view instanceof AddKelasDosen){
           
           if(source.equals(dosenAddKelas.getBtnBack())){
               view = new DosenUtamaView();
               dosenUtama = new DosenUtamaView();
               dosenUtama.setVisible(true);
               dosenAddKelas.dispose();
               dosenUtama.addListener(this);
           }
           else if(source.equals(dosenAddKelas.getBtnSubmit())){
               if(kodeMK.equals("")||kodeKelas.equals("")){
                   dosenAddKelas.setNotification("Field tidak boleh kosong");
               }
               else{
               apps.getDosen(currentUsername).createKelas(kodeKelas,kodeMK,jumlah);
               view = new DosenUtamaView();
               dosenUtama = new DosenUtamaView();
               dosenUtama.setVisible(true);
               dosenAddKelas.dispose();
               dosenUtama.addListener(this);
               }
           }
           else if(source.equals(dosenAddKelas.gettFJum())){
               sJumlah = dosenAddKelas.gettFJum().getText();
               try{
                   jumlah = Integer.parseInt(sJumlah);
               }
               catch(NumberFormatException ex){
                   dosenAddKelas.setNotification("Not a number, try again");
                   jumlah = 0;
               }
           }
           else if(source.equals(dosenAddKelas.gettFKodeKelas())){
               kodeKelas = dosenAddKelas.gettFKodeKelas().getText();
           }
           else if(source.equals(dosenAddKelas.gettFkodeMK())){
               kodeMK = dosenAddKelas.gettFkodeMK().getText();
           }
           
       }
       
       //View Pilih Kelas
       
       else if(view instanceof PilihKelasView){
           if(source.equals(pilKelas.getBtnPilih())){
               
               currentKodeKelas = pilKelas.getSelectedList();
               view = new MenuKelasUtamaDosen();
               kelasUtamaDosen = new MenuKelasUtamaDosen();
               kelasUtamaDosen.setVisible(true);
               pilKelas.dispose();
               
               kelasUtamaDosen.setLnamaKelas(currentKodeKelas);
               kelasUtamaDosen.addListener(this);
               
               
           }
           else if(source.equals(pilKelas.getBtnBack())){
               view = new DosenUtamaView();
               dosenUtama = new DosenUtamaView();
               dosenUtama.setVisible(true);
               pilKelas.dispose();
               dosenUtama.addListener(this);
           
           }
           
                   
       }
       
       else if(view instanceof MenuKelasUtamaDosen ){
           if(source.equals(kelasUtamaDosen.getBtnBack())){
               
               
               view = new DosenUtamaView();
               dosenUtama = new DosenUtamaView();
               dosenUtama.setVisible(true);
               kelasUtamaDosen.dispose();
               dosenUtama.addListener(this);
               
           
           }
           else if(source.equals(kelasUtamaDosen.getBtnKelompok())){
               
               
           
           }
           else if(source.equals(kelasUtamaDosen.getBtnMhs())){
               
           
           }
           else if(source.equals(kelasUtamaDosen.getBtnTugas())){
               
           
           }
           
           else if(source.equals(kelasUtamaDosen.getBtnKelas())){
               view = new KelolaKelasDosen();
               kelolaKelas = new KelolaKelasDosen();
               kelolaKelas.setVisible(true);
               kelasUtamaDosen.dispose();
               kelolaKelas.addListener(this);
               
               //add inisiasi here
               int idxKelas = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
               String namaMK = apps.getDosen(currentUsername).getKelas(idxKelas).getMataKuliah().getKodeMK();
               int sksMK = apps.getDosen(currentUsername).getKelas(idxKelas).getMataKuliah().getSks();
               int jumlahMhs = apps.getDosen(currentUsername).getKelas(idxKelas).getJumlahMhs();
               int jumlahKelompok = apps.getDosen(currentUsername).getKelas(idxKelas).getMaxKelompok();
               int jumlahTugasTotal = apps.getDosen(currentUsername).getKelas(idxKelas).getJumlahTugas();
               int jumlahTugasIndividu = apps.getDosen(currentUsername).getKelas(idxKelas).getJumlahTugasIndividu();
               int jumlahTugasKelompok = jumlahTugasTotal - jumlahTugasIndividu;
               
               kelolaKelas.setlNamaKelas(currentKodeKelas);
               kelolaKelas.setlMK(namaMK);
               kelolaKelas.setlSks(Integer.toString(sksMK));
               kelolaKelas.setlJumlahMhs(Integer.toString(jumlahMhs));
               kelolaKelas.setlJumlahKelompok(Integer.toString(jumlahKelompok));
               kelolaKelas.setlJumlahTugasTotal(Integer.toString(jumlahTugasTotal));
               kelolaKelas.setlJumlahTugasIndividu(Integer.toString(jumlahTugasIndividu));
               kelolaKelas.setlJumlahTugasKelompok(Integer.toString(jumlahTugasKelompok));
               
           }
           
           
       
       }
       
       else if(view instanceof KelolaKelasDosen){
           
           if(source.equals(kelolaKelas.getBtnBack())){
               view = new MenuKelasUtamaDosen();
               kelasUtamaDosen = new MenuKelasUtamaDosen();
               kelasUtamaDosen.setVisible(true);
               kelolaKelas.dispose();
               kelasUtamaDosen.addListener(this);
               
               kelasUtamaDosen.setLnamaKelas(currentKodeKelas);
               
           
           }
           
           else if(source.equals(kelolaKelas.getBtnDeleteKelas())){
               
              
               int result = JOptionPane.showConfirmDialog(j, "Are You Sure? ","Delete Kelas",JOptionPane.YES_NO_OPTION);
               if(result==0){
                   
                   JOptionPane.showMessageDialog(j, "Kelas Dihapus");
                   
                   view = new DosenUtamaView();
                   dosenUtama = new DosenUtamaView();
                   dosenUtama.setVisible(true);
                   kelolaKelas.dispose();
                   apps.getDosen(currentUsername).deleteKelas(apps.getDosen(currentUsername).idxKelas(currentKodeKelas));
                   currentKodeKelas = "";
                   dosenUtama.addListener(this);
                   
               }
               
           }
       }
       
       
       
       else if(view instanceof MahasiswaUtamaView){
           
       
       }
    }
    
    
}
