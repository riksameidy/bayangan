/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesbayangan.POJO;

/**
 *
 * @author ASUS
 */
public class Mahasiswa extends Orang {
    
    private long nim;
    private String jurusan;
    private int maxTugas; //default max tugas = 5
    private int jumlahTugas;
    private int jumlahmyTugas;
    private Tugas[] tugas;
    private Tugas[] myTugas;
    private int jumlahKelas;
    
    @Override
    public String toStringJenis(){
        return "Mahasiswa";
    }
    
    public Mahasiswa(long nim){
        this.maxTugas = 5;
        this.nim = nim;
        tugas = new Tugas[maxTugas];
        myTugas = new Tugas[maxTugas];
        jumlahKelas = 0;
    }
    
    public long getNim() {
        return nim;
    }
    public void setNim(long nim) {
        this.nim = nim;
    }
    public int getMaxTugas() {
        return maxTugas;
    }
    public void setMaxTugas(int maxTugas) {
        this.maxTugas = maxTugas;
    }
    public Tugas getTugas(int n) {
        return tugas[n];
    }
    public String getJurusan() {
        return jurusan;
    }
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    public void addTugas(Tugas t){
        if(jumlahTugas<maxTugas){
            tugas[jumlahTugas++] = t;
        }
    }
    public void doTugas(int t, String jawaban, int noSoal){
        if(tugas[t].getIsTugasIndividu()){
        tugas[t].addJawaban(jawaban,noSoal);
        }
    }
    public void submitTugas(int t){
        tugas[t].setStatusDikerjakan(true);
    }
    
    public void tambahKelas(){
        jumlahKelas++;
    }
    
    public void kurangiKelas(){
        jumlahKelas--;
    }
    
    public int getJumlahKelas(){
        return jumlahKelas;
    }
    
    public String[] getAlltugas(){
        
        if(jumlahTugas==0){
            return null;
        }
        else{
            String temp[];
            temp = new String[jumlahTugas];
            for (int i = 0; i < jumlahTugas; i++) {
                temp[i] = tugas[i].getNamaTugas();
  
            }
            return temp;
        }
    }

    public Tugas getMyTugas(int i) {
        return myTugas[i];
    }
    
    public int idxmyTugas(String namaTugas){
        int idx = -1;
        for (int i = 0; i < jumlahmyTugas; i++) {
            if(namaTugas.equals(myTugas[i].getNamaTugas())){
                idx = i;
            }
            
        }
        return idx;
    }
    
    
    public String[] getAlltugasIndividu(){
        
        if(jumlahTugas==0){
            return null;
        }
        else{
            String temp[] = null;
            temp = new String[jumlahTugas];
            for (int i = 0; i < jumlahTugas; i++) {
                if(tugas[i].getIsTugasIndividu()){
                temp[i] = tugas[i].getNamaTugas();
                }
  
            }
            return temp;
        }
    }
    public String[] getAlltugasKelompok(){
        
        if(jumlahTugas==0){
            return null;
        }
        else{
            String temp[] = null;
            temp = new String[jumlahTugas];
            for (int i = 0; i < jumlahTugas; i++) {
                if(!tugas[i].getIsTugasIndividu()){
                temp[i] = tugas[i].getNamaTugas();
                }
  
            }
            return temp;
        }
    }
    
    public void createmyTugas(Tugas t){
        
        myTugas[jumlahmyTugas] = new Tugas(t.getNamaTugas());
        myTugas[jumlahmyTugas].setMaxSoal(t.getMaxSoal());
        myTugas[jumlahmyTugas].setIsTugasIndividu(t.getIsTugasIndividu());
        for (int i = 0; i < t.getJumlahSoal(); i++) {
            myTugas[jumlahmyTugas].addSoal(t.getSoal(i));
        }
        jumlahmyTugas++;
        
    }
    
}
