package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
//		DaoFactory factory = new DaoFactory();
//		UserDao dao1 = factory.userDao();
//		UserDao dao2 = factory.userDao();
//		
//		System.out.println(dao1);	// springbook.user.dao.UserDao@15db9742
//		System.out.println(dao2);	// springbook.user.dao.UserDao@6d06d69c
		
		/*
		 * DaoFactoryó�� @Confguration�� ���� �ڹ��ڵ带 ���������� ����Ϸ��� 
		 * AnnotationConfigApplicationContext�� �̿�
		 * ���ø����̼� ���ڽ�Ʈ ���� �� ������ �Ķ���ͷ� DaoFactory Ŭ������ �־��ش�
		 */
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
//		UserDao dao3 = context.getBean("userDao", UserDao.class);
//		UserDao dao4 = context.getBean("userDao", UserDao.class);
		
//		System.out.println(dao3);	// springbook.user.dao.UserDao@32a068d1
//		System.out.println(dao4);	// springbook.user.dao.UserDao@32a068d1
		
		UserDao dao = new DaoFactory().userDao();
		
		User user = new User();
//		user.setId("song2");
//		user.setName("����ȣ");
//		user.setPassword("1234");
//		
//		dao.add(user);
//		
//		System.out.println(user.getId()+" : ��� ����");
		
		User user2 = dao.get("song2");
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " : ��ȸ ����");                                      
		
	}
}
