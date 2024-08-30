package spring.service;


import spring.pojo.UserInfo;

public interface UserService {
    UserInfo add(String username, String password);
}
