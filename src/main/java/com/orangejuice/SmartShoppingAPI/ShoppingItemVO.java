package com.orangejuice.SmartShoppingAPI;

import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Builder
@Getter
public class ShoppingItemVO {
    private UUID id;
    private String name;
    private String description;
}

