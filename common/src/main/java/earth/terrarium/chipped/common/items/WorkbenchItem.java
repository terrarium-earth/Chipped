package earth.terrarium.chipped.common.items;

import com.teamresourceful.resourcefullib.common.menu.MenuContentHelper;
import earth.terrarium.chipped.common.menus.WorkbenchMenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class WorkbenchItem extends Item {

    public WorkbenchItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        // Use the super result if not pass as that means they gave it a component that causes it to do other things.
        var result = super.use(level, player, hand);
        if (result == InteractionResult.PASS) {
            if (player instanceof ServerPlayer sp) {
                MenuContentHelper.open(sp, new WorkbenchMenuProvider(player.getItemInHand(hand)));
            }
            return InteractionResult.SUCCESS;
        }
        return result;
    }
}
