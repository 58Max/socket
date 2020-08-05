import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String []args){
        try {
            ServerSocket serverSocket = new ServerSocket(6868);
            System.out.println("等待客户端连接.....");
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接！");
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);//建立通道
            printWriter.println("您已成功连接服务器！");
            new Thread(new SendThread(socket)).start();//启动发送消息线程
            new Thread(new ReviceThread(socket)).start();//启动接收消息线程
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
