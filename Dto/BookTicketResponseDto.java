package com.BookMyShow.Dto;

import com.BookMyShow.Models.ResponseType;
import com.BookMyShow.Models.Ticket;

public class BookTicketResponseDto {
	private Ticket ticket;
	private String errorMeassage;
	private ResponseType responseType;
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public String getErrorMeassage() {
		return errorMeassage;
	}
	public void setErrorMeassage(String errorMeassage) {
		this.errorMeassage = errorMeassage;
	}
	public ResponseType getResponseType() {
		return responseType;
	}
	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}
	
	
}
