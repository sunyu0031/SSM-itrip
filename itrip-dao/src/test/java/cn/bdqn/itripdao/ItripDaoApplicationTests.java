package cn.bdqn.itripdao;

import cn.bdqn.itripdao.devuser.DevUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ItripDaoApplicationTests {
    @Resource
    private DevUserMapper devUserMapper;

    @Test
    void contextLoads(){

    }

}
