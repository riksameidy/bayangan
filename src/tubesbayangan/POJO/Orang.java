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
public abstract class Orang {
    private String username;
    private String password;
    private String nama;
    private String fakultas;
    private String email;
    private long noTelp;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getFakultas() {
        return fakultas;
    }
    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(long noTelp) {
        this.noTelp = noTelp;
    }
    
    public abstract String toStringJenis();
   
}
