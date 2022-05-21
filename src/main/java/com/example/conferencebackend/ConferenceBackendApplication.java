package com.example.conferencebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConferenceBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConferenceBackendApplication.class, args);

//		LectureRepository lectureRepository = configurableApplicationContext.getBean(LectureRepository.class);
//		UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
//
//		User bartek = new User("bartek", "bartek@gmail.com");
//		User tomek = new User("tomek", "tomek@gmail.com");
//		User ania = new User("ania", "ania@gmail.com");
//
//		List<User> users = new ArrayList<>();
//		users.add(bartek);
//		users.add(tomek);
//		users.add(ania);
//
//		Lecture lecture1 = new Lecture("Math", LocalTime.of(10, 0), LocalTime.of(11, 45));
//		Lecture lecture2 = new Lecture("IT", LocalTime.of(12, 0), LocalTime.of(13, 45));
//		List<Lecture> lectures = new ArrayList<>();
//		lectures.add(lecture1);
//		lectures.add(lecture2);
//
//		lectureRepository.saveAll(lectures);
//
//		bartek.registerInLecture(lecture1);
//		bartek.registerInLecture(lecture2);
//		ania.registerInLecture(lecture1);
//		tomek.registerInLecture(lecture2);
//
//		userRepository.saveAll(users);

	}

}
