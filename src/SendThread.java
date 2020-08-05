
import java.io.PrintWriter;
import java.util.Scanner;

import java.net.Socket;

public class SendThread implements Runnable{
    private Socket socket;

    public SendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter writer = null;
        Scanner oo = new Scanner(System.in);
        String outdata = null;
        try {
            writer = new PrintWriter(socket.getOutputStream(),false);
            while(true){
               outdata = oo.nextLine();
               if(!"bye".equals(outdata)){
                   System.out.println("开始发送！");
                   writer.write(outdata);
                   writer.flush();
               }else{
                   writer.write(outdata);
                   writer.flush();
                   break;
               }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
