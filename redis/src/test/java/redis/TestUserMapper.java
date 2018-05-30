package redis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xsh.springboot.BootApplication;
import com.xsh.springboot.dao.UserMapper;
import com.xsh.springboot.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={BootApplication.class})
public class TestUserMapper {
	
	@Autowired
	private UserMapper userMapper;
	@Test
	public void test1() {
		System.out.println("进入到了我的这个方法" + userMapper);
		List<User> list = userMapper.findAll();
		System.out.println("我打赌进入不到这个里面");
		if(list == null) {
			System.out.println("数据未查到或者空指针");
		}else{
			for (User user : list) {
				System.out.println(user.getId() + ": " + user.getName() + ": " + user.getPassword());
			}
		}
	}
}
