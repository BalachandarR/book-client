package com.client.book.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
public class Book {

    private String bookId;
    private String bookName;
    private String author;
    private BigDecimal bookPrice;
}
