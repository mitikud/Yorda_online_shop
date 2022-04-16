package com.bezkoder.spring.jwt.mongodb.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document(collection = "user")
@TypeAlias("Customer")
public class Customer extends User {
}
