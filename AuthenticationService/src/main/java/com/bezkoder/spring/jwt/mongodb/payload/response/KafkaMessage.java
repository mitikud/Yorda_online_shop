package com.bezkoder.spring.jwt.mongodb.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KafkaMessage {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
}
