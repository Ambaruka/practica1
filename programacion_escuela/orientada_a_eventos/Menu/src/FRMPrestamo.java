import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRMPrestamo extends JFrame{
    private JPanel JPPrestamo;
    private JLabel JLTituolo;
    private JList JLIprestamo;
    private JLabel JLPrestamo;
    private JList JLIEntrega;
    private JLabel JLEntrega;
    private JTextField JTAlumno;
    private JLabel JLNombre;
    private JTextField JTLibro;
    private JLabel JLLibro;
    private JButton JBRegistrar;
    private JButton JBLimpiar;
    private JButton JBAtras;
    private JLabel JLMensaje;

    int contador=0;
    int alumnito=0;
    int librito=0;
    public FRMPrestamo(Prestamo[] prestamo,Alumnos[] alumnos,Libro[] libros,FRMMenu frmMenu ) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPPrestamo);
        setSize(500,700);


        JBRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (posible()){
                    for (int i=0;alumnos[i]!=null;i++){
                        if (alumnos[i].getNombre().equals(JTAlumno.getText())){
                        alumnito=i;}
                    }
                    for (int i=0;libros[i]!=null;i++){
                        if (libros[i].getNombre().equals(JTLibro.getText())){
                            librito=i;
                        }
                    }

                    if (alumnos[alumnito]!=null && libros[librito]!=null){
                    prestamo[contador]=new Prestamo(Integer.parseInt(JLIprestamo.getSelectedValue().toString()),Integer.parseInt(JLIEntrega.getSelectedValue().toString()),
                            alumnos[alumnito],libros[librito]);
                    JLMensaje.setText("Registro hecho con éxito");}

                    else if (alumnos[alumnito]==null){JLMensaje.setText("Alumno no encontrado");}
                    else {JLMensaje.setText("Libro no encontrado");}

                }else {JLMensaje.setText("Complete los datos");}
            }
        });

        JBAtras.addActionListener(e->{
            this.dispose();
            frmMenu.setVisible(true);
        });
        JBLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            vacio();
            }
        });
    }
    private boolean posible(){
        boolean posible = true;
        if (JTAlumno.getText().trim().isEmpty() || JTLibro.getText().trim().isEmpty()|| JLIprestamo.getSelectedValue()==null|| JLIEntrega.getSelectedValue()==null){
            posible = false;
        }return posible;
    }
    private void vacio(){
        JTAlumno.setText("");
        JTLibro.setText("");
        JLIEntrega.clearSelection();
        JLIprestamo.clearSelection();
    }

}
