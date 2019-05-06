package by.itacademy.pinchuk.jd2.service;

import by.itacademy.pinchuk.jd2.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService = UserService.getInstance();

    @Test
    public void get() {
        User user = userService.get(1L);
        assertEquals(1L, user.getId());
        assertEquals("John", user.getName());
    }
}