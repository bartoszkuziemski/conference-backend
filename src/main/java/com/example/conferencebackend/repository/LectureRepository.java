package com.example.conferencebackend.repository;

import com.example.conferencebackend.models.Lecture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends CrudRepository<Lecture, Long> {
}
