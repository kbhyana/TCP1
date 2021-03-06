package chatbox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JTextField;

/**
 *
 * @author J Girish
 */
public class Server_Chat extends javax.swing.JFrame {

    /**
     * Creates new form Server_Chat
     */
    public Server_Chat() {
        initComponents();
    }
    ArrayList<Socket>s=new ArrayList<>();
    ArrayList<DataOutputStream> Dos=new ArrayList<>();
Scanner sc; 
DataInputStream is_c,is_s;
 DataOutputStream os_c,os_s;
 int x=0,y=0;
 Thread t1,t2;
 Socket s_client,client;
/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 540));
        getContentPane().setLayout(null);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Server");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jRadioButton1.setBorderPainted(true);
        jRadioButton1.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(79, 55, 107, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Client");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(292, 55, 99, 29);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("IP address:-");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 120, 85, 17);

        jTextField1.setEditable(false);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(136, 112, 275, 34);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Port Number:-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 170, 110, 17);

        jTextField2.setEditable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(136, 164, 275, 34);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(30, 430, 340, 30);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 430, 60, 30);

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 480, 20, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Disconnected");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 480, 80, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbox/yel.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 480, 20, 20);

        jButton2.setText("Sign In");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(80, 210, 80, 29);

        jButton3.setText("Sign off");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(280, 210, 80, 29);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMinimumSize(new java.awt.Dimension(164, 94));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 250, 380, 170);

        jLabel3.setText("jLabel3");
        jLabel3.setMaximumSize(new java.awt.Dimension(300, 400));
        jLabel3.setMinimumSize(new java.awt.Dimension(300, 400));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 460, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      if(jRadioButton1.isSelected())
        {
            try{
         
           
           
            String send_data="Server  :"+jTextField3.getText();
            // String send_data=jTextField3.getText();
             for(int i=0;i<s.size();i++)                                                       //nxt 4 lines used for conference msging
              Dos.add(new DataOutputStream(s.get(i).getOutputStream()));
             for(int i=0;i<s.size();i++)
                 Dos.get(i).writeUTF(send_data);
           // os_s.writeUTF(send_data);                                                        //use for single client case
            jTextArea1.append(send_data+"\n"); 
            jTextField3.setText("");
                }
            catch (IOException ex) {
                Logger.getLogger(Server_Chat.class.getName()).log(Level.SEVERE, null, ex);
              
            }
        }
        else if(jRadioButton2.isSelected())
        {
            try{
        
       
             String send_data="Client"+client.getLocalPort()+":"+jTextField3.getText();
            os_c.writeUTF(send_data);
            System.out.println("sent"+send_data);
            jTextArea1.append(send_data+"\n");
               jTextField3.setText("");   
                }
            catch (IOException ex) {
                Logger.getLogger(Server_Chat.class.getName()).log(Level.SEVERE, null, ex);
              
        }
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
       jTextField1.setText("127.0.0.1");
        jTextField2.setText("8001");
      
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setEditable(rootPaneCheckingEnabled);
        jTextField2.setEditable(rootPaneCheckingEnabled);
          jTextField3.setEditable(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton2.isSelected())
        {
            try {
                 client=new Socket(jTextField1.getText(),Integer.valueOf(jTextField2.getText()));
            is_c=new DataInputStream(client.getInputStream());
            os_c=new DataOutputStream(client.getOutputStream());
            int Q=is_c.readInt();
            if( Q==1)
            {
              jLabel4.setVisible(false);
                 jLabel5.setText("Connected");
            }
            
            } catch (IOException ex) {
                Logger.getLogger(Server_Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            Chatbox c=new Chatbox(1,client, jTextArea1,s,jLabel4,jLabel5);
         t1=new Thread(c);
            t1.start();
        
        }
        else if(jRadioButton1.isSelected())
        {
          
         check ch=null;
         for(int i=0;i<3;i++)
         {
               try {   
            ServerSocket socket=new ServerSocket(8001);
           ch=new check(socket);  
            } catch (IOException ex) {
                Logger.getLogger(Server_Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
              
         Thread a=new Thread(ch);
         a.start();
         }
          }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           if(jRadioButton1.isSelected())
        {
        for(int i=0;i<Dos.size();i++)
        {
            try {
                Dos.get(i).writeUTF("Exit");
            } catch (IOException ex) {
                Logger.getLogger(Server_Chat.class.getName()).log(Level.SEVERE, null, ex);
            }                
        }
        Dos.clear();
        s.clear();
               try {
                   Thread.sleep(10000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Server_Chat.class.getName()).log(Level.SEVERE, null, ex);
               }
            try {
               
                s_client.close();
                  jLabel4.setVisible(true);
                 jLabel5.setText("Disconnected");
            } catch (IOException ex) {
                Logger.getLogger(Server_Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
         t2.stop();
        
        }
        else if(jRadioButton2.isSelected()){
            for(int i=0;i<s.size();i++)
            {
            if(s.get(i).getInetAddress()==client.getLocalAddress()&&s.get(i).getPort()==client.getLocalPort())
            {
            s.remove(i);
            Dos.remove(i);
            }
            }
            try {
                client.close();
                jLabel4.setVisible(true);
                 jLabel5.setText("Disconnected");
                 
        } catch (IOException ex) {
            Logger.getLogger(Server_Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
             t1.stop();
         
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Server_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server_Chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
class check implements Runnable
{
ServerSocket socket;
        public check(ServerSocket socket) {
            this.socket=socket;
        }

        @Override
        public void run() {
            
              try {
                            
                 s_client=socket.accept();
                 s.add(s_client);
                 System.out.println("Connected");              
                 jLabel4.setVisible(false);
                 jLabel5.setText("Connected");
                 System.out.println(s_client.getInetAddress() +"        " +s_client.getPort());
                    is_s=new DataInputStream(s_client.getInputStream());
                    os_s=new DataOutputStream(s_client.getOutputStream());
                    os_s.writeInt(1);
        }
        catch (IOException ex) {
                Logger.getLogger(Server_Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
       
         
            Chatbox c=new Chatbox(0,s_client,jTextArea1,s,jLabel4,jLabel5);
              t2=new Thread(c);
            t2.start(); //To change body of generated methods, choose Tools | Templates.
        }




}

}
