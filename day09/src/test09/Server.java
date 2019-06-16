package test09;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(52013);
        Socket socket = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("day09/2.txt"));

        String line = "";
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();//此处不能关闭br因为嵌套socket,关闭br会关闭socket

        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw2.write("接收成功");

        bw2.close();//close中隐含先flush功能,不能先关br,先关br会使socket关闭,导致bw2写不过去
        br.close();
        socket.close();
    }
}
