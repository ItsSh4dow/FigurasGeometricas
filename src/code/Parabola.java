package code;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Parabola extends JFrame{
    private JPanel panel;
    private JLabel r, inicio, fin;
    private JTextField campoInicio, campoFin;
    private JButton calcular, regresar; 
    private JTable resultados; 
    private DefaultTableModel modelo;

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
        inicio = new JLabel("Inicio: ");
        inicio.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        inicio.setBounds(20,50,80,20);
        panel.add(inicio);

        fin = new JLabel("Final: ");
        fin.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        fin.setBounds(300,50,80,20);
        panel.add(fin);

        r = new JLabel("r: ");
        r.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        r.setBounds(150,200,300,20);
        r.setVisible(false);
        panel.add(r);

    }
    public void agregarInputText(){
        campoInicio = new JTextField();
        campoInicio.setBounds(90, 50,70,25);
        panel.add(campoInicio); 

        campoFin = new JTextField();
        campoFin.setBounds(360,50,70,25);
        panel.add(campoFin);
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
                    if(campoInicio.getText().length() != 0 && campoFin.getText().length() != 0){
                        if(e.getSource() == calcular){
                            aux1 = (Integer.parseInt(campoInicio.getText()) < Integer.parseInt(campoFin.getText())) ? Integer.parseInt(campoInicio.getText()) : Integer.parseInt(campoFin.getText());
                            aux2 = (Integer.parseInt(campoFin.getText()) > Integer.parseInt(campoInicio.getText())) ? Integer.parseInt(campoFin.getText()) : Integer.parseInt(campoInicio.getText());
                            agregarTabla(aux1, aux2);
                        }    
                    }   
                    
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
    private void agregarTabla(int begin, int end){
        modelo = new DefaultTableModel();
        resultados =  new JTable(modelo);
        modelo.addColumn("X");
        modelo.addColumn("Y");
        for(double i = begin; i <= end; i++){
            Double res [] = {i,Math.pow(i, 2)};
            modelo.addRow(res);
        }
        panel.add(resultados);
        JScrollPane scroll = new JScrollPane(resultados, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(150,120,250,150);
        panel.add(scroll);
        
    } 
}
