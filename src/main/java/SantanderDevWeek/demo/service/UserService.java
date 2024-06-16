package SantanderDevWeek.demo.service;


import SantanderDevWeek.demo.model.User;

public interface UserService {
    User findById(Long id);
    User create(User createUser);
}
