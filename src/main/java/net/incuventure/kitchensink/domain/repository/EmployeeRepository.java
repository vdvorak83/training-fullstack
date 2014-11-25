package net.incuventure.kitchensink.domain.repository;

import net.incuventure.kitchensink.domain.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class EmployeeRepository {

    @Autowired(required=true)
    private SessionFactory sessionFactory;

    public EmployeeRepository() {
    }

    public Employee load(Integer id) {
        // return (TradeOrder) this.sessionFactory.getCurrentSession().load(TradeOrder.class, id);

        return (Employee) this.sessionFactory.getCurrentSession().createQuery(
                "from net.incuventure.training.domain.Employee where id = :id").setParameter("id", id).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public void saveOrUpdate(Employee employee) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @SuppressWarnings("unchecked")
    public void persist(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);
    }

    @SuppressWarnings("unchecked")
    public void update(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(employee);
    }

    @SuppressWarnings("unchecked")
    public void merge(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findByCriteria(List<Criterion> criterion) {

        Criteria crit =  this.sessionFactory.getCurrentSession().createCriteria(Employee.class);

        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    public Long getCount() {

        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);

        criteria.setProjection(Projections.rowCount());

        return (Long) criteria.uniqueResult();
    }

}
