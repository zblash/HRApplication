package com.yusufcancelik.demo.Validations;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ResumeValidator implements ConstraintValidator<ValidResume, MultipartFile> {

    @Override
    public void initialize(ValidResume constraintAnnotation) {

    }


    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {

        if (isSupportedContentType(Objects.requireNonNull(multipartFile.getContentType()))) return true;
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
                "Sadece PDF uzantılı dosya ekleyebilirsiniz.")
                .addConstraintViolation();
        return false;
    }

    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("application/pdf");
    }
}

