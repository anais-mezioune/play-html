package services;

import play.templates.JavaExtensions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EcommerceExtensions extends JavaExtensions {

    public static String format(LocalDateTime date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

}
