package sk.viawebtour.www.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sk.viawebtour.www.domain.User;

@Component
public class UserNameValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	User user = (User) target;
        if (StringUtils.isEmpty(user.getId())) {
            errors.rejectValue("empty", "user.error.name.empty");
        }
    }
}
