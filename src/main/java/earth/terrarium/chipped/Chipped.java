package earth.terrarium.chipped;

import com.google.common.collect.Multimap;
import net.minecraft.resources.Identifier;

public class Chipped {
    public static final String MOD_ID = "chipped";
    public static final String BLOCK_FILE = "blocks.json";

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    public static void initRegistries() {
        
    }
}
