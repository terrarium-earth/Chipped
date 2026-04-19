package earth.terrarium.chipped.client.network;

import earth.terrarium.chipped.client.screens.WorkbenchScreen;
import earth.terrarium.chipped.common.network.ClientboundRecipesPacket;
import net.minecraft.client.Minecraft;

public class ClientNetwork {

    public static void handleRecipes(ClientboundRecipesPacket packet) {
        if (Minecraft.getInstance().screen instanceof WorkbenchScreen screen) {
            if (packet.reset()) screen.getMenu().reset();
            screen.setResults(packet.items());
        }
    }
}
