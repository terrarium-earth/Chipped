package com.grimbo.chipped.registry.fabric;

import com.grimbo.chipped.registry.RegistryHelpers;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class RegistryHelpersImpl {

    public static <T extends AbstractContainerMenu> MenuType<T> createMenuType(RegistryHelpers.MenuFactory<T> factory) {
        return new ExtendedScreenHandlerType<>(factory::create);
    }

    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(RegistryHelpers.BlockEntityFactory<E> factory, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(factory::create, blocks).build(null);
    }
}
