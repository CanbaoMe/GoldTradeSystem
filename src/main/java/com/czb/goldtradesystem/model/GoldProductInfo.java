package com.czb.goldtradesystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "gold_product_info")
public class GoldProductInfo  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String productType;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "enterprise_rate")
    private BigDecimal enterpriseRate;

    @Column(name = "opr_time")
    private String oprTime;

}