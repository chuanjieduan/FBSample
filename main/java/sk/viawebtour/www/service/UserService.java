package sk.viawebtour.www.service;


import sk.viawebtour.www.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getList();

}
