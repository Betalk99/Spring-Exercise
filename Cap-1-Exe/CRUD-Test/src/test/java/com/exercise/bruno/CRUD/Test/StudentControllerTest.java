package com.exercise.bruno.CRUD.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.exercise.bruno.CRUD.Test.controllers.StudentController;
import com.exercise.bruno.CRUD.Test.entities.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;


@SpringBootTest
@TestPropertySource(value = {"classpath:application-test.properties"})
@AutoConfigureMockMvc
class StudentControllerTest {

	@Autowired
	private StudentController studentController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private Student createStudentNew() throws Exception {
		Student student = new Student();
		student.setName("Bruno");
		student.setSurname("Orlandi");
		student.setIsWorking(false);

		return createStudentNewa(student);
	}

	private Student createStudentNewa(Student student) throws Exception {
		MvcResult result = createAStudent();
		Student student1 = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);

		return student1;
	}

	private MvcResult createAStudent() throws Exception {
		Student student = new Student();
		student.setName("Bruno");
		student.setSurname("Orlandi");
		student.setIsWorking(false);

		if(student == null) return null;

		String studentJSON = objectMapper.writeValueAsString(student);


		return this.mockMvc.perform(post("/v1/student/create").contentType(MediaType.APPLICATION_JSON).content(studentJSON)).andDo(print()).andExpect(status().isOk()).andReturn();


	}

	private Student getStudentFromId(Long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/v1/student/list/"+id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		if(result.getResponse().getContentLength() == 0)
			return null;

		return objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
	}

	@Test
	void controllerNotNull() {
		assertThat(studentController).isNotNull();
	}

	@Test
	void createUser() throws Exception {
		Student student = new Student();
		student.setName("Bruno");
		student.setSurname("Orlandi");
		student.setIsWorking(false);

		String studentJSON = objectMapper.writeValueAsString(student);


		MvcResult result = this.mockMvc.perform(post("/v1/student/create").contentType(MediaType.APPLICATION_JSON).content(studentJSON)).andDo(print()).andExpect(status().isOk()).andReturn();


		Student student1 = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);

		assertThat(student1.getId()).isNotNull();


	}

	@Test
	void readeUser() throws Exception {
		createAStudent();

		MvcResult result = this.mockMvc.perform(get("/v1/student/list"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List<Student> student1 = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);

		assertThat(student1.size()).isNotZero();

	}

	@Test
	void readeUserID() throws Exception {
		Student student =createStudentNew();
		assertThat(student.getId()).isNotNull();

		MvcResult result = this.mockMvc.perform(get("/v1/student/list/"+student.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student student1 = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);

		assertThat(student1.getId()).isEqualTo(student.getId());

	}


	@Test
	void updateUser() throws Exception{
		Student student =createStudentNew();
		assertThat(student.getId()).isNotNull();

		Boolean newStatus = true;
		student.setIsWorking(newStatus);

		String studentJSON = objectMapper.writeValueAsString(student);


		MvcResult result = this.mockMvc.perform(patch("/v1/student/upgrade/"+student.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(studentJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();


		Student student1 = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(student1.getId()).isEqualTo(student.getId());
		assertThat(student1.getName()).isEqualTo(student.getName());
		assertThat(student1.getIsWorking()).isEqualTo(true);


	}





	@Test
	void deleteUser() throws Exception{
		Student student =createStudentNew();
		assertThat(student.getId()).isNotNull();

		this.mockMvc.perform(delete("/v1/student/delete/"+student.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student student1 = getStudentFromId(student.getId());

		assertThat(student1).isNull();

	}






}
