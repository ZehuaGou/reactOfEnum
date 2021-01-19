package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public enum ConfirmEnum {

    //想要拿到这个通过
    PASS(1, "通过"),

    REFUSE(0, "驳回");

    private Integer code;

    private String desc;

    public static ConfirmEnum get(int code) {
        for (ConfirmEnum e : values()) {
            if (e.getValue().equals(code)) {
                return e;
            }
        }
        return null;
    }

    public Serializable getValue() {
        return this.code;
    }
}
