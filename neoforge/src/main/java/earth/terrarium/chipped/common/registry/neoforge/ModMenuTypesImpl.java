package earth.terrarium.chipped.common.registry.neoforge;

import earth.terrarium.chipped.common.registry.ModMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

public class ModMenuTypesImpl {
    public static <T extends AbstractContainerMenu> MenuType<T> create(ModMenuTypes.MenuFactory<T> factory) {
        return IMenuTypeExtension.create(factory::create);
    }

    public static void openMenu(ServerPlayer player, BlockPos pos, MenuProvider provider) {
        player.openMenu(provider, buf -> buf.writeBlockPos(pos));
    }
}
