package com.chen.community;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.util.List;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoad() {

    }
    @Test
    void deleteMetting() throws Exception{
        String realPath = ResourceUtils.getFile("classpath:").getPath();
        System.out.println("realPath: "+realPath);
    }
}
