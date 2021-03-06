package com.WebMall.validation;

import com.WebMall.model.User;
import com.WebMall.service.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
            return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");

        if (user.getEmail().length() < 6 || user.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email");
        }

        if (userService.findByUsername(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
