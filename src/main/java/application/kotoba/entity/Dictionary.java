package application.kotoba.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "dictionaries")
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String language;


    @Column(name = "userId", nullable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "userId", insertable=false, updatable=false)
    private User user;

    @OneToMany(mappedBy = "dictionary")
    private Set<Word> words;


}
