package net.jxtremeog.extendedmod.integration;

public enum WorkbenchShapedIngredientLocation {
    //NOTE RECIPE INGREDIENT LISTS RECORD AIR SPOTS)
    //TIER ONE
    ZIRCON_FROM_ZIRCON("036"),
    GOLDEN_HOE("013467"),
    GOLDEN_SHOVEL("147"),
    GOLDEN_SWORD("147"),
    GOLDEN_PICKAXE("01234567"),
    GOLDEN_AXE("013467"),
    IRON_HOE("013467"),
    IRON_SHOVEL("147"),
    IRON_SWORD("147"),
    IRON_PICKAXE("01234567"),
    IRON_AXE("013467"),
    CHAINMAIL_BOOTS("345678"),
    CHAINMAIL_LEGGINGS("012345678"),
    CHAINMAIL_CHESTPLATE("012345678"),
    CHAINMAIL_HELMET("012345"),
    CROSSBOW("012345678"),
    SHIELD("012345678"),
    WORKBENCH_TWO("012345678"),
    WORKBENCH_TWO_BLUEPRINT("012345"),

    //TIER TWO
    TEST_TWO2("036"),
    DIAMOND_HOE("013467"),
    DIAMOND_SHOVEL("147"),
    DIAMOND_SWORD("147"),
    DIAMOND_PICKAXE("01234567"),
    DIAMOND_AXE("013467"),
    GOLDEN_BOOTS("345678"),
    GOLDEN_LEGGINGS("012345678"),
    GOLDEN_CHESTPLATE("012345678"),
    GOLDEN_HELMET("012345"),
    IRON_BOOTS("345678"),
    IRON_LEGGINGS("012345678"),
    IRON_CHESTPLATE("012345678"),
    IRON_HELMET("012345"),
    WORKBENCH_THREE("012345678"),
    WORKBENCH_THREE_BLUEPRINT("012345"),

    //TIER THREE
    DIAMOND_BOOTS("345678"),
    DIAMOND_LEGGINGS("012345678"),
    DIAMOND_CHESTPLATE("012345678"),
    DIAMOND_HELMET("012345"),
    TEST_THREE2("036");

    private final String slotLocations;

    WorkbenchShapedIngredientLocation(String slotLocations){
        this.slotLocations = slotLocations;
    }

    public String getSlotLocations() {
        return slotLocations;
    }
}