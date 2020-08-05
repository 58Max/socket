import java.io.IOException;
import java.net.Socket;

public class TestClient {
    public static void main(String []args){
        System.out.println("正在尝试连接服务器.......");
        try {
            Socket socket = new Socket("127.0.0.1",6868);
            new Thread(new SendThread(socket)).start();//启动发送消息线程
            new Thread(new ReviceThread(socket)).start();//启动接收消息线程
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
