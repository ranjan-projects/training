package com.host.reachable;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Up {

    public static void main(String[] args) throws Exception {


        String ipAddress = "10.81.248.113";

        InetAddress geek = InetAddress.getByName(ipAddress);
        System.out.println("Sending Ping Request to " + ipAddress);
        if (geek.isReachable(5000))
            System.out.println("Host is reachable");
        else
            System.out.println("Sorry ! We can't reach to this host");


    }


/*
    String ipAddress = "test24.core.esb.virginmoney.com";
     InetAddress[] geek = InetAddress.getAllByName(ipAddress);
*/

}
