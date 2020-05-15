package mvc.vista;

import mvc.controlador.Controlador;
import mvc.controlador.ControladorMVC;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class VentanaClienteNuevo{
    private Controlador controlador;

    public VentanaClienteNuevo (Controlador controlador){
        this.controlador=controlador;
    }

    private void GUI() {
        JFrame ventana = new JFrame("Nuevo Cliente");
        Container contenedor = ventana.getContentPane();
        JPanel panelPrincipal=new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.PAGE_AXIS));

        JPanel panelCampos= new JPanel();
        panelCampos.setLayout(new GridLayout(7,2));
        JPanel panelTipo=new JPanel();
        panelTipo.setLayout(new BoxLayout(panelTipo,BoxLayout.LINE_AXIS));
        JPanel panelAnyadir =new JPanel();
        panelAnyadir.setLayout(new BoxLayout(panelAnyadir,BoxLayout.LINE_AXIS));

        JLabel nombre= new JLabel("Nombre:");
        JLabel apellidos= new JLabel("Apellidos:");
        JLabel nif=new JLabel("NIF:");
        JLabel email=new JLabel("Correo:");
        JLabel poblacion=new JLabel("Población:");
        JLabel provincia=new JLabel("Provincia:");
        JLabel codPostal=new JLabel("Código postal:");

        JTextField campo1 = new JTextField(20);
        JTextField campo2 = new JTextField(20);
        JTextField campo3 = new JTextField(20);
        JTextField campo4 = new JTextField(20);
        JTextField campo5 = new JTextField(20);
        JTextField campo6 = new JTextField(20);
        JTextField campo7 = new JTextField(20);

        panelCampos.add(nombre);
        panelCampos.add(campo1);
        panelCampos.add(apellidos);
        panelCampos.add(campo2);
        panelCampos.add(nif);
        panelCampos.add(campo3);
        panelCampos.add(email);
        panelCampos.add(campo4);
        panelCampos.add(poblacion);
        panelCampos.add(campo5);
        panelCampos.add(provincia);
        panelCampos.add(campo6);
        panelCampos.add(codPostal);
        panelCampos.add(campo7);

        JRadioButton particular = new JRadioButton("Particular");
        JRadioButton empresa = new JRadioButton("Empresa");
        particular.setSelected(true);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(particular);
        grupo.add(empresa);
        empresa.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                switch(e.getStateChange()) {
                    case ItemEvent.SELECTED:
                        campo2.setEnabled(false);
                        break;
                    case ItemEvent.DESELECTED:
                        campo2.setEnabled(true);
                        break;
                }
            }
        });
        JButton jbAnyadir=new JButton("Añadir");
        jbAnyadir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String apellidos="";
                String nombre=campo1.getText();
                String nif=campo3.getText();
                String correo=campo4.getText();
                String poblacion=campo5.getText();
                String provincia=campo6.getText();
                String codPostal=campo7.getText();
                int cp= Integer.parseInt(codPostal);
                if(campo2.isEnabled()){
                    apellidos=campo2.getText();
                }
                controlador.crearCliente(nombre,apellidos,nif,correo,poblacion,provincia,cp);
                ventana.dispose();

            }
        });
        panelTipo.add(particular);
        panelTipo.add(empresa);
        panelAnyadir.add(jbAnyadir);

        panelPrincipal.add(panelCampos);
        panelPrincipal.add(panelTipo);
        panelPrincipal.add(panelAnyadir);
        contenedor.add(panelPrincipal);



        ventana.setDefaultCloseOperation(ventana.HIDE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);

    }
    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI();
            }
        });
    }
}
