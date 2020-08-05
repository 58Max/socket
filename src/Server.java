import java.util.Scanner;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter printWriter;
    private String indata;
    private String outdata;
    public static void main(String []args){
        new Server().server();
    }

    public void server(){
        try {
            serverSocket = new ServerSocket(7979);
            while(true){
                System.out.println("等待客户端的连接");
                socket = serverSocket.accept();
                printWriter = new PrintWriter(socket.getOutputStream(),true);//建立通道
                printWriter.println("您已成功连接服务器！");
                printWriter.flush();
                Scanner out = new Scanner(System.in);
                Scanner in = new Scanner(socket.getInputStream());
                while(true){
                    if(!(indata =out.nextLine()).equals("bye")) {
                        System.out.println("客户机： " + out.nextLine());
                    } else{
                        printWriter.close();
                        socket.close();
                        serverSocket.close();
                        in.close();
                        out.close();
                    }
                    outdata = out.nextLine();
                    printWriter.println(outdata);
                    printWriter.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
