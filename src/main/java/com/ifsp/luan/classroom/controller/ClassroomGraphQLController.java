package com.ifsp.luan.classroom.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ifsp.luan.classroom.model.Classroom;
import com.ifsp.luan.classroom.repository.ClassroomRepository;

@Controller
public class ClassroomGraphQLController {
    private final ClassroomRepository classroomRepository;

    public ClassroomGraphQLController(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @QueryMapping
    public List<Classroom> classrooms() {
        return classroomRepository.findAll();
    }

    @QueryMapping
    public Classroom classroom(@Argument String id) {
        return classroomRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Classroom createClassroom(
        @Argument String description,
        @Argument String block,
        @Argument String floor,
        @Argument Integer capacity,
        @Argument String observation
    ) {
        Classroom classroom = new Classroom(null, description, block, floor, capacity, observation);
        return classroomRepository.save(classroom);
    }
}
