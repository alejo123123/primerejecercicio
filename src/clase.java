import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Clase extends JFrame {

    String[] opciones = { "50000", "20000", "10000", "5000", "2000", "1000", "500", "200", "100", "50" };
    String[] encabe = { "cantidad", "presentacion", "denominacion" };
    String[] presentaciones = { "billete", "billete", "billete", "billete", "billete", "moneda", "moneda", "moneda", "moneda", "moneda" };
    int[] existencias = {0,0,0,0,0,0,0,0,0,0};
    int [] devuelta = {0,0,0,0,0,0,0,0,0,0};
    private JTextField txtCantidad, txtexi;
    private JComboBox cmbRespuesta;
    JTable tblplata;
   
    

    public Clase() {

        setTitle("Caja Registradora");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        JLabel lblPregunta = new JLabel("Denominacion:");
        lblPregunta.setBounds(100, 50, 100, 20);
        add(lblPregunta);


        cmbRespuesta = new JComboBox();
        cmbRespuesta.setBounds(200, 50, 100, 25);
        add(cmbRespuesta);
        cmbRespuesta.setModel(new DefaultComboBoxModel(opciones));

        JButton btnAgregar = new JButton("actualizar existencias");
        btnAgregar.setBounds(90, 100, 100, 25);
        add(btnAgregar);

        txtexi = new JTextField();
        txtexi.setBounds(200, 100, 100, 25);
        add(txtexi);


        JLabel lblde = new JLabel("valor a devolver:");
        lblde.setBounds(50, 150, 100, 20);
        add(lblde);


       JButton btnde = new JButton("Devolver");
        btnde.setBounds(270, 150, 100, 25);
        add(btnde);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(150, 150, 100, 25);
        add(txtCantidad);


        tblplata = new JTable();
        JScrollPane spplata = new JScrollPane(tblplata);
        spplata.setBounds(10, 230, 470, 200);
        add(spplata);


        DefaultTableModel modelo = new DefaultTableModel(null, encabe);
        tblplata.setModel(modelo);


        btnAgregar.addActionListener(e -> {
            agregare();
        });
    }

    private void agregare() {
        int index = cmbRespuesta.getSelectedIndex();
        String num = txtexi.getText();
        existencias[index] = Integer.parseInt(num);
        txtexi.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tblplata.getModel();
        modelo.setRowCount(0);
      

        for (int i = 0; i<opciones.length;i++) {

        Object[] fila = { 
            existencias[i], 
            presentaciones[i], 
            opciones[i] 
        };
        modelo.addRow(fila);

        
         
    }

        
    }
}
