import javax.swing.*;
import java.awt.event.*;

public class FRMLibros extends JFrame{
    private JList<String> JLGeneros;
    private JLabel JLTitulo;
    private JPanel JPLibros;
    private JLabel JLGenero;
    private JTextField JTNombre;
    private JLabel JLNombre;
    private JTextField JTPublicacion;
    private JLabel JLPublicacion;
    private JRadioButton JRDisponible;
    private JRadioButton JRNoDisponible;
    private JLabel JLDisponible;
    private JButton JBRegistrar;
    private JButton JBLimpiar;
    private JButton JBAtras;
    private JLabel JLMensaje;

    ButtonGroup disponibilidad=new ButtonGroup();
    int contador=5;

    public FRMLibros(Libro[] libros,FRMMenu frmMenu) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPLibros);
        setSize(500,700);

        JLPublicacion.setText("<html>Año de<br>publicación</html>");
        disponibilidad.add(JRDisponible);
        disponibilidad.add(JRNoDisponible);

        JTPublicacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                mensaje();
                validaNumeros(e);
            }
        });
        JTNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                mensaje();
            }
        });
        JRDisponible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje();
            }
        });
        JRNoDisponible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje();
            }
        });
        JBRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje();
                if (posible()==true){
                libros[contador]=new Libro(JLGeneros.getSelectedValue(),JTNombre.getText(),Integer.parseInt(JTPublicacion.getText()),disponibles());
                contador++;
                JLMensaje.setText("Registro hecho con éxito");
                }else {JLMensaje.setText("Llene los datos");}
            }
        });
        JBLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                mensaje();
            }
        });
        JBAtras.addActionListener(e ->{
                mensaje();
                limpiar();
                this.dispose();
                frmMenu.setVisible(true);
        });
    }
    private boolean posible(){
        boolean posible=true;
        if (JTNombre.getText().trim().isEmpty() || JTPublicacion.getText().trim().isEmpty()||JLGeneros.getSelectedValue()==null||disponibilidad.getSelection()==null){
            posible=false;
        }return posible;
    }

    private boolean disponibles(){
        if (JRDisponible.isSelected()){return true;}
        else {return false;}
    }

    private void limpiar(){
        JTNombre.setText("");
        JLGeneros.clearSelection();
        JTPublicacion.setText("");
        disponibilidad.clearSelection();
    }

    private void mensaje(){
        JLMensaje.setText("");
    }

    private void validaNumeros(KeyEvent e){
        if (!(Character.isDigit(e.getKeyChar()))){
            e.consume();
        }
    }
}
