package com.yusufcancelik.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "applicants")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Applicant {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotEmpty
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String Phone;

    @NotBlank
    private String address;

    @NotBlank
    private String thoughts;

    private String resumeLink;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-M-yyyy")
    private Date applicationDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @JsonIgnore
    private Job job;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return Objects.equals(id, applicant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
