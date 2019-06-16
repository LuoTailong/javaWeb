package test07;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务器端的Socket对象,指定端口号
        ServerSocket server = new ServerSocket(9999);

        //2.监听连接
        Socket socket = server.accept();

        //3.获取输入流,读取客户端写过来的数据
        InputStream is = socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String s = new String(bys, 0, len);

        //4.将读取到的数据打印到控制台
        System.out.println(s);

        //5.获取输出流,给客户端写一句话
        socket.getOutputStream().write("不约, 你吃藕".getBytes());

        //6.释放资源
        socket.close();
    }
}
