package com.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookMyShow.Dto.BookTicketRequestDto;
import com.BookMyShow.Dto.BookTicketResponseDto;
import com.BookMyShow.Exceptions.InvalidRequestException;
import com.BookMyShow.Models.ResponseType;
import com.BookMyShow.Service.TicketService;


@RestController
public class TicketController {
	// This is to follow dependency inversion principle(every class should not depend on each other)
	@Autowired
	private TicketService ticketService;
	// Constructor injection
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@PostMapping("/BookTickets")
	public BookTicketResponseDto BookTicket(@RequestBody BookTicketRequestDto requestDto) {
		BookTicketResponseDto responseDto = new BookTicketResponseDto();
		try {
			Validations(requestDto);
			this.ticketService.BookTicket(requestDto.getSeatIds(),requestDto.getUserId(),requestDto.getShowId());
			
		}
		catch (Exception e) 
		{
			responseDto.setResponseType(ResponseType.FAILURE);
			responseDto.setErrorMeassage(e.getMessage());
		}
		return responseDto;
	}

	private void Validations(BookTicketRequestDto requestDto) throws InvalidRequestException{
		if(requestDto.getSeatIds() == null || requestDto.getSeatIds().isEmpty()) {
			throw new InvalidRequestException("Show id should not be empty");
		}
		if(requestDto.getUserId() < 0) {
			throw new InvalidRequestException("Invalid user id");
		}
		if(requestDto.getShowId() < 0) {
			throw new InvalidRequestException("Invalid Show id");
		}
		
	}
}
