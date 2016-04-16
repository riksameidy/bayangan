/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apps;

import java.util.ArrayList;
import java.util.List;
import tubesbayangan.POJO.Dosen;
import tubesbayangan.POJO.Kelompok;
import tubesbayangan.POJO.Mahasiswa;
import tubesbayangan.POJO.MataKuliah;


/**
 *
 * @author ASUS
 */
public class Apps {
    
    private List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private List<Dosen> daftarDosen = new ArrayList<>();
    private List<Kelompok> daftarKelompok = new ArrayList<>();
    private List<MataKuliah> daftarMK = new ArrayList<>();
    
    public String[] searchMhsInKelas(Mahasiswa m){
        
        if(m.getJumlahKelas()==0){
            return null;
        }
        else{
        String[] temp = new String[m.getJumlahKelas()];
        int idx = 0;
        for (Dosen d : daftarDosen) {
            for(int i=0;i<d.getJumlahKelas();i++){
                for(int j=0;j< d.getKelas(i).getJumlahMhs();j++){
                    if(d.getKelas(i).getMahasiswa(j).getNim()==m.getNim()){
                        temp[idx] = d.getKelas(i).getNama();
                        idx++;
                    }
                }
            }
        }
            return temp;
        }
    
    }
    
    public boolean searchMhsinKelompok(Kelompok k, long nim){
        boolean found = false;
        for (int i = 0; i < k.getJumlahAnggota(); i++) {
            if(k.getAnggota(i).getNim()==nim){
                found = true;
            }
            
        }
        return found;
    }
    
    public Dosen getDosenbyKelas(String kodeKelas){
        Dosen dos = null;
        
        for (Dosen d : daftarDosen) {
            for (int i = 0; i < d.getJumlahKelas(); i++) {
                if(d.getKelas(i).getNama().equals(kodeKelas)){
                    dos = d;
                }
                
            }
        }
        return dos;
    
    }
    
    public void createDosen(long nip){
        Dosen d = new Dosen(nip);
        daftarDosen.add(d);
    } 
    public void  addDosen(Dosen d){
        daftarDosen.add(d);
    }
    public Dosen getDosen(long nip){
        Dosen d = null;
        for(Dosen c: daftarDosen){
            if(c.getNip()==nip){
                d= c;
            }
        }
        return d;
    }
    public Dosen getDosen(String username){
        Dosen d = null;
        for(Dosen c: daftarDosen){
            if(c.getUsername().equals(username)){
                d= c;
            }
        }
        return d;
    }
    public boolean isDosenAda(long nip){
        return daftarDosen.contains(this.getDosen(nip));
    }
    public int searchDosen(long nip){
        return daftarDosen.indexOf(getDosen(nip));
    }
    public int searchDosen(String username){
        return daftarDosen.indexOf(getDosen(username));
    }
    public void deleteDosen(long nip){
        daftarDosen.remove(getDosen(nip));
    }
    
    public void createMhs(long nim){
        Mahasiswa m = new Mahasiswa(nim);
        daftarMahasiswa.add(m);
    }
    public Mahasiswa getMhs(long nim){
        Mahasiswa m= null;
        for(Mahasiswa c: daftarMahasiswa){
            if(c.getNim()==nim){
                m=c;
            }
        }
        return m;
    }
    public Mahasiswa getMhs(String username){
        Mahasiswa m= null;
        for(Mahasiswa c: daftarMahasiswa){
            if(username.equals(c.getUsername())){
                m=c;
            }
        }
        return m;
    }
    public boolean isMhsAda(long nim){
        return daftarMahasiswa.contains(getMhs(nim));
    }
    public int searchMhs(long nim){
        return daftarMahasiswa.indexOf(getMhs(nim));
    }
    public int searchMhs(String username){
        return daftarMahasiswa.indexOf(getMhs(username));
    }
    public void deleteMhs(long nim){
        daftarMahasiswa.remove(getMhs(nim));
    }
    
    public void createKelompok(int noKelompok){
        Kelompok k = new Kelompok(noKelompok);
        daftarKelompok.add(k);
    }  
    public Kelompok getKelompok(int noKelompok){
        Kelompok kel=null;
        for(Kelompok k: daftarKelompok){
            if(k.getNoKelompok()==noKelompok){
                kel = k;
            }
        }
        return kel;
    }
    public boolean isKelompokAda(int noKelompok){
       return daftarKelompok.contains(getKelompok(noKelompok));
    }
    public int searchKelompok(int noKelompok){
        return daftarKelompok.indexOf(getKelompok(noKelompok));
    }
    public void deleteKelompok(int noKelompok){
        daftarKelompok.remove(getKelompok(noKelompok));
    }
    
    
    public void createMataKuliah(String kodeMK){
        MataKuliah mk = new MataKuliah(kodeMK);
        daftarMK.add(mk);
    }
    public MataKuliah getMk(String kodeMK){
        MataKuliah mk=null;
        for(MataKuliah k: daftarMK){
            if(k.getKodeMK().equals(kodeMK)){
                mk = k;
            }
        }
        return mk;
    }
    public boolean isMkAda(String kodeMK){
       return daftarMK.contains(getMk(kodeMK));
    }
    public int searchMK(String kodeMK){
        return daftarMK.indexOf(getMk(kodeMK));
    }
    public void deleteMK(String kodeMK){
        daftarMK.remove(getMk(kodeMK));
    }
 
    
    //Fungsionalitas
        
      public void SignupMhs(String username , String password, String nama,long nim){
          
                createMhs(nim);
                Mahasiswa m = getMhs(nim);
                m.setUsername(username);
                m.setPassword(password);
                m.setNama(nama);
                
      }
      
      public void SignupDosen(String username , String password, String nama,long nip){
                
              createDosen(nip);
              Dosen d = getDosen(nip);
              d.setNama(nama);
              d.setPassword(password);
              d.setUsername(username);         
      }
      
      public void EditDosen(String username,String password, String nama , String email){
          Dosen d = getDosen(username);
          d.setEmail(email);
          d.setNama(nama);
          d.setPassword(password);
      
      }
      
      
      
      
      
      
    //Main Menu

    
}
