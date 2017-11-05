package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books", schema = "ksiegarnia")
public class BooksEntity {
    @Column(name = "Title")
    private String title;
    @Column(name = "Author")
    private String author;
    @Column(name = "Published")
    private Date published;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "Category")
    private String category;
    @Column(name = "Page_Count")
    private Integer pageCount;
    @Column(name = "Publisher", updatable = false, insertable = false)
    private String publisher;
    @Column(name = "Price")
    private BigDecimal price;
    @Column(name = "On_Stock")
    private Integer onStock;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


}
