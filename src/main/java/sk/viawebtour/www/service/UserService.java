package sk.viawebtour.www.service;


import java.util.List;

import sk.viawebtour.www.domain.User;

public interface UserService {

    User save(User user);

    List<User> getList();

}
