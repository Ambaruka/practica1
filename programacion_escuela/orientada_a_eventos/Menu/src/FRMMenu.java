import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRMMenu extends JFrame{
    private JLabel JLTitulo;
    private JPanel JPMenu;
    private JLabel JLAccion;
    private JMenuItem JMIRegistrarA;
    private JMenu JMAlumnos;
    private JMenuItem JMIVisualizarA;
    private JMenu JMLibros;
    private JMenuItem JMIRegistrarL;
    private JMenuItem JMIVisualizarL;
    private JMenu JMPrestamos;
    private JMenuItem JMIRegistrarP;
    private JMenuItem JMIVisualizarP;

    public Alumnos[] alumnos=new Alumnos[10];
    public Libro[] libros=new Libro[15];
    public Prestamo[] prestamos=new Prestamo[10];



    public FRMMenu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPMenu);
        setSize(500,500);

        libros[0]=new Libro("Realismo mágico","Cien años de soledad",1967,false);
        libros[1]=new Libro("Distopía","1984",1949,true);
        libros[2]=new Libro("Novela romantica","Orgullo y prejuicio",1813,true);
        libros[3]=new Libro("Drama","Matar un ruiseñor",1960,false);
        libros[4]=new Libro("Fantasía épica","El señor de los anillos",1954,true);

        JMIRegistrarA.addActionListener(e->{
                seVa();
                FRMAlumnos frmAlumnos=new FRMAlumnos(alumnos,this);
                frmAlumnos.setVisible(true);

        });
        JMIVisualizarA.addActionListener(e->{
                seVa();
                FRMViAlumnos frmViAlumnos=new FRMViAlumnos(alumnos,this);
                frmViAlumnos.setVisible(true);

        });
        JMIRegistrarL.addActionListener(e->{
                seVa();
                FRMLibros frmLibros=new FRMLibros(libros,this);
                frmLibros.setVisible(true);

        });
        JMIVisualizarL.addActionListener(e->{
                seVa();
                FRMViLibros frmViLibros=new FRMViLibros(libros,this);
                frmViLibros.setVisible(true);

        });
        JMIRegistrarP.addActionListener(e->{
                seVa();
                FRMPrestamo frmPrestamo=new FRMPrestamo(prestamos,alumnos,libros,this);
                frmPrestamo.setVisible(true);

        });
        JMIVisualizarP.addActionListener(e->{
                seVa();
                FRMViPrestamos frmViPrestamos=new FRMViPrestamos(prestamos,this);
                frmViPrestamos.setVisible(true);

        });
    }
    private void seVa(){
        this.setVisible(false);
    }
}
