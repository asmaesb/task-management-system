package com.tms.backend.models;

import jakarta.persistence.*;

public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User belongsTo;

    private int totalTasks;
    private int finishedTasks;

    // Add other report metrics like completion rate
    // Completion average time etc..
}
