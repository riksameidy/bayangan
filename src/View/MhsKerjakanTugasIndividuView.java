/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author my asus
 */
public class MhsKerjakanTugasIndividuView extends javax.swing.JFrame implements View {

    /**
     * Creates new form MhsKerjakanTugas
     */
    public MhsKerjakanTugasIndividuView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNamaTugas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnJawab = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSoal = new javax.swing.JTextArea();
        ComboBoxSoal = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tAJawab = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNamaTugas.setText("Nama Tugas Disini");

        jLabel2.setText("Soal");

        btnBack.setText("Back");

        btnJawab.setText("Jawab");

        textSoal.setColumns(20);
        textSoal.setRows(5);
        jScrollPane1.setViewportView(textSoal);

        ComboBoxSoal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tAJawab.setColumns(20);
        tAJawab.setRows(5);
        jScrollPane2.setViewportView(tAJawab);

        jLabel1.setText("Jawaban: ");

        btnSubmit.setText("Submit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(labelNamaTugas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(ComboBoxSoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnBack)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnJawab))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                .addComponent(jScrollPane2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnSubmit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNamaTugas)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(ComboBoxSoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnJawab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmit)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setLabelNamaTugas(String s) {
        this.labelNamaTugas.setText(s);
    }

    public JComboBox<String> getComboBoxSoal() {
        return ComboBoxSoal;
    }

    public void setComboBoxSoal(String[] s) {
        this.ComboBoxSoal.setModel(new DefaultComboBoxModel<>(s));
    }

    public JTextArea gettAJawab() {
        return tAJawab;
    }

    public void settAJawab(String s) {
        this.tAJawab.setText(s);
    }

    public JTextArea getTextSoal() {
        return textSoal;
    }

    public void setTextSoal(String s) {
        this.textSoal.setText(s);
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }
    
    

    /**
     * @param args the command line arguments
     */

    
    
    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnJawab() {
        return btnJawab;
    }
    
    public void addListener(ActionListener l){
        btnBack.addActionListener(l);
        btnJawab.addActionListener(l);
        btnSubmit.addActionListener(l);
        ComboBoxSoal.addActionListener(l);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxSoal;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnJawab;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNamaTugas;
    private javax.swing.JTextArea tAJawab;
    private javax.swing.JTextArea textSoal;
    // End of variables declaration//GEN-END:variables


}
