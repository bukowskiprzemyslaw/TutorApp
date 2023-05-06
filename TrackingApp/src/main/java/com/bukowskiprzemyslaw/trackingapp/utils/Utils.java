package com.bukowskiprzemyslaw.trackingapp.utils;

import jakarta.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Utils {

    public static String getIpAddress(HttpServletRequest request) {

        String ipAddress = request.getRemoteAddr();

        if (ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
            try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(new URL("https://checkip.amazonaws.com").openStream()));
            ) {
                ipAddress = br.readLine();
            } catch (Exception e) {
            }
        }

        return ipAddress;
    }

}
