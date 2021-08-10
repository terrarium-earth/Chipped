package com.grimbo.chipped.registry;

import com.grimbo.chipped.block.ChippedWoodType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ChippedBlockTypes {
    public static final List<GlassBlock> GLASSES = new ArrayList<>();
    public static final List<IronBarsBlock> GLASS_PANES = new ArrayList<>();
    public static final EnumMap<ChippedWoodType, List<GlassBlock>> WOOD_GLASSES = new EnumMap<>(ChippedWoodType.class);
    public static final EnumMap<ChippedWoodType, List<IronBarsBlock>> WOOD_GLASS_PANES = new EnumMap<>(ChippedWoodType.class);
    public static final EnumMap<DyeColor, List<StainedGlassBlock>> STAINED_GLASSES = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, List<StainedGlassPaneBlock>> STAINED_GLASS_PANES = new EnumMap<>(DyeColor.class);

    public static final List<VineBlock> VINES = new ArrayList<>();

    public static final List<Block> LANTERNS = new ArrayList<>();
    public static final List<Block> SOUL_LANTERNS = new ArrayList<>();

    public static final List<RedstoneTorchBlock> REDSTONE_TORCHES = new ArrayList<>();
    public static final List<TorchBlock> TORCHES = new ArrayList<>();
}
