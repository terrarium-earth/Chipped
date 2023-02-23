package earth.terrarium.chipped.common.palette;

import java.util.ArrayList;
import java.util.List;

public enum Palette {
    MELON("bright_%", "dark_%", "golden_%", "ripe_%", "rustic_%", "sticky_%", "sunny_%", "swampy_%", "sweet_%", "tropics_%"),
    HAY_BLOCK("antique_%", "bundled_%", "detailed_%", "fertile_%", "jungle_%", "pale_%", "rich_%", "swampy_%"),
    MOSS_BLOCK("blobby_%", "blue_%", "crunchy_%", "lime_%", "old_%", "red_%", "smooth_%", "spongy_%", "sprinkled_%", "yellow_%"),
    MUSHROOM_STEM("blooming_%", "broken_%", "grimy_%", "old_%", "poisonous_%", "smooth_%", "warm_%"),
    DRIED_KELP_BLOCK("bamboo_%", "blue_%", "brown_%", "compact_%", "crimson_%", "leafy_%", "mossy_%", "netherwart_%", "rough_crimson_%", "shroomy_%", "sugarcane_%", "wart_%"),
    SPONGE("bulby_%", "fine_%", "giant_%", "lush_%", "old_%", "smooth_%", "soft_%"),
    BONE_BLOCK("cracked_%", "crunched_%", "dark_%", "double_roped_%", "fractured_%", "gilded_basalt_%", "inscribed_%", "reinforced_%", "roped_%", "tiled_%", "weaved_%"),
    MUSHROOM("bulbed_%", "button_%", "clustered_%", "double_%", "franken_%", "hooded_%", "micro_%", "mini_%", "%_bulb", "%_bushel", "%_cluster", "%_trio", "umbrella_%", "wicked_%"),
    WARPED_FUNGUS(MUSHROOM, List.of("clustered_%")),
    MUSHROOM_BLOCK("dark_dusted_%", "dark_freckled_%", "dark_scaled_%", "dark_smooth_%", "dark_spotted_%", "dark_sprinkled_%", "dusted_%", "freckled_%", "light_dusted_%", "light_freckled_%", "light_scaled_%", "light_smooth_%", "light_spotted_%", "light_sprinkled_%", "scaled_%", "smooth_%", "spotted_%", "sprinkled_%", "white_dusted_%", "white_freckled_%", "white_spotted_%", "white_sprinkled_%"),
    RED_MUSHROOM_BLOCK("dark_dotted_%", "dark_dusted_%", "dark_freckled_%", "dark_smooth_%", "dark_spotted_%", "dotted_%", "dusted_%", "freckled_%", "light_dotted_%", "light_dusted_%", "light_freckled_%", "light_smooth_%", "light_spotted_%", "smooth_%", "spotted_%"),
    COBWEB("broken_%", "hanging_broken_%", "%_arch", "%_floor", "dense_%", "hanging_%", "scattered_%", "stretched_%", "stringy_%", "thick_%_floor"),
    CRIMSON_ROOTS("budding_%_bulb", "budding_%", "%_bloom", "%_bramble", "%_bud", "%_bulb", "%_floret", "flowered_%_bulb", "flowered_%", "small_%_bud", "sprouting_%_bulb", "sprouting_%", "wilted_%_bud", "wilted_%_bulb"),
    WARPED_ROOTS("bloomed_%", "flowering_%", "half_grown_%", "lily_%", "mangled_%", "overgrown_%", "stem_%", "wiggly_%", "young_%"),
    WART_BLOCK("bubbling_%", "crumbled_%", "dried_%", "erratic_%", "eyed_%", "patched_%", "porous_%", "rough_%", "scabbed_%", "scaled_%", "seared_%", "semi_spongy_%", "speckled_%", "spongy_%"),
    NETHER_SPROUTS("bolby_%", "bushy_%", "corny_%", "corrupted_%", "creeping_%", "crusted_%", "fired_%", "flimsy_%", "grizly_%", "high_%", "large_%", "%_weeds", "seeded_%", "short_%", "shroomy_%", "tall_shroomy_%", "thin_%", "tubed_%", "warty_%", "wide_%"),
    LILY_PAD("big_flower_%", "broken_%", "dark_broken_%", "dark_flowering_%", "dark_large_%", "dark_leaf_%", "dark_micro_%s", "dark_paddle_%", "dark_rough_%", "dark_smol_%", "dark_smooth_%", "flowering_%", "large_%", "leaf_%", "light_leaf_%", "light_rough_%", "micro_%s", "pacman_%", "paddle_%", "rough_%", "smol_%", "smooth_%"),
    VINE("droopy_%", "flowery_%", "ivy_%", "leafy_%", "long_%", "lush_%", "nether_%", "poisonous_%", "thicc_%", "thin_%", "warped_%"),
    LEAVES("apple_%", "cherry_%", "dead_%", "frosted_%", "golden_%", "golden_apple_%", "golden_cherry_%", "magenta_flower_%", "orange_%", "red_%", "white_flower_%"),
    ROOTS("blue_%", "crimson_%", "flowery_%", "leafy_%", "lush_%", "muddy_%", "thin_%"),

    PUMPKIN("autumnkin", "dewkin", "dirty_dewkin", "dirty_goldkin", "dirty_rosekin", "end_%", "end_%_purple", "goldkin", "kabotchkin", "nether_%", "overgrown_%", "overgrown_autumnkin", "overgrown_lumpkin", "overgrown_pimpkin", "pimpkin", "rosekin"),
    CARVED_PUMPKIN("anguished_%", "bad_time_%", "boo_%", "creepy_%", "devious_%", "end_%", "end_purple_%", "horrified_%", "kitty_faced_%", "nether_%", "overjoyed_%", "owo_%", "silly_%", "slight_smile_%", "smiling_%", "spooky_%", "squished_cute_%", "suspicious_%", "tiny_smug_%", "traditional_%", "upside_down_%", "wide_eyed_%"),

    GRAVEL("andesite_%", "dirty_%", "dusty_%", "orange_%", "rought_%", "sandy_%", "sifted_%"),
    SAND("ash_%", "course_%", "desert_%", "kelp_%", "lush_red_%", "overgrown_%", "pearl_%", "soft_%", "tar_%", "wet_%", "wet_red_%", "white_%"),
    SOUL_SAND("faded_%", "fine_%", "glowing_%", "graveled_%", "happy_%", "hardened_%", "lauching_%", "meming_%", "reanimated_%", "scared_%", "sifted_%", "smoothed_%", "trampled_%"),

    GLOWSTONE("broken_%", "bulbed_%", "cracked_%", "double_inlayed_%", "edged_%_lantern", "fancy_%_lantern", "framed_%_lantern", "glowing_lodestone_side", "%_lantern", "hived_%", "inlayed_%", "nether_engraved_%", "ornate_%_lantern", "patterned_%", "polished_%", "shimmering_%", "smooth_%", "thick_inlayed_%", "tiled_%_pillar", "wither_engraved_%"),
    SEA_LANTERN("broken_%", "bulbed_%", "cracked_%", "double_inlayed_%", "fancy_%", "framed_%", "hived_%", "inlayed_%", "ornate_%", "polished_%", "reinforced_%", "sea_lodestone_side", "shimmering_%", "smooth_%", "special_%", "thick_inlayed_%", "tiled_%_pillar"),
    SHROOMLIGHT("broken_%", "cracked_%", "double_inlayed_%", "edged_%_lantern", "fancy_%_lantern", "framed_%_lantern", "hived_%", "inlayed_%", "ornate_%_lantern", "polished_%", "reinforced_%", "shimmering_%", "%_lantern", "%_lodestone_side", "smooth_%", "thick_inlayed_%", "tiled_%_pillar"),
    TORCH("acacia_%", "birch_%", "crimson_%", "dark_oak_%", "glow_%", "iron_%", "jungle_%", "spruce_%", "warped_%"),
    REDSTONE_TORCH("blue_%", "crimson_%", "green_%", "lightstick_%", "yellow_%"),
    REDSTONE_LAMP("edged_%", "edged_white_%", "fancy_%", "fancy_white_%", "hived_%", "hived_white_%", "inlayed_%", "inlayed_white_%", "nice_%", "nice_white_%", "ornate_%", "ornate_white_%", "reinforced_%", "reinforced_white_%", "smooth_%", "smooth_white_%", "thick_inlayed_%", "thick_white_inlayed_%"),
    SPECIAL_LANTERN("big_lantern", "donut_lantern", "tall_lantern", "wide_lantern"),
    SPECIAL_SOUL_LANTERN("big_soul_lantern", "donut_soul_lantern", "tall_soul_lantern", "wide_soul_lantern"),
    LANTERN("blue_paper_%", "burning_coal_%", "checkered_iron_%", "dark_blue_paper_%", "ender_%", "green_paper_%", "iron_bowl_%", "purple_paper_%", "red_paper_%", "small_green_%", "white_paper_%", "wooden_cage_%", "wrought_iron_%", "yellow_tube_%"),
    SOUL_LANTERN("blue_paper_%", "blue_tube_%", "checkered_iron_%", "golden_paper_%", "gray_paper_%", "iron_bowl_%", "lime_paper_%", "orange_paper_%", "small_red_%", "wooden_cage_%", "yellow_paper_%"),
    FROGLIGHT("ad_astra_%", "ancient_%", "barred_%", "elemental_%", "exposed_%", "glass_%", "reinforced_%", "round_%"),

    BOOKSHELF("ancient_cubed_oak_%", "ancient_oak_%", "ancient_oak_large_%", "ancient_vertical_oak_%", "botanical_oak_%", "botanical_oak_cubed_%", "botanical_oak_large_%", "cubed_oak_%", "cubed_oak_empty_%", "cubed_oak_spaced_%", "cubed_oak_webbed_%", "curvy_%", "dusty_%", "full_%", "historical_oak_%", "historical_oak_large_%", "mixed_cubed_oak_%", "mixed_oak_%", "mixed_oak_large_%", "oak_%", "oak_empty_%", "oak_large_%", "oak_lighted_%", "oak_lighted_large_%", "oak_spaced_%", "oak_spaced_large_%", "oak_webbed_%", "oak_webbed_large_%", "vertical_botanical_oak_%", "vertical_mixed_oak_%", "vertical_oak_%", "vertical_oak_lighted_%", "vertical_oak_webbed_%"),
    LADDER("crooked_%", "crooked_plank_%", "crooked_ropeplank_%", "metal_%", "mossy_%", "plank_%", "railed_%", "rope_planked_%", "roped_%", "strong_%"),

    WOOL("barky_%", "blocky_%", "bundled_%", "cornered_%", "crafted_%", "cross_haired_%", "cubed_%", "harsh_quilted_%", "knitted_%", "patched_%", "rectangle_%", "ribbled_%", "scaled_%", "soft_%", "stringed_%", "tiled_%", "tripped_%", "wickered_%", "windmill_%", "woved_%"),

    STONE("%_bricks", "%_mini_tiles", "%_pillar", "%_pillar_top", "%_scales", "angry_%", "blank_%_carving", "bordered_%", "brick_bordered_%", "carved_%", "checkered_%_tiles", "cobbled_%", "cracked_%_bricks", "cracked_disordered_%_bricks", "cracked_flat_%_tiles", "creeper_%_carving", "crying_%", "curly_%_pillar", "cut_%_column", "cut_blank_%", "glad_%", "duh_%", "edged_%_bricks", "engraved_%", "eroded_%", "etched_%_bricks", "fine_%_pillar", "flat_%_tiles", "inlayed_%", "inscribed_%", "layed_%_bricks", "loded_%", "massive_%_bricks", "offset_%_bricks", "ornate_%_pillar", "overlapping_%_tiles", "pillar_%_bricks", "polished_%", "prismal_%_remnants", "rough_%", "rounded_%_bricks", "runic_carved_%", "sad_%", "sanded_%", "simple_%_pillar", "small_%_bricks", "smooth_%_column", "smooth_inlayed_%", "smooth_ringed_%", "smoothed_double_inlayed_%", "spider_%_carving", "spiraled_%", "stacked_%_bricks", "thick_inlayed_%", "tiled_%", "tiled_%_column", "tiled_bordered_%", "tiny_%_bricks", "tiny_brick_bordered_%", "tiny_layered_%_bricks", "tiny_layered_%_slabs", "trodden_%", "unamused_%", "vertical_cut_%", "vertical_disordered_%_bricks", "weathered_%"),
    BASALT(STONE, List.of("rough_%", "trodden_%")),
    BLACKSTONE(STONE, List.of("%_bricks", "cracked_%_bricks", "rough_%", "weathered_%"), "smooth_%_bricks"),
    DARK_PRISMARINE(STONE, List.of("%_mini_tiles")),
    DEEPSLATE(STONE, List.of("%_bricks", "cobbled_%", "cracked_%_bricks", "cracked_flat_%_tiles", "flat_%_tiles", "layed_%_bricks", "offset_%_bricks")),
    GILDED_BLACKSTONE(STONE, List.of("rough_%", "smooth_%"), "chunky_%", "reinforced_%", "special_%", "spiral_%"),
    LODESTONE("%_bricks", "%_mini_tiles", "%_pillar", "%_pillar_top", "%_scales", "angry_%", "blank_%_carving", "blank_%_side", "bordered_%", "brick_bordered_%", "carved_%", "checkered_%_tiles", "cobbled_%", "cracked_%_bricks", "cracked_disordered_%_bricks", "cracked_flat_%_tiles", "creeper_%_carving", "crying_%", "curly_%_pillar", "cut_%_column", "cut_blank_%", "glad_%", "diamond_%", "dot_%", "duh_%", "edged_%_bricks", "engraved_%", "eroded_%", "etched_%_bricks", "fine_%_pillar", "flat_%_tiles", "inlayed_%", "inscribed_%", "layed_%_bricks", "massive_%_bricks", "offset_%_bricks", "ornate_%_pillar", "overlapping_%_tiles", "pillar_%_bricks", "polished_%", "prismal_%_remnants", "ring_%", "ring_%_side", "rough_%", "rounded_%_bricks", "runic_carved_%", "sad_%", "sanded_%", "sea_lantern_%", "simple_%_pillar", "small_%_bricks", "smooth_%_column", "smooth_ringed_%", "smoothed_double_inlayed_%", "spider_%_carving", "spiraled_%", "stacked_%_bricks", "thick_inlayed_%", "tiled_%", "tiled_%_column", "tiled_bordered_%", "tiny_%_bricks", "tiny_brick_bordered_%", "tiny_layered_%_bricks", "tiny_layered_%_slabs", "trodden_%", "unamused_%", "vertical_cut_%", "vertical_disordered_%_bricks", "watching_%", "weathered_%", "wider_diamond_%", "wider_ring_%", "wider_watching_%"),
    MOSSY_STONE_BRICKS(STONE, List.of("%_bricks")),
    PRISMARINE(STONE, List.of("prismal_%_remnants"), "granite_%"),
    PURPUR_BLOCK(STONE, List.of("heckered_%_tiles", "checkered_%_tiles")),
    QUARTZ_BLOCK(STONE, List.of("carved_%", "offset_%_bricks", "%_pillar_top", "spiraled_%")),
    BASE_STONE(STONE, List.of("%_bricks", "cracked_%_bricks", "curly_%_pillar", "eroded_%", "fine_%_pillar", "ornate_%_pillar", "simple_%_pillar", "smooth_ringed_%", "%_mini_tiles")),
    CLAY(STONE, List.of("eroded_%")),
    BRICKS(STONE, List.of("layed_%_bricks")),
    MUD("%_bricks", "%_pillar", "%_pillar_top", "%_scales", "angled_%_bricks", "angry_%", "arrow_%", "bordered_%", "brick_bordered_%", "button_%", "carved_%", "carved_%_pillar", "centered_%", "chiseled_%", "cracked_%_bricks", "creeper_%_carving", "crunched_%_bricks", "crying_%", "curly_%_pillar", "cut_blank_%", "diamond_%_bricks", "double_%_bricks", "duh_%", "edged_%_bricks", "engraved_%", "etched_%_bricks", "eye_%", "fancy_%", "fancy_%_pillar", "fancy_chiseled_%", "fine_%_pillar", "glad_%", "heart_%", "horned_%", "inlayed_%", "keyhole_%", "large_%_sigil", "large_tiled_%", "leaning_%", "loreful_%", "massive_%_bricks", "mini_tiled_%", "offset_%_bricks", "ornate_%_pillar", "overlapping_%_tiles", "pancake_%", "panelled_%", "placed_%", "polished_%", "prismal_%_remnants", "quad_%", "rough_%", "hard_%", "rough_panelled_%", "rune_%", "sad_%", "scaly_%", "sigil_%", "simple_%_pillar", "small_%_bricks", "smooth_%", "smooth_ringed_%", "smoothed_double_inlayed_%", "spider_%_carving", "spiral_%", "stacked_%_bricks", "star_%", "symbol_%", "symbolic_%_pillar", "thick_inlayed_%", "tiled_%_bricks", "tiled_%_column", "tiled_bordered_%", "tiny_%_bricks", "tiny_layered_%_bricks", "unamused_%", "vertical_cut_%", "vertical_disordered_%_bricks"),

    PLANKS("%_mosaic", "%_panel", "%_shavings", "basket_woven_%", "boxed_%", "brick_bond_%", "bricky_%", "cornered_%", "crated_%", "cross_laced_%", "crossed_%", "detailed_%", "diagonal_%", "diamond_%", "double_herringbone_%", "enclosed_%", "fine_%", "fine_vertical_%", "framed_%", "herringbone_%", "hewn_%", "laced_%", "nailed_%", "natural_%", "pegged_%", "polished_%", "railed_%", "shifted_%", "slanted_%", "smooth_%", "stacked_%", "thin_%", "tiled_%", "versailles_%", "vertical_%", "vertically_railed_%", "whirlwind_%", "wickered_%"),
    MANGROVE_PLANKS("%_mosaic", "%_panel", "%_shavings", "basket_woven_%", "boxed_%", "brick_bond_%", "bricked_%", "bricky_%", "carved_%", "chiseled_%", "cornered_%", "crated_%", "cross_laced_%", "crossed_%", "cut_%", "detailed_%", "diagonal_%", "diamond_%", "double_herringbone_%", "enclosed_%", "fine_%", "fine_vertical_%", "framed_%", "herringbone_%", "hewn_%", "laced_%", "nailed_%", "natural_%", "pegged_%", "polished_%", "railed_%", "ringed_%", "shelved_%", "shifted_%", "sided_%", "slanted_%", "smooth_%", "stacked_%", "thin_%", "tiled_%", "versailles_%", "vertical_%", "vertically_railed_%"),

    LOG("bundled_%", "center_cut_%", "damaged_%", "edge_cut_%", "firewood_%", "flowering_%", "mixed_%", "nailed_%", "overgrown_%", "planked_%", "reinforced_%"),
    WARPED_STEM("bundled_%", "center_cut_%", "damaged_%", "edge_cut_%", "firewood_%", "nailed_%", "planked_%", "rotted_%", "shrooming_%", "smooth_%"),
    CRIMSON_STEM("bundled_%", "center_cut_%", "crying_%", "damaged_%", "edge_cut_%", "firewood_%", "glittering_%", "glowing_%", "mixed_%", "nailed_%", "planked_%", "rotten_%", "shrooming_%", "smooth_%"),
    STRIPPED_LOG("carved_%", "chipped_%", "d_sign_%", "edged_%", "f_sign_%", "i_sign_%", "k_sign_%", "knotted_%", "l_sign_%", "layered_%", "lumpy_%", "m_sign_%", "patient_%", "reinforced_%", "sign_%", "stern_%", "wise_%"),
    STRIPPED_MANGROVE_LOG("carved_%", "chipped_%", "chiseled_%", "d_sign_%", "edged_%", "f_sign_%", "i_sign_%", "k_sign_%", "knotted_%", "l_sign_%", "lumpy_%", "m_sign_%", "patient_%", "reinforced_%", "sign_%", "stern_%", "vertical_layered_%", "wise_%"),
    BARREL("acacia_%", "acacia_crate", "bamboo_%", "birch_%", "birch_crate", "coal_%", "copper_%", "crimson_%", "crimson_crate", "dark_oak_crate", "fish_%", "fruit_%", "gilded_%", "gold_%", "iron_%", "jungle_crate", "mangrove_brick_%", "mangrove_crate", "mangrove_tile_%", "metal_%", "mushroom_%", "netherite_safe", "oak_%", "oak_crate", "reinforced_acacia_crate", "reinforced_birch_crate", "reinforced_crimson_crate", "reinforced_dark_oak_crate", "reinforced_jungle_crate", "reinforced_mangrove_crate", "reinforced_oak_crate", "reinforced_spruce_crate", "reinforced_warped_crate", "spruce_%", "spruce_crate", "varnished_%", "warped_crate"),

    METAL("%_panels", "ancient_%", "chipped_%", "engraved_%", "layered_%", "plated_%", "polished_%", "pressed_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%"),
    NETHERITE_BLOCK("%_panels", "chipped_%", "embossed_%", "engraved_%", "layered_%", "plated_%", "polished_%", "pressed_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%"),
    DIAMOND_BLOCK("%_panels", "ancient_%", "chipped_%", "embossed_%", "engraved_%", "layered_%", "plated_%", "pressed_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%"),
    EMERALD_BLOCK("%_panels", "ancient_%", "chipped_%", "embossed_%", "engraved_%", "layered_%", "plated_%", "polished_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%"),
    COPPER_BLOCK("ancient_%", "chipped_%", "embossed_%", "engraved_%", "layered_%", "plated_%", "pressed_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%"),
    IRON_BARS("%_top", "barbed_%", "bolted_%", "chained_%", "crossbolted_%", "crossed_%", "floral_%", "harp_%", "linked_%", "loose_%", "piked_%", "railed_%", "sighthole_%", "stepped_%", "sturdy_%", "supported_%", "thorned_%", "victorian_%_pikes", "vined_%", "woven_%", "zippered_%"),

    TERRACOTTA("%_bricks", "%_column", "%_pillar", "%_tile", "%_tiles", "chiseled_%", "circular_%", "crossed_%", "curled_%", "cut_%", "decorated_%", "hexagonical_%", "inscribed_%", "layered_%", "small_%_tiles", "starry_%", "triangular_%"),
    GLAZED_TERRACOTTA("%_pillar_sides", "%_pillar_top", "%_smooth_tiles", "%_tiles", "decorated_%", "hexagonical_%", "minimized_%", "paved_%", "shrunken_%", "starry_%", "waved_%"),
    POINTED_DRIPSTONE("andesite_%", "calcite_%", "deepslate_%", "diorite_%", "smooth_basalt_%", "granite_%", "stone_%", "tuff_%", "basalt_%", "blackstone_%", "endstone_%", "netherrack_%", "packed_ice_%"),
    GLASS("arched_leaded_%_pillar", "circle_oak_%", "clear_leaded_%", "fancy_leaded_%", "large_diamond_leaded_%", "lead_woven_%", "oak_bared_%", "oak_bordered_%", "oak_diamond_bordered_%", "oak_horizontal_lined_%", "oak_large_diamond_%", "oak_line_bared_%", "oak_ornate_bared_%", "oak_snowflake_%", "oak_woven_%", "ornate_leaded_%", "raster_leaded_%", "small_diamond_leaded_%", "square_leaded_%", "square_oak_%", "vertical_leaded_%"),
    STAINED_GLASS("arched_%_pillar", "circular_%", "fancy_%", "large_diamond_%", "ornate_%", "raster_%", "small_%", "square_%", "tiled_%", "vertical_stiped_%", "woven_%"),

    CONCRETE("%_bricks", "%_panel", "%_pillar", "%_tiles", "bolted_%", "creeper_%", "grid_%", "grill_%", "hazard_%", "mosaic_%", "pegged_%", "railed_%", "reinforced_%", "rusted_%", "smooth_%", "stacked_%", "stop_%", "striped_%", "warning_%", "wired_%"),

    TRAPDOOR("airy_%", "barred_%", "checkered_%", "classic_%", "classic_windowed_%", "cobweb_%", "distorted_%", "fancy_%", "golden_barred_%", "heavy_%", "iron_barred_%", "leafy_%", "meshed_%", "overgrown_%", "pointless_%", "slotted_%", "solid_%", "suspicious_%", "twisted_%", "vined_%", "warted_%", "windowed_%", "woven_%"),
    OAK_TRAPDOOR(TRAPDOOR, List.of("classic_%")),
    SPRUCE_TRAPDOOR(TRAPDOOR, List.of("heavy_%")),
    CRIMSON_TRAPDOOR(TRAPDOOR, List.of("suspicious_%")),
    WARPED_TRAPDOOR(TRAPDOOR, List.of("distorted_%", "fancy_%")),
    JUNGLE_TRAPDOOR(TRAPDOOR, List.of("fancy_%")),
    ACACIA_TRAPDOOR(TRAPDOOR, List.of("airy_%")),
    MANGROVE_TRAPDOOR("barred_%", "classic_%", "classic_windowed_%", "distorted_%", "fancy_%", "golden_barred_%", "heavy_%", "iron_barred_%", "screened_%", "solid_%", "suspicious_%", "windowed_%"),

    DOOR("barred_%", "beach_%", "boarded_%", "dual_paneled_%", "fortified_%", "gated_%", "glass_%", "heavy_%", "overgrown_%", "paneled_%", "paper_%", "pressed_%", "screen_%", "secret_%", "shack_%", "sliding_%", "supported_%", "tile_windowed_%", "tiled_%", "windowed_%"),
    ACACIA_DOOR(DOOR, List.of("barred_%")),
    BIRCH_DOOR(DOOR, List.of("paper_%")),
    DARK_OAK_DOOR(DOOR, List.of("paneled_%")),
    JUNGLE_DOOR(DOOR, List.of("beach_%")),
    SPRUCE_DOOR(DOOR, List.of("boarded_%")),
    CRIMSON_DOOR(DOOR, List.of("supported_%")),
    WARPED_DOOR(DOOR, List.of("overgrown_%", "sliding_%")),
    MANGROVE_DOOR("barred_%", "beach_%", "boarded_%", "cut_%", "dual_paneled_%", "fortified_%", "gated_%", "glass_%", "heavy_%", "modern_%", "overgrown_%", "paneled_%", "paper_%", "pressed_%", "reinforced_%", "secret_%", "sliding_%", "supported_%", "tile_windowed_%", "windowed_%"),
    ;


    private final String[] names;

    Palette(String... names) {
        this.names = names;
    }

    Palette(Palette base, List<String> skippedNames, String... additionalNames) {
        List<String> names = new ArrayList<>(List.of(base.names));
        names.removeAll(skippedNames);
        names.addAll(List.of(additionalNames));
        this.names = names.toArray(new String[0]);
    }


    public String[] getNames() {
        return names;
    }

    public String getName(int index) {
        return names[index];
    }
}
