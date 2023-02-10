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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Elipse extends JFrame{
    private JPanel panel;
    private JLabel h,k,a,b,datos,inicio, fin;
    private JTextField H,K,A,B, campoInicio, campoFin;
    private JCheckBox fueraOrigen;
    private JButton calcular, regresar; 
    private JTable resultados; 
    private DefaultTableModel modelo;

    public Elipse(){
        super("Elipse");
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
        inicio = new JLabel("Inicio: ");
        inicio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        inicio.setBounds(20,50,80,20);
        panel.add(inicio);

        a = new JLabel("a^2: ");
        a.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        a.setBounds(20,130,50,20);
        panel.add(a);


        fin = new JLabel("Final: ");
        fin.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        fin.setBounds(300,50,80,20);
        panel.add(fin);

        b = new JLabel("b^2: ");
        b.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        b.setBounds(300,130,50,20);
        panel.add(b);

        h = new JLabel("h: ");
        h.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        h.setBounds(180,50,50,20);
        h.setVisible(false);
        panel.add(h);

        k = new JLabel("k: ");
        k.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        k.setBounds(450,50,50,20);
        k.setVisible(false);
        panel.add(k);

        datos = new JLabel("c: ");
        datos.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        datos.setBounds(50,200,450,20);
        datos.setVisible(false);
        panel.add(datos);

    } 
    public void agregarInputText(){
        campoInicio = new JTextField();
        campoInicio.setBounds(90, 50,70,25);
        panel.add(campoInicio); 

        
        A = new JTextField();
        A.setBounds(70, 130,70,25);
        panel.add(A); 

        campoFin = new JTextField();
        campoFin.setBounds(360,50,70,25);
        panel.add(campoFin);

        B = new JTextField();
        B.setBounds(350,130,70,25);
        panel.add(B);

        H = new JTextField();
        H.setBounds(200,50,70,25);
        H.setVisible(false);
        panel.add(H);
        

        K = new JTextField();
        K.setBounds(480,50,70,25);
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
            int aux1, aux2;
            @Override
            public void actionPerformed(ActionEvent e){   
                try{
                    if(A.getText().length() !=  0 && B.getText().length() != 0 &&  campoInicio.getText().length() != 0  && campoFin.getText().length() != 0 && !fueraOrigen.isSelected()){
                        if(e.getSource() == calcular && Double.parseDouble(A.getText()) >= 0 && Double.parseDouble(B.getText()) >= 0){
                            aux1 = (Integer.parseInt(campoInicio.getText()) < Integer.parseInt(campoFin.getText())) ? Integer.parseInt(campoInicio.getText()) : Integer.parseInt(campoFin.getText());
                            aux2 = (Integer.parseInt(campoFin.getText()) > Integer.parseInt(campoInicio.getText())) ? Integer.parseInt(campoFin.getText()) : Integer.parseInt(campoInicio.getText());
                            agregarTabla(1, aux1, aux2);
                        }    
                    } 
                    else if((campoInicio.getText().length() !=  0 && campoFin.getText().length() != 0) && (H.getText().length() !=  0 && K.getText().length() != 0)){
                        if(e.getSource() == calcular){
                            aux1 = (Integer.parseInt(campoInicio.getText()) < Integer.parseInt(campoFin.getText())) ? Integer.parseInt(campoInicio.getText()) : Integer.parseInt(campoFin.getText());
                            aux2 = (Integer.parseInt(campoFin.getText()) > Integer.parseInt(campoInicio.getText())) ? Integer.parseInt(campoFin.getText()) : Integer.parseInt(campoInicio.getText());
                            agregarTabla(2, aux1, aux2);
                        }
                    }
                    
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
    private void agregarTabla(int number, int begin, int end){
        modelo = new DefaultTableModel();
        resultados =  new JTable(modelo);
        if(number == 1){
            modelo.addColumn("X");
            modelo.addColumn("Y");
            modelo.addColumn("Foco");
            for(double i = begin; i <= end; i++){
                Double res [] = {i,i, redondear((2*Double.parseDouble(A.getText())) / (Math.sqrt(Double.parseDouble(B.getText())))) };
                modelo.addRow(res);
            }
            panel.add(resultados);
            JScrollPane scroll = new JScrollPane(resultados, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setBounds(150,170,250,150);
            panel.add(scroll);
        }
        else if (number == 2){
            modelo.addColumn("X");
            modelo.addColumn("Y");
            modelo.addColumn("Foco");
            for(double i = begin; i <= end; i++){
                Double res [] = {Math.pow(i - Double.parseDouble(H.getText()),2), Math.pow(i - Double.parseDouble(K.getText()),2), 
                    redondear((2*Double.parseDouble(A.getText())) / (Math.sqrt(Double.parseDouble(B.getText()))))};
                modelo.addRow(res);
            }
            panel.add(resultados);
            JScrollPane scroll = new JScrollPane(resultados, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setBounds(150,170,250,150);
            panel.add(scroll);
        }
    }
}