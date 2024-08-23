package com.generic.factory;

import com.generic.implementation.DateNotifier;
import com.generic.implementation.StringNotifier;
import com.generic.interfaces.Notifier;

import java.security.AccessControlException;
import java.time.LocalDate;

public class NotifierFactory {

    private NotifierFactory() {
        throw new AccessControlException("cannot initialize");
    }

    public static <T> Notifier<T> getNotifier(Class<T> cls) {

        if(cls == String.class) {
            return (Notifier<T>) new StringNotifier();   // either by casting
        } else if (cls == LocalDate.class){
            return Notify.DATE.make();
        } else {
            return null;
        }
    }

    enum Notify {

        STRING {
            @Override
            Notifier<String> make() {
                return new StringNotifier();
            }
        },
        DATE {
            @Override
            Notifier<LocalDate> make() {
                return new DateNotifier();
            }
        };

        abstract <T> Notifier<T> make();
    }

}
