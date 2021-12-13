/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdoptionWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Utils.HeaderColors;
import Business.WorkQueue.RescueUnitRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class AdoptionAdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem system;
    Organization organization;
    Network network;
    UserAccount account;

    /**
     * Creates new form FireSafetyAdminWorkAreaJPanel
     */
    public AdoptionAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        this.organization = organization;
        this.network = network;
        this.account = account;
          workRequestTable.getTableHeader().setDefaultRenderer(new HeaderColors());
        populateTable();
    }

    private void populateTable() {
        workRequestTable.getTableHeader().setDefaultRenderer(new HeaderColors());
        DefaultTableModel model = (DefaultTableModel) workRequestTable.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if(wr instanceof RescueUnitRequest) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = ((RescueUnitRequest) wr);
                row[1] = ((RescueUnitRequest) wr).getSender().getEmployee().getName();
                row[2] = ((RescueUnitRequest) wr).getSceneName();
                row[3] = ((RescueUnitRequest) wr).getNoOfVictims();
                row[4] = ((RescueUnitRequest) wr).getMessage();
                row[5] = ((RescueUnitRequest) wr).getStatus();
                row[6] = ((RescueUnitRequest) wr).getSenderOrganization().getName();
                row[7] = ((RescueUnitRequest) wr).getSenderNetwork().getName();
                row[8] = ((RescueUnitRequest) wr).getRequestDate();
                model.addRow(row);
            }
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestTable = new javax.swing.JTable();
        processReqBtn = new javax.swing.JButton();
        acceptBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();
        completeReqBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1338, 840));
        setPreferredSize(new java.awt.Dimension(1338, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 56, 82));
        jLabel1.setText("ADOPTION ADMIN WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        workRequestTable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        workRequestTable.setForeground(new java.awt.Color(25, 56, 82));
        workRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ReportId", "Sender", "Report Name", "Dogs", "Message", "Status", "Sender Organization", "Sender Network", "Requested Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestTable.setSelectionBackground(new java.awt.Color(56, 90, 174));
        jScrollPane2.setViewportView(workRequestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 1250, 170));

        processReqBtn.setBackground(new java.awt.Color(255, 255, 255));
        processReqBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        processReqBtn.setForeground(new java.awt.Color(25, 56, 82));
        processReqBtn.setText("Process Request");
        processReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processReqBtnActionPerformed(evt);
            }
        });
        add(processReqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, -1, -1));

        acceptBtn.setBackground(new java.awt.Color(255, 255, 255));
        acceptBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        acceptBtn.setForeground(new java.awt.Color(25, 56, 82));
        acceptBtn.setText("Accept Request");
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });
        add(acceptBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, -1));

        rejectBtn.setBackground(new java.awt.Color(255, 255, 255));
        rejectBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        rejectBtn.setForeground(new java.awt.Color(25, 56, 82));
        rejectBtn.setText("Reject Request");
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });
        add(rejectBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, -1));

        completeReqBtn.setBackground(new java.awt.Color(255, 255, 255));
        completeReqBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        completeReqBtn.setForeground(new java.awt.Color(25, 56, 82));
        completeReqBtn.setText("Complete Request");
        completeReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeReqBtnActionPerformed(evt);
            }
        });
        add(completeReqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adoppp.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 1270, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void processReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processReqBtnActionPerformed
        // TODO add your handling code here:
        int count = workRequestTable.getSelectedRowCount();
        if (count != 1) {
            JOptionPane.showMessageDialog(null, "Select one row", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int selectedRow = workRequestTable.getSelectedRow();
            RescueUnitRequest emerReq = (RescueUnitRequest) workRequestTable.getValueAt(selectedRow, 0);
            if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else if(emerReq.getStatus().equals("Processing")){
                JOptionPane.showMessageDialog(null, "Request is already Processing");
            }else if(emerReq.getStatus().equals("Rejected")){
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Completed")){
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Requested")) {
                JOptionPane.showMessageDialog(null, "Request is not yet Accepted");
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");                
                emerReq.setStatus("Processing");
                emerReq.setMessage(msg);
                populateTable();
            }            
        }
    }//GEN-LAST:event_processReqBtnActionPerformed

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        int count = workRequestTable.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = workRequestTable.getSelectedRow();
            RescueUnitRequest emerReq = (RescueUnitRequest) workRequestTable.getValueAt(selectedRow, 0);
            if(emerReq.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted");
            }else if(emerReq.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Request is already Processing");
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                emerReq.setStatus("Accepted");
                emerReq.setMessage(msg);
                populateTable();
            }
            //emerReq.setStatus("Accepted");
        }
    }//GEN-LAST:event_acceptBtnActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        int count = workRequestTable.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = workRequestTable.getSelectedRow();
            RescueUnitRequest emerReq = (RescueUnitRequest) workRequestTable.getValueAt(selectedRow, 0);
            if(emerReq.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted");
            }else if(emerReq.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted and Processing");
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                emerReq.setStatus("Rejected");
                emerReq.setMessage(msg);
                populateTable();
            }
        }
    }//GEN-LAST:event_rejectBtnActionPerformed

    private void completeReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeReqBtnActionPerformed
        int count = workRequestTable.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = workRequestTable.getSelectedRow();
            RescueUnitRequest emerReq = (RescueUnitRequest) workRequestTable.getValueAt(selectedRow, 0);
            if(emerReq.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request should be in processing state before marking complete");
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else if(emerReq.getStatus().equals("Requested")) {
                JOptionPane.showMessageDialog(null, "Request is not yet Accepted");
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                emerReq.setStatus("Completed");
                emerReq.setMessage(msg);
                populateTable();
            }
        }
    }//GEN-LAST:event_completeReqBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton completeReqBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processReqBtn;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JTable workRequestTable;
    // End of variables declaration//GEN-END:variables
}
