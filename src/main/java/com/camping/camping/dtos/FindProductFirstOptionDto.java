package com.camping.camping.dtos;

import com.camping.camping.domains.vo.FirstOptionName;
import com.camping.camping.domains.vo.Money;
import com.camping.camping.domains.vo.Name;
import com.querydsl.core.annotations.QueryProjection;

public class FindProductFirstOptionDto {

    private Long id;
    private FirstOptionName name;
    private Money addPrice;

    @QueryProjection

    public FindProductFirstOptionDto(Long id, FirstOptionName name, Money addPrice) {
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

    public FirstOptionName getName() {
        return name;
    }

    public void setName(FirstOptionName name) {
        this.name = name;
    }

    public Money getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(Money addPrice) {
        this.addPrice = addPrice;
    }
}
