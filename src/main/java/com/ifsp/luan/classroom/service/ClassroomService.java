package com.ifsp.luan.classroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifsp.luan.classroom.model.Classroom;
import com.ifsp.luan.classroom.repository.ClassroomRepository;


@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public Optional<Classroom> getClassroomById(String id) {
        return classroomRepository.findById(id);
    }

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }
}
