/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rejaluo.syslogserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author reja
 */
public class ServerMain {

    public static void main(String[] args) throws Throwable {
        // TODO Auto-generated method stub
        DatagramSocket datagramSocket = new DatagramSocket(8081);
        System.out.println("Started");
        while (true) {
            DatagramPacket packet = new DatagramPacket(new byte[512], 512);
            try {
                datagramSocket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println(packet.getAddress() + "/" + packet.getPort() + ":" + msg);
                packet.setData("I am server!!!".getBytes());
                datagramSocket.send(packet);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
