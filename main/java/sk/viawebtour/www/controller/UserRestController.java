package sk.viawebtour.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.viawebtour.www.domain.User;
import sk.viawebtour.www.service.UserService;
import sk.viawebtour.www.service.excepiton.UserAlreadyExistsException;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
    private final UserService userService;

    @Inject
    public UserRestController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User createUser(@RequestBody @Valid final User user) {
        LOGGER.debug("Received request to create the {}", user);
        return userService.save(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listUsers() {
        LOGGER.debug("Received request to list all users");
        return userService.getList();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return e.getMessage();
    }

}
