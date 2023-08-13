package ru.maxima.finalproject.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Authorities {

    @SuppressWarnings("InstantiationOfUtilityClass")
    @Getter
    private static final Authorities instance = new Authorities();

    private static final String ROLE_ADMIN = "Admin";
    private static final String ROLE_USER = "User";

}
