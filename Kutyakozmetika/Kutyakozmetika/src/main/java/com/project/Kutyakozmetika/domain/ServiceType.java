package com.project.Kutyakozmetika.domain;

import lombok.Getter;

@Getter
public enum ServiceType {
    SHEARING("Nyírás"),
    TRIMMING("Trimmelés"),
    COMBING("Fésülés");

    private String displayName;

    ServiceType(String displayName) {
        this.displayName = displayName;
    }
}
