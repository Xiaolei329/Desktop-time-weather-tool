import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Mon Apr 08 16:53:33 CST 2024
 */

/**
 * @author ASUS
 */
public class configtest extends JDialog
{
    public configtest()
    {
        initComponents();
        //将文件读取入设置界面
        File writeName = new File("src/config.txt");
        String txtContent = fileUtil.txt2String(writeName);
        String[] parts = txtContent.split(";");
        this.textField3.setText(parts[0]);
        this.textField4.setText(parts[1]);
        this.textField2.setText(parts[2]);
        this.textField1.setText(parts[3]);
    }

    //将设置写入文件
    private void button1MouseClicked(MouseEvent e)
    {
        File writeName = new File("src/config.txt");
        String txtContent = fileUtil.txt2String(writeName);
        String[] parts = txtContent.split(";");
        String var = this.textField3.getText().trim();
        String config = var + ";" + this.textField4.getText().trim() + ";" + this.textField2.getText().trim() + ";" + this.textField1.getText().trim() + ";"
                +parts[4] + ';' + parts[5] + ';' + parts[6] + ';' + parts[7] + ';';         //对之前的字符串原封不动重新拼接
        fileUtil.writeFile("src/config.txt", config);
        this.dispose();
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        content = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        label1 = new JLabel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        textField1 = new JTextField();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();
        label2 = new JLabel();
        panel11 = new JPanel();
        panel12 = new JPanel();
        panel13 = new JPanel();
        textField2 = new JTextField();
        panel14 = new JPanel();
        panel15 = new JPanel();
        panel16 = new JPanel();
        label3 = new JLabel();
        panel17 = new JPanel();
        panel18 = new JPanel();
        panel19 = new JPanel();
        textField3 = new JTextField();
        panel20 = new JPanel();
        panel22 = new JPanel();
        panel23 = new JPanel();
        label4 = new JLabel();
        panel24 = new JPanel();
        panel25 = new JPanel();
        panel26 = new JPanel();
        textField4 = new JTextField();
        panel27 = new JPanel();
        button = new JPanel();
        button1 = new JButton();
        panel21 = new JPanel();

        //======== this ========
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("\u8bbe\u7f6e");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new EtchedBorder());
            panel1.setLayout(new BorderLayout());

            //======== content ========
            {
                content.setLayout(new GridLayout(4, 1));

                //======== panel3 ========
                {
                    panel3.setLayout(new GridLayout(1, 2));

                    //======== panel4 ========
                    {
                        panel4.setLayout(new GridLayout());

                        //---- label1 ----
                        label1.setText("\u5fc3\u77e5\u5929\u6c14\u79c1\u94a5:");
                        label1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 16));
                        panel4.add(label1);
                    }
                    panel3.add(panel4);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new GridLayout(3, 0));

                        //======== panel6 ========
                        {
                            panel6.setLayout(new GridLayout());
                        }
                        panel5.add(panel6);

                        //======== panel7 ========
                        {
                            panel7.setLayout(new GridLayout());
                            panel7.add(textField1);
                        }
                        panel5.add(panel7);

                        //======== panel8 ========
                        {
                            panel8.setLayout(new GridLayout());
                        }
                        panel5.add(panel8);
                    }
                    panel3.add(panel5);
                }
                content.add(panel3);

                //======== panel9 ========
                {
                    panel9.setLayout(new GridLayout(1, 2));

                    //======== panel10 ========
                    {
                        panel10.setLayout(new GridLayout());

                        //---- label2 ----
                        label2.setText("\u57ce\u5e02\u540d\u5b57:");
                        label2.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
                        label2.setHorizontalAlignment(SwingConstants.CENTER);
                        panel10.add(label2);
                    }
                    panel9.add(panel10);

                    //======== panel11 ========
                    {
                        panel11.setLayout(new GridLayout(3, 0));

                        //======== panel12 ========
                        {
                            panel12.setLayout(new GridLayout());
                        }
                        panel11.add(panel12);

                        //======== panel13 ========
                        {
                            panel13.setLayout(new GridLayout());
                            panel13.add(textField2);
                        }
                        panel11.add(panel13);

                        //======== panel14 ========
                        {
                            panel14.setLayout(new GridLayout());
                        }
                        panel11.add(panel14);
                    }
                    panel9.add(panel11);
                }
                content.add(panel9);

                //======== panel15 ========
                {
                    panel15.setLayout(new GridLayout(1, 2));

                    //======== panel16 ========
                    {
                        panel16.setLayout(new GridLayout());

                        //---- label3 ----
                        label3.setText("\u76ee\u6807\u540d\u5b57:");
                        label3.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
                        label3.setHorizontalAlignment(SwingConstants.CENTER);
                        panel16.add(label3);
                    }
                    panel15.add(panel16);

                    //======== panel17 ========
                    {
                        panel17.setLayout(new GridLayout(3, 0));

                        //======== panel18 ========
                        {
                            panel18.setLayout(new GridLayout());
                        }
                        panel17.add(panel18);

                        //======== panel19 ========
                        {
                            panel19.setLayout(new GridLayout());
                            panel19.add(textField3);
                        }
                        panel17.add(panel19);

                        //======== panel20 ========
                        {
                            panel20.setLayout(new GridLayout());
                        }
                        panel17.add(panel20);
                    }
                    panel15.add(panel17);
                }
                content.add(panel15);

                //======== panel22 ========
                {
                    panel22.setLayout(new GridLayout(1, 2));

                    //======== panel23 ========
                    {
                        panel23.setLayout(new GridLayout());

                        //---- label4 ----
                        label4.setText("\u76ee\u6807\u65e5\u671f:");
                        label4.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
                        label4.setHorizontalAlignment(SwingConstants.CENTER);
                        panel23.add(label4);
                    }
                    panel22.add(panel23);

                    //======== panel24 ========
                    {
                        panel24.setLayout(new GridLayout(3, 0));

                        //======== panel25 ========
                        {
                            panel25.setLayout(new GridLayout());
                        }
                        panel24.add(panel25);

                        //======== panel26 ========
                        {
                            panel26.setLayout(new GridLayout());
                            panel26.add(textField4);
                        }
                        panel24.add(panel26);

                        //======== panel27 ========
                        {
                            panel27.setLayout(new GridLayout());
                        }
                        panel24.add(panel27);
                    }
                    panel22.add(panel24);
                }
                content.add(panel22);
            }
            panel1.add(content, BorderLayout.CENTER);

            //======== button ========
            {
                button.setLayout(new BorderLayout());

                //---- button1 ----
                button1.setText("\u63d0\u4ea4");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });
                button.add(button1, BorderLayout.EAST);

                //======== panel21 ========
                {
                    panel21.setLayout(new GridLayout());
                }
                button.add(panel21, BorderLayout.WEST);
            }
            panel1.add(button, BorderLayout.SOUTH);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        setSize(260, 355);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel content;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel label1;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JTextField textField1;
    private JPanel panel8;
    private JPanel panel9;
    private JPanel panel10;
    private JLabel label2;
    private JPanel panel11;
    private JPanel panel12;
    private JPanel panel13;
    private JTextField textField2;
    private JPanel panel14;
    private JPanel panel15;
    private JPanel panel16;
    private JLabel label3;
    private JPanel panel17;
    private JPanel panel18;
    private JPanel panel19;
    private JTextField textField3;
    private JPanel panel20;
    private JPanel panel22;
    private JPanel panel23;
    private JLabel label4;
    private JPanel panel24;
    private JPanel panel25;
    private JPanel panel26;
    private JTextField textField4;
    private JPanel panel27;
    private JPanel button;
    private JButton button1;
    private JPanel panel21;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
