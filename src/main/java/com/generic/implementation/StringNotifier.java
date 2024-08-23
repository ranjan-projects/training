package com.generic.implementation;

import com.generic.interfaces.Notifier;

public class StringNotifier implements Notifier<String> {

    @Override
    public void notify(String str) {
        System.out.println("notify" + str);
    }
}
