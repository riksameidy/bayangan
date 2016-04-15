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
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import tubesbayangan.POJO.Kelas;

/**
 *
 * @author my asus
 */
public class Controller2 implements ActionListener{
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
    private PengelolaanTugasView kelolaTugas;
    private AddTugasDosenView addTugas;
    
    //diisi chii
    private MhsKelasUtamaMahasiswa kelasUtamaMahasiswa;
    private MhsEditProfileView mhsEditProfile;
    private MhsGabungKelompokView mhsGabungKelompok;
    private MhsJawabTugasIndividuView mhsJawabTugasIndividu;
    private MhsKerjakanTugasIndividuView mhsKerjakanTugasIndividu;
    private MhsLihatInfoKelompokView mhsLihatInfoKelompok;
    private MhsLihatKelompokView mhsLihatKelompok;
    private MhsPilihKelasView mhsPilihKelas;
    private MhsPilihKetuaKelompokView mhsPilihKetuaKelompok;
    private MhsPilihTugasIndividuView mhsPilihTugasIndividu;
    private MhsProfileView mhsProfile;
    private MhsPilihTugasKelompokView mhsPilihTugasKelompok;
    private MhsKerjakanTugasKelompokView mhsKerjakanTugasKelompok;
    private MhsJawabTugasKelompokView mhsJawabTugasKelompok;
    //sampe sini
    
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
    
    private String namaTugas;
    private int sjumlahSoal;
    
    
    
    private int status = 0; //1 jika Mhs , 2 jika Dosen;
    private int jenisTugas=0; //1 jika Individu , 2 Jika Kelompok
    
    private String currentUsername;
    private String currentKodeKelas;
    
    public Controller2(Apps apps){
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
        int idxTugas;
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
                                //diisi chii
                                currentUsername = username;
                                login.setVisible(false);
                                mahasiswaUtama =  new MahasiswaUtamaView();
                                mahasiswaUtama.setVisible(true);
                                mahasiswaUtama.addListener(this);
                                login.dispose();
                                view = new MahasiswaUtamaView();
                                //sampe sini
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
             
              
            
                
                profile.setJenisUserLabel("Dosen");
                profile.setNimnipLabel("NIP");
                profile.setUsernameL(apps.getDosen(currentUsername).getUsername());
                profile.setNamaL(apps.getDosen(currentUsername).getNama());
                profile.setNipnimL(Long.toString(apps.getDosen(currentUsername).getNip()));
                profile.setEmailL(apps.getDosen(currentUsername).getEmail());
                
               
                
           
           }
           
           else if(source.equals(dosenUtama.getBtnKelas())){
                
                
                //
                int jum = apps.getDosen(currentUsername).getJumlahKelas();
                String[] namaKelas;
                if(jum==0){
                    JOptionPane.showMessageDialog(j,"Anda Belum Memiliki Kelas");
                    view = new DosenUtamaView();
                    dosenUtama.dispose();
                    dosenUtama = new DosenUtamaView();
                    dosenUtama.setVisible(true);
                    dosenUtama.addListener(this);
                    
                }
                else{
                    namaKelas = new String[jum];
                    int i=0;
                    view = new PilihKelasView();
                    pilKelas = new PilihKelasView();
                    pilKelas.setVisible(true);
                    dosenUtama.dispose();
                    while(i<jum){
                        namaKelas[i] = apps.getDosen(currentUsername).getKelas(i).getNama();
                        i++;
                    }
                    pilKelas.setList(namaKelas);
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
           
           }
           else if(source.equals(editProfile.getBtnBack())){
               view = new ProfileView();
               profile = new ProfileView();
               profile.setVisible(true);
               editProfile.dispose();
               profile.AddListener(this);
              
                
                
                profile.setJenisUserLabel("Dosen");
                profile.setNimnipLabel("NIP");
                profile.setUsernameL(apps.getDosen(currentUsername).getUsername());
                profile.setNamaL(apps.getDosen(currentUsername).getNama());
                profile.setNipnimL(Long.toString(apps.getDosen(currentUsername).getNip()));
                profile.setEmailL(apps.getDosen(currentUsername).getEmail());
                
               
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
               view = new PengelolaanTugasView();
               kelolaTugas = new PengelolaanTugasView();
               kelolaTugas.setVisible(true);
               
               kelasUtamaDosen.dispose();
               kelolaTugas.addListener(this);
               
               
           
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
               int jumlahKelompok = apps.getDosen(currentUsername).getKelas(idxKelas).getJumlahKelompok();
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
       
       else if(view instanceof PengelolaanTugasView){
           
           if(source.equals(kelolaTugas.getBtnBack())){
               view = new MenuKelasUtamaDosen();
               kelasUtamaDosen = new MenuKelasUtamaDosen();
               kelasUtamaDosen.setVisible(true);
               kelolaTugas.dispose();
               kelasUtamaDosen.addListener(this);
               kelasUtamaDosen.setLnamaKelas(currentKodeKelas);
           
           }
           else if(source.equals(kelolaTugas.getBtnAddTugas())){
               if(source.equals(kelolaTugas.getBtnAddTugas())){
               
               view = new AddTugasDosenView();
               addTugas = new AddTugasDosenView();
               addTugas.setVisible(true);
               kelolaTugas.dispose();
               addTugas.addListener(this);
               
               
               }
               
           
           }
           else if(source.equals(kelolaTugas.getBtnPilihTugas())){
               
           
           }
       
       }
       
       else if(view instanceof AddTugasDosenView){
           if(source.equals(addTugas.getBtnBack())){
               
               view = new PengelolaanTugasView();
               kelolaTugas = new PengelolaanTugasView();
               kelolaTugas.setVisible(true);
               addTugas.dispose();
               kelolaTugas.addListener(this);
               
               
           }
           else if(source.equals(addTugas.getBtnSubmit())){
               if(namaTugas.equals("")||sjumlahSoal==0||jenisTugas==0){
                   JOptionPane.showMessageDialog(j, "Field Tidak Boleh Kosong");
                   addTugas.addListener(this);
               }
               else{
                   idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
                   apps.getDosen(currentUsername).getKelas(idx).addTugas(namaTugas);
                   idxTugas = apps.getDosen(currentUsername).getKelas(idx).idxTugas(namaTugas);
                   if(jenisTugas==1){
                       apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).setMaxSoal(sjumlahSoal);
                       apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).setIsTugasIndividu(true);
                       
                   }
                   else if(jenisTugas==2){
                       
                       
                       apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).setMaxSoal(sjumlahSoal);
                       apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).setIsTugasIndividu(false);
                   
                   }
                   view = new PengelolaanTugasView();
                   kelolaTugas = new PengelolaanTugasView();
                   kelolaTugas.setVisible(true);
                   addTugas.dispose();
                   System.out.println(apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getNamaTugas());
                   System.out.println(apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getIsTugasIndividu());
                   System.out.println(apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getMaxSoal());
                   kelolaTugas.addListener(this);
               
               }
           
           }
           
           else if(source.equals(addTugas.getBtnRadioIndividu())){
               if(addTugas.getBtnRadioIndividu().isSelected()){
                   jenisTugas=1;
               }
               addTugas.addListener(this);
               
           }
           
           else if(source.equals(addTugas.getBtnRadioKelompok())){
              if(addTugas.getBtnRadioKelompok().isSelected()){
                   jenisTugas=2;
               }
              addTugas.addListener(this);
           }
           
           else if(source.equals(addTugas.gettFNamaTugas())){
               namaTugas = addTugas.gettFNamaTugas().getText();
           }
           else if(source.equals(addTugas.gettFJumlahSoal())){
               
               try{
               sjumlahSoal = Integer.parseInt(addTugas.gettFJumlahSoal().getText()); 
               }
               catch(NumberFormatException ne){
               JOptionPane.showMessageDialog(j, "Jumlah soal harus berisi angka");
               addTugas.settFJumlahSoal("");
               sjumlahSoal = 0;
               
               
              }
              addTugas.addListener(this);
               
           
           }
           
           
       
       }
       
       //bikinan chii
       else if(view instanceof MahasiswaUtamaView){ //menu utamanya mahasiswa abis login
           if (source.equals(mahasiswaUtama.getBtnProfile())){ //mau liat profil mahasiswa
               view = new MhsProfileView();
               mhsProfile = new MhsProfileView();
               mhsProfile.addListener(this);
               mahasiswaUtama.dispose();
               mhsProfile.setVisible(true);
           }
           else if (source.equals(mahasiswaUtama.getBtnKelas())){ //mau milih kelas
               view = new MhsPilihKelasView();
               mhsPilihKelas = new MhsPilihKelasView();
               mhsPilihKelas.addListener(this);
               mahasiswaUtama.dispose();
               mhsPilihKelas.setVisible(true);
            }
           else if (source.equals(mahasiswaUtama.getBtnLogout())){ //mau balik lagi ke login
               view =  new LoginView();
               login = new LoginView();
               login.addListener(this);
               mahasiswaUtama.dispose();
               currentUsername= "";
               password = "";
               login.setVisible(true);
           }
       }
       
       else if(view instanceof MhsProfileView){ //tampil info profil mahasiswa
           if (source.equals(mhsProfile.getBtnEditProfil())){ //mau edit profil mahasiswa
               view = new MhsEditProfileView();
               mhsEditProfile = new MhsEditProfileView();
               mhsEditProfile.addListener(this);
               mhsProfile.dispose();
               mhsEditProfile.setVisible(true);
           }
           
           else if (source.equals(mhsProfile.getBtnBack())){ //mau balik lagi ke menu utama mahasiswa
               view = new MahasiswaUtamaView();
               mahasiswaUtama = new MahasiswaUtamaView();
               mahasiswaUtama.addListener(this);
               mhsProfile.dispose();
               mahasiswaUtama.setVisible(true);
           }
           
       }
       
       else if(view instanceof MhsEditProfileView){ //mau edit si profilnya
           if (source.equals(mhsEditProfile.getBtnSubmit())){ //mau simpan data profil yang abis diedit
               view = new MhsProfileView();
               mhsProfile = new MhsProfileView();
               mhsProfile.addListener(this);
               mhsEditProfile.dispose();
               mhsProfile.setVisible(true);
           }
           
           else if (source.equals(mhsEditProfile.getBtnBack())){ //balik lagi ke profil, gajadi edit profilnya
               view = new MhsProfileView();
               mhsProfile = new MhsProfileView();
               mhsProfile.addListener(this);
               mhsEditProfile.dispose();
               mhsProfile.setVisible(true);
           }
       }
       
       else if(view instanceof MhsPilihKelasView){ //mau pilih kelas mahasiswa
           if (source.equals(mhsPilihKelas.getBtnPilih())){ //masuk ke kelas utama mahasiswa
               view = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa.addListener(this);
               mhsPilihKelas.dispose();
               kelasUtamaMahasiswa.setVisible(true);
           }
           else if (source.equals(mhsPilihKelas.getBtnBack())){ //gajadi pilih kelas, balik ke menu utama mahasiswa
               view = new MahasiswaUtamaView();
               mahasiswaUtama = new MahasiswaUtamaView();
               mahasiswaUtama.addListener(this);
               mhsPilihKelas.dispose();
               mahasiswaUtama.setVisible(true);
           }
       }
       
       else if(view instanceof MhsKelasUtamaMahasiswa){ //di menu kelas nya mahasiswa
           if (source.equals(kelasUtamaMahasiswa.getBtnBack())){ //balik ke menu pilih kelas
               view = new MhsPilihKelasView();
               mhsPilihKelas = new MhsPilihKelasView();
               mhsPilihKelas.addListener(this);
               kelasUtamaMahasiswa.dispose();
               mhsPilihKelas.setVisible(true);
           }
           else if (source.equals(kelasUtamaMahasiswa.getBtnPilihTugas())){ //mau liat list tugas dan pilih tugas
               view =  new MhsPilihTugasIndividuView();
               mhsPilihTugasIndividu =  new MhsPilihTugasIndividuView();
               mhsPilihTugasIndividu.addListener(this);
               kelasUtamaMahasiswa.dispose();
               mhsPilihTugasIndividu.setVisible(true);
           }
           else if (source.equals(kelasUtamaMahasiswa.getBtnGabungKelompok())){ //mau liat list kelompok dan gabung
               view = new MhsGabungKelompokView();
               mhsGabungKelompok = new MhsGabungKelompokView();
               mhsGabungKelompok.addListener(this);
               kelasUtamaMahasiswa.dispose();
               mhsGabungKelompok.setVisible(true);
           }
           else if (source.equals(kelasUtamaMahasiswa.getBtnKelolaKelompok())){ //mau liat dan kelola kelompok
               view = new MhsLihatKelompokView();
               mhsLihatKelompok = new MhsLihatKelompokView();
               mhsLihatKelompok.addListener(this);
               kelasUtamaMahasiswa.dispose();
               mhsLihatKelompok.setVisible(true);
           }
       }
       
       else if (view instanceof MhsPilihTugasIndividuView){
           if (source.equals(mhsPilihTugasIndividu.getBtnBack())){ //mau balik lagi ke menu kelas mahasiswa
               view = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa.addListener(this);
               mhsPilihTugasIndividu.dispose();
               kelasUtamaMahasiswa.setVisible(true);
           }
           else if(source.equals(mhsPilihTugasIndividu.getBtnPilih())){ //mau ngerjain tugas
               view = new MhsKerjakanTugasIndividuView();
               mhsKerjakanTugasIndividu = new MhsKerjakanTugasIndividuView();
               mhsKerjakanTugasIndividu.addListener(this);
               mhsPilihTugasIndividu.dispose();
               mhsKerjakanTugasIndividu.setVisible(true);
           }
       }
       
       else if (view instanceof MhsKerjakanTugasIndividuView){
           if (source.equals(mhsKerjakanTugasIndividu.getBtnBack())){ //balik lagi ke pilih tugas
               view = new MhsPilihTugasIndividuView();
               mhsPilihTugasIndividu = new MhsPilihTugasIndividuView();
               mhsPilihTugasIndividu.addListener(this);
               mhsKerjakanTugasIndividu.dispose();
               mhsPilihTugasIndividu.setVisible(true);
           }
           else if (source.equals(mhsKerjakanTugasIndividu.getBtnJawab())){ //pilih jawab tugas
               view = new MhsJawabTugasIndividuView();
               mhsJawabTugasIndividu = new MhsJawabTugasIndividuView();
               mhsJawabTugasIndividu.addListener(this);
               mhsKerjakanTugasIndividu.dispose();
               mhsJawabTugasIndividu.setVisible(true);
           }
       }
       
       else if (view instanceof MhsJawabTugasIndividuView){
           if(source.equals(mhsJawabTugasIndividu.getBtnLihatSoal())){ //mau liat soal nya lagi
               view = new MhsKerjakanTugasIndividuView();
               mhsKerjakanTugasIndividu = new MhsKerjakanTugasIndividuView();
               mhsKerjakanTugasIndividu.addListener(this);
               mhsJawabTugasIndividu.dispose();
               mhsKerjakanTugasIndividu.setVisible(true);
           }
           else if (source.equals(mhsJawabTugasIndividu.getBtnSubmit())){ //mau submit jawabannya
               view = new MhsKerjakanTugasIndividuView();
               mhsKerjakanTugasIndividu = new MhsKerjakanTugasIndividuView();
               mhsKerjakanTugasIndividu.addListener(this);
               mhsJawabTugasIndividu.dispose();
               mhsKerjakanTugasIndividu.setVisible(true);
           }
       }
       
       else if (view instanceof MhsGabungKelompokView){
           if (source.equals(mhsGabungKelompok.getBtnCancel())){ //gajadi gabung kelompoknya
               view = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa.addListener(this);
               mhsGabungKelompok.dispose();
               kelasUtamaMahasiswa.setVisible(true);
           }
           else if (source.equals(mhsGabungKelompok.getBtnGabung())){ //mau gabung ke kelompok yang dipilih
               view = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa.addListener(this);
               mhsGabungKelompok.dispose();
               kelasUtamaMahasiswa.setVisible(true);
           }
               
       }
       
       else if (view instanceof MhsLihatKelompokView){
           if(source.equals(mhsLihatKelompok.getBtnBack())){ //mau balik lagi ke 
               view = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa = new MhsKelasUtamaMahasiswa();
               kelasUtamaMahasiswa.addListener(this);
               mhsLihatKelompok.dispose();
               kelasUtamaMahasiswa.setVisible(true);
           }
           else if(source.equals(mhsLihatKelompok.getBtnInfoKelompok())){ //mau liat info kelompok
               view =  new MhsLihatInfoKelompokView();
               mhsLihatInfoKelompok =  new MhsLihatInfoKelompokView();
               mhsLihatInfoKelompok.addListener(this);
               mhsLihatKelompok.dispose();
               mhsLihatInfoKelompok.setVisible(true);
           }
           else if(source.equals(mhsLihatKelompok.getBtnPilihKetua())){ //mau pilih ketua kelompok
               view = new MhsPilihKetuaKelompokView();
               mhsPilihKetuaKelompok = new MhsPilihKetuaKelompokView();
               mhsPilihKetuaKelompok.addListener(this);
               mhsLihatKelompok.dispose();
               mhsPilihKetuaKelompok.setVisible(true);
           }
           else if(source.equals(mhsLihatKelompok.getBtnTugasKelompok())){ //mau liat tugas kelompoknya
               view = new MhsPilihTugasKelompokView();
               mhsPilihTugasKelompok = new MhsPilihTugasKelompokView();
               mhsPilihTugasKelompok.addListener(this);
               mhsLihatKelompok.dispose();
               mhsPilihTugasKelompok.setVisible(true);
           }
       }
       
       else if (view instanceof MhsPilihTugasKelompokView){
           if (source.equals(mhsPilihTugasKelompok.getBtnBack())){ //balik lagi ke liat list tugasnya
               view = new MhsLihatKelompokView();
               mhsLihatKelompok = new MhsLihatKelompokView();
               mhsLihatKelompok.addListener(this);
               mhsPilihTugasKelompok.dispose();
               mhsLihatKelompok.setVisible(true);
           }
           else if (source.equals(mhsPilihTugasKelompok.getBtnPilih())){ //pilih mau ngerjain tugas
               view = new MhsKerjakanTugasKelompokView();
               mhsKerjakanTugasKelompok = new MhsKerjakanTugasKelompokView();
               mhsKerjakanTugasKelompok.addListener(this);
               mhsPilihTugasKelompok.dispose();
               mhsKerjakanTugasKelompok.setVisible(true);
           }
           
       }
       
       else if (view instanceof MhsKerjakanTugasKelompokView){
           if(source.equals(mhsKerjakanTugasKelompok.getBtnBack())){ //balik lagi ke list pilih tugas
               view = new MhsPilihTugasKelompokView();
               mhsPilihTugasKelompok = new MhsPilihTugasKelompokView();
               mhsPilihTugasKelompok.addListener(this);
               mhsKerjakanTugasKelompok.dispose();
               mhsPilihTugasKelompok.setVisible(true);
           }
           else if(source.equals(mhsKerjakanTugasKelompok.getBtnJawab())){ //mau jawab soal nya
               view = new MhsJawabTugasKelompokView();
               mhsJawabTugasKelompok = new MhsJawabTugasKelompokView();
               mhsJawabTugasKelompok.addListener(this);
               mhsKerjakanTugasKelompok.dispose();
               mhsJawabTugasKelompok.setVisible(true);
           }
       }
       
       else if (view instanceof MhsJawabTugasKelompokView){
           if(source.equals(mhsJawabTugasKelompok.getBtnLihatSoal())){ //mau liat soalnya
               view = new MhsKerjakanTugasKelompokView();
               mhsKerjakanTugasKelompok = new MhsKerjakanTugasKelompokView();
               mhsKerjakanTugasKelompok.addListener(this);
               mhsJawabTugasKelompok.dispose();
               mhsKerjakanTugasKelompok.setVisible(true);
           }
           else if (source.equals(mhsJawabTugasKelompok.getBtnSubmit())){ //submit jawabannya
               view = new MhsKerjakanTugasKelompokView();
               mhsKerjakanTugasKelompok = new MhsKerjakanTugasKelompokView();
               mhsKerjakanTugasKelompok.addListener(this);
               mhsJawabTugasKelompok.dispose();
               mhsKerjakanTugasKelompok.setVisible(true);
           }
       }
       else if (view instanceof MhsLihatInfoKelompokView){
            if(source.equals(mhsLihatInfoKelompok.getBtnBack())){ //balik lagi ke lihat kelompok
                view = new MhsLihatKelompokView();
                mhsLihatKelompok = new MhsLihatKelompokView();
                mhsLihatKelompok.addListener(this);
                mhsLihatInfoKelompok.dispose();
                mhsLihatKelompok.setVisible(true);
        }
    }
       else if (view instanceof MhsPilihKetuaKelompokView){
           if(source.equals(mhsPilihKetuaKelompok.getBtnCancel())){ //balik lagi ke lihat kelompok
               view = new MhsLihatKelompokView();
               mhsLihatKelompok = new MhsLihatKelompokView();
               mhsLihatKelompok.addListener(this);
               mhsPilihKetuaKelompok.dispose();
               mhsLihatKelompok.setVisible(true);
           }
           else if(source.equals(mhsPilihKetuaKelompok.getBtnPilih())){ //pilih ketua kelompok dari list anggota
               view = new MhsLihatInfoKelompokView();
               mhsLihatInfoKelompok = new MhsLihatInfoKelompokView();
               mhsLihatInfoKelompok.addListener(this);
               mhsPilihKetuaKelompok.dispose();
               mhsLihatInfoKelompok.setVisible(true);
           }
       }  
       //sampe sini
    } 
}
