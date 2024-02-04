package earth.terrarium.chipped.common.items;

import earth.terrarium.chipped.common.menus.WorkbenchMenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WorkbenchItem extends Item {

    public WorkbenchItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        var stack = player.getItemInHand(usedHand);
        player.openMenu(new WorkbenchMenuProvider(getName(stack)));
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
