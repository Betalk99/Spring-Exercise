package com.exercise.bruno.unit.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.exercise.bruno.unit.test.controllers.UserController;
import com.exercise.bruno.unit.test.entities.UserEntity;
import com.exercise.bruno.unit.test.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.h2.engine.User;
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
class UserEntityControllerTest {

	@Autowired
	private UserController userController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private UserEntity createUserNew() throws Exception {
		UserEntity user = new UserEntity();
		user.setNome("Bruno");
		user.setCognome("Orlandi");

		return createUserNewa(user);
	}

	private UserEntity createUserNewa(UserEntity user) throws Exception {
		MvcResult result = createAUser();
		UserEntity user1 = objectMapper.readValue(result.getResponse().getContentAsString(), UserEntity.class);

		return user1;
	}

	private MvcResult createAUser() throws Exception {
		UserEntity user = new UserEntity();
		user.setNome("Bruno");
		user.setCognome("Orlandi");

		if(user == null) return null;

		String userJSON = objectMapper.writeValueAsString(user);

		return this.mockMvc.perform(post("/v1/users/create").contentType(MediaType.APPLICATION_JSON).content(userJSON)).andDo(print()).andExpect(status().isOk()).andReturn();

	}

	private UserEntity getUserFromId(Long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/v1/users/list/" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		if (result.getResponse().getContentLength() == 0)
			return null;

		return objectMapper.readValue(result.getResponse().getContentAsString(), UserEntity.class);
	}


		@Test
		void controllerNotNull () {
			assertThat(userController).isNotNull();
		}

		@Test
		void createUser () throws Exception {
			UserEntity user = new UserEntity();
			user.setNome("Bruno");
			user.setCognome("Orlandi");

			String userJSON = objectMapper.writeValueAsString(user);


			MvcResult result = this.mockMvc.perform(post("/v1/users/create").contentType(MediaType.APPLICATION_JSON)
					.content(userJSON)).andDo(print()).andExpect(status().isOk()).andReturn();

			UserEntity user1 = objectMapper.readValue(result.getResponse().getContentAsString(), UserEntity.class);

			assertThat(user1.getId()).isNotNull();

		}

		@Test
		void readeUser () throws Exception {
			createAUser();

			MvcResult result = this.mockMvc.perform(get("/v1/users/list"))
					.andDo(print())
					.andExpect(status().isOk())
					.andReturn();

			List<UserEntity> userEntityList = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);

			assertThat(userEntityList.size()).isNotZero();

		}

		@Test
		void readeUserID () throws Exception {
			UserEntity user = createUserNew();
			assertThat(user.getId()).isNotNull();

			MvcResult result = this.mockMvc.perform(get("/v1/users/list/" + user.getId()))
					.andDo(print())
					.andExpect(status().isOk())
					.andReturn();

			UserEntity user1 = objectMapper.readValue(result.getResponse().getContentAsString(), UserEntity.class);

			assertThat(user1.getId()).isEqualTo(user.getId());

		}

		@Test
		void updateUser () throws Exception {
			UserEntity user = createUserNew();
			assertThat(user.getId()).isNotNull();

			String newName = "Pippo";
			user.setNome(newName);

			String studentJSON = objectMapper.writeValueAsString(user);

			MvcResult result = this.mockMvc.perform(patch("/v1/users/update/" + user.getId())
							.contentType(MediaType.APPLICATION_JSON)
							.content(studentJSON))
					.andDo(print())
					.andExpect(status().isOk())
					.andReturn();


			UserEntity user1 = objectMapper.readValue(result.getResponse().getContentAsString(), UserEntity.class);
			assertThat(user1.getId()).isEqualTo(user.getId());
			assertThat(user1.getNome()).isEqualTo(user.getNome());

		}


		@Test
		void deleteUser () throws Exception {
			UserEntity user = createUserNew();
			assertThat(user.getId()).isNotNull();

			this.mockMvc.perform(delete("/v1/users/delete/" + user.getId()))
					.andDo(print())
					.andExpect(status().isOk())
					.andReturn();

			UserEntity user1 = getUserFromId(user.getId());

			assertThat(user1).isNull();

		}

	}


