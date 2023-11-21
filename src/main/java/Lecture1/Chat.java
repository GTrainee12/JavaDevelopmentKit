package Lecture1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/*
Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля,
IP-адреса сервера, порта подключения к серверу, область ввода сообщений, JTextArea
область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат.
Желательно сразу сгруппировать компоненты, относящиеся к серверу сгруппировать на JPanel
сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу
 */
public class Chat extends JFrame{
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();
    private final String[] data1 = { "Иван" ,"Александр"  ,"Екатерина","Мария","Мария","Андрей","Анастасия","Дмитрий","Ольга","Николай","Елена"};

    JList<String> list1 = new JList<String>(data1);

    JButton btnSend = new JButton("Отправить.");

    JPanel contents = new JPanel();{
        for (String string : data1) {
            dlm.add(0, string);
        }
    }

    JLabel lblPassword = new JLabel("Password:");
    JLabel lblIP = new JLabel("IP:");
    JLabel lblMessage = new JLabel("Сообщение:");
    JLabel lblLogMessage = new JLabel("История сообщений:");

    JTextArea txtFieldLog = new JTextArea();
    JTextField txtFieldPassword = new JTextField();
    JTextField txtFieldIP = new JTextField();
    JTextField txtFieldMessage = new JTextField();

    JTextArea areaMessage = new JTextArea();
    JPanel panServer = new JPanel(new GridLayout(6, 2));
    JPanel panClient = new JPanel(new GridLayout(4, 1));
    String password;
    String IP;
    String message;



    Chat(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatWindow");
        setResizable(false);



        contents.add(new JScrollPane(list1));
        panServer.add(lblPassword);
        panServer.add(txtFieldPassword);
        panServer.add(lblIP);
        panServer.add(txtFieldIP);
        panServer.add(lblLogMessage);
        panServer.add(txtFieldLog);
        panClient.add(lblMessage);
        panClient.add(areaMessage);
        panClient.add(txtFieldMessage);
        panClient.add(btnSend);






        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = list1.getSelectedValue() + ": " + txtFieldMessage.getText() + "\n";
                areaMessage.append(message);
                File myLog = new File("log.txt");
                try {
                    BufferedWriter write = new BufferedWriter(new FileWriter(myLog));
                    write.write(message);
                    write.close();
                } catch (IOException ex) {throw new RuntimeException(ex);}

                System.out.println("Отправлено сообщение: " + message);
            }
        });
        try {
            FileReader reader = new FileReader( "log.txt");
            BufferedReader br = new BufferedReader(reader);
            char buffer[] = new char[4096];
            int len;
            while ((len = reader.read(buffer)) != -1){
                String s = new String (buffer, 0, len);
                txtFieldLog.append(s); }
            br.close();
        } catch (IOException e) {e.printStackTrace();}




        setContentPane(contents);
        setLayout(new GridLayout(2,1));
        add(panServer);
        add(panClient);
        setVisible(true);
    }

    public static void main(String[] args) {new Chat();}
}
