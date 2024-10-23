import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRMViAlumnos extends JFrame{
    private JPanel JPVIAlumnos;
    private JLabel JLtitulo;
    private JButton JBAnterior;
    private JButton JBSiguiente;
    private JButton button3;
    private JLabel JLNombre;
    private JLabel JLMatricula;
    private JLabel JLDias;
    private JLabel JLEstado;
    private JLabel SuNombre;
    private JLabel SuMatricula;
    private JLabel SusDias;
    private JLabel SuEstado;
    private JLabel JLMensaje;

    int posicion=0;

    public FRMViAlumnos(Alumnos[] alumnos,FRMMenu frmMenu) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPVIAlumnos);
        setSize(500,500);

        JLDias.setText("<html>Periodo de<br> prestamo /<html>");

        if (alumnos[posicion]!=null){
            imprimir(alumnos[posicion]);
        }else if (posicion==0){
            JLMensaje.setText("No hay registros");
            limpiar();
        }

        JBAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (posicion>0){
                    posicion--;
                    imprimir(alumnos[posicion]);
                }else {JLMensaje.setText("Se encuentra en el primer registro");}
            }
        });
        JBSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (alumnos[posicion+1]!=null){
                    posicion++;
                    imprimir(alumnos[posicion]);
                }else {JLMensaje.setText("Se encuentra en el ultimo registro");}

            }
        });
        button3.addActionListener(e->{
            this.dispose();
            frmMenu.setVisible(true);
        });
    }

    private String estado(Alumnos alumnos){
        if (alumnos.isEntregado()==true){
            return "Entregados";
        }else {return "En prestamo";}
    }

    private void imprimir(Alumnos alumnos){
        SuNombre.setText(alumnos.getNombre());
        SuMatricula.setText(String.valueOf(alumnos.getMatricula()));
        SusDias.setText(String.valueOf(alumnos.getDias()) + "días");
        SuEstado.setText(estado(alumnos));
        JLMensaje.setText("");
    }

    private void limpiar(){
        SuNombre.setText("");
        SuMatricula.setText("");
        SusDias.setText("");
        SuEstado.setText("");
    }
}
