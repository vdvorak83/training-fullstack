package net.incuventure.kitchensink.domain.repository;

import net.incuventure.kitchensink.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
@Transactional
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testThis() {

        Employee employee = new Employee("Gamboa", "Jett");

        employeeRepository.persist(employee);

        Employee e = employeeRepository.load(1);

    }

    @Test
    public void testCount() {

        Employee employee = new Employee("Gamboa", "Jett");

        employeeRepository.persist(employee);

        Long count = employeeRepository.getCount();

        System.out.println("total count is: " + count);

    }
}
