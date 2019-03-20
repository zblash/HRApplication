package com.yusufcancelik.demo.DTO;

import com.yusufcancelik.demo.Validations.ValidResume;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ApplicantDTO {

    @NotEmpty(message = "İsim Boş Geçilemez")
    private String name;

    @Email(message = "Email Geçerli Değil")
    @NotEmpty(message = "Email Boş Geçilemez")
    private String email;

    @NotEmpty(message = "Telefon Numarası Boş Geçilemez")
    private String Phone;

    @NotEmpty(message = "Adres Boş Geçilemez")
    private String address;

    @NotEmpty(message = "Ön Yazı Boş Geçilemez")
    private String thoughts;

    @NotNull
    @ValidResume
    private MultipartFile file;

    @NotNull
    private Long jobId;
}
