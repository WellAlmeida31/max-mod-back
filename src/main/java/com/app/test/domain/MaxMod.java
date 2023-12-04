package com.app.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "max_mod",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"number_x", "number_y", "number_n"})})
public class MaxMod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number_x", nullable = false)
    private Integer x;
    @Column(name = "number_y", nullable = false)
    private Integer y;
    @Column(name = "number_n", nullable = false)
    private Integer n;
    @Column(name = "max_mod")
    private Integer K;
}
