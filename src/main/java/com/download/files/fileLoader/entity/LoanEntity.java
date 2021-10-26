package com.download.files.fileLoader.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "loan")
public class LoanEntity implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inn")
    private String inn;

    @Column(name = "sum")
    private Long sum;
}
