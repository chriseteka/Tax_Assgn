
package tax_assgn.GUI;

import javax.swing.JOptionPane;

public class firstPage extends javax.swing.JFrame {
    
    //IMPORTING ALL THE REQUIRED CLASSES
    tax_assgn.ExceptionalCases exp = new tax_assgn.ExceptionalCases();
    
    public firstPage() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        showFilingStatus = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        choice = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("ONE KIND JUNKY TAX CALCULATION APPLICATION.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 490, 36));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, 572, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setText("CHOOSE A FILING STATUS FROM THE FOLLOWING");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 370, 40));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 360, 10));

        jScrollPane1.setBackground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setBorder(null);

        showFilingStatus.setEditable(false);
        showFilingStatus.setBackground(new java.awt.Color(204, 255, 255));
        showFilingStatus.setColumns(20);
        showFilingStatus.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        showFilingStatus.setRows(5);
        showFilingStatus.setText("CHOOSE FILING STATUS BY THEIR NUMBER(S)\n0. QUERY\n1. SINGLE\n2. MARRIED FILING JOINTLY\n3. MARRIED FILING SEPERATELY\n4. HEAD OF HOUSEHOLD\n5. OTHERS\n6. EXIT APPLICATION");
        showFilingStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        showFilingStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        showFilingStatus.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(showFilingStatus);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 370, 190));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("CHOICE:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 70, 30));

        choice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceActionPerformed(evt);
            }
        });
        jPanel1.add(choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 300, 30));

        submitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        submitButton.setText("SUBMIT");
        submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 110, 30));

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelButton.setText("CANCEL");
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 110, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void choiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if(!(choice.getText().equals(""))) //CHECKS TO BE SURE THE TEXTBOX IS NOT EMPTY
        {
            String inputedString = choice.getText().replaceAll("//s", "");
            if(inputedString.length() == 1) //CHECKS IF THE INPUT IS A CHAR(AN ALPHABET)
            {
                try //CHECKS IF THE INPUT IS AN ALPHABET
                {
                    //IF ITS NOT AN ALPHABET, IT CONVERTS IT TO AN INTEGER
                    int selectedChoice = Integer.parseInt(choice.getText());
                    
                    if(selectedChoice >= 0) //CHECKS IF THE INTEGER IS POSITIVE OR ZERO
                    {
                        if(selectedChoice <= 6) //CHECKS IF THE INTEGER IS NOT MORE THAN SIX
                        {
                            if(selectedChoice != 6) //CHECKS IF THE INTEGER IS NOT SIX
                            {
                                double income = Integer.parseInt(JOptionPane.showInputDialog("ENTER YOUR INCOME"));
                                if(income >= 0 && income <= 10000000) //CHECKS IF THE INPUTTED INCOME IS POSITIVE AND LESS THAN 8 DIGITS
                                {
                                    tax_assgn.Tax_Assgn.beginExecutionGUI(selectedChoice, income);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "YOU MAY HAVE INPUTTED, A NEGATIVE NUMBER OR A NUMBER MORE THAN 7-DIGIT");
                                }
                            }
                            else //IF INTEGER IS SIX, THEN EXIT OPTION
                            {
                                tax_assgn.Tax_Assgn.beginExecutionGUI(6, 0);
                            }
                        }
                        else //IF INTEGER IS MORE THAN SIX, REPORT
                        {
                            JOptionPane.showMessageDialog(null, "PLEASE INPUT A VALID OPTION FROM THE LIST OF OPTIONS PROVIDED.");
                        }
                    }
                    else //REPORTS IF INTEGER IS NEGATIVE
                    {
                        JOptionPane.showMessageDialog(null, "YOU MAY HAVE ENTERED A NEGATIVE NUMBER WHICH IS NOT ALLOWED");
                    }
                }catch(NumberFormatException e) //REPORTS IF INPUT IN THE TEXT BOX IS AN ALPHABET
                {
                    JOptionPane.showMessageDialog(null, "YOU MAY HAVE INPUTTED AN ALPHABET, IN PLACE OF A NUMBER");
                }
            }
            else if(inputedString.length() == 3) //CHECKS IF INPUTS IN THE TEXTBOX IS OF LENGHT 3
            {
                char firstRefinedInput = inputedString.charAt(0);
                char inputSeperator = inputedString.charAt(1);
                char secondRefinedInput = inputedString.charAt(2);
                
                if(inputSeperator == ',') //CHECKS IF THE INPUT IS OF THE FORM a,b
                {
                    //CHECKS IF INPUTS ARE VALID NUMBERS
                    if( !((firstRefinedInput >= 'a' && firstRefinedInput <= 'z') || (firstRefinedInput >= 'A' && firstRefinedInput <= 'Z') ||
                            (secondRefinedInput >= 'a' && secondRefinedInput <= 'z') || (secondRefinedInput >= 'A' && secondRefinedInput <= 'Z')))
                    {
                        int firstNum = Integer.parseInt(Character.toString(firstRefinedInput));
                        int secondNum = Integer.parseInt(Character.toString(secondRefinedInput));

                        double income = Integer.parseInt(JOptionPane.showInputDialog("ENTER YOUR INCOME"));
                        exp.computeMultipleInput(firstNum, secondNum, income);
                    }
                    else //REPORTS IF ONE OR ALL OF THE INPUT IS AN ALPHABET
                    {
                        JOptionPane.showMessageDialog(null, "YOU MAY HAVE INPUTTED AN ALPHABET, IN PLACE OF A NUMBER");
                    }
                }
                else //REPORTS THAT THE INPUT IS NOT OF THE FORM a,b
                {
                    JOptionPane.showMessageDialog(null, "PLEASE CHOOSE ANY TWO VALUSE IN THE FORM: a,b e.g 1,3");
                }
            }
            else //REPORTS IF AN INVALID OPTION(S) HAS BEEN INPUTTED IN THE TEXTBOX
            {
                JOptionPane.showMessageDialog(null, "PLEASE INPUT A VALID OPTION FROM THE LIST OF OPTIONS PROVIDED.\n "
                                                + " YOU CAN ALSO TYPE IN TWO OPTIONS, e.g: 1,2");
            }
        }
        else //REPORTS IF THE TEXTBOX HAS NO INPUTS
        {
            JOptionPane.showMessageDialog(null, "YOU HAVE NOT INPUTTED ANY NUMBER OR CHOICE");
        }    
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //SHOWS EXIT OPTION IF CANCEL BUTTON IS CLICKED
        tax_assgn.Tax_Assgn.beginExecutionGUI(6, 0);
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(firstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(firstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(firstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(firstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new firstPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField choice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea showFilingStatus;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
