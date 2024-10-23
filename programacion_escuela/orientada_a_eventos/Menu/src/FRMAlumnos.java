import javax.swing.*;
import java.awt.event.*;

public class FRMAlumnos extends JFrame{
    private JPanel JPAlumnos;
    private JLabel JLTitulo;
    private JTextField JTNombre;
    private JTextField JTMatricula;
    private JList JLIDias;
    private JLabel JLNombre;
    private JRadioButton JRBEntregados;
    private JRadioButton JRBPrestamo;
    private JLabel JLMatricula;
    private JLabel JLDias;
    private JLabel JLEntregados;
    private JLabel JLMensaje;
    private JButton JBRegistrar;
    private JButton JBLimpiar;
    private JButton JBAtras;

    ButtonGroup libros=new ButtonGroup();


    public FRMAlumnos(Alumnos[] alumnos, FRMMenu frmMenu) {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPAlumnos);
        setSize(500,700);

        libros.add(JRBEntregados);
        libros.add(JRBPrestamo);

        JTNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                limpiar();
                validaLetras(e);
                enter(e,JTNombre,JTMatricula);
            }
        });

        JTMatricula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                limpiar();
                validaNumeros(e);
            }
        });

        JLIDias.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                limpiar();
            }
        });

        JRBEntregados.addActionListener(e -> limpiar());

        JRBPrestamo.addActionListener(e -> limpiar());

        JBRegistrar.addActionListener(e -> {
            limpiar();
            if (posible()){
                int matricula =Integer.parseInt(JTMatricula.getText());
                int contador=0;
                for (int i=0;i<alumnos.length;i++){
                    if (alumnos[i]==null){
                        contador=i;
                        break;
                    }
                }
                alumnos[contador]=new Alumnos(JTNombre.getText(),
                        matricula,
                        Integer.parseInt(JLIDias.getSelectedValue().toString()),
                        libros());
                JLMensaje.setText("Registro hecho con exito");
            }else {JLMensaje.setText("Complete los datos");}
        });

        JBLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                JTNombre.setText("");
                JTMatricula.setText("");
                JLIDias.clearSelection();
                libros.clearSelection();
            }
        });

        JBAtras.addActionListener(e -> {
            this.dispose();
            frmMenu.setVisible(true);
        });
    }
    private boolean posible(){
        boolean posible= !JTNombre.getText().trim().isEmpty() && !JTMatricula.getText().trim().isEmpty() && JLIDias.getSelectedValue() != null && libros.getSelection() != null;
        return posible;
    }

    private boolean libros(){
        if (JRBEntregados.isSelected()){
            return true;
        }else {return false;}
    }

    private void validaLetras(KeyEvent e){
        if (!(Character.isAlphabetic(e.getKeyChar()))){
            e.consume();
        }
    }
    private void validaNumeros(KeyEvent e){
        if (!(Character.isDigit(e.getKeyChar()))){
            e.consume();
        }
    }

    private void enter(KeyEvent e,JTextField javier,JComponent oskar){
        char letra = e.getKeyChar();
        if (letra == KeyEvent.VK_ENTER) {
            oskar.requestFocus();//pasar el focus al siguiente input
        }
    }

    private void limpiar(){JLMensaje.setText("");}
}
