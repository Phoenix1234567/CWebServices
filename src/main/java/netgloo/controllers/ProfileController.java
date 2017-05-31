package netgloo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.models.User;
import netgloo.services.interfaces.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> signUp(@RequestBody User user) {
		Boolean response = profileService.addUser(user);
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
	}
}
