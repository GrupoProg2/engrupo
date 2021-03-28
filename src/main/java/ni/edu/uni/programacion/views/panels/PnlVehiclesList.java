/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views.panels;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.backend.pojo.VehicleSubModel;
import ni.edu.uni.programacion.controllers.PnlVehicleController;
import ni.edu.uni.programacion.views.VehicleMain;

/**
 *
 * @author Usuario
 */
public class PnlVehiclesList extends javax.swing.JPanel {

    private VehicleSubModel vehicleSubModel;
    private Vehicle vehiculo;
    private PnlVehicleController vehicleController;
    private PnlVehicle pnlVehicle;
    private JsonVehicleDaoImpl vjdao;
    TableRowSorter trs;
    
    
    public PnlVehiclesList() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtFiltre = new javax.swing.JTextField();
        btnView = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setForeground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtFiltre.setMinimumSize(new java.awt.Dimension(30, 24));
        txtFiltre.setPreferredSize(new java.awt.Dimension(300, 25));
        txtFiltre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltreKeyTyped(evt);
            }
        });
        jPanel1.add(txtFiltre);

        btnView.setText("View");
        btnView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel1.add(btnView);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Year", "Make", "Model", "Style", "VIN"
            }
        ));
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        
     try {
            vjdao = new JsonVehicleDaoImpl();
          
            //vjdao.create(v);
            
            List<Vehicle> vehicles = (List<Vehicle>) vjdao.getAll();
            
            String matris[][] = new String[vehicles.size()][5];
            for(int i = 0; i < vehicles.size(); i++){
                String año = String.valueOf(vehicles.get(i).getYear());
                matris[i][0] = año;
                matris[i][1] = vehicles.get(i).getMake();
                matris[i][2] = vehicles.get(i).getModel();
                matris[i][3] = vehicles.get(i).getStyle();
                matris[i][4] = vehicles.get(i).getVin();
                
            }
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
            matris,new String [] {
                "Year", "Make", "Model", "Style", "VIN"
            }
        ));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnViewActionPerformed
      DefaultTableModel dtm=new DefaultTableModel();
    private void txtFiltreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltreKeyTyped
    
       
     txtFiltre.addKeyListener(new KeyAdapter(){
         @Override
         public void keyReleased(KeyEvent e) {

           trs.setRowFilter(RowFilter.regexFilter(txtFiltre.getText(), 1));

         }

     });
     
     trs= new TableRowSorter((TableModel)dtm);
     jTable2.setRowSorter(trs);
       
    }//GEN-LAST:event_txtFiltreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtFiltre;
    // End of variables declaration//GEN-END:variables
}
