package service;

import org.springframework.stereotype.Service;

/**
 * Created by kfrak on 05.12.2018.
 */
@Service
public class TeapotService {

    public String getMessage(){
        return "Hi, I'm teapot";
    }
}
