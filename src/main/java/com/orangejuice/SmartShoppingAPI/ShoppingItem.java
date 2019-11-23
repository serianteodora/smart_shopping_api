package com.orangejuice.SmartShoppingAPI;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@EqualsAndHashCode(exclude = {"name", "description"})
public class ShoppingItem {
    private UUID id;
    private String name;
    private String description;
}
