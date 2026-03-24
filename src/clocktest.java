import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun Apr 28 11:38:02 CST 2024
 */

/**
 * @author ASUS
 */
public class clocktest extends JDialog
{
    private String clock_static=null;
    private String down_static=null;
    File writeName = new File("src/config.txt");
    String txtContent = fileUtil.txt2String(writeName);
    String[] parts = txtContent.split(";");
    public clocktest()
    {
        //读取配置文件
        initComponents();

        //设置开启关闭按钮的初始状态
        if(parts[4].equals("true"))
        {
            button2.setText("关闭");
        }
        else
        {
            button2.setText("开启");
        }
        if(parts[6].equals("true"))
        {
            button3.setText("关闭");
        }
        else
        {
            button3.setText("开启");
        }

//        class ClockListener implements ItemListener
//        {
//            @Override
//            public void itemStateChanged(ItemEvent e)
//            {
//                if(button2.getText().equals("true"))
//                {
//                    clock_static = "true";
//                }
//                else
//                {
//                    clock_static = "false";
//                }
//            }
//        }
//
//        class DownListener implements ItemListener
//        {
//
//            @Override
//            public void itemStateChanged(ItemEvent e)
//            {
//                if(button3.getText().equals("true"))
//                {
//                    down_static = "true";
//                }
//                else
//                {
//                    down_static = "false";
//                }
//            }
//        }

        this.textField1.setText(parts[5]);
        this.textField2.setText(parts[7]);
//        button2.addItemListener(new ClockListener());
//        button3.addItemListener(new DownListener());
        down_static=parts[6];
        clock_static=parts[4];
    }

    //OK按钮的设置
    private void button1MouseClicked(MouseEvent e)
    {
        String var1 = this.textField1.getText().trim();
        String var2 = this.textField2.getText().trim();
        String config = parts[0] + ";" + parts[1] + ";" + parts[2] + ";"        //对之前的字符串原封不动重新拼接
                + parts[3] + ";" + clock_static +";"
                + var1.trim() + ";" + down_static+ ";" + var2.trim() + ";";
        fileUtil.writeFile("src/config.txt", config);
        this.dispose();
    }

    //对开启关闭按钮更新状态
    private void button2MouseClicked(MouseEvent e)
    {
        if(button2.getText().equals("开启"))
        {
            clock_static = "true";
            button2.setText("关闭");
        }
        else
        {
            clock_static = "false";
            button2.setText("开启");
        }
    }

    //对开启关闭按钮更新状态
    private void button3MouseClicked(MouseEvent e)
    {

        if(button3.getText().equals("开启"))
        {
            down_static = "true";
            button3.setText("关闭");

        }
        else
        {
            down_static = "false";
            button3.setText("开启");

        }
    }

//    static class ClockListener implements ItemListener
//    {
//
//
//        @Override
//        public void itemStateChanged(ItemEvent e)
//        {
//            if(e.getStateChange() == ItemEvent.SELECTED)
//            {
//                String var = this.textField1.getText().trim();
//                String config = var + ";" + this.textField4.getText().trim() + ";" + this.textField2.getText().trim() + ";" + this.textField1.getText().trim() + ";";
//                fileUtil.writeFile("src/config.txt", config);
//            }
//            else
//            {
//                System.out.println("取消");
//            }
//        }
//
//    }
//
//    static class DownListener implements ItemListener
//    {
//
//        @Override
//        public void itemStateChanged(ItemEvent e)
//        {
//            if(e.getStateChange() == ItemEvent.SELECTED)
//            {
//                System.out.println("选中");
//            }
//            else
//            {
//                System.out.println("取消");
//            }
//        }
//    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel4 = new JPanel();
        panel7 = new JPanel();
        label1 = new JLabel();
        panel6 = new JPanel();
        panel10 = new JPanel();
        panel11 = new JPanel();
        button2 = new JButton();
        panel12 = new JPanel();
        panel5 = new JPanel();
        panel8 = new JPanel();
        label2 = new JLabel();
        panel9 = new JPanel();
        panel13 = new JPanel();
        panel14 = new JPanel();
        textField1 = new JTextField();
        panel15 = new JPanel();
        panel3 = new JPanel();
        panel16 = new JPanel();
        panel18 = new JPanel();
        label3 = new JLabel();
        panel19 = new JPanel();
        panel22 = new JPanel();
        panel23 = new JPanel();
        button3 = new JButton();
        panel24 = new JPanel();
        panel17 = new JPanel();
        panel20 = new JPanel();
        label4 = new JLabel();
        panel21 = new JPanel();
        panel25 = new JPanel();
        panel26 = new JPanel();
        textField2 = new JTextField();
        panel27 = new JPanel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(2, 0));

            //======== panel2 ========
            {
                panel2.setBorder(new BevelBorder(BevelBorder.LOWERED));
                panel2.setForeground(Color.blue);
                panel2.setLayout(new GridLayout(2, 0));

                //======== panel4 ========
                {
                    panel4.setBorder(new EtchedBorder());
                    panel4.setLayout(new GridLayout(1, 2));

                    //======== panel7 ========
                    {
                        panel7.setLayout(new GridLayout());

                        //---- label1 ----
                        label1.setText("\u95f9\u949f\u9009\u9879");
                        label1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 20));
                        label1.setHorizontalAlignment(SwingConstants.CENTER);
                        panel7.add(label1);
                    }
                    panel4.add(panel7);

                    //======== panel6 ========
                    {
                        panel6.setLayout(new GridLayout(3, 0));

                        //======== panel10 ========
                        {
                            panel10.setLayout(new GridLayout());
                        }
                        panel6.add(panel10);

                        //======== panel11 ========
                        {
                            panel11.setLayout(new GridLayout());

                            //---- button2 ----
                            button2.setText("\u83b7\u53d6\u4e2d");
                            button2.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
                            button2.setForeground(Color.cyan);
                            button2.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    button2MouseClicked(e);
                                }
                            });
                            panel11.add(button2);
                        }
                        panel6.add(panel11);

                        //======== panel12 ========
                        {
                            panel12.setLayout(new GridLayout());
                        }
                        panel6.add(panel12);
                    }
                    panel4.add(panel6);
                }
                panel2.add(panel4);

                //======== panel5 ========
                {
                    panel5.setBorder(new EtchedBorder());
                    panel5.setLayout(new GridLayout(1, 2));

                    //======== panel8 ========
                    {
                        panel8.setLayout(new GridLayout());

                        //---- label2 ----
                        label2.setText("\u95f9\u949f\u65f6\u95f4");
                        label2.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 20));
                        label2.setHorizontalAlignment(SwingConstants.CENTER);
                        panel8.add(label2);
                    }
                    panel5.add(panel8);

                    //======== panel9 ========
                    {
                        panel9.setLayout(new GridLayout(3, 0));

                        //======== panel13 ========
                        {
                            panel13.setLayout(new GridLayout());
                        }
                        panel9.add(panel13);

                        //======== panel14 ========
                        {
                            panel14.setLayout(new GridLayout());

                            //---- textField1 ----
                            textField1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
                            textField1.setHorizontalAlignment(SwingConstants.CENTER);
                            panel14.add(textField1);
                        }
                        panel9.add(panel14);

                        //======== panel15 ========
                        {
                            panel15.setLayout(new GridLayout());
                        }
                        panel9.add(panel15);
                    }
                    panel5.add(panel9);
                }
                panel2.add(panel5);
            }
            panel1.add(panel2);

            //======== panel3 ========
            {
                panel3.setBorder(new BevelBorder(BevelBorder.LOWERED));
                panel3.setForeground(Color.blue);
                panel3.setLayout(new GridLayout(2, 0));

                //======== panel16 ========
                {
                    panel16.setBorder(new EtchedBorder());
                    panel16.setLayout(new GridLayout(1, 2));

                    //======== panel18 ========
                    {
                        panel18.setLayout(new GridLayout());

                        //---- label3 ----
                        label3.setText("\u5173\u673a\u9009\u9879");
                        label3.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 20));
                        label3.setHorizontalAlignment(SwingConstants.CENTER);
                        panel18.add(label3);
                    }
                    panel16.add(panel18);

                    //======== panel19 ========
                    {
                        panel19.setLayout(new GridLayout(3, 0));

                        //======== panel22 ========
                        {
                            panel22.setLayout(new GridLayout());
                        }
                        panel19.add(panel22);

                        //======== panel23 ========
                        {
                            panel23.setLayout(new GridLayout());

                            //---- button3 ----
                            button3.setText("\u83b7\u53d6\u4e2d");
                            button3.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
                            button3.setForeground(Color.cyan);
                            button3.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    button3MouseClicked(e);
                                }
                            });
                            panel23.add(button3);
                        }
                        panel19.add(panel23);

                        //======== panel24 ========
                        {
                            panel24.setLayout(new GridLayout());
                        }
                        panel19.add(panel24);
                    }
                    panel16.add(panel19);
                }
                panel3.add(panel16);

                //======== panel17 ========
                {
                    panel17.setBorder(new EtchedBorder());
                    panel17.setLayout(new GridLayout(1, 2));

                    //======== panel20 ========
                    {
                        panel20.setLayout(new GridLayout());

                        //---- label4 ----
                        label4.setText("\u5173\u673a\u65f6\u95f4");
                        label4.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 20));
                        label4.setHorizontalAlignment(SwingConstants.CENTER);
                        panel20.add(label4);
                    }
                    panel17.add(panel20);

                    //======== panel21 ========
                    {
                        panel21.setLayout(new GridLayout(3, 0));

                        //======== panel25 ========
                        {
                            panel25.setLayout(new GridLayout());
                        }
                        panel21.add(panel25);

                        //======== panel26 ========
                        {
                            panel26.setLayout(new GridLayout());

                            //---- textField2 ----
                            textField2.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
                            textField2.setHorizontalAlignment(SwingConstants.CENTER);
                            panel26.add(textField2);
                        }
                        panel21.add(panel26);

                        //======== panel27 ========
                        {
                            panel27.setLayout(new GridLayout());

                            //---- button1 ----
                            button1.setText("\u786e\u5b9a");
                            button1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 20));
                            button1.setForeground(Color.green);
                            button1.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    button1MouseClicked(e);
                                }
                            });
                            panel27.add(button1);
                        }
                        panel21.add(panel27);
                    }
                    panel17.add(panel21);
                }
                panel3.add(panel17);
            }
            panel1.add(panel3);
        }
        contentPane.add(panel1);
        setSize(270, 375);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel4;
    private JPanel panel7;
    private JLabel label1;
    private JPanel panel6;
    private JPanel panel10;
    private JPanel panel11;
    private JButton button2;
    private JPanel panel12;
    private JPanel panel5;
    private JPanel panel8;
    private JLabel label2;
    private JPanel panel9;
    private JPanel panel13;
    private JPanel panel14;
    private JTextField textField1;
    private JPanel panel15;
    private JPanel panel3;
    private JPanel panel16;
    private JPanel panel18;
    private JLabel label3;
    private JPanel panel19;
    private JPanel panel22;
    private JPanel panel23;
    private JButton button3;
    private JPanel panel24;
    private JPanel panel17;
    private JPanel panel20;
    private JLabel label4;
    private JPanel panel21;
    private JPanel panel25;
    private JPanel panel26;
    private JTextField textField2;
    private JPanel panel27;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
