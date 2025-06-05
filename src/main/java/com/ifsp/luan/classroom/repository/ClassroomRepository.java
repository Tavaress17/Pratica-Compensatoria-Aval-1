package com.ifsp.luan.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsp.luan.classroom.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, String> {}
