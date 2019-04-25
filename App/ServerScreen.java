package App;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServerScreen extends javax.swing.JFrame {

    private Server server;

    public ServerScreen(Server server) {
        initComponents();
        populate();
        setVisible(true);
        this.server = server;
        
//        try {
//            addOffer(new HashMap<String, Object>() {
//                {
//                    put("client", new Client());
//                    put("id", 111);
//                    put("city", "gp");
//                    put("hotel", "hp");
//                    put("people", 123);
//                    put("dateDeparture", "01/01/2019");
//                    put("dateReturn", "02/01/2019");
//                    put("maxPrice", new Float(10));
//                }
//            });
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    public void addOffer(OfferInterface offer) {
        try {
            ClientInterfaceRemote client = (ClientInterfaceRemote) offer.get("client");
            DefaultTableModel model = (DefaultTableModel) jTableOffers.getModel();

            model.addRow(new Object[]{
                (String) offer.get("clientId"),
                (Integer) offer.get("id"),
                (String) offer.get("city"),
                (String) offer.get("hotel"),
                (Integer) offer.get("people"),
                (String) offer.get("dateDeparture"),
                (String) offer.get("dateReturn"),
                (Float) offer.get("maxPrice")
            });
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelOffer(String clientId, Integer offerId) {
        DefaultTableModel table = (DefaultTableModel) jTableOffers.getModel();

        for (int i = 0; i < table.getRowCount(); i++) {
            if (clientId.equals((String) table.getValueAt(i, 0))) {
                if (offerId.equals((Integer) table.getValueAt(i, 1))) {
                    table.removeRow(i);
                    return;
                }
            }
        }
    }

    public JTable getTableOffers() {
        return jTableOffers;
    }

    public JTable getTableBedrooms() {
        return jTableBedrooms;
    }

    public JTable getTableFlights() {
        return jTableFlights;
    }

    public void populate() {
        DefaultTableModel tableBedrooms = (DefaultTableModel) jTableBedrooms.getModel();
        tableBedrooms.addRow(new Object[]{"c1", "h1", new Float(100)});
        tableBedrooms.addRow(new Object[]{"c2", "h2", new Float(100)});
        tableBedrooms.addRow(new Object[]{"c1", "h2", new Float(100)});
        tableBedrooms.addRow(new Object[]{"c2", "h1", new Float(100)});

        DefaultTableModel tableFlights = (DefaultTableModel) jTableFlights.getModel();
        tableFlights.addRow(new Object[]{"c1", new Float(100), "01/01/2020", "02/01/2020"});
        tableFlights.addRow(new Object[]{"c2", new Float(100), "01/02/2020", ""});
    }

    // --
    /**
     * Creates new form ServerScreen
     */
    public ServerScreen() {
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtextFieldHotel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTextFieldPrice = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCityDestiny = new javax.swing.JTextField();
        jTextFieldPrice = new javax.swing.JTextField();
        jButtonNewBedroom = new javax.swing.JButton();
        jButtonNewFlight = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBedrooms = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFlights = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableOffers = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldHotelCity = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jTextFieldDateDeparture = new javax.swing.JTextField();
        jTextFieldDateReturn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Loja de Turismo");

        jtextFieldHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextFieldHotelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel2.setText("Cadastre quarto de Hotel");

        JTextFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldPriceActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel6.setText("Cadastre um voo");

        jTextFieldCityDestiny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCityDestinyActionPerformed(evt);
            }
        });

        jButtonNewBedroom.setText("Cadastrar");
        jButtonNewBedroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewBedroomActionPerformed(evt);
            }
        });

        jButtonNewFlight.setText("Cadastrar");
        jButtonNewFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewFlightActionPerformed(evt);
            }
        });

        jTableBedrooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cidade", "Hotel", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBedrooms);

        jTableFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cidade Destino", "Preço", "Dt. de Ida", "Dt. de Volta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableFlights);

        jTableOffers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Interesse", "Cidade", "Hotel", "Pessoas", "Dt. de Ida", "Dt. de Volta", "Preço Max."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableOffers);

        jLabel11.setText("Interesses Cadastrados");

        jTextFieldDateReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateReturnActionPerformed(evt);
            }
        });

        jLabel3.setText("Cidade:");

        jLabel4.setText("Hotel");

        jLabel5.setText("Preço:");

        jLabel7.setText("Cidade Destino:");

        jLabel8.setText("Preço:");

        jLabel9.setText("Dt. de Ida / Volta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldHotelCity, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtextFieldHotel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNewBedroom)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonNewFlight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldDateDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldDateReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)
                                    .addComponent(jTextFieldCityDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(jTextFieldHotelCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(jtextFieldHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNewBedroom)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(jTextFieldCityDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDateDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDateReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNewFlight)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtextFieldHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextFieldHotelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextFieldHotelActionPerformed

    private void jButtonNewFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewFlightActionPerformed
        DefaultTableModel t = (DefaultTableModel) jTableFlights.getModel();
        t.addRow(new Object[]{
            jTextFieldCityDestiny.getText(),
            new Float(jTextFieldPrice.getText()),
            jTextFieldDateDeparture.getText(),
            jTextFieldDateReturn.getText(),
        });

        server.notifyIfMatches();
    }//GEN-LAST:event_jButtonNewFlightActionPerformed

    private void JTextFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextFieldPriceActionPerformed

    private void jButtonNewBedroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewBedroomActionPerformed
        DefaultTableModel t = (DefaultTableModel) jTableBedrooms.getModel();
        t.addRow(new Object[]{
            (String) jTextFieldHotelCity.getText(),
            (String) jtextFieldHotel.getText(),
            new Float(JTextFieldPrice.getText())
        });

        server.notifyIfMatches();
    }//GEN-LAST:event_jButtonNewBedroomActionPerformed

    private void jTextFieldCityDestinyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCityDestinyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCityDestinyActionPerformed

    private void jTextFieldDateReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDateReturnActionPerformed

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
            java.util.logging.Logger.getLogger(ServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldPrice;
    private javax.swing.JButton jButtonNewBedroom;
    private javax.swing.JButton jButtonNewFlight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTableBedrooms;
    private javax.swing.JTable jTableFlights;
    private javax.swing.JTable jTableOffers;
    private javax.swing.JTextField jTextFieldCityDestiny;
    private javax.swing.JTextField jTextFieldDateDeparture;
    private javax.swing.JTextField jTextFieldDateReturn;
    private javax.swing.JTextField jTextFieldHotelCity;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jtextFieldHotel;
    // End of variables declaration//GEN-END:variables
}
