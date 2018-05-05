package spring.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangdong on 5/5/18.
 */
public class TestEmpService {
    @Test
    public void testTrasaction(){
        Emp emp=new Emp();
        emp.setId("00000003");
        emp.setName("某某某");
        emp.setAge(50);
        emp.setSex("男");
        emp.setPhone("566666");

        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:transaction.xml");
        EmpService service=ctx.getBean(EmpService.class);
        service.insertEmp(emp);
    }
}
