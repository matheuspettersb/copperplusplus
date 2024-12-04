package lakao.copperpp.item;

import lakao.copperpp.CopperPlusPlus;
import lakao.copperpp.item.custom.CopperHookItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CopperPlusPlus.MOD_ID, name), item);
    }

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new Item(new FabricItemSettings()));
    public static final Item COPPER_HELMET = registerItem("copper_helmet", new Item(new FabricItemSettings()));

    public static final Item COPPER_HOOK = registerItem("copper_hook", new CopperHookItem(new FabricItemSettings().maxDamage(64)));

    public static void addItemsToToolGroup(FabricItemGroupEntries entries) {
        entries.add(COPPER_PICKAXE);
        entries.add(COPPER_HOOK);
    }

    public static void addItemsToCombatGroup(FabricItemGroupEntries entries) {
        entries.add(COPPER_HELMET);
    }

    public static void registerModItems() {
        CopperPlusPlus.LOGGER.info("Registering mod items for " + CopperPlusPlus.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatGroup);
    }

}
