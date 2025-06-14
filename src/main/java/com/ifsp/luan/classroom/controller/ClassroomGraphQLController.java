package com.ifsp.luan.classroom.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ifsp.luan.classroom.model.Classroom;
import com.ifsp.luan.classroom.service.ClassroomService;

@Controller
public class ClassroomGraphQLController {

    private final ClassroomService classroomService;

    public ClassroomGraphQLController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @QueryMapping
    public List<Classroom> classrooms() {
        return classroomService.getAllClassrooms();
    }

    @QueryMapping
    public Classroom classroom(@Argument String id) {
        return classroomService.getClassroomById(id);
    }

    @MutationMapping
    public Classroom createClassroom(
        @Argument String description,
        @Argument String block,
        @Argument String floor,
        @Argument Integer capacity,
        @Argument String observation
    ) {
        return classroomService.createClassroom(description, block, floor, capacity, observation);
    }

    @MutationMapping
    public Classroom updateClassroom(
        @Argument String id,
        @Argument String description,
        @Argument String block,
        @Argument String floor,
        @Argument Integer capacity,
        @Argument String observation
    ) {
        return classroomService.updateClassroom(id, description, block, floor, capacity, observation);
    }

    @MutationMapping
    public Boolean deleteClassroom(@Argument String id) {
        return classroomService.deleteClassroom(id);
    }
}