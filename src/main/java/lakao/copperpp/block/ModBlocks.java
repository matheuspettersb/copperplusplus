package lakao.copperpp.block;

import lakao.copperpp.CopperPlusPlus;
import lakao.copperpp.block.custom.CopperSmelterBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    private static final Block COPPPER_SMELTER = registerBlock("copper_smelter",
            new CopperSmelterBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CopperPlusPlus.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(CopperPlusPlus.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void addItemsToGroup(FabricItemGroupEntries entries) {
        entries.add(COPPPER_SMELTER);
    }

    public static void registerModBlocks() {
        CopperPlusPlus.LOGGER.info("Registering mod blocks for " + CopperPlusPlus.MOD_ID);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addItemsToGroup);

    }
}
