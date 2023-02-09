package code;


import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Elipse extends JFrame {

    private JPanel panel;
    private JLabel X, Y, L1, L2, Res;
    private JTextField V1, V2, h, k;
    private JButton calcular, regresar;
    private JCheckBox sinOrigen;
    private double a, b, c, lr;

    public Elipse() {
        super("Ecuacion de la Elipse");
        setSize(650, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
    }

    public void iniciarComponentes() {
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
        X = new JLabel("    X");
        X.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        X.setBounds(10, 50, 50, 20);
        panel.add(X);

        L1 = new JLabel("-----");
        L1.setFont(new Font("Arial", Font.BOLD, 30));
        L1.setBounds(10, 65, 70, 20);
        panel.add(L1);

        Y = new JLabel("    Y");
        Y.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        Y.setBounds(150, 50, 50, 20);
        panel.add(Y);

        L2 = new JLabel("-----");
        L2.setFont(new Font("Century Gothic", Font.BOLD, 30));
        L2.setBounds(150, 65, 70, 20);
        panel.add(L2);

        Res = new JLabel("Resultado: ");
        Res.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        Res.setBounds(10, 150, 550, 20);
        Res.setVisible(false);
        panel.add(Res);

    }

    public void agregarInputText() {
        V1 = new JTextField();
        V1.setBounds(15, 90, 50, 20);
        panel.add(V1);

        V2 = new JTextField();
        V2.setBounds(160, 90, 50, 20);
        panel.add(V2);

        h = new JTextField();
        h.setBounds(80, 50, 50, 20);
        h.setVisible(false);
        panel.add(h);

        k = new JTextField();
        k.setBounds(220, 50, 50, 20);
        k.setVisible(false);
        panel.add(k);

    }

    public void agregarCheckBox() {
        sinOrigen = new JCheckBox("¿Calcular Fuera del Origen?");
        sinOrigen.setBounds(250, 335, 200, 30);
        sinOrigen.setBackground(Color.white);
        panel.add(sinOrigen);

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

    }

    private void accionesBotones() {
        ActionListener evento1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (V1.getText().length() != 0 && V2.getText().length() != 0 && !sinOrigen.isSelected()) {
                        if (e.getSource() == calcular) {
                            if (Double.parseDouble(V1.getText()) > Double.parseDouble(V2.getText())) {
                                a = Double.parseDouble(V1.getText());
                                b = Double.parseDouble(V2.getText());

                                c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
                                lr = (2 * Math.pow(b, 2)) / a;

                                Res.setText(("Centro (0,0)    F(Focos)= ±" + c + "     Lr (Lado recto) = ±" + lr));
                                Res.setVisible(true);

                            } else {
                                a = Double.parseDouble(V2.getText());
                                b = Double.parseDouble(V1.getText());

                                c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
                                lr = (2 * Math.pow(b, 2)) / a;

                                Res.setText(("Centro (0,0)    F(Focos)= ±" + c + "     Lr (Lado recto) = ±" + lr));
                                Res.setVisible(true);
                            }

                        }
                    } else if ((V1.getText().length() != 0 && V2.getText().length() != 0) && (h.getText().length() != 0 && k.getText().length() != 0)) {
                        if (e.getSource() == calcular) {

                            if (Double.parseDouble(V1.getText()) > Double.parseDouble(V2.getText())) {
                                a = Double.parseDouble(V1.getText());
                                b = Double.parseDouble(V2.getText());

                                c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
                                lr = (2 * Math.pow(b, 2)) / a;

                                Res.setText(("Centro (" + Double.parseDouble(h.getText()) + "," + Double.parseDouble(k.getText()) + ")    F(Focos)= ±" + c + "     Lr (Lado recto) = ±" + lr));
                                Res.setVisible(true);

                            } else {
                                a = Double.parseDouble(V2.getText());
                                b = Double.parseDouble(V1.getText());

                                c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
                                lr = (2 * Math.pow(b, 2)) / a;

                                Res.setText(("Centro (" + Double.parseDouble(h.getText()) + "," + Double.parseDouble(k.getText()) + ")    F(Focos)= ±" + c + "     Lr (Lado recto) = ±" + lr));
                                Res.setVisible(true);
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
        regresar.addActionListener(evento1);
        calcular.addActionListener(evento1);

        ActionListener evento2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (sinOrigen.isSelected()) {
                    h.setVisible(true);
                    k.setVisible(true);
                    X.setText(" X^2 -");
                    X.setBounds(10, 50, 70, 20);
                    Y.setText(" Y^2 -");
                    Y.setBounds(150, 50, 70, 20);
                    L1.setText("-------");
                    L1.setBounds(10, 65, 150, 20);
                    L2.setText("-------");
                    L2.setBounds(150, 65, 150, 20);
                    V1.setBounds(20, 90, 50, 20);
                    V2.setBounds(180, 90, 50, 20);
                } else {
                    h.setVisible(false);
                    k.setVisible(false);
                    X.setText(" X");
                    X.setBounds(10, 50, 50, 20);
                    Y.setText(" Y");
                    Y.setBounds(150, 50, 70, 20);
                    L1.setText("----");
                    L1.setBounds(10, 65, 70, 20);
                    L2.setText("----");
                    L2.setBounds(150, 65, 70, 20);
                    V1.setBounds(15, 90, 50, 20);
                    V2.setBounds(160, 90, 50, 20);
                }
            }
        };
        sinOrigen.addActionListener(evento2);

    }

}
