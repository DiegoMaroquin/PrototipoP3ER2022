/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.vista;

import rrhh.modelo.daocliente;
import rrhh.controlador.clscliente;
import rrhh.modelo.daoConcepto;
import rrhh.controlador.clsConcepto;

import rrhh.modelo.daoAsignacion;
import rrhh.controlador.clsAsignacion;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import java.io.File;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class frmAsignacion extends javax.swing.JInternalFrame {

    public void llenadoDeCombos() {
        daocliente empleadoDAO = new daocliente();
        List<clscliente> empleados = empleadoDAO.select();
        empleadoss.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            empleadoss.addItem(empleados.get(i).getnombre_cliente());
        }
    }
    
   
    public void llenadoDeconceptoID() {
        daoConcepto conceptoDAO = new daoConcepto();
        List<clsConcepto> IdConcepto = conceptoDAO.select();
        Cbx_buscado.addItem("Seleccione una opción");
        for (int i = 0; i < IdConcepto.size(); i++) {
            Cbx_buscado.addItem(IdConcepto.get(i).getconcepnombre());
        }
    }
    
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Concepto");
        modelo.addColumn("Igss");
        modelo.addColumn("Isr");
        modelo.addColumn("Otros");
        modelo.addColumn("Total");
        daoAsignacion asignaDAO = new daoAsignacion();
        List<clsAsignacion> asignas = asignaDAO.select();
        tablaasignacion.setModel(modelo);
        String[] dato = new String[8];
        for (int i = 0; i < asignas.size(); i++) {
            dato[0] = Integer.toString(asignas.get(i).getaid());
            dato[1] = asignas.get(i).getanombre();
            dato[2] = asignas.get(i).getaconcepto();
            dato[3] = asignas.get(i).getavigss();
            dato[4] = asignas.get(i).getavisr();
            dato[5] = asignas.get(i).getavotros();
            dato[6] = asignas.get(i).getavalor();
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

  

    public void agrega(Stack pila){
    conceptosAgregados.setText(String.valueOf(pila));
    }
    public void agregaValores(Stack pilaValores){
    VConceptos.setText(String.valueOf(pilaValores));
    }
 
    
    public void buscarconcepto() {
        clsConcepto conceptoAConsultar = new clsConcepto();
        daoConcepto conceptoDAO = new daoConcepto();
        
        conceptoAConsultar.setconcepnombre(Cbx_buscado.getSelectedItem().toString());
        conceptoAConsultar = conceptoDAO.query2(conceptoAConsultar);     
        valor.setText(conceptoAConsultar.getconcepvalor());
        efecto.setSelectedItem(conceptoAConsultar.getconcepefecto());
       
        }
   
    
    double nhoras=0;
    public void buscarsalario() {
        
        conceptosAgregados.setText(""); 
        salario.setText(""); 
        
        
        clscliente empleadoAConsultar2 = new clscliente();
        daocliente empleadoDAO = new daocliente();
        
        empleadoAConsultar2.setnombre_cliente(empleadoss.getSelectedItem().toString());
        empleadoAConsultar2 = empleadoDAO.query2(empleadoAConsultar2);
    
        salario.setText(empleadoAConsultar2.getdireccion_cliente());     
        salario1.setText(empleadoAConsultar2.getdireccion_cliente());     
        nhoras=Double.parseDouble(empleadoAConsultar2.getnit_cliente());
         
        }

    
    public void sumayresta(){
efecto.addItem("");
efecto.addItem("+");
efecto.addItem("-");
}

 public void tipo(){
tiposAsignacion.addItem("algunos/excepcion");
tiposAsignacion.addItem("muchos");
}    
   

    
    public void procedimientosAdd(){
   String igss = "igss";
   String isr= "isr" ;
   String horas= "horas_extras" ;
   String conceptos = Cbx_buscado.getSelectedItem().toString();

   Double numero1= Double.parseDouble(salario.getText());
   Double numeroCP= Double.parseDouble(salario1.getText());
   Double numero2= Double.parseDouble(valor.getText()); 
   int calculos = efecto.getSelectedIndex();
   
   if(calculos == 1){
   
   if (conceptos.equals(igss)){
   double porcentaje = (numero2 * numeroCP)/100;
    porcentajeIgssA = (numero2 * numeroCP)/100;
   salario.setText(String.valueOf(numero1 + porcentaje));
   
   
   }
   else if (isr.equals(conceptos)){
   double porcentaje = (numero2 * numeroCP)/100;
   porcentajeIsrA = (numero2 * numeroCP)/100;
   salario.setText(String.valueOf(numero1 + porcentaje));
   
   }else if (horas.equals(conceptos)){
   double horasX = nhoras * numero2;
   
   salario.setText(String.valueOf(numero1 + horasX));
   
   }
   else{
  salario.setText(String.valueOf(numero1 + numero2));
   }
  
   }
   
   
   if(calculos == 2){
   
     if (conceptos.equals(igss)){
   double porcentaje = (numero2 * numeroCP) / 100;
   porcentajeIgssA = (numero2 * numeroCP)/100;
   salario.setText(String.valueOf(numero1 - porcentaje));
   
   }
     else if (isr.equals(conceptos)){
   double porcentaje = (numero2 * numeroCP) / 100;
   porcentajeIsrA = (numero2 * numeroCP)/100;
   salario.setText(String.valueOf(numero1 - porcentaje));
   
   }else if (horas.equals(conceptos)){
   double horasX = nhoras * numero2;
   
   salario.setText(String.valueOf(numero1 - horasX));
   
   }else{
  salario.setText(String.valueOf(numero1 - numero2));
   }

   }
    }
    
 public void proceso(){
   Double numero1= Double.parseDouble(VV.getText());
   Double numero2= Double.parseDouble(valor.getText());    
  int calculos = efecto.getSelectedIndex();
   
 if(calculos == 1){
   
  VV.setText(String.valueOf(numero1 + numero2));
   }
 if(calculos == 2){
   
 
  VV.setText(String.valueOf(numero1 - numero2));
  
   }
  
   }
    

    public void autollenadoEmpleados(){
      
      

     int calculos = efecto.getSelectedIndex();
        
        
     int c = 0;
     String consultar="",vacio="";
    String agregados;
     int contador=1, contador2=1;
    consultar = JOptionPane.showInputDialog("registro" + "Numero de empleados" + c+".");
    int a = Integer.parseInt(consultar);
     clscliente empleadoAConsultar = new clscliente();
     daocliente empleadoDAO = new daocliente();
        
     clsAsignacion busquedaAConsultar = new clsAsignacion();
     daoAsignacion busquedaDAO = new daoAsignacion();
     
     daoAsignacion datosDAO = new daoAsignacion();
     clsAsignacion datosAInsertar = new clsAsignacion(); 
       
    while(contador <= a){
    
    empleadoAConsultar.setCodigo_cliente(contador);
    empleadoAConsultar = empleadoDAO.query(empleadoAConsultar); 

     
     empleadoAConsultar.getnombre_cliente();
     empleadoAConsultar.getdireccion_cliente();
     empleadoAConsultar.getnit_cliente();

   String conceptos = conceptosAgregados.getText();
   String valorConcepto = VConceptos.getText();

    Double numero1= Double.parseDouble(empleadoAConsultar.getdireccion_cliente());
    Double numeroH= Double.parseDouble(empleadoAConsultar.getnit_cliente());
    Double numero2= Double.parseDouble(VV.getText());
    double porcentajeIgss = (vigss * numero1)/100;  
    double porcentajeIsr = (visr * numero1)/100; 
    double calculoshoras= vhoras * numeroH;
    
    
 if(calculos == 1){
         
     datosAInsertar.setanombre(empleadoAConsultar.getnombre_cliente());
     datosAInsertar.setaconcepto(conceptos);
     datosAInsertar.setavigss(String.valueOf(porcentajeIgss));
     datosAInsertar.setavisr(String.valueOf(porcentajeIsr));
     datosAInsertar.setavotros(String.valueOf(pilaValores));
     datosAInsertar.setavalor(String.valueOf(numero1 - porcentajeIgss - porcentajeIsr +calculoshoras + numero2));
    
     datosDAO.insert(datosAInsertar);
      llenadoDeTablas();

   }
 if(calculos == 2){
   
     datosAInsertar.setanombre(empleadoAConsultar.getnombre_cliente());
     datosAInsertar.setaconcepto(conceptos);
     datosAInsertar.setavigss(String.valueOf(porcentajeIgss));
     datosAInsertar.setavisr(String.valueOf(porcentajeIsr));
     datosAInsertar.setavotros(String.valueOf(pilaValores));
     datosAInsertar.setavalor(String.valueOf(numero1 - porcentajeIgss - porcentajeIsr +calculoshoras + numero2));
    
     datosDAO.insert(datosAInsertar);
      llenadoDeTablas();
     
 
   }
      contador++;
   
    }
    
    
    
    
    
    }
    
    
    public frmAsignacion() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
        llenadoDeconceptoID();
        sumayresta();
        tipo();

        VV.setText("0");
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        lb = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaasignacion = new javax.swing.JTable();
        empleadoss = new javax.swing.JComboBox<>();
        label2 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        lb1 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        conceptosAgregados = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        label8 = new javax.swing.JLabel();
        reiniciar = new javax.swing.JButton();
        salario = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();
        buscarSalario = new javax.swing.JButton();
        efecto = new javax.swing.JComboBox<>();
        label10 = new javax.swing.JLabel();
        tiposAsignacion = new javax.swing.JComboBox<>();
        tipos_asignacion = new javax.swing.JButton();
        label11 = new javax.swing.JLabel();
        VV = new javax.swing.JTextField();
        Cbx_buscado = new javax.swing.JComboBox<>();
        VConceptos = new javax.swing.JTextField();
        salario1 = new javax.swing.JTextField();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        jCheckBox1.setText("jCheckBox1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asignaciones");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 95, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 95, -1));

        Buscar.setText("Buscar");
        Buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 70, -1));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText(".");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 550, 20, 10));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 95, -1));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 13, -1));

        tablaasignacion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaasignacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Concepto", "Igss", "Isr", "Otros", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaasignacion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 780, 303));

        empleadoss.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        empleadoss.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        empleadoss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadossActionPerformed(evt);
            }
        });
        getContentPane().add(empleadoss, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, -1));

        label2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label2.setText("Conceptos Asignados");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, -1, 20));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Conceptos agregados");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        valor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        valor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        valor.setOpaque(false);
        getContentPane().add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 100, 30));

        lb1.setForeground(new java.awt.Color(204, 204, 204));
        lb1.setText(".");
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 13, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Valor");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, -1, -1));

        lb3.setForeground(new java.awt.Color(204, 204, 204));
        lb3.setText(".");
        getContentPane().add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 13, -1));
        getContentPane().add(conceptosAgregados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 220, 30));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Efecto");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        agregar.setText("agregar");
        agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        getContentPane().add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 95, -1));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Tipo de asignacion");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        reiniciar.setText("reset");
        reiniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 95, -1));
        getContentPane().add(salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 220, 30));

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Salario final");
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 70, 20));

        buscarSalario.setText("Buscar");
        buscarSalario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        buscarSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarSalarioActionPerformed(evt);
            }
        });
        getContentPane().add(buscarSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 70, -1));

        efecto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        efecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efectoActionPerformed(evt);
            }
        });
        getContentPane().add(efecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 100, 20));

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Buscar conceptos");
        getContentPane().add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        tiposAsignacion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tiposAsignacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        tiposAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposAsignacionActionPerformed(evt);
            }
        });
        getContentPane().add(tiposAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, -1));

        tipos_asignacion.setText("Eligir");
        tipos_asignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipos_asignacionActionPerformed(evt);
            }
        });
        getContentPane().add(tipos_asignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 70, -1));

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Empleado disponible");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        VV.setEnabled(false);
        getContentPane().add(VV, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 90, 30));

        Cbx_buscado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Cbx_buscado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Cbx_buscado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_buscadoActionPerformed(evt);
            }
        });
        getContentPane().add(Cbx_buscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 120, -1));

        VConceptos.setEnabled(false);
        getContentPane().add(VConceptos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 220, 30));

        salario1.setEnabled(false);
        getContentPane().add(salario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 20, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String algun ="algunos/excepcion", much="muchos";
        
        
        
        int c = 0;
        String consultar="";
        consultar = JOptionPane.showInputDialog("Eliminar Asignacion" + " Ingresar numero de ID que aparece en la tabla derecha." + c+".");
        
        
        
        daoAsignacion asignaDAO = new daoAsignacion();
        clsAsignacion asignaAEliminar = new clsAsignacion();;
        asignaAEliminar.setaid(Integer.parseInt(consultar));
        asignaDAO.delete(asignaAEliminar);
        llenadoDeTablas();
        
       
       
    }//GEN-LAST:event_btnEliminarActionPerformed

   
    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
       String algun ="algunos/excepcion", much="muchos";
       
         if(tiposAsignacion.getSelectedItem().toString().equals(much)){
        
        
             autollenadoEmpleados();
             
             
        }else{
        daoAsignacion perfilusuarioDAO = new daoAsignacion();
        clsAsignacion perfilusuarioAInsertar = new clsAsignacion();
        perfilusuarioAInsertar.setanombre(empleadoss.getSelectedItem().toString());
        perfilusuarioAInsertar.setaconcepto(String.valueOf(pila));
        perfilusuarioAInsertar.setavigss(String.valueOf(porcentajeIgssA));
        perfilusuarioAInsertar.setavisr(String.valueOf(porcentajeIsrA));
        perfilusuarioAInsertar.setavotros(String.valueOf(pilaValores));
        perfilusuarioAInsertar.setavalor(salario.getText());
        // aqui falta el valor
        perfilusuarioDAO.insert(perfilusuarioAInsertar);
        llenadoDeTablas();
        
         }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
        buscarconcepto();
 
    }//GEN-LAST:event_BuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
       VConceptos.setText("");
        salario.setText("");
        valor.setText("");
        efecto.setSelectedIndex(0);
        tiposAsignacion.setSelectedIndex(0);
        Cbx_buscado.setSelectedIndex(0);
        empleadoss.setSelectedIndex(0);
        conceptosAgregados.setText("");
        btnRegistrar.setEnabled(true);
        btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void empleadossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadossActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_empleadossActionPerformed
Stack<String> pila = new Stack<String>();
Stack<String> pilaValores = new Stack<String>();

int nagregados = 1; int n;
double vigss=0,visr=0,vhoras=0;
double porcentajeIgssA =0 , porcentajeIsrA = 0;
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
       String algun ="algunos/excepcion", much="muchos";
         String igss ="igss",isr ="isr",horas="horas extras";
         String separador=": ";
        if(tiposAsignacion.getSelectedItem().toString().equals(much)){
        
        if (igss.equals(Cbx_buscado.getSelectedItem().toString())){
        
        vigss = Double.parseDouble(valor.getText());
            
         
        String nameconcepto; 
        nameconcepto = Cbx_buscado.getSelectedItem().toString(); 
        pila.push(nameconcepto); 
        agrega(pila); 
            
   
        
        
        n = nagregados++;
        
        
        }else if (isr.equals(Cbx_buscado.getSelectedItem().toString())){
        
        visr = Double.parseDouble(valor.getText());
        
         
        String nameconcepto; 
        nameconcepto = Cbx_buscado.getSelectedItem().toString(); 
        pila.push(nameconcepto); 
        agrega(pila); 
            
        
        
        n = nagregados++;
   
        }
        else if (horas.equals(Cbx_buscado.getSelectedItem().toString())){
        
         vhoras = Double.parseDouble(valor.getText());
        
         
         
        String nameValores; 
        nameValores = Cbx_buscado.getSelectedItem().toString()+separador+valor.getText(); 
        pilaValores.push(nameValores); 
        agregaValores(pilaValores);  
        String nameconcepto; 
        nameconcepto = Cbx_buscado.getSelectedItem().toString(); 
        pila.push(nameconcepto); 
        agrega(pila); 
            
        
        
        n = nagregados++;
   
        }
        else{
        
            
     
        proceso();    
        
         String nameValores; 
        nameValores = Cbx_buscado.getSelectedItem().toString()+separador+valor.getText(); 
        pilaValores.push(nameValores); 
        agregaValores(pilaValores); 
        
        
        String nameconcepto; 
        nameconcepto = Cbx_buscado.getSelectedItem().toString(); 
        pila.push(nameconcepto); 
        agrega(pila); 

        n = nagregados++;
        
        }
        
        }else{
            
        if (igss.equals(Cbx_buscado.getSelectedItem().toString())){
        
        String nameconcepto; 
        nameconcepto = Cbx_buscado.getSelectedItem().toString(); 
        pila.push(nameconcepto); 
        agrega(pila); 
            
        procedimientosAdd();
        
        
        n = nagregados++;
        
        }else if (isr.equals(Cbx_buscado.getSelectedItem().toString())){
        
        String nameconcepto; 
        nameconcepto = Cbx_buscado.getSelectedItem().toString(); 
        pila.push(nameconcepto); 
        agrega(pila); 
            
        procedimientosAdd();
        
        
        n = nagregados++;
        
        }else{
        
        String nameValores; 
        nameValores = Cbx_buscado.getSelectedItem().toString()+separador+valor.getText(); 
        pilaValores.push(nameValores); 
        agregaValores(pilaValores); 
        
        
        String nameconcepto; 
        nameconcepto = Cbx_buscado.getSelectedItem().toString(); 
        pila.push(nameconcepto); 
        agrega(pila); 
        
        
         procedimientosAdd();
        
        
        n = nagregados++;
        
        }    
            
            
            
     
        
        
         
        
       
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        // TODO add your handling code here:
        vigss = 0;
        visr = 0;
        porcentajeIgssA = 0;
        porcentajeIsrA = 0;
        VV.setText("0");
        conceptosAgregados.setText("");
        
        
        int contador = 1;
        
        while(contador <= n){
        if(!pila.empty()){ 
                pila.pop(); 
                agrega(pila); 
        }
         if(!pilaValores.empty()){ 
                pilaValores.pop(); 
                agregaValores(pilaValores); 
        }
   
        contador++;
        }
        salario.setText("");
    }//GEN-LAST:event_reiniciarActionPerformed

    private void efectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_efectoActionPerformed

    private void buscarSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarSalarioActionPerformed
        // TODO add your handling code here:
     
        buscarsalario();
        
    }//GEN-LAST:event_buscarSalarioActionPerformed

    private void tiposAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposAsignacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiposAsignacionActionPerformed

    private void tipos_asignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipos_asignacionActionPerformed
        // TODO add your handling code here:
         String algun ="algunos/excepcion", much="muchos";
        
         if(tiposAsignacion.getSelectedItem().toString().equals(much)){
        
             buscarSalario.setVisible(false);
             empleadoss.setVisible(false);
             label11.setVisible(false);
             label9.setVisible(false);
             salario.setVisible(false);
           
        }else{
         buscarSalario.setVisible(true);
             empleadoss.setVisible(true);
             label11.setVisible(true);
             label9.setVisible(true);
             salario.setVisible(true);
           
         
         }
        
    }//GEN-LAST:event_tipos_asignacionActionPerformed

    private void Cbx_buscadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_buscadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_buscadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JComboBox<String> Cbx_buscado;
    private javax.swing.JTextField VConceptos;
    private javax.swing.JTextField VV;
    private javax.swing.JButton agregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton buscarSalario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField conceptosAgregados;
    private javax.swing.JComboBox<String> efecto;
    private javax.swing.JComboBox<String> empleadoss;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lbusu;
    private javax.swing.JButton reiniciar;
    private javax.swing.JTextField salario;
    private javax.swing.JTextField salario1;
    private javax.swing.JTable tablaasignacion;
    private javax.swing.JComboBox<String> tiposAsignacion;
    private javax.swing.JButton tipos_asignacion;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
