package sk.viawebtour.www.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sk.viawebtour.www.domain.UserCreateForm;

@Component
public class UserCreateFormPasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserCreateForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        if (!form.getPassword1().equals(form.getPassword2())) {
            errors.rejectValue("password2", "user.error.password.no_match");
        }
    }
}
