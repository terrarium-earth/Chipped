package com.grimbo.chipped.datagen;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedWoodType;
import com.grimbo.chipped.registry.ChippedBlocks;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RRPPreGenEntrypoint;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

import java.util.concurrent.TimeUnit;

public class ChippedDataGen implements RRPPreGenEntrypoint {
    private static final RuntimeResourcePack RRP = RuntimeResourcePack.create(new ResourceLocation(Chipped.MOD_ID, "datagen"));

    @Override
    public void pregen() {
        try { //Required to stop crash
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        block("stone", 18);
        block("granite", 18);
        block("diorite", 18);
        block("andesite", 18);
        block("prismarine", 18);
        block("dark_prismarine", 18);
        block("purpur_block", 18);
        block("cobblestone", 18);
        block("quartz_block", 18);
        block("sandstone", 18);
        block("red_sandstone", 18);
        block("nether_bricks", 18);
        block("red_nether_bricks", 18);
        block("end_stone", 18);
        block("netherrack", 18);

        block("gilded_blackstone", 26);
        block("blackstone", 21);
        block("basalt", 20);
        block("obsidian", 20);

        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            block(color + "_terracotta", 18);
            block(color + "_concrete", 18);
            block(color + "_wool", 18);
            blockState(color + "_carpet", 18);
            blockItemModel(color + "_carpet", 18);
            lootTable(color + "_carpet", 18);

            block(color + "_stained_glass", 8);
            lootTable(color + "_stained_glass_pane", 8);
        }

        block("crying_obsidian", 20);
        block("glowstone", 20);
        block("sea_lantern", 16);
        block("shroomlight", 16);
        blockItemModel("redstone_lamp", 18);
        blockModel("redstone_lamp", "redstone_lamp_off", 18);
        blockModel("redstone_lamp_on", 18);
        lootTable("redstone_lamp", 18);

        block("glass", 14);
        lootTable("glass_pane", 14);

        for (var type : ChippedWoodType.VALUES) {
            block(type + "_wood_glass", 6);
            lootTable(type + "_wood_glass_pane", 6);

            block(type + "_planks", 18);
        }

        block("clay", 19);
        blockState("warped_wart_block", 14);
        blockItemModel("warped_wart_block", 14);
        blockModel("warped_wart_block", "/warped_wart_block/warped_wart_block", 14);
        lootTable("warped_wart_block", 14);
        blockState("nether_wart_block", 13);
        blockItemModel("nether_wart_block", 13);
        blockModel("nether_wart_block", "/nether_wart_block/nether_wart_block", 13);
        lootTable("nether_wart_block", 13);
        blockState("soul_sand", 11);
        blockItemModel("soul_sand", 11);
        blockModel("soul_sand", "/soul_sand/soul_sand", 11);
        lootTable("soul_sand", 11);

        lootTable("hay_block", 8);
        lootTable("melon", 10);
        lootTable("vine", 17);
        lootTable("brown_mushroom", 15);
        lootTable("red_mushroom", 15);
        lootTable("warped_fungus", 14);
        lootTable("crimson_fungus", 15);
        lootTable("warped_roots", 9);
        lootTable("crimson_roots", 14);
        lootTable("nether_sprouts", 20);
        lootTable("brown_mushroom_block", 24);
        lootTable("red_mushroom_block", 13);
        lootTable("cobweb", 10);
        lootTable("lily_pad", 6);

        lootTable("special_lantern", 4);
        lootTable("special_soul_lantern", 4);
        lootTable("lantern", 4);
        rawLootTable("lantern_6");
        for (int i = 9; i <= 14; i++) {
            rawLootTable("lantern_" + i);
        }
        lootTable("soul_lantern", 3);
        for (int i = 5; i <= 11; i++) {
            rawLootTable("lantern_" + i);
        }

        for (int i = 2; i <= 6; i++) {
            rawLootTable("redstone_torch_" + i);
        }
        lootTable("torch", 9);

        for (var pumpkin : ChippedBlocks.specialPumpkinList) {
            rawLootTable("pumpkin_" + pumpkin);
            rawLootTable("jack_o_lantern_" + pumpkin);
            rawLootTable("carved_pumpkin_" + pumpkin);
        }
        lootTable("pumpkin", 13);
        lootTable("jack_o_lantern", ChippedBlocks.carvedPumpkinList.length);
        lootTable("carved_pumpkin", ChippedBlocks.carvedPumpkinList.length);
    }

    public static void register() {
        RRPCallback.BEFORE_VANILLA.register(a -> a.add(RRP));
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) RRP.dump();
    }

    private static void blockState(String path, int count) {
        for (int i = 1; i <= count; i++) {
            final ResourceLocation identifier = new ResourceLocation(Chipped.MOD_ID, path + "_" + i);
            RRP.addBlockState(JState.state(JState.variant(JState.model(prefixPath(identifier, "block").toString()))), identifier);
        }
    }

    private static void blockItemModel(String path, int count) {
        for (int i = 1; i <= count; i++) {
            final ResourceLocation identifier = new ResourceLocation(Chipped.MOD_ID, path + "_" + i);
            RRP.addModel(JModel.model(prefixPath(identifier, "block").toString()), prefixPath(identifier, "item"));
        }
    }

    private static void lootTable(String path, int count) {
        for (int i = 1; i <= count; i++) {
            final ResourceLocation identifier = new ResourceLocation(Chipped.MOD_ID, path + "_" + i);
            RRP.addLootTable(prefixPath(identifier, "blocks"), JLootTable.loot("minecraft:block").pool(JLootTable.pool().rolls(1).bonus(0).entry(JLootTable.entry().type("minecraft:item").name(identifier.toString())).condition(JLootTable.predicate("minecraft:survives_explosion"))));
        }
    }

    private static void blockModel(String path, int count) {
        for (int i = 1; i <= count; i++) {
            final ResourceLocation prefix = prefixPath(new ResourceLocation(Chipped.MOD_ID, path + "_" + i), "block");
            RRP.addModel(JModel.model("block/cube_all").textures(JModel.textures().var("all", prefix.toString())), prefix);
        }
    }

    private static void blockModel(String blockPath, String texturePath, int count) {
        for (int i = 1; i <= count; i++) {
            final ResourceLocation blockPrefix = prefixPath(new ResourceLocation(Chipped.MOD_ID, blockPath + "_" + i), "block");
            final ResourceLocation texturePrefix = prefixPath(new ResourceLocation(Chipped.MOD_ID, texturePath + "_" + i), "block");
            RRP.addModel(JModel.model("block/cube_all").textures(JModel.textures().var("all", texturePrefix.toString())), blockPrefix);
        }
    }

    private static void itemModel(String path, String location, int count) {
        for (int i = 1; i <= count; i++) {
            final ResourceLocation prefix = prefixPath(new ResourceLocation(Chipped.MOD_ID, path + "_" + i), location);
            RRP.addModel(JModel.model("item/generated").textures(JModel.textures().layer0(prefix.toString())), prefix);
        }
    }

    private static void rawLootTable(String path) {
        final ResourceLocation identifier = new ResourceLocation(Chipped.MOD_ID, path);
        RRP.addLootTable(prefixPath(identifier, "blocks"), JLootTable.loot("minecraft:block").pool(JLootTable.pool().rolls(1).bonus(0).entry(JLootTable.entry().type("minecraft:item").name(identifier.toString())).condition(JLootTable.predicate("minecraft:survives_explosion"))));
    }

    private static void block(String path, int count) {
        blockState(path, count);
        blockItemModel(path, count);
        lootTable(path, count);
        blockModel(path, count);
    }

    private static ResourceLocation prefixPath(ResourceLocation identifier, String prefix) {
        return new ResourceLocation(identifier.getNamespace(), prefix + "/" + identifier.getPath());
    }
}
