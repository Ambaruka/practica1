import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRMViLibros extends JFrame{
    private JPanel JPViLibros;
    private JLabel JLTitulo;
    private JLabel JLNombre;
    private JLabel JLGenero;
    private JLabel JLPublicacion;
    private JLabel JLDisponibilidad;
    private JLabel SuNombre;
    private JLabel SuGenero;
    private JLabel SuPublicacion;
    private JLabel SuDisponibilidad;
    private JButton JBAnterior;
    private JButton JBSiguiente;
    private JButton JBAtras;
    private JLabel JLMensaje;

    int contador=0;

    public FRMViLibros(Libro[] libros,FRMMenu frmMenu) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPViLibros);
        setSize(500,500);

        JLPublicacion.setText("<html>Año de<br>publicación</html>");

            imprecion(libros[contador]);

        JBAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador>0){
                    contador--;
                    imprecion(libros[contador]);
                }else {JLMensaje.setText("Sen encuentra en el primer registro");}
            }
        });
        JBSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (libros[contador+1]!=null){
                    contador++;
                    imprecion(libros[contador]);
                }else {JLMensaje.setText("Sen encuentra en el untimo registro");}
            }
        });
        JBAtras.addActionListener(e->{
            this.dispose();
            frmMenu.setVisible(true);
        });
    }
    private void imprecion(Libro libro){
        SuNombre.setText(libro.getNombre());
        SuGenero.setText(libro.getGenero());
        SuPublicacion.setText(String.valueOf(libro.getAñoPublicacion()));
        if (libro.isDisponible()==true){SuDisponibilidad.setText("Disponible");}
        else {SuDisponibilidad.setText("No disponible");}
        
    }
}
