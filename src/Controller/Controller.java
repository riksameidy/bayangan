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
import tubesbayangan.POJO.Kelompok;
import tubesbayangan.POJO.Mahasiswa;

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
    private PengelolaanTugasView kelolaTugas;
    private AddTugasDosenView addTugas;
    private PilihTugasDosen pilTugas;
    private AddSoalView addSoal;
    private PengelolaanMahasiswa kelolaMhs;
    private AddMahasiswaView addMhs;
    private ViewMahasiswaKelas viewMhs;
    private PilihKelompokView pilKelompok;
    private PilihKelompokViewEdit pilKelompokEdit;
    
    
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
    
    private int noKelompok;
    private int JumlahKelompok;
    
    
    
    private int status = 0; //1 jika Mhs , 2 jika Dosen;
    private int jenisTugas=0; //1 jika Individu , 2 Jika Kelompok
    
    private String currentUsername;
    private String currentKodeKelas;
    private String currentTugas;
    private int    currentNoKelompok;
    private String myDosen;
    
    private long nimAdd;
    
    
    private PengelolaanKelompokDosen kelolaKelompok;
    private CreateKelompokDosen createKelompok;
    
    
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
        int idxTugas;
        int idxKelompok;
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
                                currentUsername = username;
                                
                                nama = "";
                                password="";
                                email = "";
                                
                                login.setNotification("Login Berhasil sebagai Mahasiswa");
                                view = new MahasiswaUtamaView();
                                mahasiswaUtama = new MahasiswaUtamaView();
                                login.dispose();
                                mahasiswaUtama.setVisible(true);
                                mahasiswaUtama.addListener(this);
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
               
               
               
               view = new PengelolaanKelompokDosen();
               kelolaKelompok = new PengelolaanKelompokDosen();
               kelolaKelompok.setVisible(true);
               kelolaKelompok.AddListener(this);
               kelasUtamaDosen.dispose();
           
           }
           else if(source.equals(kelasUtamaDosen.getBtnMhs())){
               
               view = new PengelolaanMahasiswa();
               kelolaMhs = new PengelolaanMahasiswa();
               kelolaMhs.setVisible(true);
               kelolaMhs.AddListener(this);
               kelasUtamaDosen.dispose();
           
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
               
               view = new AddTugasDosenView();
               addTugas = new AddTugasDosenView();
               addTugas.setVisible(true);
               kelolaTugas.dispose();
               addTugas.addListener(this);
               
           
           }
           else if(source.equals(kelolaTugas.getBtnPilihTugas())){
               
               idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
               int jum = apps.getDosen(currentUsername).getKelas(idx).getJumlahTugas();
               if(jum==0){
                   JOptionPane.showMessageDialog(j, "Belum Memiliki Tugas");
                   kelolaTugas.addListener(this);
                   
               }
               else{
                   view = new PilihTugasDosen();
                   pilTugas = new PilihTugasDosen();
                   pilTugas.setVisible(true);
                   kelolaTugas.dispose();
                   pilTugas.AddListener(this);
                   String[] temp;
                   
                   
                   temp = apps.getDosen(currentUsername).getKelas(idx).getAllTugasnotAssigned();
                   
                   if(temp==null){
                       temp = new String[1];
                       temp[0] = "Tidak Ada Tugas";
                       pilTugas.setList(temp);
                   }
                   else{
                       pilTugas.setList(temp);
                   } 
                   
                   temp = apps.getDosen(currentUsername).getKelas(idx).getAllTugasAssigned();
                   
                   if(temp==null){
                       temp = new String[1];
                       temp[0] = "Tidak Ada Tugas ";
                       pilTugas.setListTugasAssigned(temp);
                   
                   }
                   else{
                       pilTugas.setListTugasAssigned(temp);
                     
                   }
                   
                   
               }
               
               
               
               
               
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
       
       else if(view instanceof PilihTugasDosen){
           
           if(source.equals(pilTugas.getBtnBack())){
               view = new PengelolaanTugasView();
               kelolaTugas = new PengelolaanTugasView();
               kelolaTugas.setVisible(true);
               kelolaTugas.addListener(this);
               pilTugas.dispose();
           
           }
           else if(source.equals(pilTugas.getBtnAssign())){
               
               currentTugas = pilTugas.getListTugas().getSelectedValue();
               if(currentTugas==null){
                   JOptionPane.showMessageDialog(j,"Silahkan Pilih Tugas");
               }
               else if(currentTugas.equals("Tidak Ada Tugas")){
                   JOptionPane.showMessageDialog(j,"Tidak ada Tugas yang dipilih");
               }
               else{
                   
                   String[] s;
                   idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
                   idxTugas = apps.getDosen(currentUsername).getKelas(idx).idxTugas(currentTugas);
                   int x = apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getMaxSoal();
                   s = new String[x];
                   for(int i=0;i<x;i++){
                       s[i] = "soal "+ Integer.toString(i+1);
                   }
                   
                   
                   view = new AddSoalView();
                   addSoal = new AddSoalView();
                   addSoal.setVisible(true);
                   
                   addSoal.setComboBoxSoal(s);
                   addSoal.setlNamaTugas(apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getNamaTugas());
                   
                   addSoal.addListener(this);
                   pilTugas.dispose();
                   
               }
               
               
           }
           
           else if(source.equals(pilTugas.getBtnEdit())){
               currentTugas = pilTugas.getListTugasAssigned().getSelectedValue();
               if(currentTugas==null){
                   JOptionPane.showMessageDialog(j,"Silahkan Pilih Tugas yang akan di edit");
               }
               else if(currentTugas.equals("Tidak Ada Tugas")){
                   JOptionPane.showMessageDialog(j,"Tidak ada Tugas yang dipilih");
               }
               else{
                    
                   String[] s;
                   idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
                   idxTugas = apps.getDosen(currentUsername).getKelas(idx).idxTugas(currentTugas);
                   int x = apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getMaxSoal();
                   s = new String[x];
                   for(int i=0;i<x;i++){
                       s[i] = "soal "+ Integer.toString(i+1);
                   }
                   
                   
                   view = new AddSoalView();
                   addSoal = new AddSoalView();
                   addSoal.setVisible(true);
                   
                   addSoal.setComboBoxSoal(s);
                   addSoal.setlNamaTugas(apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getNamaTugas());
                   
                   addSoal.addListener(this);
                   pilTugas.dispose();
                   
                   
                   
               }
           
           }
       
       }
       
       else if(view instanceof AddSoalView){
           
           int idxCbSoal = addSoal.getComboBoxSoal().getSelectedIndex();
           
           if(source.equals(addSoal.getBtnAddSoal())){
               if(addSoal.getTfInputSoal().getText().equals("")){
                   JOptionPane.showMessageDialog(j, "Field Soal tidak boleh Kosong");
               }
               else{
                   
                       idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
                       idxTugas = apps.getDosen(currentUsername).getKelas(idx).idxTugas(currentTugas);
                       String s = addSoal.getTfInputSoal().getText();
                       apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).addSoal(s);
                       addSoal.settFshowSoal(apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getSoal(idxCbSoal));
                   
                   JOptionPane.showMessageDialog(j, "Soal Berhasil Ditambahkan");
               }
               
           }
           else if(source.equals(addSoal.getBtnFinish())){
               idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
               idxTugas = apps.getDosen(currentUsername).getKelas(idx).idxTugas(currentTugas);
               
               //assign to mahasiswa here
               apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).setStatusAssign(true);
               
               view = new PengelolaanTugasView();
               kelolaTugas = new PengelolaanTugasView();
               kelolaTugas.setVisible(true);
               kelolaTugas.addListener(this);
               addSoal.dispose();
           
           }
           
           
           else if(source.equals(addSoal.getComboBoxSoal())){
               idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
               idxTugas = apps.getDosen(currentUsername).getKelas(idx).idxTugas(currentTugas);
               //int x = apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getJumlahSoal();
               addSoal.settFshowSoal(apps.getDosen(currentUsername).getKelas(idx).getTugas(idxTugas).getSoal(idxCbSoal));
               addSoal.setTfInputSoal("");
               
               
           }
           
           
           
       
       
       }
       
       else if (view instanceof PengelolaanKelompokDosen){
           
           if(source.equals(kelolaKelompok.getBtnCreateKelompok())){
               
               view = new CreateKelompokDosen();
               createKelompok = new CreateKelompokDosen();
               createKelompok.setVisible(true);
               kelolaKelompok.dispose();
               createKelompok.AddListener(this);
               
           }
           else if(source.equals(kelolaKelompok.getBtnBack())){
               view = new MenuKelasUtamaDosen();
               kelasUtamaDosen = new MenuKelasUtamaDosen();
               kelasUtamaDosen.setVisible(true);
               kelolaKelompok.dispose();
               kelasUtamaDosen.addListener(this);
               
           
           }
           else if(source.equals(kelolaKelompok.getBtnPilihKelompok())){
               
               view = new PilihKelompokView();
               pilKelompok = new PilihKelompokView();
               
               int[] kel;
               kel = apps.getDosen(currentUsername).getKelas(apps.getDosen(currentUsername).idxKelas(currentKodeKelas)).getAllKelompok();
               int jum = apps.getDosen(currentUsername).getKelas(apps.getDosen(currentUsername).idxKelas(currentKodeKelas)).getJumlahKelompok();
               if(jum==0){
                   pilKelompok.setlKelompok(new String[]{"Tidak ada"});
               }
               else{
                   String[] s = new String[jum];
                   for (int i = 0; i < s.length; i++) {
                       s[i] = Integer.toString(kel[i]);
                       
                   }
                   pilKelompok.setlKelompok(s);
               }
               
               
               pilKelompok.setVisible(true);
               pilKelompok.addListener(this);
               kelolaKelompok.dispose();
           
           }
           
       
       }
       
       else if(view instanceof PilihKelompokView){
       
           if (source.equals(pilKelompok.getBtnBack())){
               
               view = new PengelolaanKelompokDosen();
               kelolaKelompok = new PengelolaanKelompokDosen();
               kelolaKelompok.setVisible(true);
               pilKelompok.dispose();
               kelolaKelompok.AddListener(this);
               
           }
           else if(source.equals(pilKelompok.getBtnDelete())){
               if(pilKelompok.getlKelompok().getSelectedValue().equals("Tidak ada")){
                   
                   pilKelompok.addListener(this);
                   
               }
               else{
                   String s = pilKelompok.getlKelompok().getSelectedValue();
                   int x = Integer.parseInt(s);
                   int idxMhs = apps.getDosen(currentUsername).getKelas(apps.getDosen(currentUsername).idxKelas(currentKodeKelas)).idxKelompok(x);
                   apps.getDosen(currentUsername).getKelas(apps.getDosen(currentUsername).idxKelas(currentKodeKelas)).deleteKelompok(idxMhs);
                   
                   JOptionPane.showMessageDialog(j, "Mahasiswa Telah Dihapus");
                   
                   view = new PengelolaanKelompokDosen();
                   kelolaKelompok = new PengelolaanKelompokDosen();
                   kelolaKelompok.setVisible(true);
                   kelolaKelompok.AddListener(this);
                   pilKelompok.dispose();
                   
                   
                   
               }
               
           
           }
           else if(source.equals(pilKelompok.getBtnPilih())){
               
               String s = pilKelompok.getlKelompok().getSelectedValue();
               
               if(s==null){
                   JOptionPane.showMessageDialog(j, "Silahkan Pilih Kelompok");
                       pilKelompok.addListener(this);
               }
               
               else{
                   if(s.equals("Tidak ada")){
                   JOptionPane.showMessageDialog(j, "Tidak ada Kelompok yang dipilih");
                       pilKelompok.addListener(this);
                   }
                   else{
                       
                       view = new PilihKelompokViewEdit();
                       pilKelompokEdit = new PilihKelompokViewEdit();
                       pilKelompokEdit.setVisible(true);
                       pilKelompok.dispose();
                       pilKelompokEdit.AddListener(this);
                       
                       //inisiasi label + list Anggota
                       idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
                       idxKelompok = apps.getDosen(currentUsername).getKelas(idx).idxKelompok(Integer.parseInt(s));
                       
                       String ketu;
                       
                       noKelompok = apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).getNoKelompok();
                       currentNoKelompok = noKelompok;
                       pilKelompokEdit.setLabelNoKelompok(Integer.toString(noKelompok));
                       
                       try{
                           long s1 = apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).getKetua().getNim();
                           ketu = Long.toString(s1);
                       }
                       catch(Exception ex){
                           
                           ketu = "None";
                       }
                       
                       pilKelompokEdit.setLabelKetua(ketu);
                       
                       String[] listAnggota;
                       
                       long temps[];
                       temps = apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).getAllnimMhs();
                       if(temps==null){
                           pilKelompokEdit.setlAnggota(new String[]{"None"});
                       }
                       else{
                           listAnggota = new String[temps.length];
                           for (int i = 0; i < temps.length; i++) {
                               listAnggota[i] = Long.toString(temps[i]);
                           }
                           
                           pilKelompokEdit.setlAnggota(listAnggota);
                           
                       
                       }
                       
                       
                       
                       
                       
                       
                       
                   
                   }
                   
               }
           
           }
           
       
       
       
       }
       else if(view instanceof PilihKelompokViewEdit){
           
            idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
            idxKelompok = apps.getDosen(currentUsername).getKelas(idx).idxKelompok(currentNoKelompok);
            
           
           if(source.equals(pilKelompokEdit.getBtnAddMhs())){
               
               if(nimAdd==0){JOptionPane.showMessageDialog(j, "Silahkan inputkan NIM");}
               else{
                   
               if(apps.getDosen(currentUsername).getKelas(idx).idxMhs(nimAdd)!=-1){
               
               Mahasiswa m = apps.getMhs(nimAdd);
               apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).addAnggota(m);
               
               
               JOptionPane.showMessageDialog(j, "Berhasil Ditambahkan");
               view = new PilihKelompokViewEdit();
               pilKelompokEdit.dispose();
               pilKelompokEdit = new PilihKelompokViewEdit();
               pilKelompokEdit.setVisible(true);
               pilKelompokEdit.AddListener(this);
               
             
                       
                       //inisiasi label + list Anggota
                       String ketu;
                       
                      
                       pilKelompokEdit.setLabelNoKelompok(Integer.toString(currentNoKelompok));
                       
                       try{
                           long s1 = apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).getKetua().getNim();
                           ketu = Long.toString(s1);
                       }
                       catch(Exception ex){
                           
                           ketu = "None";
                       }
                       
                       pilKelompokEdit.setLabelKetua(ketu);
                       
                       String[] listAnggota;
                       
                       long temps[] = null;
                       temps = apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).getAllnimMhs();
                       
                       if(temps==null){
                           pilKelompokEdit.setlAnggota(new String[]{"None"});
                       }
                       else{
                           listAnggota = new String[temps.length];
                           for (int i = 0; i < temps.length; i++) {
                               listAnggota[i] = Long.toString(temps[i]);
                           }
                           
                           pilKelompokEdit.setlAnggota(listAnggota);
                           
                       
                       }
                       nimAdd = 0;
               }
               else{
                   JOptionPane.showMessageDialog(j, "Mahasiswa Tidak Ada di Kelas");
               }
               }    
               
           
           }
           else if(source.equals(pilKelompokEdit.getBtnBack())){
               view = new PengelolaanKelompokDosen();
               kelolaKelompok = new PengelolaanKelompokDosen();
               kelolaKelompok.setVisible(true);
               pilKelompokEdit.dispose();
               kelolaKelompok.AddListener(this);
               
           }
           else if(source.equals(pilKelompokEdit.getBtnSetKetua())){
               
              String s = pilKelompokEdit.getlAnggota().getSelectedValue();
              if(s==null){
                  JOptionPane.showMessageDialog(j, "silahkan pilih Mahasiswa");
                  pilKelompokEdit.AddListener(this);
              }
              else{
                  
                  if(s.equals("None")){
                      JOptionPane.showMessageDialog(j, "Tidak ada Mahasiswa Dipilih");
                      pilKelompokEdit.AddListener(this);
                  }
                  else{
                      int idxKetu = apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).idxAnggota(Long.parseLong(s));
                      apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).setKetua(idxKetu);
                      JOptionPane.showMessageDialog(j, "Berhasil");
                      pilKelompokEdit.dispose();
                      view = new PilihKelompokViewEdit();
                      pilKelompokEdit = new PilihKelompokViewEdit();
                      
                      
                      
                      String ketu;
                       
                      
                       pilKelompokEdit.setLabelNoKelompok(Integer.toString(currentNoKelompok));
                       
                       try{
                           long s1 = apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).getKetua().getNim();
                           ketu = Long.toString(s1);
                       }
                       catch(Exception ex){
                           
                           ketu = "None";
                       }
                       
                       pilKelompokEdit.setLabelKetua(ketu);
                       
                       String[] listAnggota;
                       
                       long temps[] = null;
                       temps = apps.getDosen(currentUsername).getKelas(idx).getKelompok(idxKelompok).getAllnimMhs();
                       
                       if(temps==null){
                           pilKelompokEdit.setlAnggota(new String[]{"None"});
                       }
                       else{
                           listAnggota = new String[temps.length];
                           for (int i = 0; i < temps.length; i++) {
                               listAnggota[i] = Long.toString(temps[i]);
                           }
                           
                           pilKelompokEdit.setlAnggota(listAnggota);
                           
                       
                       }
                       nimAdd = 0;
                      
                      
                      pilKelompokEdit.setVisible(true);
                      pilKelompokEdit.AddListener(this);
                  
                  }
              
              }
               
           
           }
           
           else if(source.equals(pilKelompokEdit.getTfNim())){
              
               try{
                   long s = Long.parseLong(pilKelompokEdit.getTfNim().getText());
                   if(apps.searchMhs(s)==-1){
                       
                       JOptionPane.showMessageDialog(j, "Mahasiswa Tidak Ditemukan");
                       pilKelompokEdit.AddListener(this);
                   }
                   else{
                       idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
                       
                       int[] tempkelompok = apps.getDosen(currentUsername).getKelas(idx).getAllKelompok();
                       
                       int foundMhs = -1;
                       for (int i = 0; i < tempkelompok.length; i++) {
                           int jmk = apps.getDosen(currentUsername).getKelas(idx).getKelompok(i).getMaxAnggota();
                           for(int k=0;k<jmk;k++){
                               if(apps.getDosen(currentUsername).getKelas(idx).getKelompok(i).getAnggota(k)!=null){
                                    if(apps.getDosen(currentUsername).getKelas(idx).getKelompok(i).getAnggota(k).getNim()==s){
                                        foundMhs=k;
                                    }
                               }
                           
                           }    
                       }
                       if(foundMhs==-1){
                           nimAdd = s;
                           
                       }
                       else{
                           JOptionPane.showMessageDialog(j, "Mahasiswa Sudah Gabung di Kelompok Lain");
                       }
                   
                   }
                   
               }
               catch(NumberFormatException ex){
                   
                   JOptionPane.showMessageDialog(j, "NIM must be a number");
                   pilKelompokEdit.AddListener(this);
               }
           
           
           }
       }
       
       
       else if(view instanceof CreateKelompokDosen){
           
           
           
           if(source.equals(createKelompok.getBtnSubmit())){
               if(noKelompok<=0||JumlahKelompok<=0){
                   JOptionPane.showMessageDialog(j, "No kelompok Harus lebih dari 0");
                   createKelompok.AddListener(this);
               }
               else{
                   
                   idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
                   idxKelompok = apps.getDosen(currentUsername).getKelas(idx).idxKelompok(noKelompok);
                   if(idxKelompok==-1){
                       
                       apps.getDosen(currentUsername).getKelas(idx).addKelompok(new Kelompok(noKelompok,JumlahKelompok));
                       JOptionPane.showMessageDialog(j,"Kelompok Berhasil Ditambahkan");
                       
                       view = new PengelolaanKelompokDosen();
                       kelolaKelompok = new PengelolaanKelompokDosen();
                       kelolaKelompok.setVisible(true);
                       createKelompok.dispose();
                       kelolaKelompok.AddListener(this);
                       
                   }
                   else{
                   JOptionPane.showMessageDialog(j, "No Kelompok Sudah ada");
                    createKelompok.AddListener(this);
                   }
                   
                   
                   
                   
               }
               
               
           }
           else if(source.equals(createKelompok.getBtnCancel())){
               
               noKelompok = 0;
               JumlahKelompok = 0;
               
               view = new PengelolaanKelompokDosen();
               kelolaKelompok = new PengelolaanKelompokDosen();
               kelolaKelompok.setVisible(true);
               createKelompok.dispose();
               kelolaKelompok.AddListener(this);
               
               
           }
           
           else if(source.equals(createKelompok.getTfNoKelompok())){
               String sNo = createKelompok.getTfNoKelompok().getText();
               try{
               noKelompok = Integer.parseInt(sNo);
               
               }
               catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(j, "Haruslah Berupa Angka");
               
               }
               createKelompok.AddListener(this);
               
               
           }
           
           else if(source.equals(createKelompok.gettFJumlahAnggota())){
           
               String sNo = createKelompok.gettFJumlahAnggota().getText();
               try{
               JumlahKelompok = Integer.parseInt(sNo);
               
               }
               catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(j, "Haruslah Berupa Angka");
               
               }
               createKelompok.AddListener(this);
           
           }
       
       }
       
       else if(view instanceof PengelolaanMahasiswa){
           
           if(source.equals(kelolaMhs.getBtnAdd())){
               view = new AddMahasiswaView();
               addMhs = new AddMahasiswaView();
               addMhs.setVisible(true);
               kelolaMhs.dispose();
               addMhs.addListener(this);
           
           }
           else if(source.equals(kelolaMhs.getBtnView())){
               
               view = new ViewMahasiswaKelas();
               viewMhs = new ViewMahasiswaKelas();
               kelolaMhs.dispose();
               
               long[] tempss;
               idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
               tempss = apps.getDosen(currentUsername).getKelas(idx).getAllnim();
               if(tempss==null){
                   String[] s = new String[1];
                   s[0] = "Tidak ada Mahasiswa Dalam Kelas";
                   viewMhs.setlMahasiswa(s);
                   
               }
               else{
                   String[] s = new String[tempss.length];
                   for (int i = 0; i < s.length; i++) {
                        s[i] = Long.toString(tempss[i]);
                   }
                   viewMhs.setlMahasiswa(s);
                    
                   
               }
               
               viewMhs.setVisible(true);
               viewMhs.AddListener(this);
               
           
           }
           
           else if(source.equals(kelolaMhs.getBtnBack())){
           
               view = new MenuKelasUtamaDosen();
               kelasUtamaDosen = new MenuKelasUtamaDosen();
               kelasUtamaDosen.setVisible(true);
               kelolaMhs.dispose();
               kelasUtamaDosen.addListener(this);
           
           }
           
       
       }
       
       else if(view instanceof AddMahasiswaView){
           if(source.equals(addMhs.getBtnAdd())){
               int idxNim = apps.searchMhs(nimAdd);
               if(idxNim==-1){
                   JOptionPane.showMessageDialog(j, "NIM Mahasiswa Tidak ada");
                   
               }
               else{
                   
                   
                   idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
                   
                   if(apps.getDosen(currentUsername).getKelas(idx).getJumlahMhs()< apps.getDosen(currentUsername).getKelas(idx).getMaxMhs()){
                   
                        if(apps.getDosen(currentUsername).getKelas(idx).idxMhs(nimAdd)!=-1){
                            
                        JOptionPane.showMessageDialog(j, "Mhs Sudah ada dalam Kelas");
                        
                        }
                        else{
                       
                        apps.getDosen(currentUsername).getKelas(idx).addMahasiswa(apps.getMhs(nimAdd)); 
                        apps.getMhs(nimAdd).tambahKelas();
                        JOptionPane.showMessageDialog(j, "Berhasil Ditambahkan");
                        
                        view = new PengelolaanMahasiswa();
                        kelolaMhs  = new PengelolaanMahasiswa();
                        kelolaMhs.setVisible(true);
                        kelolaMhs.AddListener(this);
                        addMhs.dispose();
                        }
                   }
                   else{
                        JOptionPane.showMessageDialog(j, "Kelas sudah Penuh ");
                        addMhs.addListener(this);
                   }
                   
                   
                   
                   
               }
           }
           else if(source.equals(addMhs.getBtnBack())){
               
               view = new PengelolaanMahasiswa();
               kelolaMhs  = new PengelolaanMahasiswa();
               kelolaMhs.setVisible(true);
               kelolaMhs.AddListener(this);
               addMhs.dispose();
               
           }
           
           else if(source.equals(addMhs.getTfNIM())){
               
               String temps = addMhs.getTfNIM().getText(); 
               try{
                   nimAdd = Long.parseLong(temps);
                   
               }
               catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(j, "NIM Haruslah berupa Angka");
                   addMhs.addListener(this);
               }
           
           }
           
           
       }
       
       else if(view instanceof ViewMahasiswaKelas){
           if(source.equals(viewMhs.getBtnBack())){
               
               view = new PengelolaanMahasiswa();
               kelolaMhs = new PengelolaanMahasiswa();
               kelolaMhs.setVisible(true);
               viewMhs.dispose();
               kelolaMhs.AddListener(this);
               
           }
           
           else if(source.equals(viewMhs.getBtnDelete())){
               
               if(viewMhs.getlMahasiswa().getSelectedValue().equals("Tidak ada Mahasiswa Dalam Kelas")){
                   JOptionPane.showMessageDialog(j, "Tidak ada Mahasiswa yang dipilih");
                   viewMhs.AddListener(this);
                   
                   
               }
               else{
                   idx = apps.getDosen(currentUsername).idxKelas(currentKodeKelas);
                   String s = viewMhs.getlMahasiswa().getSelectedValue();
                   long delNim = Long.parseLong(s);
                   int idxMhs = apps.getDosen(currentUsername).getKelas(idx).idxMhs(delNim);
                   apps.getDosen(currentUsername).getKelas(idx).deleteMhsInKelompok(delNim);
                   apps.getDosen(currentUsername).getKelas(idx).deleteMhs(idxMhs);
                   apps.getMhs(delNim).kurangiKelas();
                   
                   
                   
                   JOptionPane.showMessageDialog(j, "Berhasil Dihapus Dari Kelas");
                   
                   view = new PengelolaanMahasiswa();
                   kelolaMhs = new PengelolaanMahasiswa();
                   kelolaMhs.setVisible(true);
                   
                   viewMhs.dispose();
                   
                   kelolaMhs.AddListener(this);
                   
                   
                   
                   
               
               }
               
               
           
           }
       
       }
            
       
      //bikinan chii
       else if(view instanceof MahasiswaUtamaView){ //menu utamanya mahasiswa abis login
           
           if (source.equals(mahasiswaUtama.getBtnProfile())){ //mau liat profil mahasiswa
               
               
               view = new MhsProfileView();
               mhsProfile = new MhsProfileView();
               mahasiswaUtama.dispose();
               
               Mahasiswa m = apps.getMhs(currentUsername);
               
               if(m.getNama()!=null){
               mhsProfile.setLabelEmail(m.getNama());
               }
               if(Long.toString(m.getNim())!=null){
               mhsProfile.setLabelNIM(Long.toString(m.getNim()));
               }
               if(m.getNama()!=null){
               mhsProfile.setLabelNama(m.getNama());
               }
               
               mhsProfile.setVisible(true);
               mhsProfile.addListener(this);
               
               
               
           }
           
           else if (source.equals(mahasiswaUtama.getBtnKelas())){ //mau milih kelas
               view = new MhsPilihKelasView();
               mhsPilihKelas = new MhsPilihKelasView();
               mahasiswaUtama.dispose();
               
               Mahasiswa m = apps.getMhs(currentUsername);
               
               String[] l;
               l = apps.searchMhsInKelas(m);
               if(l==null){
                   mhsPilihKelas.setListKelasMahasiswa(new String[]{"Tidak Ada Kelas"});
               }
               else{
                   mhsPilihKelas.setListKelasMahasiswa(l);
                   
               }
               
               
               
               
               mhsPilihKelas.setVisible(true);
               mhsPilihKelas.addListener(this);
               
               
               
               
               
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
               
               if(nama.equals("")||password.equals("")||email.equals("")){
                   JOptionPane.showMessageDialog(j, "Silahkan Isi Field");
                   mhsEditProfile.addListener(this);
               }
               else{
               
               
               apps.getMhs(currentUsername).setPassword(password);
               apps.getMhs(currentUsername).setNama(nama);
               apps.getMhs(currentUsername).setEmail(email);
               JOptionPane.showMessageDialog(j, "Berhasil Di edit");
               
               view = new MhsProfileView();
               mhsProfile = new MhsProfileView();
               mhsEditProfile.dispose();
               Mahasiswa m = apps.getMhs(currentUsername);
               
               if(m.getNama()!=null){
               mhsProfile.setLabelEmail(m.getNama());
               }
               if(Long.toString(m.getNim())!=null){
               mhsProfile.setLabelNIM(Long.toString(m.getNim()));
               }
               if(m.getNama()!=null){
               mhsProfile.setLabelNama(m.getNama());
               }
               
               mhsProfile.setVisible(true);
               mhsProfile.addListener(this);
               
               }
           }
               
           
           
           else if (source.equals(mhsEditProfile.getBtnBack())){ //balik lagi ke profil, gajadi edit profilnya
               view = new MhsProfileView();
               mhsProfile = new MhsProfileView();
               mhsProfile.addListener(this);
               mhsEditProfile.dispose();
               mhsProfile.setVisible(true);
           }
           
           else if(source.equals(mhsEditProfile.getTfNamaEdit())){
               nama = mhsEditProfile.getTfNamaEdit().getText();
           }
           
           else if(source.equals(mhsEditProfile.getTfEmailEdit())){
               email = mhsEditProfile.getTfEmailEdit().getText();
           }
           else if(source.equals(mhsEditProfile.gettFPassEdit())){
               password = mhsEditProfile.gettFPassEdit().getText();
           
           }
       }
       
       
       
       else if(view instanceof MhsPilihKelasView){ //mau pilih kelas mahasiswa
           if (source.equals(mhsPilihKelas.getBtnPilih())){ //masuk ke kelas utama mahasiswa
            String s = mhsPilihKelas.getListKelasMahasiswa().getSelectedValue();
               
               if(s==null){
                   JOptionPane.showMessageDialog(j, "Silahkan Pilih Kelas");
                   mhsPilihKelas.addListener(this);
               }
               else{
                   if(s.equals("Tidak Ada Kelas")){
                   JOptionPane.showMessageDialog(j, "Tidak Ada Kelas yang Dipilih");
                   mhsPilihKelas.addListener(this);
                       
                   }
                   else{
                    
                    
                    
                    view = new MhsKelasUtamaMahasiswa();
                    kelasUtamaMahasiswa = new MhsKelasUtamaMahasiswa();
                    
                    currentKodeKelas = s;
                    myDosen = apps.getDosenbyKelas(currentKodeKelas).getUsername();
                    kelasUtamaMahasiswa.setjLabel1(currentKodeKelas);
                    
    
                    mhsPilihKelas.dispose();
                    kelasUtamaMahasiswa.setVisible(true);
                    kelasUtamaMahasiswa.addListener(this);
                   
                   }
               
               }
               
               
               
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
               kelasUtamaMahasiswa.dispose();
               
               Mahasiswa m = apps.getMhs(currentUsername);
               
               String[] l;
               l = apps.searchMhsInKelas(m);
               if(l==null){
                   mhsPilihKelas.setListKelasMahasiswa(new String[]{"Tidak Ada Kelas"});
               }
               else{
                   mhsPilihKelas.setListKelasMahasiswa(l);
                   
               }
               
               mhsPilihKelas.setVisible(true);
               mhsPilihKelas.addListener(this);
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

    }
    
    
}
