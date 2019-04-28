package com.example.hellojava8.optional;

import java.util.Optional;

public class OptionalUsage {

    public static void main(String[] args) {

//        Optional<Insurance> insuranceOptional1 = Optional.<Insurance>empty();
//        insuranceOptional1.get();

        Optional<Insurance> insuranceOptional2 = Optional.of(new Insurance());
        insuranceOptional2.get();

        Optional<Insurance> objectOptional = Optional.ofNullable(null);
        objectOptional.orElseGet(Insurance::new);

        objectOptional.orElse(new Insurance());

        objectOptional.orElseThrow(RuntimeException::new);

        objectOptional.orElseThrow(() -> new RuntimeException("not found exception"));



    }
}
