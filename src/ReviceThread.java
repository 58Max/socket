import java.io.*;
import java.net.Socket;

public class ReviceThread implements Runnable {
    private Socket socket;

    public ReviceThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        String indata = null;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                     indata = in.readLine();
                     System.out.println(indata);
                    if("bye".equals(indata)){
                        break;
                    }
                }
                in.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
