package com.leonardchow.club.application;

import javax.swing.text.html.Option;

import com.leonardchow.club.model.Facility;
import com.leonardchow.club.model.Member;

import java.util.*;
import java.util.stream.Collectors;

public class BookingRegister {
    private HashMap<Facility, ArrayList<Booking>> bookingRegistry;

    public BookingRegister() {
        this.bookingRegistry = new HashMap<>();
    }

    public Boolean addBooking(Member member, Facility facility, Date startDate, Date endDate) {
        try {
            Booking newBooking = new Booking(member, facility, startDate, endDate);

            ArrayList<Booking> bookingList = bookingRegistry.get(facility);
            if (bookingList == null) {
                // create new list
                bookingList = new ArrayList<>();
                bookingRegistry.put(facility, bookingList);
            }

            Optional<Booking> overlap = bookingList.stream().filter(booking -> newBooking.overlaps(booking)).findFirst();
            if (overlap.isPresent()) {
                throw new BadBookingException("There is a conflict with booking below:\n" + overlap.get().toString());
            }

            bookingList.add(newBooking);
        } catch (BadBookingException e) {
            System.err.println("Could not create the booking. " + e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<Booking> getBookingsBetween(Facility facility, Date firstDate, Date lastDate) {
        return new ArrayList<>(
                bookingRegistry.get(facility).stream()
                .filter(booking -> booking.getStartDate().after(firstDate) && booking.getEndDate().before(lastDate))
                .collect(Collectors.toList())
        );
    }

    public void removeBooking(Booking bookingToDelete) {
        bookingRegistry.values().stream()
                .filter(bookings -> bookings.stream()
                        .anyMatch(booking -> booking == bookingToDelete))
                .findFirst()
                .ifPresent(bookings -> bookings.remove(bookingToDelete));
    }
}
