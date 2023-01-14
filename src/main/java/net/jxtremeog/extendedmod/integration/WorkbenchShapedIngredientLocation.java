package net.jxtremeog.extendedmod.integration;

public enum WorkbenchShapedIngredientLocation {
    ZIRCON_FROM_ZIRCON("036");

    private final String slotLocations;

    WorkbenchShapedIngredientLocation(String slotLocations){
        this.slotLocations = slotLocations;
    }

    public String getSlotLocations() {
        return slotLocations;
    }
}
