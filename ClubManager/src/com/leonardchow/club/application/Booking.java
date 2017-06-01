package com.leonardchow.club.application;

import com.leonardchow.club.model.Facility;
import com.leonardchow.club.model.Member;
import com.leonardchow.utils.DateUtils;

//import java.nio.channels.CancelledKeyException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by leonardchow on 5/25/2017.
 */
public class Booking {
    private Member member;
    private Facility facility;
    private Calendar startDate, endDate;
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("d-MMM-yyyy");

    public Booking (Member member, Facility facility, Calendar startDate, Calendar endDate) throws BadBookingException {
        if (member == null || facility == null) throw new BadBookingException("Member or facility cannot be null!");

        if (startDate == null || endDate == null) throw new BadBookingException("Dates cannot be null!");

        if (startDate.after(endDate)) throw new BadBookingException("Start date cannot be after the end date!");

        this.member = member;
        this.facility = facility;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking (Member member, Facility facility, Date startDate, Date endDate) throws BadBookingException {
        this(member, facility, DateUtils.toCalendar(startDate), DateUtils.toCalendar(endDate));
    }

    public boolean overlaps (Booking booking) {
        if (booking.facility.getName() != facility.getName()) {
            return false;
        }
        boolean overlap = false;
        // overlap scenarios for A and B:
        // A's start date is after B's start date && A's start date is before B's end date
        if (startDate.after(booking.startDate) && startDate.before(booking.endDate)) {
            overlap = true;
        }
        // B's start date is after A's start date && B's start date is before A's end date
        if (booking.startDate.after(startDate) && booking.startDate.before(endDate)) {
            overlap = true;
        }
        return overlap;
    }

    public String toString() {
        return String.format("%s, %s has booked the %s, from %s to %s.",
                member.getSurname(),
                member.getFirstName(),
                facility.getName(),
                dateFormatter.format(startDate.getTime()),
                dateFormatter.format(endDate.getTime()));
    }

    public void show() {
        System.out.println(toString());
    }

    public Member getMember() {
        return member;
    }

    public Facility getFacility() {
        return facility;
    }

    public Date getStartDate() {
        return startDate.getTime();
    }

    public Date getEndDate() {
        return endDate.getTime();
    }
}

