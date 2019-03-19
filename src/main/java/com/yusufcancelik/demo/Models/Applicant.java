package com.yusufcancelik.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String Phone;

    @NotNull
    private String address;

    @NotNull
    private String thoughts;

    private String resumeLink;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @JsonIgnore
    private Job job;
}
