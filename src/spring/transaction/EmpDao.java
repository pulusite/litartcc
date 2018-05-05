package spring.transaction;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangdong on 5/5/18.
 */
public interface EmpDao {
    void insertEmp(Emp emp);
    List<Emp> getAllEmp();
    Emp getById(String id);
    void deleteEmp(String id);
    void updateEmp(Map<String, Object> map);
}
