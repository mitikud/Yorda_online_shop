package com.yordaonline.shoppingCart.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class ShoppingCart {
    @Id
    private String id;

    private @NonNull String customerId;
    private List<Product> products = new ArrayList<>();


}
