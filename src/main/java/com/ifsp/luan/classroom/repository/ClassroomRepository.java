package com.ifsp.luan.classroom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ifsp.luan.classroom.model.Classroom;

public interface ClassroomRepository extends MongoRepository<Classroom, String> {}