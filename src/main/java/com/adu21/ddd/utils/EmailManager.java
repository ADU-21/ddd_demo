package com.adu21.ddd.utils;

import org.springframework.stereotype.Component;

@Component
public class EmailManager {
    public void sendEmail(String uuid) {
        System.out.println("Sending email: " + uuid);
    }
}
