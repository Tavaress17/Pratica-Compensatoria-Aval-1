package com.ifsp.luan.classroom.service;

import java.util.List;

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

    public Classroom getClassroomById(String id) {
        return classroomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
    }

    public Classroom createClassroom(String description, String block, String floor, Integer capacity, String observation) {
        Classroom classroom = new Classroom(null, description, block, floor, capacity, observation);
        return classroomRepository.save(classroom);
    }

    public Classroom updateClassroom(String id, String description, String block, String floor, Integer capacity, String observation) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));

        if (description != null) classroom.setDescription(description);
        if (block != null) classroom.setBlock(block);
        if (floor != null) classroom.setFloor(floor);
        if (capacity != null) classroom.setCapacity(capacity);
        if (observation != null) classroom.setObservation(observation);

        return classroomRepository.save(classroom);
    }

    public boolean deleteClassroom(String id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));

        classroomRepository.delete(classroom);
        return true;
    }
}