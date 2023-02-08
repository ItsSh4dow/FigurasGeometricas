package code;

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

public class Circulo extends JFrame{
    private JPanel panel;
    private JLabel x,y,h,k,r;
    private JTextField X,Y,H,K;
    private JCheckBox fueraOrigen;
    private JButton calcular, regresar; 
    private double resultado;

    public Circulo(){
        super("Circulo");
        this.setSize(650,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        inicarComponentes();
        
    }
    public void inicarComponentes(){
        agregarPanel();
        agregarLabels();
        agregarInputText();
        agregarCheckBox();
        agregarBotones();
    } 
    public void agregarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    } 
    public void agregarLabels(){
        x = new JLabel("X: ");
        x.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        x.setBounds(20,50,50,20);
        panel.add(x);

        y = new JLabel("Y: ");
        y.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        y.setBounds(300,50,50,20);
        panel.add(y);

        h = new JLabel("h: ");
        h.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        h.setBounds(150,50,50,20);
        h.setVisible(false);
        panel.add(h);

        k = new JLabel("k: ");
        k.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        k.setBounds(420,50,50,20);
        k.setVisible(false);
        panel.add(k);

        r = new JLabel("r: ");
        r.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        r.setBounds(150,200,300,20);
        r.setVisible(false);
        panel.add(r);

    }
    public void agregarInputText(){
        X = new JTextField();
        X.setBounds(50, 50,70,25);
        panel.add(X); 

        Y = new JTextField();
        Y.setBounds(330,50,70,25);
        panel.add(Y);

        H = new JTextField();
        H.setBounds(170,50,70,25);
        H.setVisible(false);
        panel.add(H);
        

        K = new JTextField();
        K.setBounds(450,50,70,25);
        K.setVisible(false);
        panel.add(K);
    }
    
    public void agregarCheckBox(){
        fueraOrigen = new JCheckBox("¿Esta fuera del origen?");
        fueraOrigen.setBounds(440, 380, 200,30);
        panel.add(fueraOrigen);
    }
    public void agregarBotones(){
        calcular = new JButton("Calcular");
        calcular.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        calcular.setBounds(70,380,100,30);
        panel.add(calcular);

        regresar = new JButton("Regresar");
        regresar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        regresar.setBounds(270,380,100,30);
        panel.add(regresar);

        accionesBotones();
    }
    private void accionesBotones(){ 
        ActionListener evento1 = new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){    
                try{
                    if(X.getText().length() !=  0 && Y.getText().length() != 0 && !fueraOrigen.isSelected()){
                        if(e.getSource() == calcular){
                            resultado = redondear(Math.sqrt(Math.pow(Double.parseDouble(X.getText()),2) + Math.pow(Double.parseDouble(Y.getText()),2)));
                            r.setText(("Centro (0,0)         r: "+resultado));
                            r.setVisible(true);
                        }    
                    } 
                    else if((X.getText().length() !=  0 && Y.getText().length() != 0) && (H.getText().length() !=  0 && K.getText().length() != 0)){
                        if(e.getSource() == calcular){
                           
                            resultado = redondear(Math.sqrt(Math.pow(Double.parseDouble(X.getText()) - Double.parseDouble(H.getText()),2) 
                            + Math.pow(Double.parseDouble(Y.getText()) - Double.parseDouble(K.getText()),2)));
                            r.setText(("Centro ("+H.getText()+","+K.getText()+")         r: "+resultado));
                            r.setVisible(true);
                        }
                    }
                    else
                        r.setVisible(false);
                    
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Deben ser numeros", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }      
        };
        calcular.addActionListener(evento1);

        ActionListener evento2 = new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){    
                if(fueraOrigen.isSelected()){
                    H.setVisible(true);
                    K.setVisible(true);
                    h.setVisible(true);
                    k.setVisible(true);
                }
                else{
                    H.setVisible(false);
                    K.setVisible(false);
                    h.setVisible(false);
                    k.setVisible(false);
                }     
            }
        };
        fueraOrigen.addActionListener(evento2);
        ActionListener evento3 = new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){    
                if(e.getSource() == regresar){
                    Menu menu = new Menu();
                    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    menu.setSize(650,500);
                    menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    menu.setLocationRelativeTo(null);
                    menu.setVisible(true);
                    setVisible(false);
                }
            }
        };
        regresar.addActionListener(evento3);
    }
    private double redondear(double number){
        return Math.round(number * 10000.0)/10000.0;
    }
}
