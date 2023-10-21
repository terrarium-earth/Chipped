package earth.terrarium.chipped.common.utils.forge;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraftforge.network.NetworkHooks;

public class ModUtilsImpl {
    public static void openMenu(ServerPlayer player, BlockPos pos, MenuProvider provider) {
        NetworkHooks.openScreen(player, provider, buf -> buf.writeBlockPos(pos));
    }
}
