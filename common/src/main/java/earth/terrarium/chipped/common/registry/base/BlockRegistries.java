package earth.terrarium.chipped.common.registry.base;

import com.mojang.datafixers.util.Pair;
import com.teamresourceful.resourcefullib.common.lib.Constants;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import earth.terrarium.chipped.common.blocks.DirectionBlock;
import earth.terrarium.chipped.common.blocks.SpecialLanternBlock;
import earth.terrarium.chipped.common.items.ChippedBlockItemProperties;
import earth.terrarium.chipped.common.palette.IdType;
import earth.terrarium.chipped.common.palette.Palette;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModItems;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Locale;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegistries {

    public static final Function<BlockBehaviour.Properties, Block> DEFAULT_CREATOR = Block::new;

    public static ChippedPaletteRegistry createRegistry(Block ref, Palette palette) {
        return createRegistry(ref, palette, DEFAULT_CREATOR);
    }

    public static ChippedPaletteRegistry createRegistry(Block ref, Palette palette, Supplier<Item.Properties> itemProperties) {
        return createRegistry(ref, palette, DEFAULT_CREATOR, itemProperties);
    }

    public static ChippedPaletteRegistry createRegistry(Block ref, Palette palette, Function<BlockBehaviour.Properties, Block> blockType) {
        return createRegistry(ref, palette, blockType, BlockItem::new, ChippedBlockItemProperties::model);
    }

    public static ChippedPaletteRegistry createRegistry(Block ref, Palette palette, Function<BlockBehaviour.Properties, Block> blockType, Supplier<Item.Properties> itemProperties) {
        return createRegistry(ref, palette, blockType, BlockItem::new, itemProperties);
    }

    public static ChippedPaletteRegistry createRegistry(Block ref, Palette palette, Function<BlockBehaviour.Properties, Block> blockType, BiFunction<Block, Item.Properties, BlockItem> itemType, Supplier<Item.Properties> itemProperties) {
        var registry = new ChippedPaletteRegistry(ModBlocks.BLOCKS, ref, palette);
        for (var entry : palette.ids()) {
            String id = entry.getSecond().replace("%", BuiltInRegistries.BLOCK.getKey(ref).getPath().toLowerCase(Locale.ROOT));
            IdType type = Objects.requireNonNull(entry.getFirst());
            if (type == IdType.PILLAR) {
                if (blockType != DEFAULT_CREATOR) {
                    Constants.LOGGER.error("ID: {}, Reference: {}, Palette: {}", id, BuiltInRegistries.BLOCK.getKey(ref).getPath(), palette);
                    throw new IllegalArgumentException("Cannot use custom block type with non-default id type");
                }
                registry.registerWithBaseProperties(id, RotatedPillarBlock::new);
            } else if (type == IdType.DIRECTIONAL) {
                registry.registerWithBaseProperties(id, DirectionBlock::new);
            } else {
                registry.registerWithBaseProperties(id, blockType);
            }
        }
        ModItems.createItemRegistry(registry, itemType, itemProperties);
        return registry;
    }

    public static ChippedPaletteRegistry createDyedRegistry(Block ref, Palette palette, BiFunction<DyeColor, BlockBehaviour.Properties, Block> blockType) {
        return createDyedRegistry(ref, palette, blockType, ChippedBlockItemProperties::model);
    }

    public static ChippedPaletteRegistry createDyedRegistry(Block ref, Palette palette, BiFunction<DyeColor, BlockBehaviour.Properties, Block> blockType, Supplier<Item.Properties> itemProperties) {
        var color = ref instanceof BeaconBeamBlock colorable ? colorable.getColor() : DyeColor.WHITE;
        return createRegistry(ref, palette, properties -> blockType.apply(color, properties), BlockItem::new, itemProperties);
    }

    public static Pair<ChippedPaletteRegistry, ChippedPaletteRegistry> createTorchRegistry(Block ref1, Block ref2, Palette palette, BiFunction<SimpleParticleType, BlockBehaviour.Properties, Block> blockType1, BiFunction<SimpleParticleType, BlockBehaviour.Properties, Block> blockType2) {
        var standingRegistry = new ChippedPaletteRegistry(ModBlocks.BLOCKS, ref1, palette);
        var wallRegistry = new ChippedPaletteRegistry(ModBlocks.BLOCKS, ref2, palette);
        var itemRegistry = ResourcefulRegistries.createForItems(ModItems.ITEMS);

        for (String s : palette) {
            var standingId = s.replace("%", BuiltInRegistries.BLOCK.getKey(ref1).getPath().toLowerCase(Locale.ROOT));
            var standingTorch = standingRegistry.registerWithBaseProperties(standingId, (properties) -> blockType1.apply(ParticleTypes.FLAME, properties));

            var wallId = s.replace("%", BuiltInRegistries.BLOCK.getKey(ref2).getPath().toLowerCase(Locale.ROOT));
            var wallTorch = wallRegistry.registerWithBaseProperties(wallId, (properties) -> blockType2.apply(ParticleTypes.FLAME, properties));

            itemRegistry.register(
                standingTorch.getId().getPath(),
                properties -> new StandingAndWallBlockItem(standingTorch.get(), wallTorch.get(), Direction.DOWN, properties),
                ChippedBlockItemProperties::model
            );
        }

        return Pair.of(standingRegistry, wallRegistry);
    }

    public static ChippedPaletteRegistry registerSpecialLanterns(String block, Palette palette) {
        var registry = new ChippedPaletteRegistry(ModBlocks.BLOCKS, Blocks.LANTERN, palette);
        registry.registerWithBaseProperties(palette.get(0).replace("%", block), (properties) -> new SpecialLanternBlock(properties, SpecialLanternBlock.CHONK_LANTERN_SHAPE));
        registry.registerWithBaseProperties(palette.get(1).replace("%", block), (properties) -> new SpecialLanternBlock(properties, SpecialLanternBlock.DONUT_LANTERN_SHAPE_EAST, SpecialLanternBlock.DONUT_LANTERN_SHAPE_NORTH));
        registry.registerWithBaseProperties(palette.get(2).replace("%", block), (properties) -> new SpecialLanternBlock(properties, SpecialLanternBlock.TALL_LANTERN_SHAPE));
        registry.registerWithBaseProperties(palette.get(3).replace("%", block), (properties) -> new SpecialLanternBlock(properties, SpecialLanternBlock.THICC_LANTERN_SHAPE));
        ModItems.createItemRegistry(registry, BlockItem::new, ChippedBlockItemProperties::model);
        return registry;
    }

    public static ChippedPaletteRegistry registerBorderlessBricks(String block, Palette palette) {
        var registry = new ChippedPaletteRegistry(ModBlocks.BLOCKS, Blocks.BRICKS, block, palette);
        for (var entry : palette.ids()) {
            String id = entry.getSecond().replace("%", block);
            if (Objects.requireNonNull(entry.getFirst()) == IdType.PILLAR) {
                registry.registerWithBaseProperties(id, RotatedPillarBlock::new);
            } else {
                registry.registerWithBaseProperties(id, Block::new);
            }
        }
        ModItems.createItemRegistry(registry, BlockItem::new, ChippedBlockItemProperties::model);
        return registry;
    }
}
