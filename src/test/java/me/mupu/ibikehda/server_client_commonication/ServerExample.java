package me.mupu.ibikehda.server_client_commonication;

import lombok.var;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerExample {

    public static void main(String[] args) {
        new ServerExample();
    }

    public ServerExample() {
        try {
            ServerSocket ss = new ServerSocket(666);
            System.out.println("Server started..");
            while (true) {
                try {
                    new Handler(ss.accept());
                } catch (Exception ignored1) { }
            }
        } catch (Exception ignored) { }
    }

    private class Handler extends Thread {

        private Socket s;

        private Handler(Socket s) {
            this.s = s;
            this.start();
        }

        @Override
        public void run() {
            super.run();

            var x = new ArrayList<String>();
            x.add("station1");
            x.add("station2");

            var dwe = new DataWrapper("bikeList", new DataPackageLikeBikeListExample(x));
            try {
                var oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(dwe);
                oos.flush();
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
