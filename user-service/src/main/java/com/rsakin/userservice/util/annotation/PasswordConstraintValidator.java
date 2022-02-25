package com.rsakin.userservice.util.annotation;

import com.rsakin.userservice.exception.NotValidPasswordException;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // Constraint rule set
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                // needs at least 8 characters and at most 100 chars
                new LengthRule(8, 100),
                // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                // at least one lower-case character
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                /