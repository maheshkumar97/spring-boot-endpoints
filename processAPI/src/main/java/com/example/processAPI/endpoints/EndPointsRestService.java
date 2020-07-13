package com.example.processAPI.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:8081")
@RequestMapping("/api")
@RestController
public class EndPointsRestService {

	private List<User> theList;

	@PostConstruct
	public void loadData() {

		theList = new ArrayList();
		theList.add(new User(1, "John", "Tight"));
		theList.add(new User(2, "Meri", "Fernoudas"));
		theList.add(new User(3, "Sonum", "Chand"));
	}

	@GetMapping("/user")
	public List getUsers() {
		return theList;
	}

	@GetMapping("/user/{userid}")
	public User getUser(@PathVariable int userid) {
		userid-=1;

		return theList.get(userid);
	}
}
