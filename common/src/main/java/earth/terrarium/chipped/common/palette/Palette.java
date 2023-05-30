package earth.terrarium.chipped.common.palette;

import java.util.ArrayList;
import java.util.List;

public enum Palette {
    MELON("bright_%s", "dark_%s", "golden_%s", "ripe_%s", "rustic_%s", "sticky_%s", "sunny_%s", "swampy_%s", "sweet_%s", "tropics_%s"),
    HAY_BLOCK("antique_%s", "bundled_%s", "detailed_%s", "fertile_%s", "jungle_%s", "pale_%s", "rich_%s", "swampy_%s"),
    MOSS_BLOCK("blobby_%s", "blue_%s", "crunchy_%s", "lime_%s", "old_%s", "red_%s", "smooth_%s", "spongy_%s", "sprinkled_%s", "yellow_%s"),
    MUSHROOM_STEM("blooming_%s", "broken_%s", "grimy_%s", "old_%s", "poisonous_%s", "smooth_%s", "warm_%s"),
    DRIED_KELP_BLOCK("bamboo_%s", "blue_%s", "brown_%s", "compact_%s", "crimson_%s", "leafy_%s", "mossy_%s", "netherwart_%s", "rough_crimson_%s", "shroomy_%s", "sugarcane_%s", "wart_%s"),
    SPONGE("bulby_%s", "fine_%s", "giant_%s", "lush_%s", "old_%s", "smooth_%s", "soft_%s"),
    BONE_BLOCK("cracked_%s", "crunched_%s", "dark_%s", "double_roped_%s", "fractured_%s", "gilded_basalt_%s", "inscribed_%s", "reinforced_%s", "roped_%s", "tiled_%s", "weaved_%s"),
    MUSHROOM("bulbed_%s", "button_%s", "clustered_%s", "double_%s", "franken_%s", "hooded_%s", "micro_%s", "mini_%s", "%s_bulb", "%s_bushel", "%s_cluster", "%s_trio", "umbrella_%s", "wicked_%s"),
    WARPED_FUNGUS(MUSHROOM, List.of("clustered_%s")),
    MUSHROOM_BLOCK("dark_dusted_%s", "dark_freckled_%s", "dark_scaled_%s", "dark_smooth_%s", "dark_spotted_%s", "dark_sprinkled_%s", "dusted_%s", "freckled_%s", "light_dusted_%s", "light_freckled_%s", "light_scaled_%s", "light_smooth_%s", "light_spotted_%s", "light_sprinkled_%s", "scaled_%s", "smooth_%s", "spotted_%s", "sprinkled_%s", "white_dusted_%s", "white_freckled_%s", "white_spotted_%s", "white_sprinkled_%s"),
    RED_MUSHROOM_BLOCK("dark_dotted_%s", "dark_dusted_%s", "dark_freckled_%s", "dark_smooth_%s", "dark_spotted_%s", "dotted_%s", "dusted_%s", "freckled_%s", "light_dotted_%s", "light_dusted_%s", "light_freckled_%s", "light_smooth_%s", "light_spotted_%s", "smooth_%s", "spotted_%s"),
    COBWEB("broken_%s", "hanging_broken_%s", "%s_arch", "%s_floor", "dense_%s", "hanging_%s", "scattered_%s", "stretched_%s", "stringy_%s", "thick_%s_floor"),
    CRIMSON_ROOTS("budding_%s_bulb", "budding_%s", "%s_bloom", "%s_bramble", "%s_bud", "%s_bulb", "%s_floret", "flowered_%s_bulb", "flowered_%s", "small_%s_bud", "sprouting_%s_bulb", "sprouting_%s", "wilted_%s_bud", "wilted_%s_bulb"),
    WARPED_ROOTS("bloomed_%s", "flowering_%s", "half_grown_%s", "lily_%s", "mangled_%s", "overgrown_%s", "stem_%s", "wiggly_%s", "young_%s"),
    WART_BLOCK("bubbling_%s", "crumbled_%s", "dried_%s", "erratic_%s", "eyed_%s", "patched_%s", "porous_%s", "rough_%s", "scabbed_%s", "scaled_%s", "seared_%s", "semi_spongy_%s", "speckled_%s", "spongy_%s"),
    NETHER_SPROUTS("bolby_%s", "bushy_%s", "corny_%s", "corrupted_%s", "creeping_%s", "crusted_%s", "fired_%s", "flimsy_%s", "grizly_%s", "high_%s", "large_%s", "%s_weeds", "seeded_%s", "short_%s", "shroomy_%s", "tall_shroomy_%s", "thin_%s", "tubed_%s", "warty_%s", "wide_%s"),
    LILY_PAD("big_flower_%s", "broken_%s", "dark_broken_%s", "dark_flowering_%s", "dark_large_%s", "dark_leaf_%s", "dark_micro_%ss", "dark_paddle_%s", "dark_rough_%s", "dark_smol_%s", "dark_smooth_%s", "flowering_%s", "large_%s", "leaf_%s", "light_leaf_%s", "light_rough_%s", "micro_%ss", "pacman_%s", "paddle_%s", "rough_%s", "smol_%s", "smooth_%s"),
    VINE("droopy_%s", "flowery_%s", "ivy_%s", "leafy_%s", "long_%s", "lush_%s", "nether_%s", "poisonous_%s", "thicc_%s", "thin_%s", "warped_%s"),
    LEAVES("apple_%s", "cherry_%s", "dead_%s", "frosted_%s", "golden_%s", "golden_apple_%s", "golden_cherry_%s", "magenta_flower_%s", "orange_%s", "red_%s", "white_flower_%s"),
    ROOTS("blue_%s", "crimson_%s", "flowery_%s", "leafy_%s", "lush_%s", "muddy_%s", "thin_%s"),

    PUMPKIN("autumnkin", "dewkin", "dirty_dewkin", "dirty_goldkin", "dirty_rosekin", "end_%s", "end_%s_purple", "goldkin", "kabotchkin", "nether_%s", "overgrown_%s", "overgrown_autumnkin", "overgrown_lumpkin", "overgrown_pimpkin", "pimpkin", "rosekin"),
    CARVED_PUMPKIN("anguished_%s", "bad_time_%s", "boo_%s", "creepy_%s", "devious_%s", "end_%s", "end_purple_%s", "horrified_%s", "kitty_faced_%s", "nether_%s", "overjoyed_%s", "owo_%s", "silly_%s", "slight_smile_%s", "smiling_%s", "spooky_%s", "squished_cute_%s", "suspicious_%s", "tiny_smug_%s", "traditional_%s", "upside_down_%s", "wide_eyed_%s"),

    GRAVEL("andesite_%s", "dirty_%s", "dusty_%s", "orange_%s", "rought_%s", "sandy_%s", "sifted_%s"),
    SAND("ash_%s", "course_%s", "desert_%s", "kelp_%s", "lush_red_%s", "overgrown_%s", "pearl_%s", "soft_%s", "tar_%s", "wet_%s", "wet_red_%s", "white_%s"),
    SOUL_SAND("faded_%s", "fine_%s", "glowing_%s", "graveled_%s", "happy_%s", "hardened_%s", "lauching_%s", "meming_%s", "reanimated_%s", "scared_%s", "sifted_%s", "smoothed_%s", "trampled_%s"),

    GLOWSTONE("broken_%s", "bulbed_%s", "cracked_%s", "double_inlayed_%s", "edged_%s_lantern", "fancy_%s_lantern", "framed_%s_lantern", "glowing_lodestone_side", "%s_lantern", "hived_%s", "inlayed_%s", "nether_engraved_%s", "ornate_%s_lantern", "patterned_%s", "polished_%s", "shimmering_%s", "smooth_%s", "thick_inlayed_%s", "tiled_%s_pillar", "wither_engraved_%s"),
    SEA_LANTERN("broken_%s", "bulbed_%s", "cracked_%s", "double_inlayed_%s", "fancy_%s", "framed_%s", "hived_%s", "inlayed_%s", "ornate_%s", "polished_%s", "reinforced_%s", "sea_lodestone_side", "shimmering_%s", "smooth_%s", "special_%s", "thick_inlayed_%s", "tiled_%s_pillar"),
    SHROOMLIGHT("broken_%s", "cracked_%s", "double_inlayed_%s", "edged_%s_lantern", "fancy_%s_lantern", "framed_%s_lantern", "hived_%s", "inlayed_%s", "ornate_%s_lantern", "polished_%s", "reinforced_%s", "shimmering_%s", "%s_lantern", "%s_lodestone_side", "smooth_%s", "thick_inlayed_%s", "tiled_%s_pillar"),
    TORCH("acacia_%s", "birch_%s", "crimson_%s", "dark_oak_%s", "glow_%s", "iron_%s", "jungle_%s", "spruce_%s", "warped_%s"),
    REDSTONE_TORCH("blue_%s", "crimson_%s", "green_%s", "lightstick_%s", "yellow_%s"),
    REDSTONE_LAMP("edged_%s", "edged_white_%s", "fancy_%s", "fancy_white_%s", "hived_%s", "hived_white_%s", "inlayed_%s", "inlayed_white_%s", "nice_%s", "nice_white_%s", "ornate_%s", "ornate_white_%s", "reinforced_%s", "reinforced_white_%s", "smooth_%s", "smooth_white_%s", "thick_inlayed_%s", "thick_white_inlayed_%s"),
    SPECIAL_LANTERN("big_lantern", "donut_lantern", "tall_lantern", "wide_lantern"),
    SPECIAL_SOUL_LANTERN("big_soul_lantern", "donut_soul_lantern", "tall_soul_lantern", "wide_soul_lantern"),
    LANTERN("blue_paper_%s", "burning_coal_%s", "checkered_iron_%s", "dark_blue_paper_%s", "ender_%s", "green_paper_%s", "iron_bowl_%s", "purple_paper_%s", "red_paper_%s", "small_green_%s", "white_paper_%s", "wooden_cage_%s", "wrought_iron_%s", "yellow_tube_%s"),
    SOUL_LANTERN("blue_paper_%s", "blue_tube_%s", "checkered_iron_%s", "golden_paper_%s", "gray_paper_%s", "iron_bowl_%s", "lime_paper_%s", "orange_paper_%s", "small_red_%s", "wooden_cage_%s", "yellow_paper_%s"),
    FROGLIGHT("ad_astra_%s", "ancient_%s", "barred_%s", "elemental_%s", "exposed_%s", "glass_%s", "reinforced_%s", "round_%s"),

    BOOKSHELF("ancient_cubed_oak_%s", "ancient_oak_%s", "ancient_oak_large_%s", "ancient_vertical_oak_%s", "botanical_oak_%s", "botanical_oak_cubed_%s", "botanical_oak_large_%s", "cubed_oak_%s", "cubed_oak_empty_%s", "cubed_oak_spaced_%s", "cubed_oak_webbed_%s", "curvy_%s", "dusty_%s", "full_%s", "historical_oak_%s", "historical_oak_large_%s", "mixed_cubed_oak_%s", "mixed_oak_%s", "mixed_oak_large_%s", "oak_%s", "oak_empty_%s", "oak_large_%s", "oak_lighted_%s", "oak_lighted_large_%s", "oak_spaced_%s", "oak_spaced_large_%s", "oak_webbed_%s", "oak_webbed_large_%s", "vertical_botanical_oak_%s", "vertical_mixed_oak_%s", "vertical_oak_%s", "vertical_oak_lighted_%s", "vertical_oak_webbed_%s"),
    LADDER("crooked_%s", "crooked_plank_%s", "crooked_ropeplank_%s", "metal_%s", "mossy_%s", "plank_%s", "railed_%s", "rope_planked_%s", "roped_%s", "strong_%s"),

    WOOL("barky_%s", "blocky_%s", "bundled_%s", "cornered_%s", "crafted_%s", "cross_haired_%s", "cubed_%s", "harsh_quilted_%s", "knitted_%s", "patched_%s", "rectangle_%s", "ribbled_%s", "scaled_%s", "soft_%s", "stringed_%s", "tiled_%s", "tripped_%s", "wickered_%s", "windmill_%s", "woved_%s"),

    STONE("%s_bricks", "%s_mini_tiles", "%s_pillar", "%s_pillar_top", "%s_scales", "angry_%s", "blank_%s_carving", "bordered_%s", "brick_bordered_%s", "carved_%s", "checkered_%s_tiles", "cobbled_%s", "cracked_%s_bricks", "cracked_disordered_%s_bricks", "cracked_flat_%s_tiles", "creeper_%s_carving", "crying_%s", "curly_%s_pillar", "cut_%s_column", "cut_blank_%s", "glad_%s", "duh_%s", "edged_%s_bricks", "engraved_%s", "eroded_%s", "etched_%s_bricks", "fine_%s_pillar", "flat_%s_tiles", "inlayed_%s", "inscribed_%s", "layed_%s_bricks", "loded_%s", "massive_%s_bricks", "offset_%s_bricks", "ornate_%s_pillar", "overlapping_%s_tiles", "pillar_%s_bricks", "polished_%s", "prismal_%s_remnants", "rough_%s", "rounded_%s_bricks", "runic_carved_%s", "sad_%s", "sanded_%s", "simple_%s_pillar", "small_%s_bricks", "smooth_%s_column", "smooth_inlayed_%s", "smooth_ringed_%s", "smoothed_double_inlayed_%s", "spider_%s_carving", "spiraled_%s", "stacked_%s_bricks", "thick_inlayed_%s", "tiled_%s", "tiled_%s_column", "tiled_bordered_%s", "tiny_%s_bricks", "tiny_brick_bordered_%s", "tiny_layered_%s_bricks", "tiny_layered_%s_slabs", "trodden_%s", "unamused_%s", "vertical_cut_%s", "vertical_disordered_%s_bricks", "weathered_%s"),
    BASALT(STONE, List.of("rough_%s", "trodden_%s")),
    BLACKSTONE(STONE, List.of("%s_bricks", "cracked_%s_bricks", "rough_%s", "weathered_%s"), "smooth_%s_bricks"),
    DARK_PRISMARINE(STONE, List.of("%s_mini_tiles")),
    DEEPSLATE(STONE, List.of("%s_bricks", "cobbled_%s", "cracked_%s_bricks", "cracked_flat_%s_tiles", "flat_%s_tiles", "layed_%s_bricks", "offset_%s_bricks")),
    GILDED_BLACKSTONE(STONE, List.of("rough_%s", "smooth_%s"), "chunky_%s", "reinforced_%s", "special_%s", "spiral_%s"),
    LODESTONE("%s_bricks", "%s_mini_tiles", "%s_pillar", "%s_pillar_top", "%s_scales", "angry_%s", "blank_%s_carving", "blank_%s_side", "bordered_%s", "brick_bordered_%s", "carved_%s", "checkered_%s_tiles", "cobbled_%s", "cracked_%s_bricks", "cracked_disordered_%s_bricks", "cracked_flat_%s_tiles", "creeper_%s_carving", "crying_%s", "curly_%s_pillar", "cut_%s_column", "cut_blank_%s", "glad_%s", "diamond_%s", "dot_%s", "duh_%s", "edged_%s_bricks", "engraved_%s", "eroded_%s", "etched_%s_bricks", "fine_%s_pillar", "flat_%s_tiles", "inlayed_%s", "inscribed_%s", "layed_%s_bricks", "massive_%s_bricks", "offset_%s_bricks", "ornate_%s_pillar", "overlapping_%s_tiles", "pillar_%s_bricks", "polished_%s", "prismal_%s_remnants", "ring_%s", "ring_%s_side", "rough_%s", "rounded_%s_bricks", "runic_carved_%s", "sad_%s", "sanded_%s", "sea_lantern_%s", "simple_%s_pillar", "small_%s_bricks", "smooth_%s_column", "smooth_ringed_%s", "smoothed_double_inlayed_%s", "spider_%s_carving", "spiraled_%s", "stacked_%s_bricks", "thick_inlayed_%s", "tiled_%s", "tiled_%s_column", "tiled_bordered_%s", "tiny_%s_bricks", "tiny_brick_bordered_%s", "tiny_layered_%s_bricks", "tiny_layered_%s_slabs", "trodden_%s", "unamused_%s", "vertical_cut_%s", "vertical_disordered_%s_bricks", "watching_%s", "weathered_%s", "wider_diamond_%s", "wider_ring_%s", "wider_watching_%s"),
    MOSSY_STONE_BRICKS(STONE, List.of("%s_bricks")),
    PRISMARINE(STONE, List.of("prismal_%s_remnants"), "granite_%s"),
    PURPUR_BLOCK(STONE, List.of("heckered_%s_tiles", "checkered_%s_tiles")),
    QUARTZ_BLOCK(STONE, List.of("carved_%s", "offset_%s_bricks", "%s_pillar_top", "spiraled_%s")),
    BASE_STONE(STONE, List.of("%s_bricks", "cracked_%s_bricks", "curly_%s_pillar", "eroded_%s", "fine_%s_pillar", "ornate_%s_pillar", "simple_%s_pillar", "smooth_ringed_%s", "%s_mini_tiles")),
    CLAY(STONE, List.of("eroded_%s")),
    BRICKS(STONE, List.of("layed_%s_bricks")),
    MUD("%s_bricks", "%s_pillar", "%s_pillar_top", "%s_scales", "angled_%s_bricks", "angry_%s", "arrow_%s", "bordered_%s", "brick_bordered_%s", "button_%s", "carved_%s", "carved_%s_pillar", "centered_%s", "chiseled_%s", "cracked_%s_bricks", "creeper_%s_carving", "crunched_%s_bricks", "crying_%s", "curly_%s_pillar", "cut_blank_%s", "diamond_%s_bricks", "double_%s_bricks", "duh_%s", "edged_%s_bricks", "engraved_%s", "etched_%s_bricks", "eye_%s", "fancy_%s", "fancy_%s_pillar", "fancy_chiseled_%s", "fine_%s_pillar", "glad_%s", "heart_%s", "horned_%s", "inlayed_%s", "keyhole_%s", "large_%s_sigil", "large_tiled_%s", "leaning_%s", "loreful_%s", "massive_%s_bricks", "mini_tiled_%s", "offset_%s_bricks", "ornate_%s_pillar", "overlapping_%s_tiles", "pancake_%s", "panelled_%s", "placed_%s", "polished_%s", "prismal_%s_remnants", "quad_%s", "rough_%s", "hard_%s", "rough_panelled_%s", "rune_%s", "sad_%s", "scaly_%s", "sigil_%s", "simple_%s_pillar", "small_%s_bricks", "smooth_%s", "smooth_ringed_%s", "smoothed_double_inlayed_%s", "spider_%s_carving", "spiral_%s", "stacked_%s_bricks", "star_%s", "symbol_%s", "symbolic_%s_pillar", "thick_inlayed_%s", "tiled_%s_bricks", "tiled_%s_column", "tiled_bordered_%s", "tiny_%s_bricks", "tiny_layered_%s_bricks", "unamused_%s", "vertical_cut_%s", "vertical_disordered_%s_bricks"),

    PLANKS("%s_mosaic", "%s_panel", "%s_shavings", "basket_woven_%s", "boxed_%s", "brick_bond_%s", "bricky_%s", "cornered_%s", "crated_%s", "cross_laced_%s", "crossed_%s", "detailed_%s", "diagonal_%s", "diamond_%s", "double_herringbone_%s", "enclosed_%s", "fine_%s", "fine_vertical_%s", "framed_%s", "herringbone_%s", "hewn_%s", "laced_%s", "nailed_%s", "natural_%s", "pegged_%s", "polished_%s", "railed_%s", "shifted_%s", "slanted_%s", "smooth_%s", "stacked_%s", "thin_%s", "tiled_%s", "versailles_%s", "vertical_%s", "vertically_railed_%s", "whirlwind_%s", "wickered_%s"),
    MANGROVE_PLANKS("%s_mosaic", "%s_panel", "%s_shavings", "basket_woven_%s", "boxed_%s", "brick_bond_%s", "bricked_%s", "bricky_%s", "carved_%s", "chiseled_%s", "cornered_%s", "crated_%s", "cross_laced_%s", "crossed_%s", "cut_%s", "detailed_%s", "diagonal_%s", "diamond_%s", "double_herringbone_%s", "enclosed_%s", "fine_%s", "fine_vertical_%s", "framed_%s", "herringbone_%s", "hewn_%s", "laced_%s", "nailed_%s", "natural_%s", "pegged_%s", "polished_%s", "railed_%s", "ringed_%s", "shelved_%s", "shifted_%s", "sided_%s", "slanted_%s", "smooth_%s", "stacked_%s", "thin_%s", "tiled_%s", "versailles_%s", "vertical_%s", "vertically_railed_%s"),

    LOG("bundled_%s", "center_cut_%s", "damaged_%s", "edge_cut_%s", "firewood_%s", "flowering_%s", "mixed_%s", "nailed_%s", "overgrown_%s", "planked_%s", "reinforced_%s"),
    WARPED_STEM("bundled_%s", "center_cut_%s", "damaged_%s", "edge_cut_%s", "firewood_%s", "nailed_%s", "planked_%s", "rotted_%s", "shrooming_%s", "smooth_%s"),
    CRIMSON_STEM("bundled_%s", "center_cut_%s", "crying_%s", "damaged_%s", "edge_cut_%s", "firewood_%s", "glittering_%s", "glowing_%s", "mixed_%s", "nailed_%s", "planked_%s", "rotten_%s", "shrooming_%s", "smooth_%s"),
    STRIPPED_LOG("carved_%s", "chipped_%s", "d_sign_%s", "edged_%s", "f_sign_%s", "i_sign_%s", "k_sign_%s", "knotted_%s", "l_sign_%s", "layered_%s", "lumpy_%s", "m_sign_%s", "patient_%s", "reinforced_%s", "sign_%s", "stern_%s", "wise_%s"),
    STRIPPED_MANGROVE_LOG("carved_%s", "chipped_%s", "chiseled_%s", "d_sign_%s", "edged_%s", "f_sign_%s", "i_sign_%s", "k_sign_%s", "knotted_%s", "l_sign_%s", "lumpy_%s", "m_sign_%s", "patient_%s", "reinforced_%s", "sign_%s", "stern_%s", "vertical_layered_%s", "wise_%s"),
    BARREL("acacia_%s", "acacia_crate", "bamboo_%s", "birch_%s", "birch_crate", "coal_%s", "copper_%s", "crimson_%s", "crimson_crate", "dark_oak_crate", "fish_%s", "fruit_%s", "gilded_%s", "gold_%s", "iron_%s", "jungle_crate", "mangrove_brick_%s", "mangrove_crate", "mangrove_tile_%s", "metal_%s", "mushroom_%s", "netherite_safe", "oak_%s", "oak_crate", "reinforced_acacia_crate", "reinforced_birch_crate", "reinforced_crimson_crate", "reinforced_dark_oak_crate", "reinforced_jungle_crate", "reinforced_mangrove_crate", "reinforced_oak_crate", "reinforced_spruce_crate", "reinforced_warped_crate", "spruce_%s", "spruce_crate", "varnished_%s", "warped_crate"),

    METAL("%s_panels", "ancient_%s", "chipped_%s", "engraved_%s", "layered_%s", "plated_%s", "polished_%s", "pressed_%s", "reinforced_%s", "sheet_%s", "shuttered_%s", "stacked_%s"),
    NETHERITE_BLOCK("%s_panels", "chipped_%s", "embossed_%s", "engraved_%s", "layered_%s", "plated_%s", "polished_%s", "pressed_%s", "reinforced_%s", "sheet_%s", "shuttered_%s", "stacked_%s"),
    DIAMOND_BLOCK("%s_panels", "ancient_%s", "chipped_%s", "embossed_%s", "engraved_%s", "layered_%s", "plated_%s", "pressed_%s", "reinforced_%s", "sheet_%s", "shuttered_%s", "stacked_%s"),
    EMERALD_BLOCK("%s_panels", "ancient_%s", "chipped_%s", "embossed_%s", "engraved_%s", "layered_%s", "plated_%s", "polished_%s", "reinforced_%s", "sheet_%s", "shuttered_%s", "stacked_%s"),
    COPPER_BLOCK("ancient_%s", "chipped_%s", "embossed_%s", "engraved_%s", "layered_%s", "plated_%s", "pressed_%s", "reinforced_%s", "sheet_%s", "shuttered_%s", "stacked_%s"),
    IRON_BARS("%s_top", "barbed_%s", "bolted_%s", "chained_%s", "crossbolted_%s", "crossed_%s", "floral_%s", "harp_%s", "linked_%s", "loose_%s", "piked_%s", "railed_%s", "sighthole_%s", "stepped_%s", "sturdy_%s", "supported_%s", "thorned_%s", "victorian_%s_pikes", "vined_%s", "woven_%s", "zippered_%s"),

    TERRACOTTA("%s_bricks", "%s_column", "%s_pillar", "%s_tile", "%s_tiles", "chiseled_%s", "circular_%s", "crossed_%s", "curled_%s", "cut_%s", "decorated_%s", "hexagonical_%s", "inscribed_%s", "layered_%s", "small_%s_tiles", "starry_%s", "triangular_%s"),
    GLAZED_TERRACOTTA("%s_pillar_sides", "%s_pillar_top", "%s_smooth_tiles", "%s_tiles", "decorated_%s", "hexagonical_%s", "minimized_%s", "paved_%s", "shrunken_%s", "starry_%s", "waved_%s"),
    POINTED_DRIPSTONE("andesite_%s", "calcite_%s", "deepslate_%s", "diorite_%s", "smooth_basalt_%s", "granite_%s", "stone_%s", "tuff_%s", "basalt_%s", "blackstone_%s", "endstone_%s", "netherrack_%s", "packed_ice_%s"),
    GLASS("arched_leaded_%s_pillar", "circle_oak_%s", "clear_leaded_%s", "fancy_leaded_%s", "large_diamond_leaded_%s", "lead_woven_%s", "oak_bared_%s", "oak_bordered_%s", "oak_diamond_bordered_%s", "oak_horizontal_lined_%s", "oak_large_diamond_%s", "oak_line_bared_%s", "oak_ornate_bared_%s", "oak_snowflake_%s", "oak_woven_%s", "ornate_leaded_%s", "raster_leaded_%s", "small_diamond_leaded_%s", "square_leaded_%s", "square_oak_%s", "vertical_leaded_%s"),
    STAINED_GLASS("arched_%s_pillar", "circular_%s", "fancy_%s", "large_diamond_%s", "ornate_%s", "raster_%s", "small_%s", "square_%s", "tiled_%s", "vertical_striped_%s", "woven_%s"),

    CONCRETE("%s_bricks", "%s_panel", "%s_pillar", "%s_tiles", "bolted_%s", "creeper_%s", "grid_%s", "grill_%s", "hazard_%s", "mosaic_%s", "pegged_%s", "railed_%s", "reinforced_%s", "rusted_%s", "smooth_%s", "stacked_%s", "stop_%s", "striped_%s", "warning_%s", "wired_%s"),

    TRAPDOOR("airy_%s", "barred_%s", "checkered_%s", "classic_%s", "classic_windowed_%s", "cobweb_%s", "distorted_%s", "fancy_%s", "golden_barred_%s", "heavy_%s", "iron_barred_%s", "leafy_%s", "meshed_%s", "overgrown_%s", "pointless_%s", "slotted_%s", "solid_%s", "suspicious_%s", "twisted_%s", "vined_%s", "warted_%s", "windowed_%s", "woven_%s"),
    OAK_TRAPDOOR(TRAPDOOR, List.of("classic_%s")),
    SPRUCE_TRAPDOOR(TRAPDOOR, List.of("heavy_%s")),
    CRIMSON_TRAPDOOR(TRAPDOOR, List.of("suspicious_%s")),
    WARPED_TRAPDOOR(TRAPDOOR, List.of("distorted_%s", "fancy_%s")),
    JUNGLE_TRAPDOOR(TRAPDOOR, List.of("fancy_%s")),
    ACACIA_TRAPDOOR(TRAPDOOR, List.of("airy_%s")),
    MANGROVE_TRAPDOOR("barred_%s", "classic_%s", "classic_windowed_%s", "distorted_%s", "fancy_%s", "golden_barred_%s", "heavy_%s", "iron_barred_%s", "screened_%s", "solid_%s", "suspicious_%s", "windowed_%s"),

    DOOR("barred_%s", "beach_%s", "boarded_%s", "dual_paneled_%s", "fortified_%s", "gated_%s", "glass_%s", "heavy_%s", "overgrown_%s", "paneled_%s", "paper_%s", "pressed_%s", "screen_%s", "secret_%s", "shack_%s", "sliding_%s", "supported_%s", "tile_windowed_%s", "tiled_%s", "windowed_%s"),
    ACACIA_DOOR(DOOR, List.of("barred_%s")),
    BIRCH_DOOR(DOOR, List.of("paper_%s")),
    DARK_OAK_DOOR(DOOR, List.of("paneled_%s")),
    JUNGLE_DOOR(DOOR, List.of("beach_%s")),
    SPRUCE_DOOR(DOOR, List.of("boarded_%s")),
    CRIMSON_DOOR(DOOR, List.of("supported_%s")),
    WARPED_DOOR(DOOR, List.of("overgrown_%s", "sliding_%s")),
    MANGROVE_DOOR("barred_%s", "beach_%s", "boarded_%s", "cut_%s", "dual_paneled_%s", "fortified_%s", "gated_%s", "glass_%s", "heavy_%s", "modern_%s", "overgrown_%s", "paneled_%s", "paper_%s", "pressed_%s", "reinforced_%s", "secret_%s", "sliding_%s", "supported_%s", "tile_windowed_%s", "windowed_%s"),
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
