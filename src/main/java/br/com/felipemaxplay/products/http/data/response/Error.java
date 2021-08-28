package br.com.felipemaxplay.products.http.data.response;

import org.springframework.lang.NonNull;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class Error {

    private final String code;
    private final String message;
    private final String documentation;

    public Error(@NonNull String code, @NonNull String message, @NonNull String urlDocumentation) {
        this.code = Objects.requireNonNull(code);
        this.message = Objects.requireNonNull(message);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        this.documentation = url + urlDocumentation;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDocumentation() {
        return documentation;
    }
}
