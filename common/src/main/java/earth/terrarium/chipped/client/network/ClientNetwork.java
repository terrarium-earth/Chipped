package earth.terrarium.chipped.client.network;

import earth.terrarium.chipped.client.screens.WorkbenchScreen;
import earth.terrarium.chipped.common.network.ClientboundRecipesPacket;
import earth.terrarium.chipped.common.network.ClientboundSetWorkbenchItemsPacket;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public class ClientNetwork {

    private static final List<ChippedRecipe> RECIPES = new ArrayList<>();

    public static void handleWorkbenchItems(ClientboundSetWorkbenchItemsPacket packet) {
        if (Minecraft.getInstance().screen instanceof WorkbenchScreen screen) {
            if (packet.reset()) screen.getMenu().reset();
            screen.setResults(packet.items());
        }
    }

    public static void handleRecipes(ClientboundRecipesPacket packet) {
        RECIPES.clear();
        RECIPES.addAll(packet.recipes());
    }

    public static void handleServerLeave() {
        RECIPES.clear();
    }

    public static List<ChippedRecipe> recipes() {
        return RECIPES;
    }
}
