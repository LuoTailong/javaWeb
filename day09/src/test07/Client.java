package test07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //1.创建客户端的Socket对象,指定服务器端的ip,端口号
        Socket socket = new Socket("127.0.0.1", 9999);

        //2.获取输出流,往服务器端写数据
        OutputStream os = socket.getOutputStream();
        os.write("约么? 第二次 by 客户端".getBytes());

        //3.获取输入流,读取服务端写过来的数据
        InputStream is = socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String s = new String(bys, 0, len);

        //4.打印到控制台
        System.out.println(s);

        //5.释放资源
        socket.close();
    }
}
