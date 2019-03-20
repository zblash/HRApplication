package com.yusufcancelik.demo.Models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotNull
    private Integer numberofHire;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat (pattern="dd-M-yyyy")
    private Date lastApplicationDate;

    @OneToMany(mappedBy = "job",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<Applicant> applicants;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
