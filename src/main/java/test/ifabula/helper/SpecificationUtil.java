package test.ifabula.helper;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import test.ifabula.contant.GlobalMessage;
import test.ifabula.exception.BusinessException;

public final class SpecificationUtil {

    private SpecificationUtil() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static <T> Specification<T> searchAttributeBoolean(String attribute, Boolean value) {
        return (root, query, cb) -> {
            if (ObjectUtils.isEmpty(value)) {
                return null;
            }
            return cb.equal(root.get(attribute), value);
        };
    }

    public static <T> Specification<T> searchAttributeObject(String attribute, Object object) {
        return (root, query, cb) -> {
            if (ObjectUtils.isEmpty(object)) {
                return null;
            }
            return cb.equal(root.get(attribute), object);
        };
    }
}
