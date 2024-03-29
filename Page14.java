/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package package_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Page14 extends javax.swing.JInternalFrame {

    /**
     * Creates new form Page14
     */
    public Page14() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_1 = new javax.swing.JTextField();
        txt_2 = new javax.swing.JTextField();

        setIconifiable(true);
        setResizable(true);
        setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel1.setText("Enter the customer_id");

        jLabel2.setText("Enter the Service Person Id ");

        jButton1.setBackground(new java.awt.Color(51, 0, 51));
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_1)
                    .addComponent(txt_2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jButton1)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jButton1)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x=Integer.parseInt(txt_1.getText());
        int y=Integer.parseInt(txt_2.getText());
        boolean ans=checkExist(y);
        System.out.println(ans);
        if(ans==false){
           return;
        }else{
        try {
            Connection con =DriverManager.getConnection("jdbc:mysql:///help_helper","root","");
            if(con!=null){
                
                String str="update complaints set Service_Person_id=? where Customer_id=?";
                PreparedStatement ps=con.prepareStatement(str);
                ps.setInt(1,y);
                ps.setInt(2,x);
                int row=ps.executeUpdate();
                if(row>0){
                    JOptionPane.showMessageDialog(this,"A Service Person is Allocated for Customer_id "+x);
                    super.dispose();
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"Something went wrong");
                }
          }else{
                System.out.println("Failed to Estabilish connection");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean checkExist(int y){
        String status="";
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql:///help_helper","root","");
            if(con!=null){
                String str="select Status from employee_data where employee_id=?";
                PreparedStatement ps=con.prepareStatement(str);
                ps.setInt(1,y);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    status=rs.getString(1);
                    if(status.equals("Available")){
                        return true;
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"This Employee is Not Available at this moment");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"NO SUCH EMPLOYEE ");
                    
                }
                        
            }
            else{
                System.out.println("Connection has not been made");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Page14.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txt_1;
    private javax.swing.JTextField txt_2;
    // End of variables declaration//GEN-END:variables
}
