package cn.bdqn.itripservice.devuser;

import cn.bdqn.itripdao.devuser.DevUserMapper;
import cn.bdqn.itripbeans.pojo.devuser.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserMapper devUserMapper;

    @Override
    public DevUser login(String devCode, String devPassword) throws Exception {
        DevUser user = null;
        user = devUserMapper.getLoginUser(devCode);
        //匹配密码
        if (null != user) {
            if (!user.getDevPassword().equals(devPassword))
                user = null;
        }
        return user;
    }

    @Override
    public boolean regiest(DevUser devUser) throws Exception {
        boolean regiest = false;
        if (devUserMapper.addDecUser(devUser) > 0) {
            regiest = true;
        }
        return regiest;
    }

}
