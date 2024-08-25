package com.invcd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    private final UserInfoRepository userInfoRepository;

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @PostMapping("/add")
    public UserInfo addOneUser(@RequestBody UserInfo userInfo){
        return this.userInfoRepository.save(userInfo);
    }

    @GetMapping("/find")
    public Iterable<UserInfo> findAllUsers(){
        return this.userInfoRepository.findAll();
    }
}
