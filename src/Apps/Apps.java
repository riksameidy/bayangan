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
    
    List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    List<Dosen> daftarDosen = new ArrayList<>();
    List<Kelompok> daftarKelompok = new ArrayList<>();
    List<MataKuliah> daftarMK = new ArrayList<>();
    
    public void createDosen(String nama, long nip){
        Dosen d = new Dosen(nama,nip);
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
    public boolean isDosenAda(long nip){
        return daftarDosen.contains(this.getDosen(nip));
    }
    public int searchDosen(long nip){
        return daftarDosen.indexOf(getDosen(nip));
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
    public boolean isMhsAda(long nim){
        return daftarMahasiswa.contains(getMhs(nim));
    }
    public int searchMhs(long nim){
        return daftarMahasiswa.indexOf(getMhs(nim));
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
    
    
    //Method tambahan di Task
    public void menuDosen(){
        System.out.println("Dosen");
    }
    //List Menu
    
    
    //Main Menu

    
}
