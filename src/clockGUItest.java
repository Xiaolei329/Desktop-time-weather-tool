import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 07 15:08:18 CST 2024
 */


/**
 * @author ASUS
 */
public class clockGUItest extends JDialog implements ActionListener
{
    private Timer timer;
    private int count = 20;

    Clip clip;
    {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        label1.setText("距离闹钟设定时间仅剩"+count--+"秒");
        if(count == 0)
        {
            clip.start();
        }
    }

    AudioInputStream ais;

    {
        try {
            ais = AudioSystem.getAudioInputStream(new File("src/clockmusic.wav"));
            clip.open(ais);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public clockGUItest()
    {
        initComponents();
        timer = new Timer(1000,this);
        timer.start();
    }

    //取消闹钟按钮事件
    private void button1MouseClicked(MouseEvent e)
    {
        File writeName = new File("src/config.txt");
        String txtContent = fileUtil.txt2String(writeName);
        String[] parts = txtContent.split(";");
        String config = parts[0] + ";" + parts[1] + ";" + parts[2] + ";" + parts[3] + ";"
                + "false" + ';' + parts[5] + ';' + parts[6] + ';' + parts[7] + ';';         //对之前的字符串原封不动重新拼接
        fileUtil.writeFile("src/config.txt", config);
        clip.stop();
        clip.close();
        this.dispose();
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
            label1.setText("\u8ddd\u79bb\u95f9\u949f\u8bbe\u5b9a\u65f6\u95f4\u4ec5\u5269X\u79d2");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 24));
            label1.setForeground(Color.cyan);
            panel1.add(label1);
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout());

            //---- button1 ----
            button1.setText("\u5173\u95ed\u95f9\u949f");
            button1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 22));
            button1.setForeground(Color.red);
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel2.add(button1);
        }
        contentPane.add(panel2);
        setSize(390, 260);
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
