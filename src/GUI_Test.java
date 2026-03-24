import java.awt.event.*;
import javax.swing.border.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.util.StringUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 07 18:05:25 CST 2024
 */

/**
 * @author ASUS
 */
public class GUI_Test extends JFrame implements ActionListener
{
    private Timer timer;
    private Timer timer2;
    private static boolean panduantj;
    private static String panduantq;
    public GUI_Test()
    {
        initComponents();
        Timer timer =new Timer(1000,this);
        timer.start();
    }

    //天气信息调用的天气贴图
    public static String weather2IconName(String weather)
    {
        switch (weather)
        {
            case "晴":
                return "src/image/qing.png";
            case "多云":
            case "晴间多云":
            case "大部多云":
                return "src/image/duoyun.png";
            case "阴":
                return "src/image/yin.png";
            case "阵雨":
            case "小雨":
            case "中雨":
            case "大雨":
            case "暴雨":
            case "大暴雨":
            case "特大暴雨":
            case "冻雨":
                return "src/image/dayu.png";
            case "雷阵雨":
            case "雷阵雨伴有冰雹":
                return "src/image/leizhenyu.png";
            case "雨夹雪":
            case "阵雪":
            case "小雪":
            case "中雪":
            case "大雪":
            case "暴雪":
                return "src/image/xue.png";
            default:
                return "src/image/yin.png";
        }
    }

    //业务逻辑
    @Override
    public void actionPerformed(ActionEvent e)
    {
        DateFormat dates = new SimpleDateFormat("HH:mm");
        DateFormat times = new SimpleDateFormat("MM-dd");
        DateFormat weeks = new SimpleDateFormat("EEEE");
        Date date = new Date();

        //设置日期时间星期
        label1.setText(dates.format(date));
        label2.setText(times.format(date));
        label3.setText(weeks.format(date));
        Calendar todaydate = Calendar.getInstance();

        //设置农历日期
        LunarUtil util = new LunarUtil(todaydate);
        label4.setText("农历" + String.valueOf(util));

        //写入文件
        File writeName =new File("src/config.txt");
        String txtContent = fileUtil.txt2String(writeName);
        String[] parts = txtContent.split(";");     //通过字符串分割
        String filedate = parts[1];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        Date date2 = null;

        try
        {
            date2 =simpleDateFormat.parse(filedate);
        }
        catch (ParseException ex)
        {
            throw new RuntimeException(ex);
        }

        //设置倒数日
        Long days = (date2.getTime() - date1.getTime()) / 86400000L;        //一天=24*60*60*1000
        label5.setText("距离" + parts[0] + "还有" + days.toString() + "天");
        label6.setText(parts[2]);       //地区名称

        //未来三天的日期和天气
        Calendar calendar = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("M/dd");
        String today = format.format(calendar.getTime());       //今天
        label7.setText("今天" + today);
        calendar.add(5,1);
        String tomorrow = format.format(calendar.getTime());       //明天
        label10.setText("明天" + tomorrow);
        calendar.add(5,1);
        String aftertomorrow = format.format(calendar.getTime());       //后天
        label13.setText("后天" + aftertomorrow);
        calendar.add(5,1);
        int second = todaydate.get(13);
        if (second % 5 == 0)
        {
            String location = pinyinUtil.toHanyuPinyin(parts[2]);
            String apiKey = parts[3];
            String urlStr = "https://api.seniverse.com/v3/weather/daily.json?key=" + apiKey + "&location=" + location + "&language=zh-Hans&unit=c&start=0&days=5";
            String result = HttpURLConnectionUtil.doGet(urlStr);
            if (StringUtils.isEmpty(result))
            {
                System.out.println("天气请求失败！");
            } else
            {
                System.out.println("天气请求返回：");
                System.out.println(result);

                //解析JSON对象
                JSONObject jsonObject = JSONObject.parseObject(result);
                JSONArray results = jsonObject.getJSONArray("results");
                JSONObject obj1 = JSONObject.parseObject(results.getString(0));
                JSONArray daily = obj1.getJSONArray("daily");
                JSONObject day1 = JSONObject.parseObject(daily.getString(0));
                JSONObject day2 = JSONObject.parseObject(daily.getString(1));
                JSONObject day3 = JSONObject.parseObject(daily.getString(2));

                //获取第一天最高温度拼接最低温度
                String high1 = day1.getString("high");
                String low1 = day1.getString("low");
                label9.setText(low1 + "-" + high1 + "℃");
                String weather1 = day1.getString("text_day");
                panduantj = panduan(weather1);
                panduantq = weather1;
                label8.setIcon(new ImageIcon(weather2IconName(weather1)));

                //获取第二天最高温度拼接最低温度
                String high2 = day2.getString("high");
                String low2 = day2.getString("low");
                label12.setText(low2 + "-" + high2 + "℃");
                String weather2 = day2.getString("text_day");
                label11.setIcon(new ImageIcon(weather2IconName(weather2)));

                //获取第三天最高温度拼接最低温度
                String high3 = day3.getString("high");
                String low3 = day3.getString("low");
                label15.setText(low3 + "-" + high3 + "℃");
                String weather3 = day3.getString("text_day");
                label14.setIcon(new ImageIcon(weather2IconName(weather3)));
            }
        }
        //设置天气异常提醒弹窗
        DateFormat systime = new SimpleDateFormat("mm:ss");
        if(systime.format(date).equals("40:59"))
        {
            JDialog infrom = new informtest(panduantq);
            infrom.setVisible(panduantj);
            infrom.setAlwaysOnTop(true);
            infrom.setModal(true);
            infrom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        //设置定时关机
        SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat timess = new SimpleDateFormat("ss");       //设置秒使仅弹出一次窗口
        String sstime = timess.format(date);
        String file_time = parts[7];        //读取文件中parts7作为设置的时间
        Date sys = new Date();
        String sys_time = timeformat.format(sys);
        if(sys_time.equals(file_time) && sstime.equals("00") && parts[6].equals("true"))
        {
            try {
                Runtime.getRuntime().exec("shutdown -s -t 20");         //在20秒后关机指令
                JDialog shutdown = new shutdown_test();
                shutdown.setVisible(true);
                shutdown.setAlwaysOnTop(true);
                shutdown.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        //设置闹钟功能
        SimpleDateFormat clockformat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat clock_ss = new SimpleDateFormat("ss");
        String clock_sstime = clock_ss.format(date);
        String file_clock = parts[5];
        Date file_date = new Date();
        String clock_sys_time = clockformat.format(file_date);
        if(clock_sys_time.equals(file_clock) && clock_sstime.equals("00") && parts[4].equals("true"))
        {
            JDialog clockGUI = new clockGUItest();
            clockGUI.setVisible(true);
            clockGUI.setAlwaysOnTop(true);
            clockGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

    }

    //设置目标和天气地址
    private void label5MouseClicked(MouseEvent e) {
        JDialog jDialog =new configtest();
        jDialog.setAlwaysOnTop(true);
        jDialog.setVisible(true);
        jDialog.setModal(true);
        jDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //闹钟和关机窗体创建
    private void label1MouseClicked(MouseEvent e) {
        JDialog clock = new clocktest();
        clock.setVisible(true);
        clock.setAlwaysOnTop(true);
        clock.setModal(true);
        clock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //天气异常判断
    public static boolean panduan(String wether)
    {
        switch (wether)
        {
            case "阵雨":
            case "小雨":
            case "中雨":
            case "大雨":
            case "暴雨":
            case "大暴雨":
            case "特大暴雨":
            case "冻雨":
            case "雷阵雨":
            case "雷阵雨伴有冰雹":
            case "雨夹雪":
            case "小雪":
            case "中雪":
            case "大雪":
            case "暴雪":
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args)
    {
        FlatDarkLaf.install();
        JFrame jFrame = new GUI_Test();
        jFrame.setAlwaysOnTop(true);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        label1 = new JLabel();
        panel9 = new JPanel();
        panel15 = new JPanel();
        label2 = new JLabel();
        panel16 = new JPanel();
        label3 = new JLabel();
        panel17 = new JPanel();
        label4 = new JLabel();
        panel6 = new JPanel();
        panel10 = new JPanel();
        label5 = new JLabel();
        panel11 = new JPanel();
        label6 = new JLabel();
        panel2 = new JPanel();
        panel12 = new JPanel();
        panel18 = new JPanel();
        label7 = new JLabel();
        panel19 = new JPanel();
        label8 = new JLabel();
        panel20 = new JPanel();
        label9 = new JLabel();
        panel13 = new JPanel();
        panel21 = new JPanel();
        label10 = new JLabel();
        panel22 = new JPanel();
        label11 = new JLabel();
        panel23 = new JPanel();
        label12 = new JLabel();
        panel14 = new JPanel();
        panel24 = new JPanel();
        label13 = new JLabel();
        panel25 = new JPanel();
        label14 = new JLabel();
        panel26 = new JPanel();
        label15 = new JLabel();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 1));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(2, 1));

            //======== panel7 ========
            {
                panel7.setBorder(new BevelBorder(BevelBorder.LOWERED));
                panel7.setLayout(new GridLayout(1, 2));

                //======== panel8 ========
                {
                    panel8.setBorder(BorderFactory.createEmptyBorder());
                    panel8.setLayout(new GridLayout());

                    //---- label1 ----
                    label1.setHorizontalAlignment(SwingConstants.CENTER);
                    label1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 48));
                    label1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            label1MouseClicked(e);
                        }
                    });
                    panel8.add(label1);
                }
                panel7.add(panel8);

                //======== panel9 ========
                {
                    panel9.setLayout(new GridLayout(3, 0));

                    //======== panel15 ========
                    {
                        panel15.setBorder(new EtchedBorder());
                        panel15.setLayout(new GridLayout());

                        //---- label2 ----
                        label2.setHorizontalAlignment(SwingConstants.CENTER);
                        label2.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 24));
                        panel15.add(label2);
                    }
                    panel9.add(panel15);

                    //======== panel16 ========
                    {
                        panel16.setBorder(new EtchedBorder());
                        panel16.setLayout(new GridLayout());

                        //---- label3 ----
                        label3.setHorizontalAlignment(SwingConstants.CENTER);
                        label3.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 22));
                        panel16.add(label3);
                    }
                    panel9.add(panel16);

                    //======== panel17 ========
                    {
                        panel17.setBorder(new EtchedBorder());
                        panel17.setLayout(new GridLayout());

                        //---- label4 ----
                        label4.setHorizontalAlignment(SwingConstants.CENTER);
                        label4.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
                        panel17.add(label4);
                    }
                    panel9.add(panel17);
                }
                panel7.add(panel9);
            }
            panel1.add(panel7);

            //======== panel6 ========
            {
                panel6.setBorder(BorderFactory.createEmptyBorder());
                panel6.setLayout(new GridLayout(2, 0));

                //======== panel10 ========
                {
                    panel10.setBorder(BorderFactory.createEmptyBorder());
                    panel10.setLayout(new GridLayout());

                    //---- label5 ----
                    label5.setHorizontalAlignment(SwingConstants.CENTER);
                    label5.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 22));
                    label5.setForeground(Color.cyan);
                    label5.setBorder(new EtchedBorder());
                    label5.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            label5MouseClicked(e);
                        }
                    });
                    panel10.add(label5);
                }
                panel6.add(panel10);

                //======== panel11 ========
                {
                    panel11.setBorder(BorderFactory.createEmptyBorder());
                    panel11.setLayout(new GridLayout());

                    //---- label6 ----
                    label6.setHorizontalAlignment(SwingConstants.RIGHT);
                    label6.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
                    label6.setBorder(new EtchedBorder());
                    panel11.add(label6);
                }
                panel6.add(panel11);
            }
            panel1.add(panel6);
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {
            panel2.setBorder(new EtchedBorder());
            panel2.setLayout(new GridLayout(3, 0));

            //======== panel12 ========
            {
                panel12.setBorder(BorderFactory.createEmptyBorder());
                panel12.setLayout(new GridLayout(1, 3));

                //======== panel18 ========
                {
                    panel18.setLayout(new GridLayout());

                    //---- label7 ----
                    label7.setHorizontalAlignment(SwingConstants.CENTER);
                    label7.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 18));
                    panel18.add(label7);
                }
                panel12.add(panel18);

                //======== panel19 ========
                {
                    panel19.setLayout(new GridLayout());

                    //---- label8 ----
                    label8.setHorizontalAlignment(SwingConstants.CENTER);
                    panel19.add(label8);
                }
                panel12.add(panel19);

                //======== panel20 ========
                {
                    panel20.setLayout(new GridLayout());

                    //---- label9 ----
                    label9.setHorizontalAlignment(SwingConstants.CENTER);
                    label9.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 18));
                    panel20.add(label9);
                }
                panel12.add(panel20);
            }
            panel2.add(panel12);

            //======== panel13 ========
            {
                panel13.setBorder(BorderFactory.createEmptyBorder());
                panel13.setLayout(new GridLayout(1, 3));

                //======== panel21 ========
                {
                    panel21.setLayout(new GridLayout());

                    //---- label10 ----
                    label10.setHorizontalAlignment(SwingConstants.CENTER);
                    label10.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 18));
                    panel21.add(label10);
                }
                panel13.add(panel21);

                //======== panel22 ========
                {
                    panel22.setLayout(new GridLayout());

                    //---- label11 ----
                    label11.setHorizontalAlignment(SwingConstants.CENTER);
                    panel22.add(label11);
                }
                panel13.add(panel22);

                //======== panel23 ========
                {
                    panel23.setLayout(new GridLayout());

                    //---- label12 ----
                    label12.setHorizontalAlignment(SwingConstants.CENTER);
                    label12.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 18));
                    panel23.add(label12);
                }
                panel13.add(panel23);
            }
            panel2.add(panel13);

            //======== panel14 ========
            {
                panel14.setBorder(BorderFactory.createEmptyBorder());
                panel14.setLayout(new GridLayout(1, 3));

                //======== panel24 ========
                {
                    panel24.setLayout(new GridLayout());

                    //---- label13 ----
                    label13.setHorizontalAlignment(SwingConstants.CENTER);
                    label13.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 18));
                    panel24.add(label13);
                }
                panel14.add(panel24);

                //======== panel25 ========
                {
                    panel25.setLayout(new GridLayout());

                    //---- label14 ----
                    label14.setHorizontalAlignment(SwingConstants.CENTER);
                    panel25.add(label14);
                }
                panel14.add(panel25);

                //======== panel26 ========
                {
                    panel26.setLayout(new GridLayout());

                    //---- label15 ----
                    label15.setHorizontalAlignment(SwingConstants.CENTER);
                    label15.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 18));
                    panel26.add(label15);
                }
                panel14.add(panel26);
            }
            panel2.add(panel14);
        }
        contentPane.add(panel2);
        setSize(285, 455);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel7;
    private JPanel panel8;
    private JLabel label1;
    private JPanel panel9;
    private JPanel panel15;
    private JLabel label2;
    private JPanel panel16;
    private JLabel label3;
    private JPanel panel17;
    private JLabel label4;
    private JPanel panel6;
    private JPanel panel10;
    private JLabel label5;
    private JPanel panel11;
    private JLabel label6;
    private JPanel panel2;
    private JPanel panel12;
    private JPanel panel18;
    private JLabel label7;
    private JPanel panel19;
    private JLabel label8;
    private JPanel panel20;
    private JLabel label9;
    private JPanel panel13;
    private JPanel panel21;
    private JLabel label10;
    private JPanel panel22;
    private JLabel label11;
    private JPanel panel23;
    private JLabel label12;
    private JPanel panel14;
    private JPanel panel24;
    private JLabel label13;
    private JPanel panel25;
    private JLabel label14;
    private JPanel panel26;
    private JLabel label15;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}