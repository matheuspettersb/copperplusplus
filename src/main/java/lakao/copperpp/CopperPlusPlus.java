package lakao.copperpp;

import lakao.copperpp.block.ModBlocks;
import lakao.copperpp.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperPlusPlus implements ModInitializer {
    public static final String MOD_ID = "copperpp";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        LOGGER.info("Hello Fabric world!");
    }
}