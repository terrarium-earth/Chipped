package com.grimbo.registry.forge;

import com.grimbo.chipped.registry.RegistryHelpers;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeMenuType;

public class RegistryHelpersImpl {

    public static <T extends AbstractContainerMenu> MenuType<T> createMenuType(RegistryHelpers.MenuFactory<T> factory) {
        return IForgeMenuType.create(factory::create);
    }

    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(RegistryHelpers.BlockEntityFactory<E> factory, Block... blocks) {
        return BlockEntityType.Builder.of(factory::create, blocks).build(null);
    }
}
