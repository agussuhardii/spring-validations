package com.agussuhardi.springvalidation;

import com.agussuhardi.springvalidation.costumevalidation.RegisterCodeConstraints;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * @author agus.suhardii@gmail.com
 * @created 13/06/23/06/2023 :21.25
 * @project spring-validation
 */
public record UserVO(

        @NotNull
        @NotEmpty
        String fullName,

        @NotNull
        @NotEmpty
        @RegisterCodeConstraints
        String registerCode,

        String address


) {
}
