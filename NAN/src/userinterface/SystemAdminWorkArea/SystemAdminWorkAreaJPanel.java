/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer,EcoSystem ecosystem) {
        initComponents();
        System.out.println("here");
        this.userProcessContainer=userProcessContainer;        
        this.ecosystem=ecosystem;
        manageNetwork();
        populateTree();
        
    }
    
    public void populateTree(){
        DefaultTreeModel model=(DefaultTreeModel)jTree1.getModel();
        ArrayList<Network> networkList=ecosystem.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        
        Network network;
        Enterprise enterprise;
        Organization organization;
        
        DefaultMutableTreeNode networks=new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        for(int i=0;i<networkList.size();i++){
            network=networkList.get(i);
            networkNode=new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
            
            enterpriseList=network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j<enterpriseList.size();j++){
                enterprise=enterpriseList.get(j);
                enterpriseNode=new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
                
                organizationList=enterprise.getOrganizationDirectory().getOrganizationList();
                for(int k=0;k<organizationList.size();k++){
                    organization=organizationList.get(k);
                    organizationNode=new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        model.reload();
    }
    
    private void manageNetwork(){
        manageNetworkPanel.setBackground(new Color(255,255,255));
        manageEnterprise.setBackground(new Color(255,204,0));
        manageEnterpriseAdmin.setBackground(new Color(255,204,0));
       
        userinterface.SystemAdminWorkArea.ManageNetworkJPanel manageNetworkPanel = new userinterface.SystemAdminWorkArea.ManageNetworkJPanel(rightSystemAdminPanel, ecosystem);
        rightSystemAdminPanel.add("ManageNetworkJPanel",manageNetworkPanel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
     }
    
    private void manageEnterprise(){
        manageEnterprise.setBackground(new Color(255,255,255));
        manageNetworkPanel.setBackground(new Color(255,204,0));
        manageEnterpriseAdmin.setBackground(new Color(255,204,0));
       
        userinterface.SystemAdminWorkArea.ManageEnterpriseJPanel manageEnterprise = new userinterface.SystemAdminWorkArea.ManageEnterpriseJPanel(rightSystemAdminPanel, ecosystem);
        rightSystemAdminPanel.add("ManageEnterpriseJPanel",manageEnterprise);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
        
    }
    
    private void manageEnterpriseAdmin(){
        
        manageEnterpriseAdmin.setBackground(new Color(255,255,255));
        manageEnterprise.setBackground(new Color(255,204,0));
        manageNetworkPanel.setBackground(new Color(255,204,0));
      
        userinterface.SystemAdminWorkArea.ManageEnterpriseAdminJPanel manageEnterpriseAdmin = new userinterface.SystemAdminWorkArea.ManageEnterpriseAdminJPanel(rightSystemAdminPanel, ecosystem);
        rightSystemAdminPanel.add("ManageEnterpriseAdminJPanel",manageEnterpriseAdmin);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        systemAdminPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        manageNetworkPanel = new javax.swing.JPanel();
        manageNetwork = new javax.swing.JLabel();
        manageEnterprise = new javax.swing.JPanel();
        manageEnterpriseLabel = new javax.swing.JLabel();
        manageEnterpriseAdmin = new javax.swing.JPanel();
        manageEnterpriseAdminLabel = new javax.swing.JLabel();
        lblSelectedNode1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jSeparator2 = new javax.swing.JSeparator();
        rightSystemAdminPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(215, 81, 81));
        setPreferredSize(new java.awt.Dimension(1338, 840));
        setLayout(new java.awt.BorderLayout());

        systemAdminPanel.setBackground(new java.awt.Color(255, 204, 0));
        systemAdminPanel.setPreferredSize(new java.awt.Dimension(1338, 840));

        jPanel3.setBackground(new java.awt.Color(255, 204, 0));
        jPanel3.setMinimumSize(new java.awt.Dimension(280, 148));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 148));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageNetworkPanel.setBackground(new java.awt.Color(255, 255, 255));
        manageNetworkPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageNetworkPanelMousePressed(evt);
            }
        });
        manageNetworkPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageNetwork.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        manageNetwork.setText("Manage Network");
        manageNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageNetworkMousePressed(evt);
            }
        });
        manageNetworkPanel.add(manageNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, 36));

        jPanel3.add(manageNetworkPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 290, 50));

        manageEnterprise.setBackground(new java.awt.Color(255, 255, 255));
        manageEnterprise.setPreferredSize(new java.awt.Dimension(264, 48));
        manageEnterprise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageEnterpriseMousePressed(evt);
            }
        });
        manageEnterprise.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageEnterpriseLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        manageEnterpriseLabel.setText("Manage Enterprise");
        manageEnterpriseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageEnterpriseLabelMousePressed(evt);
            }
        });
        manageEnterprise.add(manageEnterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 203, 50));

        jPanel3.add(manageEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 290, 50));

        manageEnterpriseAdmin.setBackground(new java.awt.Color(255, 255, 255));
        manageEnterpriseAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageEnterpriseAdminMousePressed(evt);
            }
        });
        manageEnterpriseAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageEnterpriseAdminLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        manageEnterpriseAdminLabel.setText("Manage Enterprise Admin");
        manageEnterpriseAdminLabel.setPreferredSize(new java.awt.Dimension(115, 16));
        manageEnterpriseAdmin.add(manageEnterpriseAdminLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 217, 37));

        jPanel3.add(manageEnterpriseAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 290, 60));

        lblSelectedNode1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jPanel3.add(lblSelectedNode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 230, 30));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Selected Node:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 140, 30));

        jTree1.setBackground(new java.awt.Color(255, 204, 0));
        jTree1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTree1.setForeground(new java.awt.Color(0, 0, 0));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTree1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 250, 270));

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 280, -1));

        rightSystemAdminPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightSystemAdminPanel.setPreferredSize(new java.awt.Dimension(1058, 840));
        rightSystemAdminPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout systemAdminPanelLayout = new javax.swing.GroupLayout(systemAdminPanel);
        systemAdminPanel.setLayout(systemAdminPanelLayout);
        systemAdminPanelLayout.setHorizontalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemAdminPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        systemAdminPanelLayout.setVerticalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(systemAdminPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void manageNetworkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageNetworkMousePressed
        manageNetwork();
    }//GEN-LAST:event_manageNetworkMousePressed

    private void manageNetworkPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageNetworkPanelMousePressed
        // TODO add your handling code here:
        manageNetwork();
    }//GEN-LAST:event_manageNetworkPanelMousePressed

    private void manageEnterpriseLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEnterpriseLabelMousePressed
      manageEnterprise();
    }//GEN-LAST:event_manageEnterpriseLabelMousePressed

    private void manageEnterpriseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEnterpriseMousePressed
        // TODO add your handling code here:
      manageEnterprise();
    }//GEN-LAST:event_manageEnterpriseMousePressed

    private void manageEnterpriseAdminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEnterpriseAdminMousePressed
       manageEnterpriseAdmin();
    }//GEN-LAST:event_manageEnterpriseAdminMousePressed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
         DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
        if(selectedNode!=null){
            lblSelectedNode1.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTree1ValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lblSelectedNode1;
    private javax.swing.JPanel manageEnterprise;
    private javax.swing.JPanel manageEnterpriseAdmin;
    private javax.swing.JLabel manageEnterpriseAdminLabel;
    private javax.swing.JLabel manageEnterpriseLabel;
    private javax.swing.JLabel manageNetwork;
    private javax.swing.JPanel manageNetworkPanel;
    private javax.swing.JPanel rightSystemAdminPanel;
    private javax.swing.JPanel systemAdminPanel;
    // End of variables declaration//GEN-END:variables
}
