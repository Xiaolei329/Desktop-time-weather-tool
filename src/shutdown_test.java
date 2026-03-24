import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon May 06 17:25:47 CST 2024
 */



/**
 * @author ASUS
 */
public class shutdown_test extends JDialog implements ActionListener
{
    private Timer timer;
    private int count = 20;
    public shutdown_test()
    {
        initComponents();
        timer = new Timer(1000,this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e)
    {
        label1.setText("距离关机仅剩"+count--+"秒");
    }

    private void button1MouseClicked(MouseEvent e) {
        try {
            Runtime.getRuntime().exec("shutdown -a");
            this.dispose();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 0));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout());

            //---- label1 ----
            label1.setText("\u8ddd\u79bb\u5173\u673a\u4ec5\u5269X\u79d2");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 20));
            panel1.add(label1);
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout());

            //---- button1 ----
            button1.setText("\u53d6\u6d88\u5173\u673a");
            button1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel2.add(button1);
        }
        contentPane.add(panel2);
        setSize(350, 265);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
