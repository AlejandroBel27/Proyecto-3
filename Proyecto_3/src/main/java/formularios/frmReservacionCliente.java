/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;

import Dao.DAOHabitaciones;
import Dao.DAOHoteles;
import Dao.DAOReservaciones;
import Exceptions.DAOException;
import ObjetosGUI.Habitaciones;
import ObjetosGUI.Hotel;
import ObjetosGUI.Reservaciones;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Proyecto_3
 */
public class frmReservacionCliente extends javax.swing.JFrame {

    private DAOReservaciones dao = new DAOReservaciones();
    private ArrayList<String> hotel = new ArrayList<>();
    private ArrayList<String> tipo = new ArrayList<>();

    /**
     * Creates new form frmReservacionCliente
     */
    public frmReservacionCliente() {
        initComponents();
        cargarComboBoxHabitacion();
        cargarComboBoxHotel();
        imprimirTablaCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboBoxHotel = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtHoraEntrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHoraSalida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboBoxTipoHabitacion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnReservar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("CLIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalir.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon("/Users/alejandrobel/Desktop/ISW/BDA_avanzada/Proyecto-3/Proyecto_3/src/main/resources/Iconos/logout-icon.png")); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Hotel:");

        comboBoxHotel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Hora entrada:");

        jLabel5.setText("Hora salida:");

        jLabel6.setText("Tipo habitación");

        comboBoxTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableCliente);

        btnBuscar.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon("/Users/alejandrobel/Desktop/ISW/BDA_avanzada/Proyecto-3/Proyecto_3/src/main/resources/Iconos/icons8-consultar-el-manual-30.png")); // NOI18N
        btnBuscar.setText("Buscar");

        btnReservar.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnReservar.setIcon(new javax.swing.ImageIcon("/Users/alejandrobel/Desktop/ISW/BDA_avanzada/Proyecto-3/Proyecto_3/src/main/resources/Iconos/icons8-reserva-30.png")); // NOI18N
        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(comboBoxHotel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtHoraEntrada)
                                    .addComponent(txtHoraSalida)
                                    .addComponent(comboBoxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnReservar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnReservar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        InicioSesion f = new InicioSesion();
        f.setVisible(true);

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        if(txtHoraEntrada.getText().equals(" ")||txtHoraSalida.getText().equals(" ")){
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos.");
            return;
        }
        
        Reservaciones r= new Reservaciones();
        
        r.setNombreHotel(hotel);
        r.setFecha_inicio(txtHoraEntrada.getText());
        r.setFecha_fin(txtHoraSalida.getText());
        r.setTipoHabitacion(tipo);
       
    try{
        dao.insertar(r);
        JOptionPane.showMessageDialog(null, "Reservación realizada correctamente.");
        imprimirTablaCliente();
    }catch (DAOException e) {
            Logger.getLogger(frmReservacionAgencia.class.getName()).log(Level.SEVERE, null, e);
        }
        

    }//GEN-LAST:event_btnReservarActionPerformed

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
            java.util.logging.Logger.getLogger(frmReservacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReservacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReservacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReservacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReservacionCliente().setVisible(true);
            }
        });
    }

    private void cargarComboBoxHotel() {
        DAOHoteles daoHotel = new DAOHoteles();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        ArrayList<Hotel> hotel = new ArrayList<>();

        try {
            hotel = daoHotel.consultar();

            for (Hotel hoteles : hotel) {
                String hot = hoteles.getNombre();
                modelo.addElement(hot);
            }

        } catch (DAOException e) {
            Logger.getLogger(frmReservacionCliente.class.getName()).log(Level.SEVERE, null, e);
        }

        comboBoxHotel.setModel(modelo);
    }

    private void cargarComboBoxHabitacion() {
        DAOHabitaciones daoHabitacion = new DAOHabitaciones();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        ArrayList<Habitaciones> habitacion = new ArrayList<>();

        try {
            habitacion = daoHabitacion.consultar();

            for (Habitaciones hab : habitacion) {
                String tipo = hab.getTipo();
                modelo.addElement(tipo);
            }
        } catch (DAOException e) {
            Logger.getLogger(frmReservacionCliente.class.getName()).log(Level.SEVERE, null, e);
        }

        comboBoxTipoHabitacion.setModel(modelo);
    }

    private void imprimirTablaCliente() {
        DefaultTableModel modelo = new DefaultTableModel();

        tableCliente.setModel(modelo);

        modelo.addColumn("ID");
        modelo.addColumn("Hotel");
        modelo.addColumn("Tipo Habitacion");
        modelo.addColumn("Ingreso");
        modelo.addColumn("Salida");

        ArrayList<Reservaciones> res = null;

        try {
            res = dao.consultar();
        } catch (DAOException e) {
            Logger.getLogger(frmReservacionAgencia.class.getName()).log(Level.SEVERE, null, e);
        }

        StringBuffer sb = new StringBuffer();

        Object o[] = null;

        Reservaciones[] rArray = new Reservaciones[res.size()];
        rArray = res.toArray(rArray);

        for (int i = 0; i < rArray.length; i++) {

            if (txtBuscar.getText().equals(rArray[i].getNombreHotel())) {
                Object info[] = new Object[5];
                info[0] = rArray[i].getId();
                info[1] = rArray[i].getNombreHotel();
                info[2] = rArray[i].getTipoHabitacion();
                info[3] = rArray[i].getFecha_inicio();
                info[4] = rArray[i].getFecha_fin();

                modelo.addRow(info);

                Reservaciones agen = rArray[i];

                modelo.setValueAt(agen.getId().toString(), i, 0);
                modelo.setValueAt(agen.getNombreHotel().toString(), i, 1);
                modelo.setValueAt(agen.getTipoHabitacion().toString(), i, 2);
                modelo.setValueAt(agen.getFecha_inicio().toString(), i, 3);
                modelo.setValueAt(agen.getFecha_fin().toString(), i, 4);
                tableCliente.repaint();
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboBoxHotel;
    private javax.swing.JComboBox<String> comboBoxTipoHabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCliente;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtHoraEntrada;
    private javax.swing.JTextField txtHoraSalida;
    // End of variables declaration//GEN-END:variables
}
