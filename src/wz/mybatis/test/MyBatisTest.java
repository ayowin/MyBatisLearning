package wz.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wz.mybatis.manual.User;
//import wz.mybatis.generator.entity.User;

import wzlog4j.Log;

public class MyBatisTest {

    public static void main(String[] args) {

	System.out.println("----------This is mybatis test project------------");

	MyBatisTest myBatisTest = new MyBatisTest();
	myBatisTest.initMyBatis();
		
	User user = myBatisTest.getUserById(1);
	Log.d(user);
	Log.d("id: " + user.getId());
	Log.d("username: " + user.getUsername());
	Log.d("password: " + user.getPassword());
	Log.d("identity_card: " + user.getIdentityCard());
	Log.d("phone_number: " + user.getPhoneNumber());
	Log.d("job: " + user.getJob());
    }

    private SqlSessionFactory sqlSessionFactory;

    // 初始化
    public void initMyBatis() {

	try {
	    if(this.sqlSessionFactory == null) {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		inputStream = Resources.getResourceAsStream(resource);
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
	    }

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    Log.d("iniMyBatis fuction Get SqlSessionFactory success: " + this.sqlSessionFactory);
	}

    }

    // 通过id查询一个用户
    public User getUserById(int id) {

	SqlSession sqlSession = this.sqlSessionFactory.openSession();
	User user = null;
	
	try {
	    
	    // manual
	    String sql = "wz.mybatis.manual.UserMapper.getUserById";
	    
	    // mybatis-generator
//	    String sql = "wz.mybatis.generator.mapper.UserMapper.selectByPrimaryKey";
	    
	    user = (User)sqlSession.selectOne(sql,id);
	
	} finally {
	    sqlSession.close();
	}
	
	return user;
    }
}
