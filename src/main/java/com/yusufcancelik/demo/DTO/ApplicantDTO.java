package com.yusufcancelik.demo.DTO;

import com.yusufcancelik.demo.Validations.ValidResume;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ApplicantDTO {

    @NotBlank(message = "İsim Boş Geçilemez")
    private String name;

    @Email(message = "Email Geçerli Değil")
    @NotBlank(message = "Email Boş Geçilemez")
    private String email;

    @NotBlank(message = "Telefon Numarası Boş Geçilemez")
    private String Phone;

    @NotBlank(message = "Adres Boş Geçilemez")
    private String address;

    @NotBlank(message = "Ön Yazı Boş Geçilemez")
    private String thoughts;

    @NotNull
    @ValidResume
    private MultipartFile file;

    @NotNull
    private Long jobId;
}
