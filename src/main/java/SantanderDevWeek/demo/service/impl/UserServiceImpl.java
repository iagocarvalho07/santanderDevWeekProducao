package SantanderDevWeek.demo.service.impl;


import SantanderDevWeek.demo.model.User;
import SantanderDevWeek.demo.repository.UserRespository;
import SantanderDevWeek.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRespository userRespository;
    public UserServiceImpl(UserRespository userRespository){
        this.userRespository = userRespository;
    }
    @Override
    public User findById(Long id) {
        return userRespository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User createUser) {
        if (userRespository.existsByAccountNumber(createUser.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRespository.save(createUser);
    }
}
