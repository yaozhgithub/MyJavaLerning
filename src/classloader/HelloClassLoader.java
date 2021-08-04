package classloader;

import java.io.*;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) {

        try {
            Class<?> claz = new HelloClassLoader().findClass("Hello");
            claz.getMethod("hello").invoke(claz.newInstance());
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {

        byte[] bytes = getByte();
        //Hello.class 文件所有字节（x=255-x）处理后的文件
        //255-每个字节=原来的字节
        for (int i=0;i<bytes.length;i++){
            bytes[i]= (byte) (255-bytes[i]);
        }
        return defineClass(name,bytes,0,bytes.length);
    }



    public byte[] getByte(){
        File file = new File("Hello.xlass");
        try {
            FileInputStream in = new FileInputStream(file);

            ByteArrayOutputStream out =new ByteArrayOutputStream();
            byte[] buffer =new byte[1024 *4];
            int n;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer,0, n);
            }
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
