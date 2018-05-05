package spring.transaction;

/**
 * Created by zhangdong on 5/5/18.
 */
public class EmpServiceImpl implements EmpService {
    private EmpDao empDao;

    @Override
    public void insertEmp(Emp emp) {
        empDao.insertEmp(emp);

    }

    public EmpDao getEmpDao() {
        return empDao;
    }

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }
}