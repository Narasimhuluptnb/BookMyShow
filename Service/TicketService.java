package com.BookMyShow.Service;

import java.util.List;

import com.BookMyShow.Models.Ticket;


public interface TicketService {
	public Ticket BookTicket(List<Integer> seatids,int userId,int showId);
}
