/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class RegistroPago extends javax.swing.JFrame {

    /**
     * Creates new form RegistroPago
     */
    public RegistroPago() {
        initComponents();
    }

    public JTextField getTfxApellido() {
        return tfxApellido;
    }

    public void setTfxApellido(JTextField tfxApellido) {
        this.tfxApellido = tfxApellido;
    }

    public JTextField getTfxDireccion() {
        return tfxDireccion;
    }

    public void setTfxDireccion(JTextField tfxDireccion) {
        this.tfxDireccion = tfxDireccion;
    }

    public JTextField getTfxNombre() {
        return tfxNombre;
    }

    public void setTfxNombre(JTextField tfxNombre) {
        this.tfxNombre = tfxNombre;
    }

    public JTextField getTfxTelefono() {
        return tfxTelefono;
    }

    public void setTfxTelefono(JTextField tfxTelefono) {
        this.tfxTelefono = tfxTelefono;
    }    

    public JButton getBtnRegistrarPago() {
        return btnRegistrarPago;
    }

    public void setBtnRegistrarPago(JButton btnRegistrarPago) {
        this.btnRegistrarPago = btnRegistrarPago;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        tfxNombre = new javax.swing.JTextField();
        tfxApellido = new javax.swing.JTextField();
        tfxDireccion = new javax.swing.JTextField();
        tfxTelefono = new javax.swing.JTextField();
        btnRegistrarPago = new javax.swing.JButton();

        lbNombre.setText("Nombre");

        lbApellido.setText("Apellido");

        lbDireccion.setText("Dirección");

        lbTelefono.setText("Teléfono");

        btnRegistrarPago.setText("Registrar Pago");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lbNombre)
                        .addGap(18, 18, 18)
                        .addComponent(tfxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lbApellido)
                        .addGap(18, 18, 18)
                        .addComponent(tfxApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lbDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfxDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRegistrarPago)
                        .addGroup(panelLayout.createSequentialGroup()
                            .addComponent(lbTelefono)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfxTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(tfxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApellido)
                    .addComponent(tfxApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDireccion)
                    .addComponent(tfxDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefono)
                    .addComponent(tfxTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnRegistrarPago)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarPago;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField tfxApellido;
    private javax.swing.JTextField tfxDireccion;
    private javax.swing.JTextField tfxNombre;
    private javax.swing.JTextField tfxTelefono;
    // End of variables declaration//GEN-END:variables
}