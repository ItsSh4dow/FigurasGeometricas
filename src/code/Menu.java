package code;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{
    private final String arrayImages[] = {"/images/circulo.png", "/images/elipse.png", "/images/hiperbola.png",
                                          "/images/linea.png", "/images/parabola.png"};
    private JPanel panel;
    private JLabel saludo, cir, elip, hiper, lin, para;
    private JButton circulo, elipse, hiperbola, linea, parabola;
    
    // private ImageIcon imagenCirculo, imagenElipse, imagenHiperbola, imagenLinea, imagenParabola;
    private Circulo ventanaCirculo = new Circulo();
    private Hiperbola ventanHiperbola = new Hiperbola();
    private Parabola ventanaParabola = new Parabola();
    LineaRecta ventanaLineaRecta = new LineaRecta();
    public  Menu(){
        super("Graficacion ");
        this.setSize(650,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        inicarComponentes();
   }

    public void inicarComponentes(){
        agregarPanel();
        agregarLabel();
        agragarBotones();
    } 
    public void agregarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    } 
    public void agregarLabel(){
        saludo = new JLabel("Buenas amigazo, escoja una figura :)");
        saludo.setFont(new Font("Century Gothic", Font.BOLD, 20));
        saludo.setBounds(150, 20, 400,30);
        panel.add(saludo);

        cir = new JLabel("Circulo");
        cir.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        cir.setBounds(75, 200, 150,30);
        panel.add(cir);

        elip = new JLabel("Elipse");
        elip.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        elip.setBounds(285, 200, 150,30);
        panel.add(elip);

        hiper = new JLabel("Hiperbola");
        hiper.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        hiper.setBounds(460, 200, 150,30);
        panel.add(hiper);

        lin = new JLabel("Linea Recta");
        lin.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lin.setBounds(160, 350, 150,30);
        panel.add(lin);

        para = new JLabel("Parabola");
        para.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        para.setBounds(385, 350, 150,30);
        panel.add(para);
    }

    public void agragarBotones(){
        // asociamos un icono para posteriormente agregarlo al boton
        final ImageIcon imagenCirculo = new ImageIcon(getClass().getResource(arrayImages[0]));
        circulo = new JButton();
        circulo.setBounds(50,100,120,90);
        circulo.setIcon(new ImageIcon(imagenCirculo.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel.add(circulo);

        final ImageIcon imagenElipse = new ImageIcon(getClass().getResource(arrayImages[1]));
        elipse = new JButton();
        elipse.setBounds(250,100,120,90);
        elipse.setIcon(new ImageIcon(imagenElipse.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel.add(elipse);

        final ImageIcon imagenHiperbola = new ImageIcon(getClass().getResource(arrayImages[2]));
        hiperbola = new JButton();
        hiperbola.setBounds(450,100,120,90);
        hiperbola.setIcon(new ImageIcon(imagenHiperbola.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel.add(hiperbola);

        final ImageIcon imagenLinea = new ImageIcon(getClass().getResource(arrayImages[3]));
        linea = new JButton();
        linea.setBounds(160,250,120,90);
        linea.setIcon(new ImageIcon(imagenLinea.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel.add(linea);

        final ImageIcon imagenParabola = new ImageIcon(getClass().getResource(arrayImages[4]));
        parabola = new JButton();
        parabola.setBounds(370,250,120,90);
        parabola.setIcon(new ImageIcon(imagenParabola.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel.add(parabola);

        detectarFigura();
    
    }
    private void detectarFigura(){ 
        ActionListener evento1 = new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){    
                if(e.getSource() == circulo)
                    abrirVentana(ventanaCirculo);
                //else if( e.getSource() == elipse)
                    
                else if(e.getSource() == hiperbola)
                    abrirVentana(ventanHiperbola);    
                else if(e.getSource() == linea)
                    abrirVentana(ventanaLineaRecta);    
               else if(e.getSource() == parabola)
                    abrirVentana(ventanaParabola);     
            }
        };

        
        circulo.addActionListener(evento1);
        elipse.addActionListener(evento1);
        hiperbola.addActionListener(evento1);
        linea.addActionListener(evento1);
        parabola.addActionListener(evento1);
    }
    private void abrirVentana(JFrame ventana){
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(650,500);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        this.setVisible(false);
    }
    
}
