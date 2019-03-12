package me.mupu.ibikehda;

import lombok.var;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientExample {

    public static void main(String[] args) {
        new ClientExample();
    }

    public ClientExample() {
        try {
            var s = new Socket("localhost", 666);
            var ois = new ObjectInputStream(s.getInputStream());

            var dw = (DataWrapper) ois.readObject();

            if (dw.getCmd().equals("bikeList")) {
                var d = (DataPackageLikeBikeListExample) dw.getData();
                System.out.println("mathod 1 " + d);
                d.getStations().forEach(System.out::println);
            }

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

}
