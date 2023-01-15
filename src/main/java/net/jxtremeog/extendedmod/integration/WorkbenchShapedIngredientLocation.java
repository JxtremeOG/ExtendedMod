package net.jxtremeog.extendedmod.integration;

public enum WorkbenchShapedIngredientLocation {
    //TIER ONE
    ZIRCON_FROM_ZIRCON("036"),

    //TIER TWO
    TEST_TWO2("036"),

    //TIER THREE
    TEST_THREE2("036");
    private final String slotLocations;

    WorkbenchShapedIngredientLocation(String slotLocations){
        this.slotLocations = slotLocations;
    }

    public String getSlotLocations() {
        return slotLocations;
    }
}
