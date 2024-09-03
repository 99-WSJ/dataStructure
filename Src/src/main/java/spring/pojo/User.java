package spring.pojo;

import lombok.Data;

/**
 * @program: Src
 * @description: user
 * @author: wsj
 * @create: 2024-09-01 11:53
 **/
@Data
public class User {
    private String userId;
    private String password;
    private UserInfo userInfo;
}
