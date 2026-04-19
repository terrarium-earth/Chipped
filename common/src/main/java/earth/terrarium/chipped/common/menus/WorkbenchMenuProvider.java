package earth.terrarium.chipped.common.menus;

import com.mojang.datafixers.util.Either;
import com.teamresourceful.resourcefullib.common.menu.ContentMenuProvider;
import com.teamresourceful.resourcefullib.common.menu.MenuContent;
import com.teamresourceful.resourcefullib.common.menu.MenuContentSerializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public record WorkbenchMenuProvider(Content source) implements ContentMenuProvider<WorkbenchMenuProvider.Content> {

    public WorkbenchMenuProvider(Block block) {
        this(new Content(block));
    }

    public WorkbenchMenuProvider(ItemStack stack) {
        this(new Content(stack));
    }

    @Override
    public @NonNull Component getDisplayName() {
        return this.source.getName();
    }

    @Override
    public AbstractContainerMenu createMenu(int id, @NonNull Inventory inventory, @NonNull Player player) {
        return new WorkbenchMenu(id, inventory, Optional.of(this.source));
    }

    @Override
    public Content createContent(ServerPlayer player) {
        return this.source;
    }

    public record Content(Either<Block, ItemStack> source) implements MenuContent<Content> {

        public Content(Block block) {
            this(Either.left(block));
        }

        public Content(ItemStack stack) {
            this(Either.right(stack));
        }

        public Component getName() {
            return this.source.map(Block::getName, ItemStack::getHoverName);
        }

        @Override
        public MenuContentSerializer<Content> serializer() {
            return Serializer.INSTANCE;
        }
    }

    public enum Serializer implements MenuContentSerializer<Content> {
        INSTANCE;

        @Override
        public @Nullable Content from(FriendlyByteBuf buffer) {
            int id = buffer.readVarInt();
            if (id == 0 || id == -1) {
                if (id != -1 && buffer instanceof RegistryFriendlyByteBuf registry) {
                    return new Content(ItemStack.STREAM_CODEC.decode(registry));
                }
                return null;
            }
            return new Content(BuiltInRegistries.BLOCK.byId(id));
        }

        @Override
        public void to(FriendlyByteBuf buffer, Content content) {
            content.source.ifLeft(block ->
                buffer.writeVarInt(BuiltInRegistries.BLOCK.getId(block))
            );
            content.source.ifRight(stack -> {
                if (buffer instanceof RegistryFriendlyByteBuf registry) {
                    buffer.writeVarInt(0);
                    ItemStack.STREAM_CODEC.encode(registry, stack);
                } else {
                    buffer.writeVarInt(-1);
                }
            });
        }
    }
}