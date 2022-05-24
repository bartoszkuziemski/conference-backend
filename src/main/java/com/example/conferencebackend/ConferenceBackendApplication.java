package com.example.conferencebackend;

import com.example.conferencebackend.models.Lecture;
import com.example.conferencebackend.models.Room;
import com.example.conferencebackend.repository.LectureRepository;
import com.example.conferencebackend.repository.RoomRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConferenceBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConferenceBackendApplication.class, args);

		LectureRepository lectureRepository = configurableApplicationContext.getBean(LectureRepository.class);

		Lecture lecture1 = new Lecture("Java");
		Lecture lecture2 = new Lecture("Python");
		Lecture lecture3 = new Lecture("C++");
		Lecture lecture4 = new Lecture("Java");
		Lecture lecture5 = new Lecture("Python");
		Lecture lecture6 = new Lecture("C++");
		Lecture lecture7 = new Lecture("Java");
		Lecture lecture8 = new Lecture("Python");
		Lecture lecture9 = new Lecture("C++");

//		List<Lecture> lectures1 = new ArrayList<>();
//		lectures1.add(lecture1);
//		lectures1.add(lecture2);
//		lectures1.add(lecture3);
//		lectureRepository.saveAll(lectures1);
		lectureRepository.save(lecture1);
		lectureRepository.save(lecture2);
		lectureRepository.save(lecture3);
		lectureRepository.save(lecture4);
		lectureRepository.save(lecture5);
		lectureRepository.save(lecture6);
		lectureRepository.save(lecture7);
		lectureRepository.save(lecture8);
		lectureRepository.save(lecture9);

		RoomRepository roomRepository = configurableApplicationContext.getBean(RoomRepository.class);

		Room roomA = new Room("10:00", "11:45");
		Room roomB = new Room("12:00", "13:45");
		Room roomC = new Room("14:00", "15:45");

		roomA.addLecture(lecture1);
		roomA.addLecture(lecture2);
		roomA.addLecture(lecture3);
		roomB.addLecture(lecture4);
		roomB.addLecture(lecture5);
		roomB.addLecture(lecture6);
		roomC.addLecture(lecture7);
		roomC.addLecture(lecture8);
		roomC.addLecture(lecture9);

		roomRepository.save(roomA);
		roomRepository.save(roomB);
		roomRepository.save(roomC);


	}

}
