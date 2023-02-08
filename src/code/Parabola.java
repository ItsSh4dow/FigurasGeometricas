package code;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Parabola extends JFrame{
    private JPanel panel;
    private JLabel x,y,r;
    private JTextField X,Y;
    private JButton calcular, regresar; 
    private double resultado;

    public Parabola(){
        super("Parabola");
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
        Y.setEditable(false);
        panel.add(Y);
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
                    if(X.getText().length() !=  0){
                        if(e.getSource() == calcular){
                            resultado = Math.pow(Double.parseDouble(X.getText()),2);
                            Y.setText(String.valueOf(resultado));
                        }    
                    } 
                    else
                        Y.setText("");;
                    
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Deben ser numeros", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }      
        };
        calcular.addActionListener(evento1);
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
}
