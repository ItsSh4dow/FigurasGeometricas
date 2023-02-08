package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LineaRecta extends JFrame {

    private JPanel panel;
    private JLabel P, X, Y, X1, Y1, texto, Res, texto2;
    private JTextField p, x, y, x1, y1;
    private JButton calcular, regresar;
    private JCheckBox sinP;
    private double resultado, A, B;

    public LineaRecta() {
        super("Ecuacion de la Linea Recta");
        setSize(650, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        inicarComponentes();
    }

    public void inicarComponentes() {
        agregarPanel();
        agregarLabels();
        agregarInputText();
        agregarCheckBox();
        agregarBotones();

    }

    public void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.add(panel);
    }

    public void agregarLabels() {
        texto = new JLabel("Agrega coordenas de algun punto:");
        texto.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        texto.setBounds(20, 10, 400, 30);
        panel.add(texto);

        X = new JLabel("X:    ");
        X.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        X.setBounds(10, 50, 50, 20);
        panel.add(X);

        Y = new JLabel("Y: ");
        Y.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Y.setBounds(150, 50, 50, 20);
        panel.add(Y);

        P = new JLabel("Pendiente: ");
        P.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        P.setBounds(300, 50, 150, 20);
        panel.add(P);

        texto2 = new JLabel("Agrega coordenas del segundo punto:");
        texto2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        texto2.setBounds(20, 70, 400, 30);
        texto2.setVisible(false);
        panel.add(texto2);

        X1 = new JLabel("X: ");
        X1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        X1.setBounds(10, 100, 50, 20);
        X1.setVisible(false);
        panel.add(X1);

        Y1 = new JLabel("Y: ");
        Y1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Y1.setBounds(150, 100, 50, 20);
        Y1.setVisible(false);
        panel.add(Y1);

        Res = new JLabel("Pendiente Calculado: ");
        Res.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        Res.setBounds(150, 150, 300, 20);
        Res.setVisible(false);
        panel.add(Res);

    }// Fin de las Lables

    public void agregarInputText() {
        x = new JTextField();
        x.setBounds(40, 50, 70, 25);
        panel.add(x);

        y = new JTextField();
        y.setBounds(180, 50, 70, 25);
        panel.add(y);

        x1 = new JTextField();
        x1.setBounds(40, 100, 70, 25);
        x1.setVisible(false);
        panel.add(x1);

        y1 = new JTextField();
        y1.setBounds(180, 100, 70, 25);
        y1.setVisible(false);
        panel.add(y1);

        p = new JTextField();
        p.setBounds(420, 50, 70, 25);
        panel.add(p);

    }// Fin de los cuadros de Texto

    public void agregarCheckBox() {
        sinP = new JCheckBox("¿Calcular Sin Pendiente?");
        sinP.setBounds(250, 335, 200, 30);
        sinP.setBackground(Color.white);
        panel.add(sinP);

    }

    public void agregarBotones() {
        calcular = new JButton("Calcular");
        calcular.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        calcular.setBounds(200, 380, 100, 30);

        panel.add(calcular);

        regresar = new JButton("Regresar");
        regresar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        regresar.setBounds(350, 380, 100, 30);

        panel.add(regresar);

        accionesBotones();

    }// Fin de los Botones

    private void accionesBotones() {
        ActionListener evento1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (x.getText().length() != 0 && y.getText().length() != 0 && !sinP.isSelected()) {
                        if (e.getSource() == calcular) {
                            if (Double.parseDouble(x.getText()) > 0) {
                                for (A = -(Double.parseDouble(x.getText())); A <= Double.parseDouble(x.getText()); A++) {
                                    B = (Double.parseDouble(p.getText()) * A) - (Double.parseDouble(p.getText()) * Double.parseDouble(x.getText())) + Double.parseDouble(y.getText());
                                    JOptionPane.showInternalMessageDialog(null, A + "  " + B);
                                }
                            } else {
                                for (A = (Double.parseDouble(x.getText())); A <= -(Double.parseDouble(x.getText())); A++) {
                                    B = (Double.parseDouble(p.getText()) * A) - (Double.parseDouble(P.getText()) * Double.parseDouble(x.getText())) + Double.parseDouble(y.getText());

                                    JOptionPane.showInternalMessageDialog(null, A + "  " + B);
                                }
                            }

                        }
                    } else if ((x.getText().length() != 0 && y.getText().length() != 0) && (x1.getText().length() != 0 && y1.getText().length() != 0)) {
                        if (e.getSource() == calcular) {

                            resultado = (Double.parseDouble(y1.getText()) - Double.parseDouble(y.getText())) / (Double.parseDouble(x1.getText()) - Double.parseDouble(x.getText()));

                            Res.setText(("La pendiente es   r: " + resultado));
                            Res.setVisible(true);

                            if (Double.parseDouble(x.getText()) > 0) {
                                for (A = -(Double.parseDouble(x.getText())); A <= Double.parseDouble(x.getText()); A++) {
                                    B = (resultado * A) - (resultado * Double.parseDouble(x.getText())) + Double.parseDouble(y.getText());
                                    JOptionPane.showInternalMessageDialog(null, A + "  " + B);
                                }
                            } else {
                                for (A = (Double.parseDouble(x.getText())); A <= -(Double.parseDouble(x.getText())); A++) {
                                    B = (resultado * A) - (resultado * Double.parseDouble(x.getText())) + Double.parseDouble(y.getText());
                                    JOptionPane.showInternalMessageDialog(null, A + "  " + B);
                                }
                            }

                        }
                    } else {
                        Res.setVisible(false);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Deben ser numeros", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
//        regresar.addActionListener(evento1);
        calcular.addActionListener(evento1);

        ActionListener evento2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (sinP.isSelected()) {
                    X1.setVisible(true);
                    Y1.setVisible(true);
                    x1.setVisible(true);
                    y1.setVisible(true);
                    texto2.setVisible(true);
                    P.setVisible(false);
                    p.setVisible(false);
                } else {
                    X1.setVisible(false);
                    Y1.setVisible(false);
                    x1.setVisible(false);
                    y1.setVisible(false);
                    texto2.setVisible(false);
                    P.setVisible(true);
                    p.setVisible(true);
                }
            }
        };
        sinP.addActionListener(evento2);
    }

}//fin de la clase

