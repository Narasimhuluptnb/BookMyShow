package com.BookMyShow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookMyShow.Models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
