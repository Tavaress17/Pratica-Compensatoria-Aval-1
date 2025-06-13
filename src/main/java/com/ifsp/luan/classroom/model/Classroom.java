package com.ifsp.luan.classroom.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "classrooms")
@Getter @Setter
public class Classroom {
    
    @Id
    private String id;
    private String description;
    private String block;
    private String floor;
    private Integer capacity;
    private String observation;

    public Classroom(String description, String block, String floor, Integer capacity, String observation) {
        this.description = description;
        this.block = block;
        this.floor = floor;
        this.capacity = capacity;
        this.observation = observation;
    }
}
