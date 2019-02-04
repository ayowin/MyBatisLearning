package wz.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// manual
//import wz.mybatis.manual.User;
//import wz.mybatis.manual.UserMapper;

// mybatis-generator
import wz.mybatis.generator.entity.User;
import wz.mybatis.generator.mapper.UserMapper;

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
	    
	    // 方法一：
	    // 传统的方式，使用*Mapper.xml的【方法全路径】的方式获得entity
	    // 直观但易错
	    
	    // manual
//	    String sql = "wz.mybatis.manual.UserMapper.getUserById";
//	    user = (User)sqlSession.selectOne(sql,id);	
	    
	    // mybatis-generator
//	    String sql = "wz.mybatis.generator.mapper.UserMapper.selectByPrimaryKey"; 
//	    user = (User)sqlSession.selectOne(sql,id);	    
	    
	    // 方法二：
	    // 使用getMapper(*Mapper.class)方式获得*Mapper对象的方式获得entity
	    
	    // manual
//	    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//	    user = userMapper.getUserById(id);
	    
	    // mybatis-generator
	    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	    user  = userMapper.selectByPrimaryKey(id);
	
	} finally {
	    sqlSession.close();
	}
	
	return user;
    }
}
