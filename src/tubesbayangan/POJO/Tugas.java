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
public class Tugas {
    private String namaTugas;
    private int jumlahJawaban;
    private int jumlahSoal;
    private int maxSoal; //default = 20
    private boolean statusDikerjakan;
    private boolean statusAssign;
    private boolean isTugasIndividu;
    private String[] soal;
    private String[] jawaban;

    public Tugas(String namaTugas) {
        this.namaTugas = namaTugas;
        jumlahJawaban = 0;
        jumlahSoal = 0;
        maxSoal = 20;
        statusDikerjakan = false;
        statusAssign = false;
        soal = new String[maxSoal];
        jawaban = new String[maxSoal];
    }
    public String getNamaTugas() {
        return namaTugas;
    }
    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }
    public int getMaxSoal() {
        return maxSoal;
    }
    public void setMaxSoal(int maxSoal) {
        this.maxSoal = maxSoal;
    }
    public boolean getStatusDikerjakan() {
        return statusDikerjakan;
    }
    public void setStatusDikerjakan(boolean statusDikerjakan) {
        this.statusDikerjakan = statusDikerjakan;
    }
    public boolean getStatusAssign() {
        return statusAssign;
    }
    public void setStatusAssign(boolean statusAssign) {
        this.statusAssign = statusAssign;
    }
    public boolean getIsTugasIndividu() {
        return isTugasIndividu;
    }
    public void setIsTugasIndividu(boolean isTugasIndividu) {
        this.isTugasIndividu = isTugasIndividu;
    }    
    public void addSoal(String soal){
        if(jumlahSoal<maxSoal){
            this.soal[++jumlahSoal] = soal;
        }
    }
    public void addJawaban(String jawaban,int noSoal){
        if(jumlahJawaban<maxSoal){
            jumlahJawaban++;
            this.jawaban[noSoal] = jawaban;
        }
    }
    public String getSoal(int n){
        return soal[n];
    }
    public String getJawaban(int n){
        return jawaban[n];
    }
}
    

