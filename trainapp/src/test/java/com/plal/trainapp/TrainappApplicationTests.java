package com.plal.trainapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.plal.trainapp.model.Receipt;
import com.plal.trainapp.model.User;
import com.plal.trainapp.model.UserTrainBookingDetail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrainBookingControllerTests {

	@LocalServerPort
	private int port;
	private static TestRestTemplate  restTemplate;
	private UserTrainBookingDetail userDetails;
	private String baseUrl;

	@BeforeAll
	public static void beforeAll() {
		restTemplate = new TestRestTemplate();
	}
	@BeforeEach
	public void init() {
		User user = new User();
		user.setFirstName("Sunil");
		user.setLastName("K");
		user.setEmail("sunilK@gmail.com");
		userDetails = new UserTrainBookingDetail();
		userDetails.setUser(user);
		userDetails.setTrainNo(12345);
		userDetails.setTrainName("Train 1");
		userDetails.setSection("Section A");
		userDetails.setFair(20);

		baseUrl = "http://localhost:"+port+"/trainapp";
	}

	private int bookTicket() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<UserTrainBookingDetail> request = new HttpEntity<>(userDetails, headers);
		ResponseEntity<Receipt> responseEntity = this.restTemplate
				.postForEntity(baseUrl+"/book-ticket", request, Receipt.class);
		return responseEntity.getBody().getTicketNo();
	}

	@Test
	public void testBookTicket() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<UserTrainBookingDetail> request = new HttpEntity<>(userDetails, headers);
		ResponseEntity<Receipt> responseEntity = this.restTemplate
				.postForEntity(baseUrl+"/book-ticket", request, Receipt.class);
		assertEquals(201, responseEntity.getStatusCodeValue());
	}

	@Test
	public void testShowBookTicket() throws MalformedURLException {
		int ticketNo = bookTicket();
		HttpHeaders headers = new HttpHeaders();
		userDetails.setTicketNo(ticketNo);
		HttpEntity<UserTrainBookingDetail> request = new HttpEntity<>(userDetails, headers);

		ResponseEntity<UserTrainBookingDetail> responseEntity = this.restTemplate
				.getForEntity(new URL(baseUrl+"/ticket/"+ticketNo).toString(), UserTrainBookingDetail.class);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

}
