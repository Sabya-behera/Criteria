package com.example.demo14.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.demo14.Model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService implements com.example.demo14.Service.Service {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public List<Student> getStudent() {
        return null;
    }

    @Override
    public List<Student> gtStudent() {
        return null;
    }


    @Transactional
    public List<Student> getStudents() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();    /*This 3 Things are compulsory*/
        CriteriaQuery<Student> cq = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = cq.from(Student.class);
        cq.orderBy(criteriaBuilder.desc(studentRoot.get("name")));
        List<Student> students = entityManager.createQuery(cq).getResultList();
        return students;
    }

    //Equal to id
    @Transactional
    public List<Student> getStudent(Long id) {
        //Making the query object from the Criteria Builder Instance
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        //Displaying All records
        criteriaQuery.select(studentRoot);
        Predicate predicate = criteriaBuilder.equal(studentRoot.get("id"), id);
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }
  //not equal  (select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ where student0_.id<>2)
  @Transactional
  public List<Student> gtStudent(Long id) {
      CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
      CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
      Root<Student> studentRoot = criteriaQuery.from(Student.class);
      criteriaQuery.select(studentRoot);
      Predicate predicate = criteriaBuilder.notEqual(studentRoot.get("id"), id);
      criteriaQuery.where(predicate);
      TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
      List<Student> studentList = typedQuery.getResultList();
      return studentList;
  }

  //OR    (select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ where student0_.name=? or student0_.roll_number=?)
    @Transactional
    public List<Student> getStudents(String name, String rollNumber) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicateName = criteriaBuilder.equal(studentRoot.get("name"), name);
        Predicate predicateRollNumber = criteriaBuilder.equal(studentRoot.get("rollNumber"), rollNumber);
        Predicate nameOrRollNumberPredicate = criteriaBuilder.or(predicateName, predicateRollNumber);
        criteriaQuery.where(nameOrRollNumberPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }

    //and   (select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ where student0_.name=? and student0_.roll_number=?)
    @Transactional
    public List<Student> gtStudents(String name, String rollNumber) {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicateName = criteriaBuilder.equal(studentRoot.get("name"), name);
        Predicate predicateRollNumber = criteriaBuilder.equal(studentRoot.get("rollNumber"), rollNumber);
        Predicate nameAndRollNumberPredicate = criteriaBuilder.and(predicateName, predicateRollNumber);
        criteriaQuery.where(nameAndRollNumberPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }
     //NOT  (select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ where student0_.name<>?)
    @Transactional
    public List<Student> notStudents(String name) {
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicateName = criteriaBuilder.equal(studentRoot.get("name"), name);
        Predicate lastPredicate = criteriaBuilder.not(predicateName);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    //Greater_than(select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ where student0_.id>2)

    @Transactional
    public List<Student> greaterStudents(Long id) {
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate lastPredicate = criteriaBuilder.gt(studentRoot.get("id").as(Long.class), id);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    //Less_than(select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ where student0_.id<2)

    @Transactional
    public List<Student> lessStudents(Long id) {
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate lastPredicate = criteriaBuilder.lt(studentRoot.get("id").as(Long.class), id);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    //Less_than_equal(select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ where student0_.id<=2)
    @Transactional
    public List<Student> leStudents(Long id) {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicate = criteriaBuilder.le(studentRoot.get("id"), id);
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }
    //Greater_than_equal(select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ where student0_.id>=2)
    @Transactional
    public List<Student> geStudents(Long id) {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicate = criteriaBuilder.ge(studentRoot.get("id"), id);
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }
    //Between(select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ where student0_.id between 1 and 3)
    @Transactional
    public List<Student> betweenStudents(Long id1, Long id2) {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate lastPredicate = criteriaBuilder.between(studentRoot.get("id").as(Long.class),id1,id2);
        criteriaQuery.where(lastPredicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }
    //LIKE
    @Transactional
    public List<Student> likeStudents() {

        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicate = criteriaBuilder.like(studentRoot.get("name"), "%r%");
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentList = typedQuery.getResultList();

        return studentList;
    }

    //ASc (select student0_.id as id1_0_, student0_.name as name2_0_, student0_.roll_number as roll_num3_0_, student0_.university as universi4_0_ from student student0_ order by student0_.name asc)
    @Transactional
    public List<Student> ascStudents() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);

        criteriaQuery.orderBy(criteriaBuilder.asc(studentRoot.get("name")));
        List<Student> students = entityManager.createQuery(criteriaQuery).getResultList();
        return students;
    }
}
