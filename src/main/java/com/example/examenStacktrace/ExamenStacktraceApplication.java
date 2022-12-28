package com.example.examenStacktrace;

import com.example.examenStacktrace.models.Course;
import com.example.examenStacktrace.models.Student;
import com.example.examenStacktrace.models.Teacher;
import com.example.examenStacktrace.repositories.CourseRepository;
import com.example.examenStacktrace.repositories.StudentRepository;
import com.example.examenStacktrace.repositories.TeacherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ExamenStacktraceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ExamenStacktraceApplication.class, args);
		StudentRepository repository = context.getBean(StudentRepository.class);
		TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
		CourseRepository courseRepository = context.getBean(CourseRepository.class);
		//crear cursos
		Course course1 = new Course(null, "Teología", "120 horas", "En este curso veremos las bases de la religion catolica", 7, Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
		courseRepository.save(course1);
		Course course2 = new Course(null, "Matematicas 1", "150 horas", "En este curso veremos las bases de la matematica", 7, Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
		courseRepository.save(course2);
		Course course3 = new Course(null, "Matematicas 2", "170 horas", "En este curso veremos las bases de la matematica avanzada", 6, Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
		courseRepository.save(course3);
		Course course4 = new Course(null, "Ciencias Naturales", "200 horas", "En este curso veremos las bases de las ciencias natirales", 6, Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
		courseRepository.save(course4);
		//crear alumnos
		Student student1 = new Student(null, "Nahuel", "Guerra", "2664790932", "Barrio los ranqueles", "Masculino", "DNI", "40722349", LocalDate.of(1997, 10, 21), Set.of(course1, course2), Set.of(course2));
		Student student2 = new Student(null, "Laura", "Wilhelm", "2664312124", "Barrio los ranqueles", "Femenino", "DNI", "5307428",LocalDate.of(1935, 7, 12), Set.of(course2, course3, course4), Set.of(course1 ,course2));
		Student student3 = new Student(null, "Carla", "Gonzalez", "2664314567", "Barrio los Amep", "Femenino", "DNI", "45307428",LocalDate.of(1967, 8, 9), Set.of(course2, course4), Set.of(course3));
		repository.save(student1);
		repository.save(student2);
		repository.save(student3);

		//crear un profesores
		Teacher teacher1 = new Teacher(null, "Nahuel", "Ferrero", "2664790945", "Barrio los ranqueles", "Masculino", "DNI", "40722348", LocalDate.of(1978, 10, 21), List.of("Maestria empatica", "Doctorado en pedagogia"),List.of("Profesorado de Matematica", "Profesorado en teologia"),Set.of(course1, course2, course3));
		Teacher teacher2 = new Teacher(null, "Emilia", "Conrado", "2664860945", "Barrio los ranqueles", "Masculino", "DNI", "40722321", LocalDate.of(1989, 10, 21), List.of("Empatia", "Curso de Oratoria", "Doctorado en pedagogia"),List.of("Profesorado de Ciencias Naturales"),Set.of(course4));

		teacherRepository.save(teacher1);
		teacherRepository.save(teacher2);
	}
}
