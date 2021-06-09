package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private StudentService service; // Has-A Relationship

	@PostMapping("/save")
	public ResponseEntity<String> saveSudent(@RequestBody Student st) {
		ResponseEntity<String> resp = null;
		try {
			Integer saveStudent = service.saveStudent(st);
			resp = new ResponseEntity<String>("Student Record save" + saveStudent, HttpStatus.OK);

		} catch (Exception e) {
			resp = new ResponseEntity<>("Unable to save student Record", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;

	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneStudent(@PathVariable Integer id) {
		ResponseEntity<?> resp = null;
		try {
			Optional<Student> oneStudent = service.getOneStudent(id);
			if (oneStudent.isPresent()) {
				resp = new ResponseEntity<Student>(oneStudent.get(), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<String>("No Data Found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable to fetch the Record", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllStudents() {
		ResponseEntity<?> resp = null;
		try {
			List<Student> allStudent = service.getAllStudent();
			if (!allStudent.isEmpty() && allStudent != null) {
				resp = new ResponseEntity<>(allStudent, HttpStatus.OK);

			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable to fetch the data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		ResponseEntity<String> resp = null;
		try {
			boolean exist = service.isExist(id);
			if (exist) {
				service.deletStudent(id);
				resp = new ResponseEntity<String>("Sucess" + id + "removed", HttpStatus.OK);

			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable to delete the recodr" + id, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student st) {
		ResponseEntity<String> resp = null;
		try {
			boolean exist = service.isExist(st.getId());
			if (exist) {
				Integer saveStudent = service.saveStudent(st);
				resp = new ResponseEntity<String>("Student recored is updated", HttpStatus.OK);

			} else {
				resp = new ResponseEntity<String>("Student Id is not exist", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable update the student record", HttpStatus.INTERNAL_SERVER_ERROR);
		e.printStackTrace();
		}
		return resp;

	}

}
