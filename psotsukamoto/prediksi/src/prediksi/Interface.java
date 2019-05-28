/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prediksi;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import prediksi.boundary.InterfaceManager;
import prediksi.entity.Cuaca;
/**
 *
 * @author afrilia
 */
public class Interface extends javax.swing.JFrame {
InterfaceManager interface_manager;
    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
        interface_manager = new InterfaceManager();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbl_judul = new javax.swing.JLabel();
        lbl_namafile = new javax.swing.JLabel();
        btn_load = new javax.swing.JButton();
        lbl_parameterpso = new javax.swing.JLabel();
        lbl_jumlahpartikel = new javax.swing.JLabel();
        lbl_jumlahiterasi = new javax.swing.JLabel();
        lbl_c1 = new javax.swing.JLabel();
        lbl_c2 = new javax.swing.JLabel();
        tf_jumlahpartikel = new javax.swing.JTextField();
        tf_jumlahiterasi = new javax.swing.JTextField();
        tf_c1 = new javax.swing.JTextField();
        tf_c2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        btn_optimasi = new javax.swing.JButton();
        lbl_akurasitsukamoto = new javax.swing.JLabel();
        lbl_akurasipsotsukamoto = new javax.swing.JLabel();
        lbl_persenpsotsukamoto = new javax.swing.JLabel();
        lbl_persentsukamoto = new javax.swing.JLabel();
        btn_hasil = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_judul.setText("PREDIKSI CUACA");

        lbl_namafile.setForeground(new java.awt.Color(204, 204, 204));
        lbl_namafile.setText("masukkan file");

        btn_load.setText("pilih");
        btn_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadActionPerformed(evt);
            }
        });

        lbl_parameterpso.setText("Masukkan Parameter PSO :");

        lbl_jumlahpartikel.setText("Jumlah Partikel");

        lbl_jumlahiterasi.setText("Jumlah Iterasi");

        lbl_c1.setText("C1");

        lbl_c2.setText("C2");

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Tanggal", "Suhu", "Kelembaban", "Tekanan Udara", "Kecepatan Angin", "Hasil", "Tsukamoto", "PSO dan Tsukamoto"
            }
        ));
        jScrollPane3.setViewportView(tbl_data);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 200, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        btn_optimasi.setText("optimasi");
        btn_optimasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_optimasiActionPerformed(evt);
            }
        });

        lbl_akurasitsukamoto.setText("Akurasi Tsukamoto");

        lbl_akurasipsotsukamoto.setText("Akurasi Hybrid PSO + Tsukamoto");

        lbl_persenpsotsukamoto.setText("%");

        lbl_persentsukamoto.setText("%");

        btn_hasil.setText("Hasil");
        btn_hasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hasilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(lbl_judul))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_parameterpso)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_namafile, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_load))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_jumlahpartikel)
                                    .addComponent(lbl_jumlahiterasi)
                                    .addComponent(lbl_c1)
                                    .addComponent(lbl_c2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_jumlahiterasi, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                    .addComponent(tf_jumlahpartikel)
                                    .addComponent(tf_c1)
                                    .addComponent(tf_c2)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_akurasitsukamoto)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_persentsukamoto)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_akurasipsotsukamoto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_persenpsotsukamoto)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_hasil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_optimasi)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_judul)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_namafile)
                    .addComponent(btn_load, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_parameterpso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_jumlahpartikel)
                    .addComponent(tf_jumlahpartikel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_jumlahiterasi)
                    .addComponent(tf_jumlahiterasi, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_c1)
                    .addComponent(tf_c1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_c2)
                    .addComponent(tf_c2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_optimasi, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hasil, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_akurasitsukamoto)
                    .addComponent(lbl_persentsukamoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_akurasipsotsukamoto)
                    .addComponent(lbl_persenpsotsukamoto))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadActionPerformed
        // TODO add your handling code here:
        ArrayList<Cuaca> data_cuaca;
        data_cuaca = new ArrayList();
        String path;
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        
        if (result==JFileChooser.APPROVE_OPTION){
         File selectedFile = chooser.getSelectedFile();
         path = selectedFile.getAbsolutePath();
         data_cuaca = interface_manager.muat_data_excel(path);
         
         DefaultTableModel cuaca_model = (DefaultTableModel) tbl_data.getModel();
         
         String[] data = new String[7];
            for (int i = tbl_data.getRowCount()-1; i >=0; i--) {
                cuaca_model.removeRow(i);
            }

            for (int i = 0; i < data_cuaca.size(); i++) {
                data[0] = String.valueOf((int)data_cuaca.get(i).getNo());
                data[1] = data_cuaca.get(i).getTanggal();
                data[2] = String.valueOf((int)data_cuaca.get(i).getSuhu());
                data[3] = String.valueOf((int)data_cuaca.get(i).getKelembaban());
                data[4] = String.valueOf((int)data_cuaca.get(i).getTekanan_udara());
                data[5] = String.valueOf(data_cuaca.get(i).getKecepatan_angin());
                data[6] = data_cuaca.get(i).getKeadaan_cuaca();
               
                cuaca_model.addRow(data);
            }
        }    
        else {
            JOptionPane.showMessageDialog(this, "Muat Data Gagal");
        }
    }//GEN-LAST:event_btn_loadActionPerformed

    private void btn_optimasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_optimasiActionPerformed
        
        int jum_swarm = Integer.parseInt(tf_jumlahpartikel.getText());
        int jum_iterasi = Integer.parseInt(tf_jumlahiterasi.getText());
        int c1 = Integer.parseInt(tf_c1.getText());
        int c2 = Integer.parseInt(tf_c2.getText());
        interface_manager.do_pso(jum_swarm, c1, c2, jum_iterasi);
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_btn_optimasiActionPerformed

    private void btn_hasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hasilActionPerformed

        interface_manager.dofuzzysaja();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hasilActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hasil;
    private javax.swing.JButton btn_load;
    private javax.swing.JButton btn_optimasi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_akurasipsotsukamoto;
    private javax.swing.JLabel lbl_akurasitsukamoto;
    private javax.swing.JLabel lbl_c1;
    private javax.swing.JLabel lbl_c2;
    private javax.swing.JLabel lbl_judul;
    private javax.swing.JLabel lbl_jumlahiterasi;
    private javax.swing.JLabel lbl_jumlahpartikel;
    private javax.swing.JLabel lbl_namafile;
    private javax.swing.JLabel lbl_parameterpso;
    private javax.swing.JLabel lbl_persenpsotsukamoto;
    private javax.swing.JLabel lbl_persentsukamoto;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTextField tf_c1;
    private javax.swing.JTextField tf_c2;
    private javax.swing.JTextField tf_jumlahiterasi;
    private javax.swing.JTextField tf_jumlahpartikel;
    // End of variables declaration//GEN-END:variables
}
