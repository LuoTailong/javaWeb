package test09;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 52013);
        BufferedReader br = new BufferedReader(new FileReader("day09/1.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = "";
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        socket.shutdownOutput();
        br.close();//此处不能关闭bw因为嵌套socket,关闭bw会关闭socket

        BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = br2.readLine();
        System.out.println(result);

        br2.close();//br2与bw关闭顺序无要求,因为该执行的已经执行完
        bw.close();
        socket.close();
    }
}
