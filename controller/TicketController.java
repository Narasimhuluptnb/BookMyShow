package com.BookMyShow.controller;

import org.springframework.stereotype.Controller;

import com.BookMyShow.Dto.BookTicketRequestDto;
import com.BookMyShow.Dto.BookTicketResponseDto;
import com.BookMyShow.Exceptions.InvalidRequestException;
import com.BookMyShow.Models.ResponseType;


@Controller
public class TicketController {

	public BookTicketResponseDto BookTicket(BookTicketRequestDto requestDto) {
		BookTicketResponseDto responseDto = new BookTicketResponseDto();
		try {
			Validations(requestDto);
			
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
