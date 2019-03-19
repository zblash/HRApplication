package com.yusufcancelik.demo.DTO;

import com.yusufcancelik.demo.Models.Job;
import com.yusufcancelik.demo.Validations.ValidResume;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ApplicantDTO {

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

    @NotNull
    @ValidResume
    private MultipartFile file;

    @NotNull
    private Long jobId;
}
