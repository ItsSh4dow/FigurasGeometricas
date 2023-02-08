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

public class Hiperbola extends JFrame{
    private JPanel panel;
    private JLabel x,y,h,k,a,b, datos;
    private JTextField X,Y,H,K,A,B;
    private JCheckBox fueraOrigen;
    private JButton calcular, regresar; 
    private double c, lr;
    

    public Hiperbola(){
        super("Hiperbola");
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

        a = new JLabel("a^2: ");
        a.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        a.setBounds(20,130,50,20);
        panel.add(a);


        y = new JLabel("Y: ");
        y.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        y.setBounds(300,50,50,20);
        panel.add(y);

        b = new JLabel("b^2: ");
        b.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        b.setBounds(300,130,50,20);
        panel.add(b);

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

        datos = new JLabel("c: ");
        datos.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        datos.setBounds(50,200,450,20);
        datos.setVisible(false);
        panel.add(datos);

    } 
    public void agregarInputText(){
        X = new JTextField("X^2");
        X.setBounds(50, 50,70,25);
        X.setEditable(false);
        panel.add(X); 

        A = new JTextField();
        A.setBounds(70, 130,70,25);
        panel.add(A); 

        Y = new JTextField("Y^2");
        Y.setEditable(false);
        Y.setBounds(330,50,70,25);
        panel.add(Y);

        B = new JTextField();
        B.setBounds(350,130,70,25);
        panel.add(B);

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
                    if(A.getText().length() !=  0 && B.getText().length() != 0 && !fueraOrigen.isSelected()){
                        if(e.getSource() == calcular && Double.parseDouble(A.getText()) >= 0 && Double.parseDouble(B.getText()) >= 0){
                            c = redondear(Math.sqrt(Double.parseDouble(A.getText()) + Double.parseDouble(B.getText())));           
                            lr = redondear(2*Double.parseDouble(B.getText()) / (Math.sqrt(Double.parseDouble(A.getText()))));

                            datos.setText(("Centro (0,0)       a: "+redondear(Math.sqrt(Double.parseDouble(A.getText()))) 
                            + "         b: "+redondear(Math.sqrt(Double.parseDouble(B.getText())))+ "       c: "+ c+"      lr: "+lr));
                            datos.setVisible(true);
                        }    
                    } 
                    else if((A.getText().length() !=  0 && B.getText().length() != 0) && (H.getText().length() !=  0 && K.getText().length() != 0)){
                        if(e.getSource() == calcular){
                            c = redondear(Math.round(Math.sqrt(Double.parseDouble(A.getText()) + Double.parseDouble(B.getText()))));
                            lr = redondear(Math.round(2*Double.parseDouble(B.getText())) / (Math.sqrt(Double.parseDouble(A.getText()))));

                            datos.setText(("Centro ("+H.getText()+","+K.getText()+")       a: "+redondear(Math.sqrt(Double.parseDouble(A.getText()))) 
                            + "         b: "+redondear(Math.sqrt(Double.parseDouble(B.getText()))) + "       c: "+ c+"      lr: "+lr));
                            datos.setVisible(true);
                        }
                    }
                    else
                        datos.setVisible(false);
                    
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Deben ser numeros", "Error", JOptionPane.ERROR_MESSAGE);
                    datos.setVisible(false);
                }
                
            }      
            
        };
        calcular.addActionListener(evento1);

        ActionListener evento2 = new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){    
                if(fueraOrigen.isSelected()){
                    X.setText("X^2 - ");
                    Y.setText("Y^2 - ");

                    H.setVisible(true);
                    K.setVisible(true);
                    h.setVisible(true);
                    k.setVisible(true);
                }
                else{
                    X.setText("X^2 ");
                    Y.setText("Y^2 ");
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
