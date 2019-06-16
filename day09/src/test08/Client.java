package test08;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("为啥?");
        bw.flush();
        //给服务器一个结束标记
        socket.shutdownOutput();//此处也可以写bw.newLine()或者\r\n,但前提是服务器端读的方法是br.readLine()
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);
        socket.close();
    }
}
