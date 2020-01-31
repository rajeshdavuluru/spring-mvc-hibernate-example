package demo.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.code.entity.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer>{
}
