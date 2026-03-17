package com.example.TaskManager.exception;

import com.example.TaskManager.models.Priority;
import com.example.TaskManager.models.Status;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @Getter @Setter
    private LocalDateTime ldt;

    @Getter @Setter
    private int status;

    @Getter @Setter
    private String msg;

    @Getter @Setter
    private String error;
    
    @Getter @Setter
    private String path;

    public ErrorResponse(int value, String notFound, String message, String description) {}

}
