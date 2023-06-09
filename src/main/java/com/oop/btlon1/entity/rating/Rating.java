package com.oop.btlon1.entity.rating;


import com.oop.btlon1.entity.product.Book;
import com.oop.btlon1.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    private String id;
    private float star;
    private String comment;
    private User user;
    private Book book;
    private LocalDate localDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
