import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRMViPrestamos extends JFrame {
    private JPanel JPPrestamos;
    private JLabel JLTitulo;
    private JButton JBAnteriuor;
    private JButton Siguiente;
    private JButton JBAtras;
    private JLabel JLPrestamo;
    private JLabel JLDiaentrega;
    private JLabel JLAlumno;
    private JLabel JLLIbro;
    private JLabel suprestamo;
    private JLabel Suentrega;
    private JLabel SuAlumno;
    private JLabel SuLibro;
    private JLabel JLMensaje;

    int contador=0;

    public FRMViPrestamos(Prestamo[] prestamos,FRMMenu frmMenu) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPPrestamos);
        setSize(500,500);

        JLPrestamo.setText("<html>Día de<br>prestamo:</html>");
        JLDiaentrega.setText("<html>Día de<br>entrga:</html>");

    if (prestamos[contador] != null) {
        imprimir(prestamos[contador]);
    }else {JLMensaje.setText("No hay prestamos");}

        JBAnteriuor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador>0){
                    contador--;
                    imprimir(prestamos[contador]);
                }else {JLMensaje.setText("No hay prestamos anteriores");}
            }
        });
        Siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prestamos[contador+1]!=null){
                    contador++;
                    imprimir(prestamos[contador]);
                }else {JLMensaje.setText("No hay más prestamos");}
            }
        });
        JBAtras.addActionListener(e->{
            this.dispose();
            frmMenu.setVisible(true);
        });
    }
    private void imprimir(Prestamo prestamo){
        suprestamo.setText(String.valueOf(prestamo.getFechaPrestamo()));
        Suentrega.setText(String.valueOf(prestamo.getFechaEntrega()));
        SuAlumno.setText(String.valueOf(prestamo.getAlumno().getNombre()));
        SuLibro.setText(String.valueOf(prestamo.getLibro().getNombre()));
    }
}
