package teskop;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class Pencarian extends javax.swing.JFrame {

    /**
     * Creates new form Pencarian
     */
    public Pencarian() {
        initComponents();
        c1.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        c1 = new javax.swing.JComboBox();
        ke = new javax.swing.JTextField();
        car = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        p = new javax.swing.JRadioButton();
        an = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        c1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NAMA", "ALAMAT", "No HP", " " }));
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });

        ke.setText("KEYWORD");

        car.setText("cari");
        car.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        p.setText("Pengurus");
        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });

        an.setText("Anggota");
        an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(an)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(p)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ke, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(car)
                            .addGap(39, 39, 39)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(car)
                    .addComponent(ke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(an)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   String x,keyword,jns;
    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
         if(c1.getSelectedIndex() == 0)
        {
            x = "nama";
            System.out.println(c1.getSelectedIndex() +"   "+ x);
        }
        else if(c1.getSelectedIndex() == 1)
        {
            x = "alamat"; 
            System.out.println(c1.getSelectedIndex() +"   "+ x);
        }  
        else if(c1.getSelectedIndex() == 2)
        {
            x = "hp"; 
            System.out.println(c1.getSelectedIndex() +"   "+ x);
        }
          
        
    }//GEN-LAST:event_c1ActionPerformed

    private void carActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carActionPerformed
        keyword = ke.getText();       
        getData();
        
    }//GEN-LAST:event_carActionPerformed

private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
    c1.setEnabled(true);
     jns = p.getText();
}//GEN-LAST:event_pActionPerformed

private void anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anActionPerformed
    c1.setEnabled(true);
     jns = an.getText();
}//GEN-LAST:event_anActionPerformed

    /**
     */
 
    public void getData(){
//        DefaultTableModel tabel1= new DefaultTableModel();
//        tabel1.addColumn("Nama");
//        tabel1.addColumn("Alamaat");
//        tabel1.addColumn("Jabatan");
//        tabel1.addColumn("hp");
//        try {
//           
//           Connection conn = Koneksi.koneksiDB();
//           Statement stm = conn.createStatement();
//           ResultSet sql;
//           sql = stm.executeQuery("select * from pengurus");
//           if("Pengurus".equals(jns))
//           {
//                switch (x) {
//                    case "nama":
//                        sql = stm.executeQuery("select * from pengurus where nama like '%"+keyword+"%';");
//                        break;
//                    case "alamat":
//                        sql = stm.executeQuery("select * from pengurus where alamat like '%"+keyword+"%';");
//                        break;               
//                    case "hp":
//                        sql = stm.executeQuery("select * from pengurus where hp like '%"+keyword+"%';");
//                        break;
//                }
//           }
//           else
//           {
//                switch (x) {
//                    case "nama":
//                        sql = stm.executeQuery("select * from anggota where nama like '%"+keyword+"%';");
//                        break;
//                    case "alamat":
//                        sql = stm.executeQuery("select * from anggota where alamat like '%"+keyword+"%';");
//                        break;               
//                    case "hp":
//                        sql = stm.executeQuery("select * from anggota where hp like '%"+keyword+"%';");
//                        break;
//                }
//           }
//           
//           while(sql.next()){
//                tabel1.addRow(new Object[]{
//                    sql.getString(2),
//                    sql.getString(3),
//                    sql.getString(4),
//                    sql.getString(5)
//                });
//            }
//            tabel.setModel(tabel1);
//        }catch (SQLException e) {
//        }
    }
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
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pencarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton an;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox c1;
    private javax.swing.JButton car;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ke;
    private javax.swing.JRadioButton p;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
