package com.generic;

import com.generic.factory.NotifierFactory;
import com.generic.implementation.DateNotifier;
import com.generic.implementation.StringNotifier;
import com.generic.interfaces.Notifier;

import java.time.LocalDate;

public class NotifierClient {

    public static void main(String[] args) {

       /* Notifier<String> notifyString = new StringNotifier();
        notifyString.notify("2");

        Notifier<LocalDate> notifyDate = new DateNotifier();
        notifyDate.notify(LocalDate.now());*/

        Notifier<String> notifyString = NotifierFactory.getNotifier(String.class);
        notifyString.notify("2");

    }
}
