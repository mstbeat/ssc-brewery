package guru.sfg.brewery.web.controllers;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

class BaseIT {

	@Autowired
	WebApplicationContext wac;

	protected MockMvc mockMvc;

//	@MockBean
//	BeerRepository beerRepository;
//
//	@MockBean
//	BeerInventoryRepository beerInventoryRepository;
//
//	@MockBean
//	BreweryService breweryService;
//
//	@MockBean
//	CustomerRepository customerRepository;
//
//	@MockBean
//	BeerService beerService;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(wac)
				.apply(springSecurity())
				.build();
	}
	
	public static Stream<Arguments> getStreamAdminCustomer(){
		return Stream.of(Arguments.of("spring", "guru"),
				Arguments.of("scott", "tiger"));
	}
	
	public static Stream<Arguments> getStreamAllUsers(){
		return Stream.of(Arguments.of("spring", "guru"),
				Arguments.of("scott", "tiger"),
				Arguments.of("user", "password"));
	}
	
	public static Stream<Arguments> getStreamNotAdmin(){
		return Stream.of(Arguments.of("scott", "tiger"),
				Arguments.of("user", "password"));
	}

}
