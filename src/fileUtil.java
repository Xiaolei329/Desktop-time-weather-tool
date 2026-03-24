import java.io.*;

public class fileUtil
{

    //读取文件返回全部字符串
    public static String txt2String(File file)
    {
        StringBuilder result = new StringBuilder();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));   //构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null)
            {//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void writeFile(String fileName, String txt)
    {
        try
        {
            File writeName = new File(fileName); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            )
            {
                out.write(txt);
                out.flush(); // 把缓存区内容压入文件
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}


