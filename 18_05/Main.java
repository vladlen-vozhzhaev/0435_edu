/* javax.swing */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        setTitle("Chat");
        setBounds(400,300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel bootomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        JButton ok = new JButton("OK");
        JButton cancel = new JButton("cancel");
        JTextArea jta = new JTextArea();


        bootomPanel.add(ok);
        bootomPanel.add(cancel);
        centerPanel.add(jta);
        add(centerPanel, BorderLayout.CENTER);
        add(bootomPanel, BorderLayout.SOUTH);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append("ok");
            }
        });

        setVisible(true);
    }
}
