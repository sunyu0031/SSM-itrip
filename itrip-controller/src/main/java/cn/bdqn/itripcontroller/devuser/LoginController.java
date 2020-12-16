package cn.bdqn.itripcontroller.devuser;

import cn.bdqn.itripbeans.pojo.devuser.DevUser;
import cn.bdqn.itripcommon.util.ActivateCode;
import cn.bdqn.itripcommon.util.SendEmailUtil;
import cn.bdqn.itripservice.devuser.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource
    private DevUserService devUserService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //测试登陆
    @RequestMapping("/login")
    public String login(Model model, String userName, String password) throws Exception {
        DevUser devUser = devUserService.login("test001", "123456");
//        DevUser devUser = devUserService.login(userName, password);
        if (devUser != null) {
            model.addAttribute("user", devUser);
            return "regiest";
        } else {
            return "error";
        }
    }

    // 欢迎页
    @RequestMapping("/")
    public String welcom() {
        return "regiest";
    }

    // 测试redis
    @RequestMapping("/testRedis")
    public String testRedis() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("name", "xiaoming");
        String name = operations.get("name");
        System.out.print(">>>>>>>>>>>>>>" + name);
        return "index";
    }

    // 实现用户注册
    @RequestMapping("/regiest")
    public ModelAndView regiest(DevUser devUser) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("regiest");
        // 如果用户选择邮箱注册实现邮箱激活
        if (devUser.getDevEmail() != null) {
            // 生成激活码
            String activateCode = ActivateCode.getActivateCode();
            // 设置激活码
            devUser.setActivatCode(activateCode);
            // 设置激活状态
            devUser.setActivated(false);
            // 给用户邮箱发送激活码
            boolean sendResult = SendEmailUtil.sendEmail(devUser.getDevEmail(), activateCode);
            //            // 如果发送成功则跳转到激活画面
            if (sendResult) {
                boolean regiestResult = devUserService.regiest(devUser);
                // 信息注册成功则跳转到激活画面
                if (regiestResult) {
                    ValueOperations<String, Object> operations = redisTemplate.opsForValue();
                    operations.set(devUser.getDevEmail(), activateCode);
                    modelAndView.addObject("message", "success");
                }
            }
        }
        return modelAndView;
    }

    // 实现用户激活
    @RequestMapping("/doActive")
    public String doActive(String devEmail, String activatCode) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        // 先从缓存中读取
        if (operations.get(devEmail) != null) {
            if (operations.get(devEmail).equals(activatCode)) {
                // 修改用户的激活状态并跳转到登陆画面
            }
            // 缓存中没有的话就从数据库中读取
        } else {
            // 如果取到的用户激活码和画面一致则修改用户的激活状态并跳转到登陆画面

        }
        return "index";
    }
}