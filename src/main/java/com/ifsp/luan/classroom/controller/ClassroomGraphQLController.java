package com.ifsp.luan.classroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ifsp.luan.classroom.model.Classroom;
import com.ifsp.luan.classroom.repository.ClassroomRepository;

@Controller
public class ClassroomGraphQLController {
    @Autowired
    private ClassroomRepository classroomRepository;

    @QueryMapping
    public List<Classroom> classrooms() {
        return classroomRepository.findAll();
    }

    @QueryMapping
    public Classroom classroom(@Argument String id) {
        return classroomRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Classroom addClassroom(
        @Argument String name,
        @Argument String capacity,
        @Argument String observation
    ) {
        Classroom classroom = new Classroom(name, capacity, observation);
        return classroomRepository.save(classroom);
    }
}
