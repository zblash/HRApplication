package com.yusufcancelik.demo.Models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "jobs")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Job implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private int numberofHire;

    @NotNull
    @DateTimeFormat(pattern="dd-MMM-YYYY")
    private Date lastApplicationDate;

    @OneToMany(mappedBy = "job",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Applicant> applicants;
}
