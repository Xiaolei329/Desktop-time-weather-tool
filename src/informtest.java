import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 28 12:16:02 CST 2024
 */

/**
 * @author ASUS
 */
public class informtest extends JDialog {
    public informtest(String panduantq)
    {
        initComponents();
        //设置天气异常提醒文字
        this.label2.setText(tixing(panduantq));
    }

    //判断天气异常条件
    public static String tixing(String pandauntq)
    {
        switch (pandauntq)
        {
            case "阵雨":
                return "当前天气是阵雨,出门记得带伞！";
            case "小雨":
                return "当前天气是小雨,出门记得带伞！";
            case "中雨":
                return "当前天气是中雨,出门记得带伞！";
            case "大雨":
                return "当前天气是大雨,出门记得带伞！";
            case "暴雨":
                return "当前天气是暴雨,出门记得带伞！";
            case "大暴雨":
                return "当前天气是大暴雨,尽量避免外出活动！";
            case "特大暴雨":
                return "当前天气是特大暴雨,尽量避免外出活动！";
            case "冻雨":
                return "当前天气是冻雨,出门记得带伞！";
            case "雷阵雨":
                return "当前天气是雷阵雨,尽量避免外出活动！";
            case "雷阵雨伴有冰雹":
                return "当前天气是雷阵雨伴有冰雹,尽量避免外出活动！";
            case "雨夹雪":
                return "当前天气是雨夹雪,出门记得带伞！";
            case "小雪":
                return "当前天气是小雪,出门小心地滑！";
            case "中雪":
                return "当前天气是中学,出门小心地滑！";
            case "大雪":
                return "当前天气是大学,出门小心地滑！";
            case "暴雪":
                return "当前天气是暴雪,尽量避免外出活动！";
            default:
                return "信息错误！正在重新获取";
        }
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();

        //======== this ========
        setTitle("\u6e29\u99a8\u63d0\u9192");
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 0));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout());

            //---- label1 ----
            label1.setText("\u5929\u6c14\u5f02\u5e38\u63d0\u9192");
            label1.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 20));
            label1.setForeground(Color.cyan);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1);
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout());

            //---- label2 ----
            label2.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 20));
            label2.setForeground(Color.yellow);
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setText("\u4fe1\u606f\u9519\u8bef\uff01\u6b63\u5728\u91cd\u65b0\u83b7\u53d6");
            panel2.add(label2);
        }
        contentPane.add(panel2);
        setSize(395, 215);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
