package earth.terrarium.chipped.datagen.provider.client;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.RedstoneWallTorchBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;

import java.util.Objects;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput pGenerator) {
        super(pGenerator, Chipped.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.chipped.main", "Chipped");

        ModBlocks.BLOCKS.stream().filter(e -> !(e.get() instanceof WallSignBlock || e.get() instanceof WallTorchBlock || e.get() instanceof RedstoneWallTorchBlock)).forEach(entry -> addBlock(entry, StringUtils.capitaliseAllWords(entry.getId().getPath().replace("_", " "))));
        ModItems.ITEMS.stream().filter(e -> !(e.get() instanceof BlockItem)).forEach(entry -> addItem(entry, StringUtils.capitaliseAllWords(Objects.requireNonNull(entry.getId()).getPath().replace("_", " "))));

        add("container.chipped.botanist_workbench", "Botanist's Workbench");
        add("container.chipped.glassblower", "Glassblower's Workbench");
        add("container.chipped.carpenters_table", "Carpenter's Workbench");
        add("container.chipped.loom_table", "Shepherd's Workbench");
        add("container.chipped.mason_table", "Mason's Workbench");
        add("container.chipped.alchemy_bench", "Alchemy Bench");
        add("container.chipped.tinkering_table", "Tinkering Table");
        add("container.chipped.workbench", "Workbench");

        add("text.chipped.preview", "Preview");
        add("text.chipped.craft", "Craft");
        add("text.chipped.craft_all", "Craft All");
        add("text.chipped.single", "Single");
        add("text.chipped.horizontal", "Horizontal");
        add("text.chipped.vertical", "Vertical");
        add("text.chipped.two_by_two", "Two by Two");
    }
}
