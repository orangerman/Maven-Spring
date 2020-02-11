package jdbc;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.AbstractSqlParameterSource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    private ApplicationContext ctx;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private EmployeesDao employeesDao;

    {


        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
        employeesDao = (EmployeesDao) ctx.getBean("employeesDao");

    }

    @Test
    public void testDatasource() {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);

    }

    @Test
    public void testUpdate() {
        String sql = "UPDATE employees SET last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, "WWm", "1");
    }

    /**
     * 批量更新
     */
    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();

        batchArgs.add(new Object[]{"AA", "aa@163.com", 1});
        batchArgs.add(new Object[]{"BB", "bb@163.com", 2});
        batchArgs.add(new Object[]{"CC", "cc@163.com", 3});
        batchArgs.add(new Object[]{"DD", "dd@163.com", 2});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }


    /**
     * 从数据库中获取一条记录，实际得到对应的对象
     * 注意不是调用  jdbcTemplate.queryForObject(sql, Employee.class, 1);
     * 使用SQl中列的别名来匹配类的属性名
     * 不支持级联属性 ,dept_id as "department.id"
     */
    @Test
    public void testQueryForObject() {
        String sql = "SELECT id,last_name lastName,email FROM employees WHERE id = ?  ";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(employee);

    }

    /**
     * 获取单个列的值 或者做统计查询
     */
    @Test
    public void testQueryForObject2() {
        String sql = "SELECT last_name FROM employees WHERE id = ?";
        String name = jdbcTemplate.queryForObject(sql, String.class, 1);
        System.out.println(name);

    }

    /**
     * 查到实体类的集合
     * 注意调用的不是QueryForList（）
     */
    @Test
    public void testQueryForList() {
        String sql = "SELECT id,last_name lastName,email FROM employees WHERE id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 0);
        System.out.println(employees);

    }

    @Test
    public void testEmployeesDao() {
        Employee employee = employeesDao.get(1);
        System.out.println(employee);

    }

    /**
     * testNamedParameterJdbcTemplate 有具名参数
     */
    @Test
    public void testNamedParameterJdbcTemplate() {

        String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(:ln,:email,:deptid) ";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ln", "wjm");
        paramMap.put("email", "wjm@163.com");
        paramMap.put("deptid", "4");

        namedParameterJdbcTemplate.update(sql, paramMap);
    }
    @Test
    public void testNamedParameterJdbcTemplate2() {

        String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(:lastName,:email,:deptId) ";


        Employee employee = new Employee();
        employee.setLastName("Dazhuang");
        employee.setEmail("wjm@163.com");
        employee.setDeptId(4);

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, parameterSource);

    }



}
