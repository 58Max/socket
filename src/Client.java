import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private PrintWriter writer;
    private Socket socket;
    private String indata;
    private String outdata;
    public static void main(String []args){
        new Client().client();
    }
    public void client(){
        System.out.println("正在尝试连接服务器......");
        try{
            socket = new Socket("127.0.0.1",7979);
            writer = new PrintWriter(socket.getOutputStream(),true);
            System.out.println("连接成功！");
            Scanner out = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            System.out.println(in.nextLine());
            while(true){
                outdata = out.nextLine();
                writer.println(outdata);
                writer.flush();
                if("bye".equals(outdata)){
                    writer.close();
                    socket.close();
                   System.out.println("断开连接！");
                }
                indata = in.nextLine();
                System.out.println("服务器： " + indata);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
