package com.chen.until;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
class ilesImplTest {

    @Autowired
    public filetool file;

    @Test
    void deleteMetting() throws Exception{
        String realPath = ResourceUtils.getFile("classpath:").getPath();
        System.out.println(realPath);
    }
}