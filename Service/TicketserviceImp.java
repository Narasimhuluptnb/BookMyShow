package com.BookMyShow.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.sound.midi.VoiceStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.BookMyShow.Exceptions.InvalidRequestException;
import com.BookMyShow.Exceptions.SeatunavailableException;
import com.BookMyShow.Models.Seat;
import com.BookMyShow.Models.Seatstatus;
import com.BookMyShow.Models.Show;
import com.BookMyShow.Models.ShowSeat;
import com.BookMyShow.Models.Ticket;
import com.BookMyShow.Models.User;
import com.BookMyShow.Repository.SeatRepository;
import com.BookMyShow.Repository.ShowRepository;
import com.BookMyShow.Repository.ShowseatRepository;
import com.BookMyShow.Repository.Userrepository;


@Service
public class TicketserviceImp implements TicketService{
	
    private final Userrepository userrepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final ShowseatRepository showseatRepository;

    // ✅ Constructor Injection
    public TicketserviceImp(Userrepository userrepository,
                            ShowRepository showRepository,
                            SeatRepository seatRepository,
                            ShowseatRepository showseatRepository) {
        this.userrepository = userrepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.showseatRepository = showseatRepository;
    }
	
	@Override
	public Ticket BookTicket(List<Integer> seatids, int userId, int showId) throws SeatunavailableException{
		// TODO Auto-generated method stub
		Optional<User> user = this.userrepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new InvalidRequestException("User is not available");
		}
		// Just another way of writing the validation to check the show
		Show show = this.showRepository.findById(showId).orElseThrow(()->new InvalidRequestException("Show id doesn't exist"));
		
		long currentdatetime = new Date().getTime();
		
		// validation to the show timings. If the movie starts already then the booking won't get confirmed.
		if((currentdatetime+10*60)>currentdatetime) {
			throw new InvalidRequestException("The show already started");
		}
		
		List<Seat> seats = seatRepository.findAllById(seatids);
		
		if(seats.size() < seatids.size()) {
			throw new InvalidRequestException("only "+seats.size()+"seats available");
		}
		
		BlockSeatsforUser(user.get(),show,seatids);
		return null;
	}
	
	
	// Transactional make sure that if an error occurs in the method. it roll back all the changes.
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void BlockSeatsforUser(User user,Show show,List<Integer> seatids) throws SeatunavailableException {
		// It will get the available seats
		List<ShowSeat> availableSeats = this.showseatRepository.findAllByShowAndSeat_IdInAndSeatstatus(show, seatids,Seatstatus.AVAILABLE);
		if(availableSeats.size() < seatids.size()) {
			throw new SeatunavailableException("Seats are not available. Please book for the next show. Thanks");
		}
		//Moved available seats to blocked to the specific user
		availableSeats.stream().forEach(seat->{
						  	   seat.setSeatstatus(Seatstatus.Blocked);
						  	   seat.setUser(user);
					  			});
		// save all the seats into the DataBase
		showseatRepository.saveAll(availableSeats);
		return ;
		
	}

}
