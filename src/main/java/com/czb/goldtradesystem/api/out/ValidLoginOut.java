package com.czb.goldtradesystem.api.out;

import lombok.Data;

@Data
public class ValidLoginOut extends ResponseOut{
    private static final long serialVersionUID = 1L;

    String idCardNum;
}
