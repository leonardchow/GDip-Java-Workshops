package com.leonardchow.dto;

import java.io.Serializable;

/**
 * Created by leonardchow on 5/25/2017.
 */
public interface MemberDTO extends PersonDTO, Comparable<MemberDTO>, Serializable {

    public int getMemberNumber();
    
    public void setMemberNumber(int memberNumber);

    public String toString();
}
