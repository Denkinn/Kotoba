package application.kotoba.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String writing;
    private String translation;
    private String pronunciation;

    @Column(name = "dictionaryId", nullable = false)
    private Long dictionaryId;
    @ManyToOne
    @JoinColumn(name = "dictionaryId", insertable=false, updatable=false)
    private Dictionary dictionary;
}
