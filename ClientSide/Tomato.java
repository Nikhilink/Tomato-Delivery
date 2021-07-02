import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Tomato extends JFrame
{
    private static final long serialVersionUID = 1L;
    JLabel heading;
     JLabel title;
     JTextField pcno;
     JComboBox Foodname;
     JTextField quantity;
     JButton Order;
     JLabel pcn;
     JLabel foodname;
     JLabel money;
     Socket s;

     private static DataOutputStream dos;

    Tomato()
    {
       setLayout(null);
       setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tomato");
       heading = new JLabel("Tomato");
        heading.setBounds(200,30,120,50);
        heading.setFont(new java.awt.Font("Tohama",1,27));
        heading.setForeground(Color.RED);
        title = new JLabel("Order Food Online on Tomato!");
        title.setBounds(250,65,300,20);
        title.setFont(new java.awt.Font("Tohama",1,11));
        pcno = new JTextField();
        pcno.setBounds(260,100,140,30);
        pcn = new JLabel("Enter table no");
        pcn.setBounds(180,100,150,30);
        foodname = new JLabel("Food Name");
        foodname.setBounds(180,135,140,30);
        Foodname = new JComboBox();
        Foodname.addItem("Coffee");
        Foodname.addItem("Tea-Biscuits");
        Foodname.addItem("Tea");
        Foodname.addItem("Green-tea");
        Foodname.addItem("Biscuits");
        Foodname.addItem("Tea-Toast");
        Foodname.addItem("Tea-Khari");
        Foodname.addItem("Sandwich");
        Foodname.addItem("Poha");
        Foodname.addItem("Idli-Wada");
        Foodname.addItem("Pizza");
        Foodname.addItem("Wada-Paav");
        Foodname.addItem("Samosa");
        Foodname.setBounds(260,135,140,30);
        Foodname.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = Foodname.getSelectedItem().toString();
                switch(item)
                {
                    case "Coffee":
                        money.setText("Rs:- 10");
                        
                    break;
                    case "Tea-Biscuits":
                        money.setText("Rs:- 15");
                    break;
                    case "Tea":
                        money.setText("Rs:- 10");
                    break;
                    case "Green-tea":
                        money.setText("Rs:- 5");
                    break;
                    case "Biscuits":
                        money.setText("Rs:- 2");
                    break;
                    case "Tea-Toast":
                        money.setText("Rs:- 17");
                    break;
                    case "Tea-Khari":
                        money.setText("Rs:- 19");
                    break;
                    case "Sandwich":
                        money.setText("Rs:- 15");
                    case "Poha":
                        money.setText("Rs:- 10");
                    break;
                    case "Idli_Wada":
                        money.setText("Rs:- 15");
                    break;
                    case "Pizza":
                        money.setText("Rs:- 20");
                    break;
                    case "Wada-Paav":
                        money.setText("Rs:- 10");
                    break;
                    case "Samosa":
                        money.setText("Rs:- 10");
                    break;
                    default:
                        money.setText("Not Available");
                    break;

                }
            }
        });
        money = new JLabel("Rs:-");
        money.setBounds(400,135,140,30);
        Order = new JButton("Order");
        Order.setBounds(260,170,140,25);
        Order.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!"".equals(pcno.getText()))
                {
                    orderOnlineOnTomato();
                    JOptionPane.showMessageDialog(null, "Thank you for Ordering on Tomato");
                }
                else
                {
                JOptionPane.showMessageDialog(null,"Please Enter Details");
                }
            }
        });
        add(Order);
        add(money);
        add(Foodname);
        add(foodname);
        add(pcn);
        add(pcno);
       add(heading);
       add(title);
    }
    public void orderOnlineOnTomato()
    {
        try {
            s = new Socket("localhost",5678);
            dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(pcno.getText());
            dos.writeUTF(Foodname.getSelectedItem().toString());
            dos.writeUTF(money.getText());
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"sorry could not connect");
        }
    }
    public static void main(String[] args) {
        new Tomato().setVisible(true);

    }
}