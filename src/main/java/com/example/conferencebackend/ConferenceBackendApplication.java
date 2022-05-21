package com.example.conferencebackend;

import com.example.conferencebackend.models.Lecture;
import com.example.conferencebackend.repository.LectureRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ConferenceBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConferenceBackendApplication.class, args);

		LectureRepository lectureRepository = configurableApplicationContext.getBean(LectureRepository.class);
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
		Lecture lecture1 = new Lecture();
		lecture1.setSubject("Subject1");
		lecture1.setStartTime("10:00");
		lecture1.setEndTime("11:45");
		Lecture lecture2 = new Lecture();
		lecture2.setSubject("Subject2");
		lecture2.setStartTime("10:00");
		lecture2.setEndTime("11:45");
		Lecture lecture3 = new Lecture();
		lecture3.setSubject("Subject3");
		lecture3.setStartTime("10:00");
		lecture3.setEndTime("11:45");

		List<Lecture> lectures = new ArrayList<>();
		lectures.add(lecture1);
		lectures.add(lecture2);
		lectures.add(lecture3);
		lectureRepository.saveAll(lectures);
//
//		bartek.registerInLecture(lecture1);
//		bartek.registerInLecture(lecture2);
//		ania.registerInLecture(lecture1);
//		tomek.registerInLecture(lecture2);
//
//		userRepository.saveAll(users);

	}

}
