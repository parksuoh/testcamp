package com.camping.camping.dtos;

import com.camping.camping.domains.ProductSecondOption;
import com.camping.camping.domains.vo.Money;
import com.camping.camping.domains.vo.Name;
import com.camping.camping.domains.vo.SecondOptionName;
import com.querydsl.core.annotations.QueryProjection;

public class FindProductSecondOptionDto {

    private Long id;
    private SecondOptionName name;
    private Money addPrice;

    @QueryProjection
    public FindProductSecondOptionDto(Long id, SecondOptionName name, Money addPrice) {
        this.id = id;
        this.name = name;
        this.addPrice = addPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SecondOptionName getName() {
        return name;
    }

    public void setName(SecondOptionName name) {
        this.name = name;
    }

    public Money getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(Money addPrice) {
        this.addPrice = addPrice;
    }
}
