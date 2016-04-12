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
    private Tugas[] tugas;
    
    @Override
    public String toStringJenis(){
        return "Mahasiswa";
    }
    
    public Mahasiswa(long nim){
        this.maxTugas = 5;
        this.nim = nim;
        tugas = new Tugas[maxTugas];
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
    
    
}
