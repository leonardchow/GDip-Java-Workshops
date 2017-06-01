package com.leonardchow.club.application;

public class BadBookingException extends Exception {
        public BadBookingException() {
        }

        public BadBookingException(String message) {
                super(message);
        }
}
