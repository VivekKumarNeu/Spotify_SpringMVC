/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.login;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Interface.Login;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vivek
 */
public class Loginpage extends javax.swing.JPanel {

    /**
     * Creates new form Loginpage
     */
    JPanel container;
    EcoSystem system;
    private DB4OUtil dB4OUtil;
    public Loginpage(JPanel container,EcoSystem system,DB4OUtil dB4OUtil) {
        initComponents();
        this.container = container;
        this.system = system;
        this.dB4OUtil = dB4OUtil;
        networkcombo();
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
        caruserbutton = new javax.swing.JButton();
        carownerbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Login user");
        add(jLabel1);
        jLabel1.setBounds(320, 20, 145, 101);

        caruserbutton.setBackground(new java.awt.Color(0, 0, 0));
        caruserbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        caruserbutton.setForeground(new java.awt.Color(255, 255, 255));
        caruserbutton.setText("Create  User Login");
        caruserbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caruserbuttonActionPerformed(evt);
            }
        });
        add(caruserbutton);
        caruserbutton.setBounds(440, 210, 184, 97);

        carownerbutton.setBackground(new java.awt.Color(0, 0, 0));
        carownerbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        carownerbutton.setForeground(new java.awt.Color(255, 255, 255));
        carownerbutton.setText("Create Car Owner");
        carownerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carownerbuttonActionPerformed(evt);
            }
        });
        add(carownerbutton);
        carownerbutton.setBounds(160, 210, 189, 97);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Select network :");
        add(jLabel2);
        jLabel2.setBounds(70, 125, 148, 22);

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(networkJComboBox);
        networkJComboBox.setBounds(249, 128, 86, 22);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(45, 376, 56, 56);
    }// </editor-fold>//GEN-END:initComponents

    public void networkcombo(){
        
        networkJComboBox.removeAllItems();
        
        for (Network network : system.getNetworkList()){
            networkJComboBox.addItem(network);
        }
    }
    
    
    
    
    private void carownerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carownerbuttonActionPerformed
        
     Network network = (Network) networkJComboBox.getSelectedItem();
        
     if(network == null)
     {
         JOptionPane.showMessageDialog(this, "Please create a network");
     }
     else {
    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if(organization.getName().equals("Car Owner Organization"))
                {
                   Logincarowneruser ssp = new Logincarowneruser(container,network,organization,dB4OUtil,system);
                    container.add("Logincarowneruser", ssp);
                    CardLayout layout = (CardLayout) container.getLayout();
                    layout.next(container); 
                    return;
                }
        }
              //  JOptionPane.showMessageDialog(this, "No organization");
                }
          JOptionPane.showMessageDialog(this, "No organization");
     }
    }//GEN-LAST:event_carownerbuttonActionPerformed

    private void caruserbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caruserbuttonActionPerformed
        
        Network network = (Network) networkJComboBox.getSelectedItem();
        
        if(network == null)
     {
         JOptionPane.showMessageDialog(this, "Please create a network");
     }
        else
        {
    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if(organization.getName().equals("Caruser Organization"))
                {
                    
                    Logincaruser userlogin = new Logincaruser(container,network,organization,dB4OUtil,system);
                    container.add("Logincarowneruser", userlogin);
                    CardLayout layout = (CardLayout) container.getLayout();
                    layout.next(container);  
                    return;
                }
        }
                
                }
        JOptionPane.showMessageDialog(this, "No organization");
        }
    }//GEN-LAST:event_caruserbuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        Login dwjp = (Login) component;
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
        }
        catch(Exception e)
        {}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carownerbutton;
    private javax.swing.JButton caruserbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox networkJComboBox;
    // End of variables declaration//GEN-END:variables
}
