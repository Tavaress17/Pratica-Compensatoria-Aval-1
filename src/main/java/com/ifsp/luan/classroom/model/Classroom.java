package com.ifsp.luan.classroom.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "classrooms")
@Getter @Setter
public class Classroom {
    
    @Id
    private String id;
    private String name;
    private String capacity;
    private String observation;
    
    public Classroom(String name, String capacity, String observation) {
        this.name = name;
        this.capacity = capacity;
        this.observation = observation;
    }

}
