package model;

import model.enums.*;
import model.enums.ModuleType;

import java.util.*;

public class Score {
    private UUID id;
    private String name;
    private int quantity;
    private ModuleType moduleType;

    public Score() {
        this.id = UUID.randomUUID();
    }

    public Score(String name, ModuleType moduleType, int quantity) {
        this();
        this.name = name;
        this.moduleType = moduleType;
        this.quantity = quantity;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
