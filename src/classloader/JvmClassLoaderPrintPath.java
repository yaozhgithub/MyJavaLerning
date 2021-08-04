package classloader;

import java.net.URL;

public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {

        //启动类加载器
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();

        System.out.println("启动类加载器");
        for (URL url: urls) {
            System.out.println("==>"+url.toExternalForm());
        }
    }
}
