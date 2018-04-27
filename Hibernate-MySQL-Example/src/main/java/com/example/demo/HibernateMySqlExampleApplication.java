package com.example.demo;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.repo.StudentrRepo;
import com.example.demo.repo.SubjectRepository;



@SpringBootApplication
public class HibernateMySqlExampleApplication implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(HibernateMySqlExampleApplication.class);
	 @Autowired
	    private StudentrRepo studentrepo;

	 @Autowired
	    private SubjectRepository subjectRepository;
	    
	public static void main(String[] args) {
		 SpringApplication.run(HibernateMySqlExampleApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		 // save a couple of books
        Student SinhvienA = new Student("SinhVien A");
        Student SinhvienB = new Student("Sinhvien B");
        Student SinhvienC = new Student("Sinhvien C");

     
        subjectRepository.saveAll(new HashSet<Subject>(){{
            add(new Subject("CNTT", new HashSet<Student>(){{
                add(SinhvienA);
                add(SinhvienB);
            }}));

            add(new Subject("KHTN", new HashSet<Student>(){{
                add(SinhvienA);
                add(SinhvienC);
            }}));
        }});
        
        for(Student student : studentrepo.findAll()) {
            logger.info(student.toString());
        }
        
        for(Subject subject : subjectRepository.findAll()) {
            logger.info(subject.toString());
        }
        
        Subject A = new Subject("CNTT");
        Subject B = new Subject("KHTN");

        studentrepo.saveAll(new HashSet<Student>(){{
            add(new Student("Sinhvien A", new HashSet<Subject>() {{
                add(A);
                add(B);
            }}));

            add(new Student("Sinhvien B", new HashSet<Subject>() {{
                add(A);
                add(B);
            }}));
        }});

		
	}
}
