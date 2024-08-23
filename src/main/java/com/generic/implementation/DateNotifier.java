package com.generic.implementation;

import com.generic.interfaces.Notifier;

import java.time.LocalDate;

public class DateNotifier implements Notifier<LocalDate> {

    @Override
    public void notify(LocalDate date) {
        System.out.println("notifying" + date);
    }
}
