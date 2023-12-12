package com.project.Kutyakozmetika.domain;

import lombok.Getter;

@Getter
public enum AnimalType {
    DOG("Kutya"),
    CAT("Cicuka"),
    BUNNY("Nyuszi-muszi");
    private final String displayName;

    AnimalType(String displayName) {
        this.displayName = displayName;
    }
}
