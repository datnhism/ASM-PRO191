package ASM;
import java.io.*;
public class Controller {
    public static void WriteFile(String path){
        File f=new File(path);
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream(f);
            byte[] arr={10,20,30};
            fos.write(arr);
            fos.close();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
    public static void ReadFile(String path)
    {
        File f=new File(path);
        FileInputStream fis=null;
        try
        {
            fis=new FileInputStream(f);
            int filesize=(int) f.length();
            byte[] res=new byte[filesize];
            fis.read(res);
            for (int i = 0; i < filesize; i++) {
                System.out.println(res[i]);
            }
            fis.close();
        }
        catch (FileNotFoundException fe) {
            System.err.println(fe);
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
    public static void WriteDataFile(String path)
    {
        try
        {
            FileOutputStream fos= new FileOutputStream(path);
            DataOutputStream dos=new DataOutputStream(fos);
            int num=5;
            dos.writeInt(num);
            dos.writeUTF("DatNhism");
            dos.writeDouble(5.5);
            dos.close();
        }
        catch (Exception e)
        {
            System.err.println(e);

        }
    }

    public static void dataFile(String path)
    {
        try
        {
            FileInputStream fis= new FileInputStream(path);
            DataInputStream dos=new DataInputStream(fis);
            System.out.println(dos.readInt());
            System.out.println(dos.readUTF());
            System.out.println(dos.readDouble());

            dos.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
    public static void writeItf(String path)
    {
        try{
            FileWriter fw=new FileWriter(path);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("hi");
            bw.write("\n");
            bw.write("Harry is my name");
            bw.close();
            fw.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public static void writeItf(String path,String data)
    {
        try{
            FileWriter fw=new FileWriter(path);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(data);
            bw.close();
            fw.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public static String ReadBuffer(String path)
    {
        StringBuilder sb=new StringBuilder();
        try{
            FileReader fr=new FileReader(path);
            BufferedReader br=new BufferedReader(fr);

            String str=br.readLine();
            while (str!=null)
            {
                sb.append(str);
                str=br.readLine();
                if(str!=null)sb.append("\n");
            }
            br.close();
            fr.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return sb.toString();
    }
    public static void WriteObject(String path,Object o) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(o);
            oos.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
    public static Object readObject(String path)
    {
        try{
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path));
            Object o=ois.readObject();
            ois.close();
            return o;

        }
        catch (Exception e)
        {
            System.err.println(e);
            return null;
        }

    }

    public static void main(String[] args) {
        String pathName="demo.txt";
        writeItf(pathName);
        System.out.println(ReadBuffer(pathName));

    }
}
